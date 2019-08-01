package org.manager.syllabus.cseju.demosyllabusmanager.basex;

import org.basex.BaseXServer;
import org.basex.api.client.ClientSession;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;

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
