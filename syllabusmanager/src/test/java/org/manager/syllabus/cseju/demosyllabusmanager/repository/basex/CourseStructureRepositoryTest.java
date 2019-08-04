package org.manager.syllabus.cseju.demosyllabusmanager.repository.basex;

import org.basex.BaseXServer;
import org.basex.api.client.ClientSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.manager.syllabus.cseju.demosyllabusmanager.basex.BaseXService;
import org.manager.syllabus.cseju.demosyllabusmanager.services.jaxb.JAXBServices;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.*;

public class CourseStructureRepositoryTest {

    @MockBean
    private BaseXServer baseXServer;

    @MockBean
    private ClientSession clientSession;

    CourseStructureRepository courseStructureRepository;

    @Before
    public void init() {
        courseStructureRepository = new CourseStructureRepository(
                new BaseXService(baseXServer, clientSession),
                new JAXBServices()
        );
    }

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