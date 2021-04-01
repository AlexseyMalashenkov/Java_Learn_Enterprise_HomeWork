package by.it_academy.jd2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadTypeTest {
    LoadType loadType = LoadType.SESSION;
    @Test
    void testEnum() {
        assertEquals("SESSION", loadType.toString());
    }
}
