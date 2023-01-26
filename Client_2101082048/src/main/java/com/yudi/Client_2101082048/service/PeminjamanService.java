/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.Client_2101082048.service;

import com.fasterxml.classmate.GenericType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.yudi.Client_2101082048.model.Peminjaman;
import java.util.List;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

/**
 *
 * @author user
 */
public class PeminjamanService {
    private final String URL = "http://localhost:9002";
    
    public Peminjaman getPeminjaman(Long peminjamanId){
        Peminjaman peminjaman = Unirest.get(URL+"/peminjaman/"+peminjamanId)
                .asObject(Peminjaman.class)
                .getBody();
        if(peminjaman!=null){
            return peminjaman;
        }
        return null;
    }
    
    public Peminjaman savePeminjaman(Peminjaman peminjaman){
        HttpResponse<kong.unirest.JsonNode> response = Unirest.post(URL + "/peminjaman/")
                .header("content-type", "application/json")
                .body(peminjaman)
                .asJson();
        Gson gson = new Gson();
        Peminjaman a = gson.fromJson(response.getBody().toString(), Peminjaman.class);
        return a;
    }
    
    public List<Peminjaman> getAllPeminjaman(){
        List<Peminjaman> peminjamanList = Unirest.get(URL + "/peminjaman/")
                .asObject(new kong.unirest.GenericType<List<Peminjaman>>(){})
                .getBody();
        return peminjamanList;
    }
    
    public Peminjaman updatePeminjaman(Peminjaman peminjaman){
        HttpResponse<kong.unirest.JsonNode> response = Unirest.put(URL + "/peminjaman/")
                .header("content-type", "application/json")
                .body(peminjaman)
                .asJson();
        Gson gson = new Gson();
        Peminjaman a = gson.fromJson(response.getBody().toString(), Peminjaman.class);
        return a;
    }
    
    public void deletePeminjaman(Long peminjamanId){
        Unirest.delete(URL + "/peminjaman/"+peminjamanId).asEmpty();
    }
}