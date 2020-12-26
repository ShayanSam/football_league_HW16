package dao;

import entities.Season;

import javax.persistence.EntityManager;

public class SeasonDao extends AbstractDao<Season, Long>{
    public SeasonDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Season> entityClass() {
        return null;
    }
}
