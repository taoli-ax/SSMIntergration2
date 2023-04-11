package com.coh.service.impl;

import com.coh.dao.CupDao;
import com.coh.domain.Cup;
import com.coh.service.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CupServiceImpl implements CupService {
    @Autowired
    private CupDao cupDao;//因为这里使用的是自动装配，所以无法找到Bean，改成warming

    @Override
    public boolean saveCup(Cup cup) {
        cupDao.saveCup(cup);
        return true;
    }

    @Override
    public boolean updateCup(Cup cup) {
        cupDao.updateCup(cup);
        return true;
    }

    @Override
    public boolean deleteCup(int id) {
        cupDao.deleteCup(id);
        return true;
    }

    @Override
    public Cup selectCupById(int id) {

        return cupDao.selectCupById(id);
    }

    @Override
    public List<Cup> selectAllCups() {
        return cupDao.selectAllCups();
    }

    @Override
    public int countCup() {

        return cupDao.countCup();
    }
}
