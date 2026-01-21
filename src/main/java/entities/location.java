package entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="location")
public class location {
    @Id
    @GeneratedValue
    private UUID location_id;

    @Column
    private String nome;
    private String citta;
    @OneToMany(mappedBy = "location")
    private List<eventi> eventi;


}
