package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.CaseFlight;
import ru.netology.repository.CaseFlightRepository;

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
    private CaseFlight ninth = new CaseFlight(9, 3415, "SMO", "UFA", 110);
    private CaseFlight tenth = new CaseFlight(10, 3715, "SVO", "UFA", 100);
    private CaseFlight eleventh = new CaseFlight(11, 4215, "SVO", "UFA", 99);
    private CaseFlight twelfth = new CaseFlight(12, 5215, "SVO", "UFA", 97);

    @BeforeEach
    public void setUp() { // Добавляем в менеджер в произвольном порядке
        manager.add(fifth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(first);
        manager.add(eighth);
        manager.add(fourth);
        manager.add(seventh);
        manager.add(third);
        manager.add(sixth);
        manager.add(twelfth);
        manager.add(ninth);
        manager.add(second);
    }

    @Test
    public void sholdSearchAllWithFlightOutAndFlightIn() {
        CaseFlight[] actual = manager.searchAll("SVO", "UFA");
        CaseFlight[] expected = new CaseFlight[] {seventh, eighth, tenth, eleventh, twelfth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAllWithFlightOutAndWithoutFlightIn() {
        CaseFlight[] actual = manager.searchAll("SVO", "WED");
        CaseFlight[] expected = new CaseFlight[] {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAllWithoutFlightOutAndWithFlightIn() {
        CaseFlight[] actual = manager.searchAll("RJC", "UFA");
        CaseFlight[] expected = new CaseFlight[] {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAllWithoutFlightOutAndWithoutFlightIn() {
        CaseFlight[] actual = manager.searchAll("RJC", "WMD");
        CaseFlight[] expected = new CaseFlight[] {};
        assertArrayEquals(expected, actual);
    }
}