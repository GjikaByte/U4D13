package entities;

import jakarta.persistence.*;

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


}
