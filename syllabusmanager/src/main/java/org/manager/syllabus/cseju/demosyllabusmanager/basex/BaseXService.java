package org.manager.syllabus.cseju.demosyllabusmanager.basex;

import org.basex.BaseXServer;
import org.basex.api.client.ClientSession;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class BaseXService {

    private final int SERVER_PORT = 1984;
    private final String SERVER_HOST = "localhost";
    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin";
    private final String STORAGE_LOCATION = "src/main/resources/xml/";
    private final String XML_EXTENSION = ".xml";

    private BaseXServer baseXServer;

    private ClientSession session;


    /**
     * Create a new baseX xml database
     *
     * @param databaseName
     * @param rootElementXml
     */
    public void createDatabase(String databaseName, String rootElementXml) {
        try {
            File file = new File(STORAGE_LOCATION + databaseName + XML_EXTENSION);

            if (!file.exists()) {
                file.createNewFile();

                /**
                 * write initial tags
                 */
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(rootElementXml);
                fileWriter.close();

                /**
                 * start the database server
                 */
                startService(databaseName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts the baseX server
     *
     * @param databaseName
     * @throws IOException
     */
    public void startService(String databaseName) throws IOException {
        /**
         * Start server on default port 1984
         */
        String result = null;
        baseXServer = new BaseXServer();

        /**
         * Create a client session with host name, port, user name and password
         */
        try {
            session = new ClientSession(
                    SERVER_HOST, SERVER_PORT,
                    ADMIN_USERNAME, ADMIN_PASSWORD);

            /**
             * Create a database
             */
            session.execute(new CreateDB(databaseName,
                    STORAGE_LOCATION + databaseName + XML_EXTENSION));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stops the baseX server
     *
     * @param databaseName
     */
    public void stopService(String databaseName) {
        try {
            /**
             * Drop the database
             */
            session.execute(new DropDB(databaseName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * Stop the server
         */
        baseXServer.stop();
    }

    /**
     * Stop and Delete the database
     * @param databaseName
     */
    public void stopAndDeleteService(String databaseName) {
        stopService(databaseName);
        /**
         * delete the xml database
         */
        File file = new File(STORAGE_LOCATION + databaseName + XML_EXTENSION);
        if (file.exists()) {
            file.delete();
        }
    }


    /**
     * performs read query
     *
     * @param databaseName
     * @param xQuery
     * @return
     * @throws IOException
     */
    public String executeReadQuery(String databaseName, String xQuery) throws IOException {
        /**
         * Start server on default port 1984
         */
        String result = null;
        result = session.execute("XQUERY " + xQuery);
        return result;
    }

    /**
     * performs write query
     *
     * @param databaseName
     * @param xQuery
     * @throws IOException
     */
    public void executeWriteQuery(String databaseName, String xQuery) throws IOException {
        session.execute("XQUERY " + xQuery);
    }

}
