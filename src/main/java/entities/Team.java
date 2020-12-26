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

    @Column(name = "name")
    private String name;


    @Column(name = "cp_id",nullable = false)
    private Long captainId;

    @OneToMany(mappedBy = "team",cascade = {CascadeType.ALL})
    private Set<Player> playerSet;

    @OneToMany(mappedBy = "team",cascade = {CascadeType.ALL})
    private Set<Coach> coachSet;


    @ManyToOne
    private City city;



}
