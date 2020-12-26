package entities;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;


    @Column(name = "city_name")
    private String name;


    @OneToMany(mappedBy = "city", cascade = {CascadeType.ALL})
    private Set<Stadium> stadiumSet;

    @OneToMany(mappedBy = "city", cascade = {CascadeType.ALL})
    private Set<Team> teamSet;




}
