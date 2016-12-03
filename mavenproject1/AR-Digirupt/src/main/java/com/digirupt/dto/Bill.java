/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digirupt.dto;

import java.util.List;

/**
 *
 * @author Partha
 */
public class Bill {
    private Object _id;
    private String name;
    private String status;
    private String createdate;
    private String updatedate; 
    private  List<Item> itemList;
    private String categotry ;

    public Object getId() {
        return _id;
    }

    public void setId(Object _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getCategotry() {
        return categotry;
    }

    public void setCategotry(String categotry) {
        this.categotry = categotry;
    }
    
    
}
