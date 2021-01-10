package criteria;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    public static void countTeamCity(EntityManager em) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> queryArray = criteriaBuilder.createQuery(Object[].class);
        Root<Team> teamRoot = queryArray.from(Team.class);

        Join<Team, City> teamCityJoin = teamRoot.join("city");
        queryArray.multiselect(teamCityJoin.get("cityName"), criteriaBuilder.count(teamRoot.get("name")));
        queryArray.groupBy(teamCityJoin.get("cityName"));
        TypedQuery<Object[]> objArray = em.createQuery(queryArray);
        List<Object[]> list = objArray.getResultList();
        for (Object[] obj : list)
            System.out.println(obj[0] + " -- " + obj[1]);
    }

    public static void sumScoreFor1398(EntityManager em) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<Score> scoreRoot = query.from(Score.class);
        Join<Score, Season> scoreSeasonJoin = scoreRoot.join("season");
        query.multiselect(scoreRoot.get("team").get("name"), scoreSeasonJoin.get("Year"), criteriaBuilder.sum(scoreRoot.get("seasonScore")))
                .where(criteriaBuilder.equal(scoreSeasonJoin.get("Year"), "1398"));
        query.groupBy(scoreRoot.get("team").get("name"));
        TypedQuery<Object[]> objArray = em.createQuery(query);
        List<Object[]> list = objArray.getResultList();
        for (Object[] obj : list)
            System.out.printf("name %s, season  %s, sum(score) %s%n", obj[0], obj[1], obj[2]);
    }


    public static void championOfYear1398(EntityManager em) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Integer> queryArray = criteriaBuilder.createQuery(Integer.class);

        Root<Score> fromScore = queryArray.from(Score.class);
        queryArray.select(criteriaBuilder.sum(fromScore.get("seasonScore")));
                queryArray.where(criteriaBuilder.equal(fromScore.get("season").get("Year"),"1398")).groupBy(fromScore.get("team"));
        TypedQuery<Integer> typedQuery = em.createQuery(queryArray);
        List<Integer> list = typedQuery.getResultList();
        Integer max = Collections.max(list);
        CriteriaQuery<String> queryLong = criteriaBuilder.createQuery(String.class);
        Root<Score> fromScore2 = queryLong.from(Score.class);
        queryLong.select(fromScore2.get("team").get("name")).groupBy(fromScore2.get("team"));
        queryLong.having(criteriaBuilder.sum(fromScore2.get("seasonScore")).in(max));
        TypedQuery<String> teamTypedQuery = em.createQuery(queryLong);
        List<String> teamList = teamTypedQuery.getResultList();
        System.out.println("Max Score is: "+max);
        System.out.println("<---- Champion Team ---->");
        teamList.forEach(System.out::println);
    }
}



