package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class TextAreaTest {

    private final String STORAGE_LOCATION = "storage/test/test.xml";
    private TextArea textArea;

    @Before
    public void init() throws IOException {
        textArea = new TextArea(12, "Course Summary", "Empty Text Body");

        File file = new File(STORAGE_LOCATION);
        if(!file.exists()) {
            file.createNewFile();
        }
    }

    @Test
    public void testPOJOToXml() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TextArea.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(textArea, new File(STORAGE_LOCATION));
        marshaller.marshal(textArea, System.out);
    }

    @After
    public void close() {
        File file = new File(STORAGE_LOCATION);
        file.delete();
    }
}