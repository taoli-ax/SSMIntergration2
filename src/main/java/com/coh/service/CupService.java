package com.coh.service;

import com.coh.domain.Cup;

import java.util.List;

public interface CupService {
    /**
     *  新增一条
     * @param cup 实体类
     * @return 成功返回true
     */
    public boolean saveCup(Cup cup);

    public boolean updateCup(Cup cup);

    public boolean deleteCup(int id);

    public Cup selectCupById(int id);

    public List<Cup> selectAllCups();

    public int countCup();
}
