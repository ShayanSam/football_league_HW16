package criteria;

import entities.Coach;
import entities.Contract;
import entities.Player;
import entities.Season;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.List;

public class CriteriaApi {


    public static void highestPaidForCoach(EntityManager em) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Coach> queryCoach = criteriaBuilder.createQuery(Coach.class);
        CriteriaQuery<Double> queryDouble = criteriaBuilder.createQuery(Double.class);

        Root<Coach> root2 = queryCoach.from(Coach.class);
        Root<Coach> root = queryDouble.from(Coach.class);

        queryDouble.select(criteriaBuilder.max(root.get("salary")));
        TypedQuery<Double> coachTypedQuery2 = em.createQuery(queryDouble);
        Double maxSalary = coachTypedQuery2.getSingleResult();

        queryCoach.select(root2);
        queryCoach.where(criteriaBuilder.equal(root2.get("salary"), maxSalary));
        TypedQuery<Coach> coachTypedQuery = em.createQuery(queryCoach);
        List<Coach> coachList = coachTypedQuery.getResultList();
        System.out.println(coachList);

    }

    public static void highestPaidForPlayer(EntityManager em) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Contract> queryContract = criteriaBuilder.createQuery(Contract.class);
        CriteriaQuery<Double> queryDouble = criteriaBuilder.createQuery(Double.class);

        Root<Contract> root2 = queryContract.from(Contract.class);
        Root<Contract> root = queryDouble.from(Contract.class);

        queryDouble.select(criteriaBuilder.max(root.get("seasonSalary"))).groupBy(root.get("season"));
        TypedQuery<Double> coachTypedQuery2 = em.createQuery(queryDouble);
        List<Double> maxPlayerSalary = coachTypedQuery2.getResultList();

        queryContract.select(root2);
        queryContract.where(root2.get("seasonSalary").in(maxPlayerSalary));

        queryContract.groupBy(root2.get("season"));
        TypedQuery<Contract> coachTypedQuery = em.createQuery(queryContract);
        List<Contract> coachList = coachTypedQuery.getResultList();
        System.out.println(coachList);



    }
}
