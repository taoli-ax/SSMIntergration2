package com.coh.controller;

import com.coh.domain.Cup;
import com.coh.service.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.coh.controller.Code;
import java.util.List;

@RestController
@RequestMapping("cups")
public class CupController {

    @Autowired
    private CupService cupService;
    @PostMapping
    public Result saveCup(@RequestBody Cup cup){
        Boolean result=cupService.saveCup(cup);
        return new Result(result?Code.SAVE_OK:Code.SAVE_ERR,result);
    };
    @PutMapping
    public Result updateCup(@RequestBody Cup cup){
        Boolean result=cupService.updateCup(cup);
        return new Result(result?Code.UPDATE_OK:Code.UPDATE_ERR,result);
    };
    @DeleteMapping(value = {"{id}"})
    public Result deleteCupById(@PathVariable("id") int id){
        Boolean result=cupService.deleteCup(id);
        return new Result(result?Code.DELETE_OK:Code.DELETE_ERR,result);


    };
    @GetMapping("/{id}")
    public Result selectCupById(@PathVariable("id") int id){
        Cup cup=cupService.selectCupById(id);
        return new Result(cup!=null?Code.GET_OK:Code.GET_ERR,cup,cup!=null?"":"请重试");

    };
    @GetMapping
    public Result selectAllCups(){
        List<Cup> cups=cupService.selectAllCups();
        return new Result(cups!=null?Code.GET_OK:Code.GET_ERR,cups,cups!=null?"":"请重试");

    };
    @GetMapping("count")
    public Result countCup(){
        System.out.println("count");
        int result=cupService.countCup();
        return new Result(Code.GET_OK,result);

    };
}
