package org.manager.syllabus.cseju.demosyllabusmanager.repository.basex;

import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class CourseStructureRepositoryTest {

    CourseStructureRepository courseStructureRepository = new CourseStructureRepository();

    @Test
    public void createDatabase() {
        courseStructureRepository.createDatabase("test51");
        assertNotEquals(null, new File("src/main/resources/xml/test51.xml"));
    }

    @After
    public void close() {
        File file = new File("src/main/resources/xml/test51.xml");
        if (file.exists()) {
            file.delete();
        }
    }
}