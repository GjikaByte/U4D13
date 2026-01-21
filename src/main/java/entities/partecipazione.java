package entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "partecipazioni")
public class partecipazione {

    public enum Stato {
        CONFERMATA,
        DA_CONFERMARE
    }

    @Id
    @GeneratedValue
    private UUID partecipazione_id;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @ManyToMany
    @JoinTable(
            name = "persona_partecipazione",
            joinColumns = @JoinColumn(name = "partecipazione_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private List<persona> persone;

    @OneToMany(mappedBy = "partecipazione")
    private List<eventi> eventi;
}
