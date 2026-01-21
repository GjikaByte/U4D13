package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class persona {

    @Id
    @GeneratedValue
    private UUID persona_id;

    private String nome;
    private String cognome;
    private String email;

    @ManyToOne
    @JoinColumn(name = "partecipazione_id", nullable = false)
    private partecipazione partecipazione;
}
