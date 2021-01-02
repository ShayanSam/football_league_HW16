package criteria;

import entities.Coach;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class CriteriaApi {


    public static void highestPaidForCoach(EntityManager em){

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        criteriaQuery.select(criteriaQuery.from(Coach.class));
        Query query = em.createQuery(criteriaQuery);



    }



}
