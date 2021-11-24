package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(111, 20000, "DME", "SGN", 15);
    Ticket ticket2 = new Ticket(122, 25000, "BKK", "SVO", 15);
    Ticket ticket3 = new Ticket(133, 30000, "SGN", "HAN", 15);
    Ticket ticket4 = new Ticket(144, 40000, "NHA", "HUE", 15);
    Ticket ticket5 = new Ticket(155, 50000, "BKK", "SVO", 15);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    void shouldCheckFindAllFromDepartureToArrival() {
        Ticket[] expected = {ticket2, ticket5};
        Ticket[] actual = manager.findAll("BKK", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckFindAllFromDepartureNotFoundArrival() {
        assertThrows(NotFoundException.class, () -> {
            manager.findAll("DME", "NHA");
        });
    }

    @Test
    void shouldCheckNotFound() {
        assertThrows(NotFoundException.class, () -> {
            manager.findAll("SVO", "BKK");
        });
    }
}