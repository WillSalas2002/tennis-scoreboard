package tennis_scoreboard.dao;

import jakarta.persistence.NoResultException;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;
import tennis_scoreboard.model.Match;
import tennis_scoreboard.model.Player;


public class FinishedMatchesPersistenceServiceImpl implements FinishedMatchesPersistenceService {
    @Override
    public void saveMatch(Match match) {


        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.persist(match);
        session.getTransaction().commit();

        session.close();

    }

    @Override
    public void savePlayers(Player player) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            session.persist(player);
            session.getTransaction().commit();

        } catch (HibernateError e) {
            throw new HibernateError("Database error");
        }



    }

    @Override
    public Player getPlayerByName(String name) {

        Player player;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            player = session.createQuery("FROM Player WHERE name = '" + name + "'", Player.class).getSingleResult();
            session.getTransaction().commit();

        } catch (HibernateError e) {
            throw new HibernateError("Database error");
        } catch (NoResultException e) {
            return null;
        }

        return player;
    }
}
