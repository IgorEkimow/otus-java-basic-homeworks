package ru.otus.java.basic.homeworks.homework22;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayToolsTest {
    @Test
    public void testGetLastElementsCaseOne() {
        int[] input = {1, 2, 1, 2, 2};
        int[] expected = {2, 2};
        int[] actual = ArrayTools.getLastElements(input);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLastElementsCaseTwo() {
        int[] input = {2, 2, 2, 2};

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            ArrayTools.getLastElements(input);
        });

        assertEquals("Массив не содержит единиц", exception.getMessage());
    }

    @Test
    public void testValidateArrayCaseOne() {
        int[] input = {1, 2};
        assertTrue(ArrayTools.validateArray(input));
    }

    @Test
    public void testValidateArrayCaseTwo() {
        int[] input = {1, 1};
        assertFalse(ArrayTools.validateArray(input));
    }

    @Test
    public void testValidateArrayCaseThree() {
        int[] input = {1, 3};
        assertFalse(ArrayTools.validateArray(input));
    }

    @Test
    public void testValidateArrayCaseFour() {
        int[] input = {1, 2, 2, 1};
        assertTrue(ArrayTools.validateArray(input));
    }
}