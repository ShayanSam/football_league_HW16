package app;

import entities.*;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class App {

    public static void main(String[] args) {

        System.out.println("Start................................................................................................");

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Player player = Player.builder().firstName("shayan").lastName("sam").value(2_000_000.00).build();
            Player player2 = Player.builder().firstName("artin").lastName("sam").value(1_000_000.00).build();
            Player player3 = Player.builder().firstName("muhammad").lastName("soleimani").value(1_000_000.00).build();
            Player player4 = Player.builder().firstName("Ali").lastName("rezaei").value(1_000_000.00).build();
            Player player5 = Player.builder().firstName("babak").lastName("molaei").value(1_000_000.00).build();
            Player player6 = Player.builder().firstName("ahnad").lastName("mostofi").value(1_000_000.00).build();

            Coach coach = Coach.builder().firstName("Bill").lastName("Baily").salary(3000.00).build();
            Coach coach2 = Coach.builder().firstName("alex").lastName("morgan").salary(6900.00).build();

            Set<Player> players = new HashSet<>();
            Set<Player> players2 = new HashSet<>();
            Set<Coach> coaches = new HashSet<>();
            Set<Coach> coaches2 = new HashSet<>();
            players.add(player);players.add(player2);players.add(player3);
            players2.add(player4);players2.add(player5);players2.add(player6);
            coaches.add(coach);
            coaches2.add(coach2);


            Team team = Team.builder().captainId(1L).playerSet(players).coachSet(coaches).name("team_a").build();
            Team team2 = Team.builder().captainId(2L).playerSet(players2).coachSet(coaches2).name("team_b").build();
            Set<Team> teamSet = new HashSet<>();
            teamSet.add(team);

            Season season = Season.builder().year(Year.of(2017)).build();
            Season season1 = Season.builder().year(Year.of(2018)).build();

            Set<Season> seasonSet = new HashSet<>();
            seasonSet.add(season);
            seasonSet.add(season1);

            Stadium stadium = Stadium.builder().name("Azadi").capacity(100_000).build();
            Set<Stadium> stadiumSet = new HashSet<>();
            stadiumSet.add(stadium);

            City city = City.builder().name("tehran").stadiumSet(stadiumSet).teamSet(teamSet).build();
            team.setCity(city);
            team2.setCity(city);
            stadium.setCity(city);





            entityManager.persist(team);
            entityManager.persist(team2);
            entityManager.persist(city);



            entityTransaction.commit();


        }catch (Exception e){
            entityTransaction.rollback();
        }finally {
            entityManager.close();
            JpaUtil.shutdown();
            System.out.println("Done................................................................................................");
        }

    }
}
