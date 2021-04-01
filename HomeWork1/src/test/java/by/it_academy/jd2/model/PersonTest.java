package by.it_academy.jd2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    private final Person person = new Person("Aleksey", "Malashenkov", 27);

    @Test
    void testGetFirstName() {
        person.setFirstName("firstName");
        assertEquals("firstName", person.getFirstName());
    }

    @Test
    void testGetLastName() {
        person.setLastName("lastName");
        assertEquals("lastName", person.getLastName());
    }

    @Test
    void testGetAge() {
        person.setAge(27);
        assertEquals(27, person.getAge());
    }

    @Test
    void testSetFirstName() {
        person.setFirstName("firstName");
        assertEquals("firstName", person.getFirstName());
    }

    @Test
    void testSetLastName() {
        person.setLastName("lastName");
        assertEquals("lastName", person.getLastName());
    }

    @Test
    void testSetAge() {
        person.setAge(27);
        assertEquals(27, person.getAge());
    }

    @Test
    void testToString() {
        String expected = "firstName='" + person.getFirstName() + '\'' +
                ", lastName='" + person.getLastName() + '\'' +
                ", age=" + person.getAge();
        assertEquals(expected, person.toString());
    }
}
