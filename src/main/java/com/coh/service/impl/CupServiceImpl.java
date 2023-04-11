package com.coh.service.impl;

import com.coh.dao.CupDao;
import com.coh.domain.Cup;
import com.coh.service.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CupServiceImpl implements CupService {
    @Autowired
    private CupDao cupDao;//因为这里使用的是自动装配，所以无法找到Bean，改成warming

    @Override
    public boolean saveCup(Cup cup) {
        cupDao.saveCup(cup);
        return false;
    }

    @Override
    public boolean updateCup(Cup cup) {
        return false;
    }

    @Override
    public boolean deleteCupById(int id) {
        return false;
    }

    @Override
    public Cup selectCupById(int id) {
        return null;
    }

    @Override
    public List<Cup> selectAllCups() {
        return null;
    }

    @Override
    public int countCup() {
        return 0;
    }
}
