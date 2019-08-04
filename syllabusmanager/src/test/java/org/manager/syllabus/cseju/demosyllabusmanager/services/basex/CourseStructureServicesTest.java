package org.manager.syllabus.cseju.demosyllabusmanager.services.basex;

import org.junit.After;
import org.junit.Test;
import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;

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
        CourseStructure courseStructure = new CourseStructure();
        courseStructure.setName("Theory");
        courseStructure.setContentBundleList(new ArrayList<>());
        courseStructureServices.createXmlDatabase("test51", courseStructure);
        assertNotEquals(null, new File("src/main/resources/xml/test51.xml"));
    }

    @After
    public void close() {
        courseStructureServices.deleteDatabase("test51");
    }
}