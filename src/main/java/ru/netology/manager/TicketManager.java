package ru.netology.manager;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.sql.Array;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] allFromRepository = repository.findAll();
        Ticket[] result = new Ticket[0];
        for (Ticket item : allFromRepository) {
            if (item.getDepartureApt().equalsIgnoreCase(from) &&
                    item.getArrivalApt().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[result.length] = item;
                result = tmp;
            }
        }
        if (result.length == 0) {
            throw new NotFoundException("Element with: from: " + from + " to: " + to + " not found"
            );
        }
        Arrays.sort(result);
        return result;
    }
}
