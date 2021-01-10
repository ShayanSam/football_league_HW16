package entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.Year;
import java.util.Set;

@Entity
@Getter
@Setter
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id")
    private @Setter(AccessLevel.NONE) Long id;

    @Column(name = "season_year")
    private String Year;

    @OneToMany
    private Set<Team> teamSet;

    @OneToMany
    private Set<MatchEvent> matchEventSet;


    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", Year='" + Year + '\'' +
                ", teamSet=" + getTeamSet() +
                ", matchEventSet=" + getMatchEventSet() +
                '}';
    }
}
