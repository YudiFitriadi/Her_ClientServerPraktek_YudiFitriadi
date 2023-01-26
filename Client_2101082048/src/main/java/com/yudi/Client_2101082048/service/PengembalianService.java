/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.Client_2101082048.service;

import com.fasterxml.classmate.GenericType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.yudi.Client_2101082048.model.Pengembalian;
import java.util.List;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

/**
 *
 * @author user
 */
public class PengembalianService {
    private final String URL = "http://localhost:9009";
    
    public Pengembalian getPengembalian(Long pengembalianId){
        Pengembalian pengembalian = Unirest.get(URL+"/pengembalian/"+pengembalianId)
                .asObject(Pengembalian.class)
                .getBody();
        if(pengembalian!=null){
            return pengembalian;
        }
        return null;
    }
    
    public Pengembalian savePengembalian(Pengembalian pengembalian){
        HttpResponse<kong.unirest.JsonNode> response = Unirest.post(URL + "/pengembalian/")
                .header("content-type", "application/json")
                .body(pengembalian)
                .asJson();
        Gson gson = new Gson();
        Pengembalian a = gson.fromJson(response.getBody().toString(), Pengembalian.class);
        return a;
    }
    
    public List<Pengembalian> getAllPengembalian(){
        List<Pengembalian> pengembalianList = Unirest.get(URL + "/pengembalian/")
                .asObject(new kong.unirest.GenericType<List<Pengembalian>>(){})
                .getBody();
        return pengembalianList;
    }
    
    public Pengembalian updatePengembalian(Pengembalian pengembalian){
        HttpResponse<kong.unirest.JsonNode> response = Unirest.put(URL + "/pengembalian/")
                .header("content-type", "application/json")
                .body(pengembalian)
                .asJson();
        Gson gson = new Gson();
        Pengembalian a = gson.fromJson(response.getBody().toString(), Pengembalian.class);
        return a;
    }
    
    public void deletePengembalian(Long pengembalianId){
        Unirest.delete(URL + "/pengembalian/"+pengembalianId).asEmpty();
    }
}
