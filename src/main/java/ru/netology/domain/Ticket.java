package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket>{
    private int id;
    private int price;
    private String departureApt;
    private String arrivalApt;
    private int time;

    public Ticket() {
    }

    public Ticket(int id, int price, String departureApt, String arrivalApt, int time) {
        this.id = id;
        this.price = price;
        this.departureApt = departureApt;
        this.arrivalApt = arrivalApt;
        this.time = time;
    }

    public String getDepartureApt() {
        return departureApt;
    }

    public String getArrivalApt() {
        return arrivalApt;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departureApt, arrivalApt, time);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
