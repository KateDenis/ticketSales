package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public void save(Ticket item) {
        int length = this.items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(this.items, 0, tmp, 0, this.items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        this.items = tmp;
    }

    public Ticket[] findAll() {
        return this.items;
    }
}

