/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partha.mongodb.manager;

import java.net.UnknownHostException;

/**
 *
 * @author Partha
 */
final class DBManger extends DBHelper {

    static DBManger helperdb;

    private DBManger(String schema, String DBURL, Integer portNumber) throws UnknownHostException {
        super(schema, DBURL, portNumber);
    }

    public static DBManger getObj(String schema, String DBURL, Integer portNumber) throws UnknownHostException {
        if (helperdb == null) {
            DBManger db = new DBManger(schema, DBURL, portNumber);
            helperdb = db;
        }
        return helperdb;
    }

}
