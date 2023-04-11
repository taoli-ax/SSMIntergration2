package com.coh.test;

import com.coh.config.SpringConfig;
import com.coh.domain.Cup;
import com.coh.service.CupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AppTest {
    @Autowired
    private CupService cupService;
    @Test
    public void testFindAll(){
        List<Cup> cupList=cupService.selectAllCups();
        System.out.println(cupList);
    }

    @Test
    public void TestFindById(){
        Cup cup=cupService.selectCupById(1);
        System.out.println(cup);
    }

    @Test
    public void TestSave(){
        Cup cup=new Cup();
        cup.setBrand("Lucky");
        cup.setName("coffee");
        Boolean b=cupService.saveCup(cup);
        System.out.println(b);
    }
}
