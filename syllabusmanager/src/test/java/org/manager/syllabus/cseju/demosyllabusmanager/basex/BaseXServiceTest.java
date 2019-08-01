package org.manager.syllabus.cseju.demosyllabusmanager.basex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class BaseXServiceTest {

    private BaseXService baseXService = new BaseXService();

    @Before
    public void createTestDBFile() throws IOException {
        File file = new File("src/main/resources/xml/test21.xml");
        if (!file.exists()) {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("<?xml version='1.0' encoding='UTF-8'?>\n" +
                    "<courseStructure>\n" +
                    "  <contentBundles>\n" +
                    "    <contentBundle id=\"1\">\n" +
                    "      <name>Bundle 1</name>\n" +
                    "    </contentBundle>\n" +
                    "    <contentBundle id=\"2\">\n" +
                    "      <name>Bundle 2</name>\n" +
                    "    </contentBundle>\n" +
                    "  </contentBundles>\n" +
                    "</courseStructure>");
            fileWriter.close();
        }

        baseXService.startService("test21");
    }

    @Test
    public void testReadQuery() throws IOException {
        String query = "//contentBundle[@id=2]/name";
        assertEquals("<name>Bundle 2</name>", baseXService.executeReadQuery("test21", query));
    }

    @Test
    public void testInsertQuery() throws IOException {
        String query = "insert node " +
                "<contentBundle id=\"3\"><name>Bundle 3</name></contentBundle>" +
                " into /courseStructure/contentBundles";
        baseXService.executeWriteQuery("test21", query);
        query = "/courseStructure//contentBundle[@id=3]/name";
        assertEquals("<name>Bundle 3</name>", baseXService.executeReadQuery("test21", query));
    }

    @Test
    public void testInsertQuery1() throws IOException {
        String query = "insert node " +
                "<textArea><title>Untitled Text Area</title></textArea>" +
                " into /courseStructure//contentBundle[@id=2]";
        baseXService.executeWriteQuery("test21", query);
        query = "/courseStructure//contentBundle[@id=2]/textArea/title";
        assertEquals("<title>Untitled Text Area</title>", baseXService.executeReadQuery("test21", query));
    }

    @Test
    public void testDeleteQuery() throws IOException {
        String query = "delete node //contentBundle[@id=1]";
        baseXService.executeWriteQuery("test21", query);
        query = "count(//contentBundle)";
        assertEquals(1, Integer.parseInt(baseXService.executeReadQuery("test21", query)));
    }

    @After
    public void destroyTestDBFile() {
        baseXService.stopService("test21");

        File file = new File("src/main/resources/xml/test21.xml");
        file.delete();

    }
}