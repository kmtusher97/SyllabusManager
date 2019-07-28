package org.manager.syllabus.cseju.demosyllabusmanager.xQueryManager;

import org.junit.Before;
import org.junit.Test;
import org.manager.syllabus.cseju.demosyllabusmanager.model.content.ContentBundle;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class XQueryManagerTest {

    private XQueryManager xQueryManager;

    @Before
    public void init() {
        xQueryManager = new XQueryManager();
    }

    @Test
    public void createNexXQueryFileIfNotExistsTest() throws IOException {
        xQueryManager.createNexXQueryFileIfNotExists(xQueryManager.getINSERT_QUERY_FILE());

        File file = new File(xQueryManager.getQUERY_STORAGE_PATH() + xQueryManager.getINSERT_QUERY_FILE());
        assertFalse(!file.exists());
    }

    @Test
    public void makeInsertQueryTest() throws IOException {
        xQueryManager.makeInsertQuery("test1.xml", "<a></a>", "courseStructure");

        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(xQueryManager.getQUERY_STORAGE_PATH() + xQueryManager.getINSERT_QUERY_FILE()))) {

            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Test
    public void testInitialXmlAdd() throws IOException {
        xQueryManager.writeInitialXMLTags(new File(xQueryManager.getSTORAGE_PATH() + "test21.xml"));

        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(xQueryManager.getSTORAGE_PATH() + "test21.xml"))) {

            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw e;
        }
    }
}