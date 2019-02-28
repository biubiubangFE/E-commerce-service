package com.mhdss.shop.client.dto;

import java.util.List;

public class CatsDTO {

    private Long id;

    private Long parentId;

    private String catName;

    private Byte garde;

    private List<CatsDTO> catsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Byte getGarde() {
        return garde;
    }

    public void setGarde(Byte garde) {
        this.garde = garde;
    }

    public List<CatsDTO> getCatsList() {
        return catsList;
    }

    public void setCatsList(List<CatsDTO> catsList) {
        this.catsList = catsList;
    }
}
