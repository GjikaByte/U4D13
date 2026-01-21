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

    @OneToMany(mappedBy = "PartecipazionePersone")
    private List<persona> Persone;

    @OneToMany(mappedBy = "PartecipazioneEventi")
    private List<eventi> eventi;

    public partecipazione() {
    }

    public partecipazione(Stato stato) {
        this.stato = stato;
    }

    public List<eventi> getEventi() {
        return eventi;
    }

    public UUID getPartecipazione_id() {
        return partecipazione_id;
    }

    public List<persona> getPersone() {
        return this.Persone;
    }

    public Stato getStato() {
        return stato;
    }

    @Override
    public String toString() {
        return "partecipazione{" +
                "eventi=" + eventi +
                ", partecipazione_id=" + partecipazione_id +
                ", stato=" + stato +
                ", persone=" + Persone +
                '}';
    }
}
