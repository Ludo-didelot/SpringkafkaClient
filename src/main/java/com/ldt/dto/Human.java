package com.ldt.dto;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * Created by Ludovic on 16/04/2018.
 */
@NodeEntity
@Getter
@Setter
public class Human {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String[] feature;
    @Override
    public String toString(){
        return "Human "+id +" with name : " +name;
    }
}