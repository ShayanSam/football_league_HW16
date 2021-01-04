package entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private @Setter(AccessLevel.NONE)
    Long id;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "season_salary")
    private Double seasonSalary;

    @OneToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", player=" + player +
                ", seasonSalary=" + seasonSalary +
                '}';
    }
}