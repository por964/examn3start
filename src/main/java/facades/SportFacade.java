package facades;

import dtos.SportTeamDTO;
import dtos.SportTeamsDTO;
import dtos.SportsDTO;
import entities.Sport;
import entities.SportTeam;
import errorhandling.MissingInputException;
import errorhandling.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author claes
 */
public class SportFacade {

    private static SportFacade instance;
    private static EntityManagerFactory emf;

    private SportFacade() {

    }

    public static SportFacade getSportFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new SportFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getSportCount() {
        EntityManager em = emf.createEntityManager();
        try {
            Long sportCount = (Long) em.createQuery("SELECT COUNT(r) FROM Sport r").getSingleResult();
            return sportCount;
        } finally {
            em.close();
        }

    }

    public SportsDTO getAllSports() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Sport> query = em.createQuery("SELECT s FROM Sport s", Sport.class);
            List<Sport> list = query.getResultList();
            SportsDTO result = new SportsDTO(list);
            return result;
        } finally {
            em.close();
        }
    }

    public boolean sportExists(String name) {
        EntityManager em = emf.createEntityManager();
        return em.find(Sport.class, name) == null;
    }

    public String addSport(String sportName, String description) throws MissingInputException {
        if (sportName.length() == 0 || description.length() == 0) {
            throw new MissingInputException("No sport name or description provided, please try again");
        }
        EntityManager em = emf.createEntityManager();

        if (sportExists(sportName)) {
            Sport sp = new Sport(sportName, description);
            try {

                em.getTransaction().begin();
                em.persist(sp);
                em.getTransaction().commit();

            } finally {
                em.close();
            }
        }
        return sportName;

    }

    public boolean teamExists(String id) {
        EntityManager em = emf.createEntityManager();
        return em.find(SportTeam.class, id) == null;
    }

    public String addSportTeam(String price, String name, String minAge, String maxAge, String sport) {
        EntityManager em = emf.createEntityManager();

        boolean sportex = sportExists(sport);

        if (teamExists(name) && !sportex) {
            try {
                Sport sp = em.find(Sport.class, sport);
                SportTeam st = new SportTeam(name, price, minAge, maxAge);
                sp.addSportTeam(st);
                em.getTransaction().begin();
                em.persist(st);
                em.persist(sp);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        } else {
            return "Team already exists or sport doesn't exist";
        }
        return name;
    }

    public SportTeamsDTO getAllTeams() {
        EntityManager em = getEntityManager();
        try {
            return new SportTeamsDTO(em.createNamedQuery("SportTeam.getAllRows").getResultList());
        } finally {
            em.close();
        }
    }

    public SportTeamDTO editTeam(SportTeamDTO st) throws NotFoundException {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            SportTeam sportteam = em.find(SportTeam.class, st.getTeamName());
            if (sportteam == null) {
                throw new NotFoundException("Team doesn't exist");
            } else {
                sportteam.setPricePerYear(st.getPricePerYear());
                sportteam.setMinAge(st.getMinAge());
                sportteam.setMaxAge(st.getMaxAge());
            }
            em.getTransaction().commit();
            return new SportTeamDTO(sportteam);
        } finally {
            em.close();
        }
    }

    public SportTeamDTO deleteTeam(String teamName) throws NotFoundException {
        EntityManager em = getEntityManager();

        SportTeam sportteam = em.find(SportTeam.class, teamName);

        if (sportteam == null) {
            throw new NotFoundException("Team doesn't exist");
        } else {
            try {
                em.getTransaction().begin();
                em.remove(sportteam);
                em.getTransaction().commit();

            } finally {
                em.close();
            }
            return new SportTeamDTO(sportteam);
        }

    }
}
