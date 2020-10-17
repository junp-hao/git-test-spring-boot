package com.example.springboot06jpa.controller;

import com.example.springboot06jpa.bean.Pel;
import com.example.springboot06jpa.resository.PelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PelController {
    @Autowired
    PelRepository pelRepository;

    @GetMapping("/user/{id}")
    public Pel getPel(@PathVariable("id")Integer id){
        Pel pel = pelRepository.getOne(id);
        return pel;
    }

    @GetMapping("/user")
    public Pel getPel(Pel pel){
        Pel save = pelRepository.save(pel);
        return  save;
    }

}
