package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="eventi")

public class eventi {

    public enum TipoEvento  {
        PUBBLICO,
        PRIVATO
    }
    @Id
    @GeneratedValue
    private long eventi_id;

    @Column(name="titolo", nullable = false, length = 30)
    private String titolo;

    @Column(name="dataEvento", nullable = false)
    private LocalDate dataEvento;

    @Column(name="descrizione",length=50)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name="tipoEvento",length=30)
    private TipoEvento  tipoEvento;

    @Column(name="numeroMassimoPartecipanti")
    private int  numeroMassimoPartecipanti;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private location Location;


    @ManyToOne
    @JoinColumn(name = "partecipazione_id", nullable = false)
    private partecipazione PartecipazioneEventi;

    public eventi() {
    }

    public eventi(String titolo, LocalDate dataEvento, String descrizione,TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public long getId() {
        return eventi_id;
    }

    public void setId(long eventId) {
        this.eventi_id = eventId;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public String toString() {
        return "eventi{" +
                "eventId=" + eventi_id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }

}
