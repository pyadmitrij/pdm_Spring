package com.home.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.home.data.Mesage;

/**
* MesageDAO implements interaction between Mesage entity and database 
* 
* @author Dmitriy Pyasetskiy
*/

@Repository
public class MesageDAO extends GenericDAO<Mesage, Integer> implements MesageDaoI
{

	/**
	 * ����� ��������� �� �� ��
	 * @param userId �� ������������
	 * @return ���������� ������ ��������� ������ ������������
	 */
	@Override
	public List<Mesage> findByUserId(Integer userId) 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM Mesage where userId = :userId").setInteger("userId", userId);
		return query.list(); 
	}

	/**
	 * �������� ���������
	 * @param mesageId �� ���������
	 */
	@Override
	public void deleteMesage(Integer mesageId) 
	{
		Mesage mesage = (Mesage) sessionFactory.getCurrentSession().load(Mesage.class, mesageId);
		if(mesage != null)
			sessionFactory.getCurrentSession().delete(mesage);
	}
}
