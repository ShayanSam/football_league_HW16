package entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private Long id;

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;


    @Column(name = "salary",nullable = false)
    private Double salary;

    @ManyToOne
    private Team team;







}
