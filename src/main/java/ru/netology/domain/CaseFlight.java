package ru.netology.domain;

public class CaseFlight implements Comparable <CaseFlight> {
    private int id;
    private int price;
    private String flightOut;
    private String flightIn;
    private int flightTime;

    public CaseFlight(int id, int price, String flightOut, String flightIn, int flightTime) {
        this.id = id;
        this.price = price;
        this.flightOut = flightOut;
        this.flightIn = flightIn;
        this.flightTime = flightTime;
    }

    public CaseFlight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlightOut() {
        return flightOut;
    }

    public void setFlightOut(String flightOut) {
        this.flightOut = flightOut;
    }

    public String getFlightIn() {
        return flightIn;
    }

    public void setFlightIn(String flightIn) {
        this.flightIn = flightIn;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(CaseFlight o) {
        return price - o.price;
    }
}
