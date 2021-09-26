package ru.netology.manager;

import ru.netology.domain.CaseFlight;
import ru.netology.repository.CaseFlightRepository;

import java.util.Arrays;

public class FlightManager {
    private CaseFlightRepository repository;

    public FlightManager(CaseFlightRepository repository) {
        this.repository = repository;
    }

    public void add(CaseFlight item) {
        repository.save(item);
    }

    public CaseFlight[] searchAll(String flightFrom, String flightTo) {
        CaseFlight[] result = new CaseFlight[0];
        for (CaseFlight caseFlight : repository.findAll()) {
            if (caseFlight.getFlightIn().equals(flightTo) && caseFlight.getFlightOut().equals(flightFrom)) {
                CaseFlight[] tmp = new CaseFlight[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = caseFlight;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
