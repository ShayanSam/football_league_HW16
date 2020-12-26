package dao;

import javax.persistence.EntityManager;

public abstract class AbstractDao<T, U> {

    private EntityManager entityManager;

    public AbstractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(T entity){
        entityManager.persist(entity);
    }

    public void remove(T entity){
        entityManager.remove(entity);
    }

    public void update(T entity) { entityManager.merge(entity); }

    public T load(U id){
        return entityManager.find(entityClass(), id);
    }

    abstract Class<T> entityClass();
}