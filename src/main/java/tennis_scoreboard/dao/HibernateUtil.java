package tennis_scoreboard.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tennis_scoreboard.model.Match;
import tennis_scoreboard.model.Player;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(Match.class)
                    .addAnnotatedClass(Player.class)
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing Hibernate SessionFactory: " + e.getMessage(), e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
