package epicode.entities;
import epicode.Enum.TipoEvento;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.stream.Location;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name= "partita_di_calcio")
public class PartitaDiCalcio extends Event {

    private String SquadraDiCasa;
    private String SquadraOspite;
    private String SquadraVincente;
    private int GolSquadraDiCasa;
    private int GolSquadraOspite;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, List<Partecipazione> partecipazioneList, String squadraDiCasa, String squadraOspite, String squadraVincente, int golSquadraDiCasa, int golSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location, partecipazioneList);
        SquadraDiCasa = squadraDiCasa;
        SquadraOspite = squadraOspite;
        SquadraVincente = squadraVincente;
        GolSquadraDiCasa = golSquadraDiCasa;
        GolSquadraOspite = golSquadraOspite;
    }


    public String getSquadraVincente() {
        return SquadraVincente;
    }

    public String getSquadraDiCasa() {
        return SquadraDiCasa;
    }

    public String getSquadraOspite() {
        return SquadraOspite;
    }

    public int getGolSquadraDiCasa() {
        return GolSquadraDiCasa;
    }

    public int getGolSquadraOspite() {
        return GolSquadraOspite;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        SquadraDiCasa = squadraDiCasa;
    }

    public void setSquadraOspite(String squadraOspite) {
        SquadraOspite = squadraOspite;
    }

    public void setSquadraVincente(String squadraVincente) {
        SquadraVincente = squadraVincente;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        GolSquadraOspite = golSquadraOspite;
    }

    public void setGolSquadraDiCasa(int golSquadraDiCasa) {
        GolSquadraDiCasa = golSquadraDiCasa;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "SquadraDiCasa='" + SquadraDiCasa + '\'' +
                ", SquadraOspite='" + SquadraOspite + '\'' +
                ", SquadraVincente='" + SquadraVincente + '\'' +
                ", GolSquadraDiCasa=" + GolSquadraDiCasa +
                ", GolSquadraOspite=" + GolSquadraOspite +
                '}';
    }
}