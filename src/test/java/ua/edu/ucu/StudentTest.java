package ua.edu.ucu;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void equalsNullTest() {
        Student studActual = new Student("Ivan", "Morozenko", 4.1, 3);
        String studExpected = "Student{name=Ivan, surname=Morozenko, GPA=4.1, year=3}";
        assertEquals(studActual.toString(), studExpected);
    }
}
