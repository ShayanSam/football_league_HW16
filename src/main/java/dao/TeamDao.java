package dao;

import entities.Team;

import javax.persistence.EntityManager;

public class TeamDao extends AbstractDao<Team, Long>{
    public TeamDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Team> entityClass() {
        return null;
    }
}
