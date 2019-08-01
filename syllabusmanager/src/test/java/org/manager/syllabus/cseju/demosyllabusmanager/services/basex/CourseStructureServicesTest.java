package org.manager.syllabus.cseju.demosyllabusmanager.services.basex;

import org.junit.After;
import org.junit.Test;
import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

import static org.junit.Assert.*;

public class CourseStructureServicesTest {

    private CourseStructureServices courseStructureServices = new CourseStructureServices();

    @Test
    public void createDatabase() {
        courseStructureServices.createXmlDatabase("test51");
        assertNotEquals(null, new File("src/main/resources/xml/test51.xml"));
    }

    @Test
    public void createXmlDatabaseWithInitialDefinition() {
        courseStructureServices.createXmlDatabase("test51", new CourseStructure());
        assertNotEquals(null, new File("src/main/resources/xml/test51.xml"));
    }

    @After
    public void close() {
        courseStructureServices.deleteDatabase("test51");
    }
}