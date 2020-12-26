package entities;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;


    @Column(name = "cp_id",nullable = false)
    private Long captainId;

    @Column(name = "season_team_score")
    private Integer seasonScore;

    @OneToMany(mappedBy = "team")
    private Set<Player> playerSet;

    @OneToMany(mappedBy = "team")
    private Set<Coach> coachSet;

    @ManyToOne
    private Matches matches;

    @ManyToOne
    private City city;

    @ManyToOne
    private Season season;

}
