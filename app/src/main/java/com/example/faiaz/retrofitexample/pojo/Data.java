
package com.example.faiaz.retrofitexample.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("size")
    @Expose
    private Integer size;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param items
     * @param size
     */
    public Data(List<Item> items, Integer size) {
        super();
        this.items = items;
        this.size = size;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
