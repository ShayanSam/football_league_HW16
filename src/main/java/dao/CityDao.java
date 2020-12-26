package dao;

import entities.City;

import javax.persistence.EntityManager;

public class CityDao extends AbstractDao<City, Long> {

    public CityDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<City> entityClass() {
        return null;
    }
}
