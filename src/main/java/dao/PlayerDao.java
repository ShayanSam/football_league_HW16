package dao;

import entities.Player;

import javax.persistence.EntityManager;

public class PlayerDao extends AbstractDao<Player, Long>{
    public PlayerDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Player> entityClass() {
        return null;
    }
}
