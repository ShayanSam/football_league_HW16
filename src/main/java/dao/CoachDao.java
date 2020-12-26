package dao;

import entities.Coach;

import javax.persistence.EntityManager;

public class CoachDao extends AbstractDao<Coach, Long>{
    public CoachDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Coach> entityClass() {
        return null;
    }
}
