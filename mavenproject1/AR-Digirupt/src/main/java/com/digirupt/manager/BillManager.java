package com.digirupt.manager;

import com.digirupt.dto.Bill;
import com.digirupt.dto.Item;
import com.digirupt.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
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
      public String getAllItem() throws Exception {
        
        return DBManager.getDB().getAll(Constants.ITEM_TABLE);
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

    public String getAllBillIds() throws Exception {
        return DBManager.getDB().getAll(Constants.BILL_TABLE);
    }

    public String createBillIdBased(Map<String,String > itemMap ,String category) throws Exception {
        if (itemMap == null || itemMap.isEmpty()) {
            return null;
        }
        String json = "";
        
        List<Item> actualItemList=new ArrayList();
       Set<String> itemIdsSet= itemMap.keySet();
        for (String it : itemIdsSet) {
            json = DBManager.getDB().getByKey("item", it);
            System.out.println(json);
            List<Item> itemList = new Gson().fromJson(json, new TypeToken<List<Item>>() {
            }.getType());
            itemList.get(0).setPrice(itemMap.get(it));
            actualItemList.addAll(itemList);
        }
        Bill bill=new Bill();
        bill.setCategotry(category);
        bill.setItemList(actualItemList);
            return   DBManager.getDB().addDefault(Constants.BILL_TABLE,new Gson().toJson(bill, new TypeToken<Bill>() {
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
