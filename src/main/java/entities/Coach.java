package entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private @Setter(AccessLevel.NONE) Long id;

    @Column(name = "coach_name")
    private String name;

    @Column(name = "salary")
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", team=" + getTeam() +
                '}';
    }
}
