package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.CaseFlight;
import ru.netology.repository.CaseFlightRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class FlightManagerTest {
    private CaseFlightRepository repository = new CaseFlightRepository();
    private FlightManager manager =new FlightManager(repository);
    private CaseFlight first = new CaseFlight(1, 1299, "SVO", "KZN", 95);
    private CaseFlight second = new CaseFlight(2, 2199, "VKO", "KZN", 95);
    private CaseFlight third = new CaseFlight(3, 2385, "VKO", "KZN", 91);
    private CaseFlight fourth = new CaseFlight(4, 3100, "DME", "KZN", 95);
    private CaseFlight fifth = new CaseFlight(5, 3101, "DME", "UFA", 120);
    private CaseFlight sixth = new CaseFlight(6, 3201, "VKO", "UFA", 120);
    private CaseFlight seventh = new CaseFlight(7, 3209, "SVO", "UFA", 120);
    private CaseFlight eighth = new CaseFlight(8, 3215, "SVO", "UFA", 110);
    private CaseFlight nineth = new CaseFlight(9, 3415, "SMO", "UFA", 110);
    FlightByTimeFlightAsComparator comparator = new FlightByTimeFlightAsComparator();

    @BeforeEach
    public void setUp() {
        manager.add(fifth);
        manager.add(first);
        manager.add(eighth);
        manager.add(fourth);
        manager.add(seventh);
        manager.add(third);
        manager.add(sixth);
        manager.add(nineth);
        manager.add(second);
    }

    @Test
    public void sholdSearchAllWithFlightOutAndFlightIn() {
        CaseFlight[] actual = manager.searchAll("SVO", "UFA", (Comparator<CaseFlight>) comparator);
        CaseFlight[] expected = new CaseFlight[] {eighth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAllWithFlightOutAndWithoutFlightIn() {
        CaseFlight[] actual = manager.searchAll("SVO", "WED", (Comparator<CaseFlight>
                ) comparator);
        CaseFlight[] expected = new CaseFlight[] {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAllWithoutFlightOutAndWithFlightIn() {
        CaseFlight[] actual = manager.searchAll("RJC", "UFA", (Comparator<CaseFlight>) comparator);
        CaseFlight[] expected = new CaseFlight[] {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAllWithoutFlightOutAndWithoutFlightIn() {
        CaseFlight[] actual = manager.searchAll("RJC", "WMD", (Comparator<CaseFlight>) comparator);
        CaseFlight[] expected = new CaseFlight[] {};
        assertArrayEquals(expected, actual);
    }
}