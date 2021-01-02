package entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private @Setter(AccessLevel.NONE) Long id;

    @Column(name = "season_score")
    private Integer seasonScore;

    @OneToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
