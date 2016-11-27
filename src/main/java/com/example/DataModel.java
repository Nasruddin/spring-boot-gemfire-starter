package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by nasruddin on 27/11/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class DataModel {

    private int id;

    private String text;

    public DataModel(int i, String text) {
        this.id = i;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataModel dataModel = (DataModel) o;

        if (id != dataModel.id) return false;
        return text != null ? text.equals(dataModel.text) : dataModel.text == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
