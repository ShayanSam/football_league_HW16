package app;

import entities.*;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;


public class App {

    public static void main(String[] args) {

        System.out.println("Start................................................................................................");

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

//            Player player = Player.builder().firstName("shayan").lastName("sam").value(2_000_000.00).build();
//            Player player2 = Player.builder().firstName("mark").lastName("helmark").value(1_000_000.00).build();
//            Coach coach = Coach.builder().firstName("Bill").lastName("Baily").salary(3000.00).build();
//            Coach coach2 = Coach.builder().firstName("alex").lastName("morgan").salary(6900.00).build();
//            Team team = Team.builder().captainId(1L).seasonScore(3000).build();
//            Team team2 = Team.builder().captainId(2L).seasonScore(2000).build();
//            Stadium stadium = Stadium.builder().name("azadi").capacity(200_000).build();
//            City city = City.builder().name("tehran").build();
//            Season season = Season.builder().year(Year.of(2017)).build();
//            Matches matches = Matches.builder().date(LocalDate.of(2017,3,5)).time(LocalTime.of(12,55))
//                    .teamA(1L).teamB(2L).winner(1L).build();




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
