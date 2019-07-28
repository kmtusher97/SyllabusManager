package org.manager.syllabus.cseju.demosyllabusmanager.model;

import org.junit.Before;
import org.junit.Test;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.Table;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.TextArea;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.soap.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseStructureTest {

    private CourseStructure courseStructure;

    @Before
    public void init() throws IOException {
        courseStructure = new CourseStructure();
        courseStructure.setName("Theory");
        ContentBundle contentBundle = new ContentBundle();
        contentBundle.setTextArea(new TextArea("Course Summary"));
        Table table = new Table("Course Content", new ArrayList<>());
        table.addNewField();
        table.addNewField();
        contentBundle.setTable(table);
        List<ContentBundle> contentBundleList = new ArrayList<>();
        contentBundleList.add(contentBundle);
        courseStructure.setContentBundleList(contentBundleList);


        File file = new File("storage/test/test.xml");
        if(!file.exists()) {
            file.createNewFile();
            throw new FileNotFoundException("no such file");
        }
    }

    @Test
    public void testXmlStorageProcess() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(CourseStructure.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(courseStructure, new File("storage/test/test.xml"));
        marshaller.marshal(courseStructure, System.out);
    }
}