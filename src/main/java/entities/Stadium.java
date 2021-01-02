package entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadium_id")
    private @Setter(AccessLevel.NONE) Long id;

    @Column(name = "stadium_name")
    private String stadiumName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;





}
