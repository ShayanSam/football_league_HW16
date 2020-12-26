package entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
public class Stadium {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadium_id")
    private Long id;


    @Column(name = "stadium_name")
    private String name;


    @Column(name = "stadium_capacity")
    private Integer capacity;

    @OneToOne(mappedBy = "stadium")
    private Matches matches;

    @ManyToOne
    private City city;





}
