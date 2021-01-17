package facades;

import entities.Coach;
import entities.MemberInfo;
import entities.Player;
import entities.Sport;
import entities.SportTeam;
import errorhandling.AlreadyExistsException;
import errorhandling.MissingInputException;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author claes
 */
public class SportFacadeTest {

    private static EntityManagerFactory emf;
    private static SportFacade facade;

    public SportFacadeTest() {

    }

    @BeforeAll
    public static void setUpClass() {

        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = SportFacade.getSportFacade(emf);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.createNamedQuery("Coach.deleteAllRows").executeUpdate();
            em.createNamedQuery("MemberInfo.deleteAllRows").executeUpdate();
            em.createNamedQuery("Player.deleteAllRows").executeUpdate();
            em.createNamedQuery("Sport.deleteAllRows").executeUpdate();
            em.createNamedQuery("SportTeam.deleteAllRows").executeUpdate();

            Player p1 = new Player("player1", "mail1", "ph1", "15");
            Player p2 = new Player("player2", "mail2", "ph2", "30");
            Player p3 = new Player("player3", "mail3", "ph3", "65");

            Sport s1 = new Sport("sport1", "abc");
            Sport s2 = new Sport("sport2", "def");
            Sport s3 = new Sport("sport3", "ghi");

            SportTeam st1 = new SportTeam("100", "ST1", "5", "18");
            SportTeam st2 = new SportTeam("200", "ST2", "18", "30");
            SportTeam st3 = new SportTeam("300", "ST3", "30", "110");

            MemberInfo m1 = new MemberInfo();
            MemberInfo m2 = new MemberInfo();
            MemberInfo m3 = new MemberInfo();

            Coach c1 = new Coach("coach1", "mail1", "1234");
            Coach c2 = new Coach("coach2", "mail2", "456");
            Coach c3 = new Coach("caoch3", "mail3", "789");

            m1.setPayed(true);
            m2.setPayed(false);
            m3.setPayed(true);

            Calendar cal = Calendar.getInstance();
            cal.set(2020, 05, 07);

            m1.setDatePaid(cal.getTime());

            p1.addMemberInfo(m1);
            p2.addMemberInfo(m2);
            p3.addMemberInfo(m3);

            s1.addSportTeam(st1);
            s2.addSportTeam(st2);
            s3.addSportTeam(st3);

            c1.addSportTeam(st3);
            c1.addSportTeam(st2);
            c2.addSportTeam(st1);

            st1.addMemberInfo(m3);
            st1.addMemberInfo(m2);
            st2.addMemberInfo(m1);

            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(s1);
            em.persist(s2);
            em.persist(s3);
            em.persist(st1);
            em.persist(st2);
            em.persist(st3);
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterAll
    public static void tearDownClass() {

    }

    @AfterEach
    public void tearDown() {

    }
    @Test
    public void testGetSportFacade() {
        EntityManagerFactory emff = null;
        SportFacade expectedResult = null;
        SportFacade result = SportFacade.getSportFacade(emff);
        assertNotEquals(expectedResult, result);
    }

    
}
