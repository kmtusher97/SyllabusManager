package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.component.TableRow;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import static org.junit.Assert.*;

public class TableTest {

    private final int CUT_INDEX = 56;
    private final String STORAGE_LOCATION = "storage/test/test.xml";
    private Table table;

    @Before
    public void init() throws IOException {
        table = new Table();
        table.setTableId(125);
        table.setTitle("Course Content");
        table.addNewField();
        table.addNewField();
        table.addRow(1);
        table.addRow(2);

        File file = new File(STORAGE_LOCATION);
        if (!file.exists()) {
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

    @Test
    public void testPOJOToXmlStringViceVersa() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(table, stringWriter);

        String tableXmlString = (stringWriter.toString()).substring(CUT_INDEX);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader stringReader = new StringReader(tableXmlString);

        Table actual = (Table) unmarshaller.unmarshal(stringReader);

        assertEquals(actual.getTableId(), table.getTableId());
        assertEquals(actual.getTitle(), table.getTitle());
        assertEquals(actual.getFields(), table.getFields());
        List<TableRow> actual1 = actual.getRows();
        List<TableRow> expected1 = table.getRows();
        for(int i = 0; i < actual1.size(); i++) {
            assertEquals(actual1.get(i).getTableRowId(), expected1.get(i).getTableRowId());
            for(int j = 0; j < expected1.get(i).getCells().size(); j++) {
                assertEquals(actual1.get(i).getCells().get(j), expected1.get(i).getCells().get(j));
            }
        }
    }

    @After
    public void close() {
        File file = new File(STORAGE_LOCATION);
        file.delete();
    }
}