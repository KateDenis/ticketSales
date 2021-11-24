package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    TicketRepository repository = new TicketRepository();
    Ticket ticket1 = new Ticket(111, 40000, "DME", "SGN", 15);
    Ticket ticket2 = new Ticket(122, 50000, "BKK", "SVO", 15);
    Ticket ticket3 = new Ticket(133, 30000, "SGN", "HAN", 15);
    Ticket ticket4 = new Ticket(144, 20000, "NHA", "HUE", 15);
    Ticket ticket5 = new Ticket(155, 55000, "BKK", "SVO", 15);

    @Test
    void shouldSortByPrice() {
        Ticket[] expected = new Ticket[]{ticket4, ticket3, ticket1, ticket2, ticket5};
        Ticket[] actual = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}