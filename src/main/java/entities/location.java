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
    @OneToMany(mappedBy = "Location")
    private List<eventi> eventi;

    public location() {
    }

    public location(String citta, String nome) {
        this.citta = citta;
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public List<eventi> getEventi() {
        return eventi;
    }

    public String getNome() {
        return nome;
    }

    public UUID getLocation_id() {
        return location_id;
    }

    @Override
    public String toString() {
        return "location{" +
                "citta='" + citta + '\'' +
                ", location_id=" + location_id +
                ", nome='" + nome + '\'' +
                ", eventi=" + eventi +
                '}';
    }
}
