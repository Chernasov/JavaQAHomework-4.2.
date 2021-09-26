package ru.netology.manager;

import ru.netology.domain.CaseFlight;

public class FlightByTimeFlightAsComparator implements Comparator<CaseFlight> {
    public int compare(CaseFlight o1, CaseFlight o2) {
        return o1.getFlightTime() - o2.getFlightTime();
    }
}
