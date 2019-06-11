package com.zjweu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjweu.entity.Register;
import com.zjweu.entity.RegisterExample;

public interface RegisterMapper {
	long countByExample(RegisterExample example);

	int deleteByExample(RegisterExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Register record);

	int insertSelective(Register record);

	List<Register> selectByExample(RegisterExample example);

	Register selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Register record, @Param("example") RegisterExample example);

	int updateByExample(@Param("record") Register record, @Param("example") RegisterExample example);

	int updateByPrimaryKeySelective(Register record);

	int updateByPrimaryKey(Register record);

	Register selectByPhone(String Phone);
}