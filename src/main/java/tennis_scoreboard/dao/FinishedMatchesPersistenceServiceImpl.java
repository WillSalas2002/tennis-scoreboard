package tennis_scoreboard.dao;

import jakarta.persistence.NoResultException;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import tennis_scoreboard.model.Match;
import tennis_scoreboard.model.Player;

import java.util.List;


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

    @Override
    public long getCountInMatchTable() {

        long count = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            count = session.createQuery("SELECT COUNT(*) FROM Match", Long.class).getSingleResult();
        }

        return count;
    }

    @Override
    public List<Match> getTotalMatches(int offset, int limit) {

        List<Match> matchList;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            matchList = session.createQuery("FROM Match", Match.class).setFirstResult(offset).setMaxResults(limit).getResultList();
            session.getTransaction().commit();
        }

        return matchList;
    }

    @Override
    public List<Match> getMatchesByPlayerName(String nameToLookFor, int offset, int limit) {

        List<Match> matchList;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            matchList = session.createQuery("FROM Match m WHERE m.player1.name = :nameToLookFor OR m.player2.name = :nameToLookFor", Match.class)
                    .setParameter("nameToLookFor", nameToLookFor)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();
            session.getTransaction().commit();
        }

        return matchList;

    }
}
