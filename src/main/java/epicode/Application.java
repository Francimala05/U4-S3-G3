package epicode;

import com.github.javafaker.Faker;
import epicode.dao.PartecipazioneDAO;
import epicode.dao.EventsDAO;
import epicode.dao.LocationDAO;
import epicode.dao.PersonaDAO;
import epicode.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d13");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        EventsDAO eventsDAO = new EventsDAO(em);
        LocationDAO locationsDAO = new LocationDAO(em);
        PersonaDAO peopleDAO = new PersonaDAO(em);
        PartecipazioneDAO attendancesDAO = new PartecipazioneDAO(em);
        Random rndm = new Random();

        // ******************** SALVATAGGIO LOCATIONS, UTENTI E EVENTI ************************

        Location location1 = new Location(faker.address().city(), faker.address().cityName());
        // locationsDAO.save(location1);

        Location location2 = new Location(faker.address().city(), faker.address().cityName());
        // locationsDAO.save(location2);

        Persona persona1 = new Persona(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),  LocalDate.now(), rndm.nextInt(0, 2) == 0 ? 'M' : 'F');

        // ******************** PARTECIPAZIONE AD UN EVENTO ************************

        Persona person = peopleDAO.findById(23);
        Event event = eventsDAO.findById(24);

        Partecipazione partecipazione = new Partecipazione(person, event);
        // attendancesDAO.save(partecipazione);

        // Stampo eventi a cui partecipa la persona 23
        person.getListaPartecipazioni().forEach(System.out::println);

        // Stampo elenco partecipanti evento 24
        event.getListaPartecipazioni().forEach(System.out::println);

        // ******************** CASCADING ************************

        // Eliminando un evento dovrebbe eliminare anche le partecipazioni ad esso collegate
        eventsDAO.findByIdAndDelete(24);


        em.close();
        emf.close();
    }
}
