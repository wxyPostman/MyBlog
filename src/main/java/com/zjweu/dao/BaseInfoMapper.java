package com.zjweu.dao;

import com.zjweu.entity.BaseInfo;
import com.zjweu.entity.BaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseInfoMapper {
    long countByExample(BaseInfoExample example);

    int deleteByExample(BaseInfoExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(BaseInfo record);

    int insertSelective(BaseInfo record);

    List<BaseInfo> selectByExample(BaseInfoExample example);

    BaseInfo selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") BaseInfo record, @Param("example") BaseInfoExample example);

    int updateByExample(@Param("record") BaseInfo record, @Param("example") BaseInfoExample example);

    int updateByPrimaryKeySelective(BaseInfo record);

    int updateByPrimaryKey(BaseInfo record);
}