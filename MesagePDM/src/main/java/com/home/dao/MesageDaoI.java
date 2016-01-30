package com.home.dao;

import java.util.List;

import com.home.data.Mesage;

/**
 * @author Dmitriy Pyasetskiy
 */

public interface MesageDaoI extends GenericDaoI<Mesage, Integer>
{	
	List<Mesage> findByUserId(Integer userId);
	
	void deleteMesage(Integer mesageId);
}
