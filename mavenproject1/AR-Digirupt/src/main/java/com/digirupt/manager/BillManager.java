package com.digirupt.manager;

import com.digirupt.dto.Bill;
import com.digirupt.dto.Item;
import com.digirupt.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Partha
 */
public class BillManager {

    public String saveItem(String price, String name, String category) throws Exception {
        if (price == null || price.equals("") || name == null || name.equals("") || category == null || category.equals("")) {
            return null;
        }
        Item item = new Item();
        item.setCategotry(category);
        item.setName(name);
        item.setPrice(price);
        String json = new Gson().toJson(item, new TypeToken<Item>() {
        }.getType());
        return DBManager.getDB().addDefault(Constants.ITEM_TABLE, json);
    }

    public String getItem(String id) throws Exception {
        if (id == null || id.equals("")) {
            return null;
        }
        return DBManager.getDB().getByKey(Constants.ITEM_TABLE, id);
    }

    public String getItem(String id, String custom) throws Exception {
        if (id == null || id.equals("") || custom == null || custom.equals("")) {
            return null;
        }
        String ary[] = custom.split(",");
      
        
        
        String resultJson = DBManager.getDB().getByKey(Constants.ITEM_TABLE, id);
        List<Map> itemList = new Gson().fromJson(resultJson, new TypeToken<List<Map>>() {
        }.getType());

        
        Map<Object, String> itemmap = (Map<Object, String>) itemList.get(0);
       return customJson(ary,itemmap);
    }

    public String customJson(String[] ar, Map<Object, String> inputMap) {
        if (ar == null || ar.length == 0 || inputMap == null || inputMap.isEmpty()) {
            return null;
        }
        Map<String, String> resultMap = new HashMap<String, String>();
        for (String st : ar) {
            if (inputMap.containsKey(st)) {
                resultMap.put(st, inputMap.get(st));
            }
        }
        return new Gson().toJson(resultMap, new TypeToken<Map>() {
        }.getType());

    }

    public String getAllItem() throws Exception {

        return DBManager.getDB().getAll(Constants.ITEM_TABLE);
    }
    public String getAllItem(String custom) throws Exception {

        
        String ar[]=custom.split(",");
      String listJson=  DBManager.getDB().getAll(Constants.ITEM_TABLE);
       List<Map> itemList = new Gson().fromJson(listJson, new TypeToken<List<Map>>() {
        }.getType());
        
          List<Map<String,String>> resultList=new ArrayList();
          for(Map mp:itemList){
              
           Map<String, String> resultMap = new HashMap<String, String>();
        for (String st : ar) {
            if (mp.containsKey(st)) {
                resultMap.put(st, (String) mp.get(st));
            }
        }
        resultList.add(resultMap);
          }
        return new Gson().toJson(resultList, new TypeToken<List>() {
        }.getType());
    }

    public String createBill(List<Item> itemList, String category) throws Exception {
        if (itemList == null || itemList.isEmpty() || category == null || category.equals("")) {
            return null;
        }
        Bill bill = new Bill();
        bill.setItemList(itemList);
        bill.setCategotry(category);
        String json = new Gson().toJson(bill, new TypeToken<Bill>() {
        }.getType());
        return DBManager.getDB().getByKey(Constants.BILL_TABLE, json);
    }

    public String getBill(String id) throws Exception {
        if (id == null || id.equals("")) {
            return null;
        }
        return DBManager.getDB().getByKey(Constants.BILL_TABLE, id);
    }
    
        public String getBill(String id, String custom) throws Exception {
        if (id == null || id.equals("") || custom == null || custom.equals("")) {
            return null;
        }
        String ar[] = custom.split(",");
      
        
        
        String resultJson = DBManager.getDB().getByKey(Constants.BILL_TABLE, id);
        List<Map> billList = new Gson().fromJson(resultJson, new TypeToken<List<Map>>() {
        }.getType());

        
        Map bil =  billList.get(0);
      List<Map> itemList=  (List<Map>) bil.get("itemList");
          
        
          List<Map<String,String>> resultList=new ArrayList();
          for(Map mp:itemList){
              
           Map<String, String> resultMap = new HashMap<String, String>();
        for (String st : ar) {
            if (mp.containsKey(st)) {
                resultMap.put(st, (String) mp.get(st));
                
            }
        }
        resultList.add(resultMap);
          }
        return new Gson().toJson(resultList, new TypeToken<List>() {
        }.getType());
    }
        
    public String getAllBillIds() throws Exception {
        return DBManager.getDB().getAll(Constants.BILL_TABLE);
    }

    public String createBillIdBased(Map<String, String> itemMap, String category) throws Exception {
        if (itemMap == null || itemMap.isEmpty()) {
            return null;
        }
        String json = "";

        List<Item> actualItemList = new ArrayList();
        Set<String> itemIdsSet = itemMap.keySet();
        for (String it : itemIdsSet) {
            json = DBManager.getDB().getByKey(Constants.ITEM_TABLE, it);
            System.out.println(json);
            List<Item> itemList = new Gson().fromJson(json, new TypeToken<List<Item>>() {
            }.getType());
            itemList.get(0).setQuantity(itemMap.get(it));
            actualItemList.addAll(itemList);
        }
        Bill bill = new Bill();
        bill.setCategotry(category);
        bill.setItemList(actualItemList);
        return DBManager.getDB().addDefault(Constants.BILL_TABLE, new Gson().toJson(bill, new TypeToken<Bill>() {
        }.getType()));
    }

//    public String setEnv() throws Exception{
//        //        String json = new Gson().toJson(map, new TypeToken<Map<String, String>>() {
////        }.getType());
////        DBManager.getDB().addDefault("test", json);
//     String json="";
//        String []strary=new String[]{"Colgate","coin","bottle","cup","tea","sauce",""};
//        for(String s:strary){
//            Item item = new Item();
//        item.setName(s);
//         json = new Gson().toJson(item, new TypeToken<Item>() {
//        }.getType());
//        DBManager.getDB().addDefault("item", json);
//        }
////        json = DBManager.getDB().getAll("item");
//    }
}
