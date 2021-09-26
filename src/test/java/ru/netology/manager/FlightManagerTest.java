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
    private CaseFlight third = new CaseFlight(3, 2385, "VKO", "KZN", 95);
    private CaseFlight fourth = new CaseFlight(4, 3100, "DME", "KZN", 95);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(fourth);
        manager.add(third);
        manager.add(second);
    }

    @Test
    public void searchAll() {
        CaseFlight[] actual = manager.searchAll("VKO", "KZN");
        CaseFlight[] expected = new CaseFlight[] {second, third};
        assertArrayEquals(expected, actual);
    }
}