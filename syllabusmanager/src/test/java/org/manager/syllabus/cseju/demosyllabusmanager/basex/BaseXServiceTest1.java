package org.manager.syllabus.cseju.demosyllabusmanager.basex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class BaseXServiceTest1 {

    private final String DB = "Undergrad_2018to2022";

    private BaseXService baseXService;

    @Before
    public void init() {
        baseXService = new BaseXService();

        baseXService.startService(DB);
    }

    @Test
    public void executeReadQuery1() {
        String xQuery = "//Category";
        String expected = "<Category>Undergrad</Category>";
        String actual = baseXService.executeReadQuery(xQuery);
        assertEquals(actual, expected);
    }

    @Test
    public void executeReadQuery2() {
        String xQuery = "for $course in //Course\n" +
                "  where($course/CourseCode = 'MATH 101') \n" +
                "    return $course/CourseTitle";

        String expected = "<CourseTitle>Mathematics I (Matrix, Differential Calculus and Coordinate Geometry)</CourseTitle>";
        String actual = baseXService.executeReadQuery(xQuery);
        assertEquals(actual, expected);
    }

    @Test
    public void executeWriteQuery1() {
        String xQuery = "for $course in //Course\n" +
                "  where($course/CourseCode = 'CSE 100')\n" +
                "    return (\n" +
                "      insert node <Book><name>Cracking the Coding interview</name></Book> into $course/Books)";

        baseXService.executeWriteQuery(xQuery);

        xQuery = "for $course in //Course\n" +
                "  where($course/CourseCode = 'CSE 100')\n" +
                "    return $course//Book";

        String expected = "<Book>\n" +
                "  <name>Cracking the Coding interview</name>\n" +
                "</Book>";
        String actual = baseXService.executeReadQuery(xQuery);
        assertEquals(actual, expected);
    }

    @After
    public void close() {
        baseXService.stopService(DB);
    }
}