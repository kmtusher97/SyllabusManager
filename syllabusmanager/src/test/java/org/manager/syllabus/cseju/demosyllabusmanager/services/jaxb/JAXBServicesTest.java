package org.manager.syllabus.cseju.demosyllabusmanager.services.jaxb;

import org.junit.Before;
import org.junit.Test;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.Table;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.TextArea;

import static org.junit.Assert.*;

public class JAXBServicesTest {

    private JAXBServices jaxbServices;

    private TextArea textArea;
    private Table table;

    @Before
    public void init() {
        jaxbServices = new JAXBServices();

        textArea = new TextArea(10, "text area 1", "some text");
        table = new Table();
        table.setTableId(11);
        table.setTitle("table 2");
        table.addNewField();
        table.addNewField();
        table.addRow(56);
    }

    @Test
    public void objectToXmlStringTest1() {
        String actual = jaxbServices.objectToXmlString(textArea);
        String expected = "<textArea textAreaId=\"10\"><title>text area 1</title><textBody>some text</textBody></textArea>";
        assertEquals(actual, expected);
    }

    @Test
    public void objectToXmlStringTest2() {
        String actual = jaxbServices.objectToXmlString(table);
        String expected = "<table tableId=\"11\"><title>table 2</title><fields><field>Field0</field><field>Field1</field></fields><rows><row tableRowId=\"56\"><cells><cell>cell0</cell><cell>cell1</cell></cells></row></rows></table>";
        assertEquals(actual, expected);
    }

    @Test
    public void xmlStringToObjectTest1() {
        String xml = "<textArea textAreaId=\"10\"><title>text area 1</title><textBody>some text</textBody></textArea>";
        TextArea actual = (TextArea) jaxbServices.xmlStringToObject(xml, new TextArea());
        assertEquals(actual.toString(), textArea.toString());
    }

    @Test
    public void xmlStringToObjectTest2() {
        String xml = "<table tableId=\"11\"><title>table 2</title><fields><field>Field0</field><field>Field1</field></fields><rows><row tableRowId=\"56\"><cells><cell>cell0</cell><cell>cell1</cell></cells></row></rows></table>";
        Table actual = (Table) jaxbServices.xmlStringToObject(xml, new Table());
        assertEquals(actual.toString(), table.toString());
    }
}