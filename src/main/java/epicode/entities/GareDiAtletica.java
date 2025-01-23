package epicode.entities;
import epicode.Enum.TipoEvento;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.stream.Location;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name= "GareDiAtletica")
public class GareDiAtletica extends Event {

    private Persona setAtleti;
    private Persona vincitore;

    public GareDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, List<Partecipazione> partecipazioneList, String squadraDiCasa, String squadraOspite, String squadraVincente, int golSquadraDiCasa, int golSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location, partecipazioneList);

        this.setAtleti= setAtleti;
        this.vincitore= vincitore;

    }

    public Persona getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Persona setAtleti) {
        this.setAtleti = setAtleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GareDiAtletica{" +
                "setAtleti=" + setAtleti +
                ", vincitore=" + vincitore +
                '}';
    }
}