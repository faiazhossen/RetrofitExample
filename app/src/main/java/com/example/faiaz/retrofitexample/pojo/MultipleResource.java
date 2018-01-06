
package com.example.faiaz.retrofitexample.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MultipleResource {

    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("data")
    @Expose
    public Data data;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MultipleResource() {
    }

    /**
     * 
     * @param status
     * @param data
     */
    public MultipleResource(Integer status, Data data) {
        super();
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
