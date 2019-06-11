package com.zjweu.dao;

import com.zjweu.entity.Response;
import com.zjweu.entity.ResponseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResponseMapper {
    long countByExample(ResponseExample example);

    int deleteByExample(ResponseExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Response record);

    int insertSelective(Response record);

    List<Response> selectByExample(ResponseExample example);

    Response selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Response record, @Param("example") ResponseExample example);

    int updateByExample(@Param("record") Response record, @Param("example") ResponseExample example);

    int updateByPrimaryKeySelective(Response record);

    int updateByPrimaryKey(Response record);
}