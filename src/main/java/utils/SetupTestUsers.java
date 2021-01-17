package utils;

import dtos.SportsDTO;
import entities.Coach;
import entities.Favourite;
import entities.MemberInfo;
import entities.Player;
import entities.Role;
import entities.Sport;
import entities.SportTeam;
import entities.User;
import entities.UserInfo;
import errorhandling.AlreadyExistsException;
import errorhandling.MissingInputException;
import facades.UserFacade;
import facades.SportFacade;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class SetupTestUsers {

    public static void main(String[] args) throws MissingInputException, AlreadyExistsException {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        /*
        Sport basket = new Sport("basket", "sjovt");
        
        SportTeam fck = new SportTeam("200", "FCK", "22", "25");
        
        basket.addSportTeam(fck);
        
        fck.setSport(basket);
        
        em.getTransaction().begin();
        em.persist(basket);
        em.persist(fck);
        
        em.getTransaction().commit();

        Sport s1 = new Sport("tennis", "fun");

        SportTeam united = new SportTeam("250", "UNITED", "24", "26");

        Player p1 = new Player("claes", "mail", "phone", "54");

        MemberInfo m1 = new MemberInfo();
        
        Coach c1 = new Coach("Hans", "hotfiel", "1234");
        
        c1.addSportTeam(united);

        m1.setPayed(true);
        
        p1.addMemberInfo(m1);

        united.addMemberInfo(m1);
        
        s1.addSportTeam(united);
        
        em.getTransaction().begin();
        em.persist(c1);
        em.persist(s1);
        em.persist(p1);
        em.persist(united);
        em.getTransaction().commit();

        
        User user = new User("user", "test1");
        User admin = new User("admin", "test1");
        User both = new User("user_admin", "test1");
        User claes = new User("claes", "rufbtr1");
        User kunde = new User("kunde", "test22");
        User user1 = new User("user1", "test1");
        User user2 = new User("user2", "test2");
        User user3 = new User("user3", "test3");
        User user4 = new User("user4", "test4");
        User user5 = new User("user5", "test5");
        
        em.getTransaction().begin();
        UserInfo inf = new UserInfo("claesvonh", "1234");
        inf.setUser(claes);
        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        claes.addRole(userRole);
        kunde.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        user1.addRole(userRole);
        user2.addRole(userRole);
        user3.addRole(userRole);
        user4.addRole(userRole);
        user5.addRole(userRole);
        em.persist(claes);
        em.persist(kunde);
        em.persist(userRole);
        em.persist(adminRole);
        em.persist(user);
        em.persist(admin);
        em.persist(both);
        em.persist(inf);
        em.persist(user1);
        em.persist(user2);
        em.persist(user3);
        em.persist(user4);
        em.persist(user5);
        em.getTransaction().commit();
        */
        
        SportTeam abc = new SportTeam("300", "abc", "2", "2");
        
        Sport gang = new Sport("langsomt", "kedeligt");
        
        
        
        
    }

}
