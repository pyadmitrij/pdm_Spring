package com.home.service;

import java.util.List;

import com.home.data.Mesage;

/**
 * @author Dmitriy Pyasetskiy
 */

public interface MesageServiceI 
{
	void addMesage(Mesage mesage);
	void updateMesage(Mesage mesage);
	Mesage readMesage(Integer userId);
	List<Mesage> findByUserId(Integer userId);
	List<Mesage> readAllMesage();
	void deleteMesage(Integer mesageId);
	void deleteMesage(Mesage mesage);
}
