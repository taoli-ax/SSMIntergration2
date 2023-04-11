package com.coh.dao;

import com.coh.domain.Cup;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
public interface CupDao {
//    @Insert("insert into cup values(null,#{name},#{brand})")
    @Insert("insert into cup(name, brand) values(#{name}, #{brand})")//brand是对应表中的字段？对应Cup中的属性？
    public void saveCup(Cup cup);
    @Update("update cup set brand = #{brand}, name = #{name} where id = #{id}")
    public void updateCup(Cup cup);
    @Delete("delete from cup where id = #{id}")
    public void deleteCup(int cup);
    @Select("select * from cup where id=#{id}")
    public Cup selectCupById(int id);
    @Select("select * from cup")
    public List<Cup> selectAllCups();
    @Select("select count(*) from cup")
    public int countCup();


}
