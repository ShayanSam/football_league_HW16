package entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class MatchEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private @Setter(AccessLevel.NONE) Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name  = "time")
    private LocalTime time;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team awayTeam;

    @ManyToOne
    private Team winner;

    @Column(name = "hasWinner")
    private boolean hasWinner;

}
