package dao;

import entities.Matches;

import javax.persistence.EntityManager;

public class MatchesDao extends AbstractDao<Matches, Long>{
    public MatchesDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Matches> entityClass() {
        return null;
    }
}
