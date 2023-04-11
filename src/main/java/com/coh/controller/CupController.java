package com.coh.controller;

import com.coh.domain.Cup;
import com.coh.service.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cups")
public class CupController {

    @Autowired
    private CupService cupService;
    @PostMapping
    public boolean saveCup(@RequestBody Cup cup){
         return cupService.saveCup(cup);
    };
    @PutMapping
    public boolean updateCup(@RequestBody Cup cup){
        return cupService.updateCup(cup);
    };
    @DeleteMapping(value = {"{id}"})
    public boolean deleteCupById(@PathVariable("id") int id){
        return cupService.deleteCupById(id);

    };
    @GetMapping("/{id}")
    public Cup selectCupById(@PathVariable("id") int id){
        return cupService.selectCupById(id);
    };
    @GetMapping
    public List<Cup> selectAllCups(){
        return cupService.selectAllCups();
    };
    @GetMapping
    public int countCup(){
        return cupService.countCup();
    };
}
