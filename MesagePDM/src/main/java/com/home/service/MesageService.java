package com.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.dao.MesageDaoI;
import com.home.data.Mesage;

/**
 * MesageService implements interaction between controllers MesageDAO, 
 * and some other DAO classes.
 * 
 * @author Dmitriy Pyasetskiy
 */

@Service
public class MesageService implements MesageServiceI
{
	@Autowired
	private MesageDaoI mesageDAO;
		
	public MesageDaoI getMesageDAO() {
		return mesageDAO;
	}

	public void setMesageDAO(MesageDaoI mesageDAO) {
		this.mesageDAO = mesageDAO;
	}

	/**
	 * Save instance of Mesage into database.
	 * @param mesage new instance of Mesage
	 * @see Mesage
	 */
	@Transactional
	@Override
	public void addMesage(Mesage mesage) {
		mesageDAO.create(mesage);		
	}
	
	/**
	 * Update instance of Mesage from database
	 * @param mesage update instanse of Mesage.
	 * @see Mesage
	 */
	@Transactional
	@Override
	public void updateMesage(Mesage mesage) {
		mesageDAO.update(mesage);
	}

	/**
	 * Read instance of Mesage from database
	 * @param userId primary key.
	 * @return instance of mesage.
	 * @see Mesage
	 */
	@Transactional
	@Override
	public Mesage readMesage(Integer userId) {
		return mesageDAO.read(userId);
	}

	/**
	 * Find mesage from database.
	 * @param iusrId primary key.
	 * @return instance of Mesage from database.
	 */
	@Transactional
	@Override
	public List<Mesage> findByUserId(Integer userId) {
		return mesageDAO.findByUserId(userId);
	}

	/**
	 * Read list instance of Mesage from database
	 * @return list instance of mesage.
	 * @see Mesage
	 */
	@Transactional
	@Override
	public List<Mesage> readAllMesage() {
		return mesageDAO.readAll();
	}

	/**
	 * Delete mesage from database.
	 * @param mesage delete instanse of Mesage.
	 */
	@Transactional
	@Override
	public void deleteMesage(Mesage mesage) {
		mesageDAO.delete(mesage);
	}

	/**
	 * Delete mesage from database.
	 * @param mesageId delete instanse of Mesage.
	 */
	@Transactional
	@Override
	public void deleteMesage(Integer mesageId) {
		mesageDAO.deleteMesage(mesageId);		
	}

}
