package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContainerTest{

    @Test
    public void testAddAndGet() {
        Container<String> container = new Container<>();
        container.add("Hello");
        container.add("World");

        assertEquals("Hello", container.get(0));
        assertEquals("World", container.get(1));
    }

    @Test
    public void testRemove() {
        Container<String> container = new Container<>();
        container.add("Hello");
        container.add("World");

        String removed = container.remove(0);
        assertEquals("Hello", removed);
        assertEquals("World", container.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndex() {
        Container<String> container = new Container<>();
        container.get(0); // Должно выбросить исключение
    }

    @Test
    public void testSize() {
        Container<String> container = new Container<>();
        container.add("Hello");
        container.add("World");

        assertEquals(2, container.size());
    }

    @Test
    public void testIsEmpty() {
        Container<String> container = new Container<>();
        assertTrue(container.isEmpty());

        container.add("Hello");
        assertFalse(container.isEmpty());
    }
}