package com.coh.service;

import com.coh.domain.Cup;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CupService {
    /**
     *  新增一条
     * @param cup 实体类
     * @return 成功返回true
     */
    public boolean saveCup(Cup cup);

    public boolean updateCup(Cup cup);

    public boolean deleteCupById(int id);

    public Cup selectCupById(int id);

    public List<Cup> selectAllCups();

    public int countCup();
}
