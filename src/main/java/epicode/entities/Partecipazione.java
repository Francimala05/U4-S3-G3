package epicode.entities;

import epicode.Enum.TipoStato;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event evento;
    @Enumerated(EnumType.STRING)
    private TipoStato stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Event evento) {
        this.persona = persona;
        this.evento = evento;
        this.stato = TipoStato.confermata;
    }

    public long getId() {
        return id;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public TipoStato getStato() {
        return stato;
    }

    public void setStato(TipoStato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
