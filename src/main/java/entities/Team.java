package entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Entity
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private @Setter(AccessLevel.NONE) Long id;

    @Column(name = "team_name")
    private String name;

    @OneToOne
    @JoinColumn(name = "team_cp")
    private Player captain;

    @OneToMany(mappedBy = "team")
    private Set<Player> playerSet;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
