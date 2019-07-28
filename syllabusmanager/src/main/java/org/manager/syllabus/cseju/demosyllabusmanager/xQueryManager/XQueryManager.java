package org.manager.syllabus.cseju.demosyllabusmanager.xQueryManager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.manager.syllabus.cseju.demosyllabusmanager.model.CourseStructure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class XQueryManager {

    private File xQueryFile;
    private File storageFile;

    private final String STORAGE_PATH = "storage/test/";
    private final String QUERY_STORAGE_PATH = "storage/xQuery/";

    private final String INSERT_QUERY_FILE = "insert.xq";
    private final String DELETE_QUERY_FILE = "delete.xq";
    private final String UPDATE_QUERY_FILE = "update.xq";

    private FileWriter fileWriter;

    public void createNexXQueryFileIfNotExists(String filename) throws IOException {
        xQueryFile = new File(QUERY_STORAGE_PATH + filename);
        if (!xQueryFile.exists()) {
            xQueryFile.createNewFile();
        }
    }

    public void createNewXMLFileIfNotExists(String filenameWithExtension) throws IOException {
        storageFile = new File(STORAGE_PATH + filenameWithExtension);

        if (!storageFile.exists()) {
            storageFile.createNewFile();
            writeInitialXMLTags(storageFile);
        }
    }

    public void writeInitialXMLTags(File storageFile) throws IOException {
        fileWriter = new FileWriter(storageFile);
        fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + (new CourseStructure()).toXML());
        fileWriter.close();
    }

    public void makeInsertQuery(String filenameWithExtension,
                                String node,
                                String parentNode) throws IOException {

        createNexXQueryFileIfNotExists(INSERT_QUERY_FILE);

        fileWriter = new FileWriter(QUERY_STORAGE_PATH + INSERT_QUERY_FILE);
        fileWriter.write("insert node " + node + " into doc('" + STORAGE_PATH + filenameWithExtension + "')//" + parentNode);
        fileWriter.close();
    }
}
