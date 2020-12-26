package entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    @Column(name = "player_firstname",nullable = false,length = 50)
    private String firstName;

    @Column(name = "player_lastname",nullable = false,length = 50)
    private String lastName;


    @Column(name = "player_value",nullable = false)
    private Double value;

    @ManyToOne
    private Team team;


}
