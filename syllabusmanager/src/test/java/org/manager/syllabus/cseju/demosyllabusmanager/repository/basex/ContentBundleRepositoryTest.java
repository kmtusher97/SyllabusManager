package org.manager.syllabus.cseju.demosyllabusmanager.repository.basex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.manager.syllabus.cseju.demosyllabusmanager.basex.BaseXService;
import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;
import org.manager.syllabus.cseju.demosyllabusmanager.services.basex.CourseStructureServices;
import org.manager.syllabus.cseju.demosyllabusmanager.services.jaxb.JAXBServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ContentBundleRepositoryTest {

    private final String DB = "test51";
    private CourseStructureServices courseStructureServices = new CourseStructureServices();
    @Autowired
    private ContentBundleRepository contentBundleRepository;// = new ContentBundleRepository();
    private BaseXService baseXService = new BaseXService();

    @Before
    public void init() {
        CourseStructure courseStructure = new CourseStructure();
        courseStructure.setName("Theory");
        courseStructure.setContentBundleList(new ArrayList<>());

        //baseXService.createDatabase(DB, (new JAXBServices()).objectToXmlString(courseStructure, true));
        courseStructureServices.createXmlDatabase(DB, courseStructure);
    }

    @Test
    public void addContentBundle() {
        assertNotEquals(null, new File("src/main/resources/xml/" + DB + ".xml"));
        //baseXService.executeWriteQuery(DB, "insert node <contentBundle contentBundleId=\"0\"><selected>0</selected><table tableId=\"0\"><title>Untitled Table</title><fields><field>Field0</field></fields><rows><row tableRowId=\"0\"><cells><cell>cell0</cell></cells></row></rows></table><textArea textAreaId=\"0\"><title>Untitled TextArea</title><textBody>Empty Text Body</textBody></textArea></contentBundle> into //contentBundles\n");
        //contentBundleRepository.addContentBundle(DB);
        //System.out.println(baseXService.executeReadQuery(DB, "/courseStructure/contentBundles"));
        //contentBundleRepository.addContentBundle(DB);
    }

    @After
    public void close() {
        //baseXService.stopAndDeleteService(DB);
        courseStructureServices.deleteDatabase(DB);
    }
}