package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.component.TableRow;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class TableTest {

    private final String STORAGE_LOCATION = "storage/test/test.xml";
    private Table table;

    @Before
    public void init() throws IOException {
        table = new Table();
        table.setTableId(125);
        table.setTitle("Course Content");
        table.addNewField();
        table.addNewField();
        table.setRows(new ArrayList<TableRow>(Collections.singleton(new TableRow(1, new ArrayList<>()))));

        File file = new File(STORAGE_LOCATION);
        if(!file.exists()) {
            file.createNewFile();
        }
    }

    @Test
    public void testPOJOToXml() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(table, new File(STORAGE_LOCATION));
        marshaller.marshal(table, System.out);
    }

    @After
    public void close() {
        File file = new File(STORAGE_LOCATION);
        file.delete();
    }
}