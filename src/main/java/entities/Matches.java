package entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long id;


    @Column(name = "date",nullable = false)
    private LocalDate date;


    @Column(name = "time",nullable = false)
    private LocalTime time;


    @Column(name = "team_a_id",nullable = false)
    private Long teamA;


    @Column(name = "team_b_id",nullable = false)
    private Long teamB;


    @Column(name = "winner_team_id")
    private Long winner;

    @OneToMany(mappedBy = "matches")
    private Set<Team> teamSet;

    @OneToOne
    private Stadium stadium;

    @ManyToOne
    private Season season;




}
