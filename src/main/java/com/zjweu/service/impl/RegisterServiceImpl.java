package com.zjweu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjweu.dao.RegisterMapper;
import com.zjweu.entity.Register;
import com.zjweu.entity.RegisterExample;
import com.zjweu.service.RegisterService;
@Service
public class RegisterServiceImpl implements RegisterService {

	
	@Autowired
	private RegisterMapper registerMapper;

	@Override
	public boolean insert(Register record) {
		int i = registerMapper.insert(record);
		return i==1?true:false;
	}

	@Override
	public Register selectByPhone(String phone) {
		// TODO Auto-generated method stub
		return registerMapper.selectByPhone(phone);
	}

	@Override
	public boolean countByExample(RegisterExample example) {
		long l = registerMapper.countByExample(example);
		return l==1?false:true;
	}

	@Override
	public boolean updateByPrimaryKey(Register record) {
		int i = registerMapper.updateByPrimaryKey(record);
		return i==1?true:false;
	}

	@Override
	public List<Register> selectByExample(RegisterExample example) {
		List<Register> list = registerMapper.selectByExample(example);
		return list;
	}

	@Override
	public boolean updateByPrimaryKeySelective(Register record) {
		int i = registerMapper.updateByPrimaryKeySelective(record);
		return i==1?true:false;
	}


}
