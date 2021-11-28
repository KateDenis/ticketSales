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
    Ticket ticket4 = new Ticket(144, 40000, "BKK", "SVO", 15);
    Ticket ticket5 = new Ticket(155, 50000, "BKK", "SVO", 15);
    Ticket ticket6 = new Ticket(166, 20000, "SVO", "SGN", 15);
    Ticket ticket7 = new Ticket(177, 35000, "BKK", "SVO", 15);
    Ticket ticket8 = new Ticket(188, 30000, "SGN", "HAN", 15);
    Ticket ticket9 = new Ticket(199, 40000, "NHA", "HUE", 15);
    Ticket ticket10 = new Ticket(200, 31000, "BKK", "SVO", 15);
    Ticket ticket11 = new Ticket(211, 20000, "DME", "SGN", 15);
    Ticket ticket12 = new Ticket(222, 22000, "BKK", "SVO", 15);
    Ticket ticket13 = new Ticket(233, 30000, "SGN", "HAN", 15);
    Ticket ticket14 = new Ticket(244, 40000, "NHA", "HUE", 15);
    Ticket ticket15 = new Ticket(255, 50000, "HAN", "SVO", 15);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
        manager.add(ticket13);
        manager.add(ticket14);
        manager.add(ticket15);
    }

    @Test
    void shouldCheckFindAllFromDepartureToArrival() {
        Ticket[] expected = {ticket12, ticket2, ticket10, ticket7, ticket4, ticket5};
        Ticket[] actual = manager.findAll("BKK", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCheckFindAllFromDepartureToArrivalOne() {
        Ticket[] expected = {ticket15};
        Ticket[] actual = manager.findAll("HAN", "SVO");
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