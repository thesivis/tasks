package br.ce.wcaquino.taskbackend.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


public class DateUtilsTest {

    @Test
    public void testDataFutura() {
        LocalDate data = LocalDate.of(2025,01,01);
        assertTrue(DateUtils.isEqualOrFutureDate(data));
    }

    @Test
    public void testDataPassada() {
        LocalDate data = LocalDate.of(2020,01,01);
        assertFalse(DateUtils.isEqualOrFutureDate(data));
    }

    @Test
    public void testDataPresente() {
        LocalDate data = LocalDate.now();
        assertTrue(DateUtils.isEqualOrFutureDate(data));
    }
}
