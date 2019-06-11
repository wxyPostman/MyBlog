package com.zjweu.service;

import java.util.List;

import com.zjweu.entity.Register;
import com.zjweu.entity.RegisterExample;

public interface RegisterService {

	boolean insert(Register record);

	Register selectByPhone(String phone);

	boolean countByExample(RegisterExample example);

	boolean updateByPrimaryKey(Register record);
	
	boolean updateByPrimaryKeySelective(Register record);

	List<Register> selectByExample(RegisterExample example);
}
