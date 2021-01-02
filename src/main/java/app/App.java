package app;

import com.github.javafaker.Faker;
import entities.*;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.*;


public class App {

    public static void main(String[] args) {

        System.out.println("Start................................................................................................");

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Faker fake = new Faker();
            for (int i = 0; i < 100; i++) {
                Player player = new Player();
                player.setFirstName(fake.name().firstName());
                player.setLastName(fake.name().lastName());
                player.setValue(fake.number().randomDouble(2, 100_000_000, 200_000_000));
                entityManager.persist(player);
            }
            for (int i = 0; i < 10; i++) {
                Team team = new Team();
                City city = new City();
                Stadium stadium = new Stadium();
                stadium.setStadiumName(fake.name().name());
                city.setCityName(fake.name().name());
                team.setName(fake.name().name());
                team.setCity(city);
                stadium.setCity(city);
                entityManager.persist(city);
                entityManager.persist(team);
                entityManager.persist(stadium);
            }

            long count = 0;
            for (long i = 1; i<=10; i++) {
                Team team = entityManager.find(Team.class,i);
                team.setCaptain(entityManager.find(Player.class,i));
                for (long j = 1; j <=10 ; j++) {
                    count+=1;
                    Player player = entityManager.find(Player.class, count);
                        player.setTeam(team);
                }

            }

            MatchEvent matchEvent = new MatchEvent();
            matchEvent.setDate(LocalDate.of(1398,4,23));
            matchEvent.setTime(LocalTime.of(12,00));
            matchEvent.setHasWinner(true);
            matchEvent.setAwayTeam(entityManager.find(Team.class,1L));
            matchEvent.setHomeTeam(entityManager.find(Team.class,2L));
            matchEvent.setWinner(entityManager.find(Team.class,1L));

            MatchEvent matchEvent2 = new MatchEvent();
            matchEvent2.setDate(LocalDate.of(1398,5,23));
            matchEvent2.setTime(LocalTime.of(12,00));
            matchEvent2.setHasWinner(true);
            matchEvent2.setAwayTeam(entityManager.find(Team.class,3L));
            matchEvent2.setHomeTeam(entityManager.find(Team.class,4L));
            matchEvent2.setWinner(entityManager.find(Team.class,3L));

            MatchEvent matchEvent3 = new MatchEvent();
            matchEvent3.setDate(LocalDate.of(1398,4,23));
            matchEvent3.setTime(LocalTime.of(12,00));
            matchEvent3.setHasWinner(true);
            matchEvent3.setAwayTeam(entityManager.find(Team.class,5L));
            matchEvent3.setHomeTeam(entityManager.find(Team.class,6L));
            matchEvent3.setWinner(entityManager.find(Team.class,5L));

            MatchEvent matchEvent4 = new MatchEvent();
            matchEvent4.setDate(LocalDate.of(1398,6,23));
            matchEvent4.setTime(LocalTime.of(12,00));
            matchEvent4.setHasWinner(true);
            matchEvent4.setAwayTeam(entityManager.find(Team.class,7L));
            matchEvent4.setHomeTeam(entityManager.find(Team.class,8L));
            matchEvent4.setWinner(entityManager.find(Team.class,8L));

            MatchEvent matchEvent5 = new MatchEvent();
            matchEvent5.setDate(LocalDate.of(1398,4,23));
            matchEvent5.setTime(LocalTime.of(12,00));
            matchEvent5.setHasWinner(true);
            matchEvent5.setAwayTeam(entityManager.find(Team.class,9L));
            matchEvent5.setHomeTeam(entityManager.find(Team.class,10L));
            matchEvent5.setWinner(entityManager.find(Team.class,10L));

            Set<MatchEvent> matchEventSet = new HashSet<>();
            matchEventSet.add(matchEvent);
            matchEventSet.add(matchEvent2);
            matchEventSet.add(matchEvent3);
            matchEventSet.add(matchEvent4);
            matchEventSet.add(matchEvent5);

            entityManager.persist(matchEvent);
            entityManager.persist(matchEvent2);
            entityManager.persist(matchEvent3);
            entityManager.persist(matchEvent4);
            entityManager.persist(matchEvent5);

            Season season = new Season();season.setYear("1398");
            Season season2 = new Season();season2.setYear("1399");
            Set<Team> teamSet = new HashSet<Team>();
            for (long i = 0; i <=10 ; i++) {
                teamSet.add(entityManager.find(Team.class,i));
            }
            season.setTeamSet(teamSet);
            season.setMatchEventSet(matchEventSet);
            entityManager.persist(season);
            entityManager.persist(season2);

            for (long i = 1; i <= 10; i++) {
                Score score = new Score();
                score.setSeasonScore(fake.number().numberBetween(1000,10000));
                score.setTeam(entityManager.find(Team.class,i));
                score.setSeason(entityManager.find(Season.class,1L));
                entityManager.persist(score);
            }

            for (long i = 1; i <=10; i++) {
                Coach coach = new Coach();
                coach.setName(fake.name().firstName());
                coach.setSalary(fake.number().randomDouble(2,1000_000,10_000_000));
                coach.setTeam(entityManager.find(Team.class,i));
                entityManager.persist(coach);
            }
            
            
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
