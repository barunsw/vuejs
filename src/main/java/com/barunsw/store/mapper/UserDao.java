package com.barunsw.store.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
	public int insertUser(Map paramData) throws Exception;
}
