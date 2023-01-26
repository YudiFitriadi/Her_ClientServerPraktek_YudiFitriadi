/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yudi.pengembalian.service.controller;

import com.yudi.pengembalian.service.entity.Pengembalian;
import com.yudi.pengembalian.service.service.PengembalianService;
import com.yudi.pengembalian.service.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/pngembalian")
public class PengembalianController {
    @Autowired
    private PengembalianService pengembalianService;
    
    @PostMapping("/")
    public Pengembalian savePengembalian(@RequestBody Pengembalian pengembalian){
        return pengembalian.savePengembalian(pengembalian);
    }
    
    @GetMapping("{id}")
    public ResponseTemplateVO getPengembalian(@PathVariable("id") Long pengembalianId){
        return pengembalianService.getPengembalian(pengembalianId);
    }
}
