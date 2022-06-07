package com.barunsw.store.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.barunsw.store.vo.UserVo;

@Mapper
public interface UserDao {
	public int signUp(UserVo paramData) throws Exception;
}
