package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class persona {
    public enum Gender{
        Maschio,
        Femmina,
        NonBinario
    }

    @Id
    @GeneratedValue
    private UUID persona_id;

    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_di_nascita;
    private Gender sesso;

    @ManyToOne
    @JoinColumn(name = "partecipazione_id", nullable = false)
    private partecipazione PartecipazionePersone;

    public persona() {
    }

    public persona(String cognome, LocalDate data_di_nascita, String email, String nome, Gender sesso) {
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
        this.email = email;
        this.nome = nome;
        this.sesso = sesso;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public partecipazione getPartecipazione() {
        return this.PartecipazionePersone;
    }

    public UUID getPersona_id() {
        return persona_id;
    }

    public Gender getSesso() {
        return sesso;
    }

    @Override
    public String toString() {
        return "persona{" +
                "cognome='" + cognome + '\'' +
                ", persona_id=" + persona_id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", sesso=" + sesso +
                ", Partecipazione=" + PartecipazionePersone +
                '}';
    }
}
