package dao;

import entities.Stadium;

import javax.persistence.EntityManager;

public class StadiumDao extends AbstractDao<Stadium, Long>{
    public StadiumDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Stadium> entityClass() {
        return null;
    }
}
