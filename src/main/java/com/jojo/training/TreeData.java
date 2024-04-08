package com.jojo.training;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeData<T> {

    private String id;

    private String fullName;

    private List<T> children ;

    public TreeData(String id, String fullName){
        this.id = id ;
        this.fullName = fullName;
        this.children = new ArrayList<>();
    }
}
