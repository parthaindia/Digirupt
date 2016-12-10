package partha.mongodb.manager;

import java.net.UnknownHostException;

/**
 *
 * @author Partha
 */
public class DBpublicConnector {

    public DBManger getConnection(String schema, String DBURL, Integer portNumber) throws UnknownHostException {
        DBManger db = DBManger.getObj(schema, DBURL, portNumber);
        return db;
    }
}
