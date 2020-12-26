package entities;

import lombok.*;

import javax.persistence.*;
import java.time.Year;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id")
    private Long id;


    @Column(name = "season_year")
    private Year year;


    @OneToMany(mappedBy = "season")
    private Set<Team> teamSet;


    @OneToMany(mappedBy = "season")
    private Set<Matches> matchSet;






}
