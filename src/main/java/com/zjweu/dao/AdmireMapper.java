package com.zjweu.dao;

import com.zjweu.entity.Admire;
import com.zjweu.entity.AdmireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdmireMapper {
    long countByExample(AdmireExample example);

    int deleteByExample(AdmireExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Admire record);

    int insertSelective(Admire record);

    List<Admire> selectByExample(AdmireExample example);

    Admire selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Admire record, @Param("example") AdmireExample example);

    int updateByExample(@Param("record") Admire record, @Param("example") AdmireExample example);

    int updateByPrimaryKeySelective(Admire record);

    int updateByPrimaryKey(Admire record);
}