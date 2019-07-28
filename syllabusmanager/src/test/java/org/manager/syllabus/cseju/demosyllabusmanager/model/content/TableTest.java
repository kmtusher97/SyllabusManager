package org.manager.syllabus.cseju.demosyllabusmanager.model.content;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TableTest {

    private Table table;

    @Before
    public void init() {
        table = new Table("Untitled Table", new ArrayList<>());
        table.addNewField();
    }

    @Test
    public void toXMLTest() {
        String result = "<table><title>Untitled Table</title><fields><field>Field0</field></fields><rows></rows></table>";
        assertEquals(result, table.toXML());
    }
}