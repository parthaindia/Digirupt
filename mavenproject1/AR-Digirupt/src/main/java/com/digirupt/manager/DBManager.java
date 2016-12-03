/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digirupt.manager;

import com.digirupt.dto.Item;
import com.digirupt.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import partha.mongodb.manager.DBpublicConnector;
import partha.mongodb.manager.MongoInterface;

/**
 *
 * @author Partha
 */
public class DBManager {

    public static MongoInterface getDB() throws Exception {
        String schema = Constants.DBSCHEMA;
        String dbUrl = Constants.DBURL;
        Integer dbPort = Integer.parseInt(Constants.DBPORT);
        MongoInterface db = new DBpublicConnector().getConnection(schema, dbUrl, dbPort);
        return db;
    }

    public static void main(String[] args) throws Exception {
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "partha");

//        String json = new Gson().toJson(map, new TypeToken<Map<String, String>>() {
//        }.getType());
//        DBManager.getDB().addDefault("test", json);
//     String json="";
//        String []strary=new String[]{"Colgate","coin","bottle","cup","tea","sauce",""};
//        for(String s:strary){
//            Item item = new Item();
//        item.setName(s);
//         json = new Gson().toJson(item, new TypeToken<Item>() {
//        }.getType());
//        DBManager.getDB().addDefault("item", json);
//        }
//        json = DBManager.getDB().getAll("item");
//        json=DBManager.getDB().getByKey("item", "5841c3c5da9c37c320d4fac3");
//        System.out.println(json);
//                List<Item>  json1 = new Gson().fromJson(json, new TypeToken<List<Item>>() {
//        }.getType());
//        System.out.println(json1.get(0).);
        Map<String, Integer> testMap = new HashMap();

        testMap.put("5841c3c5da9c37c320d4fac3", 1);
        testMap.put("5841c3c5da9c37c320d4fac4", 1);
        testMap.put("5841c3c5da9c37c320d4fac5", 1);
        testMap.put("5841c3c5da9c37c320d4fac6", 1);

        String json = new Gson().toJson(testMap, new TypeToken<Map<String, String>>() {
        }.getType());
        System.out.println(json);
    }

}
