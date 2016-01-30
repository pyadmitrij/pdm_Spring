/**
 * @Author Sergey "yakudza" Tatarnikov 
 * @Date 30.02.2013
 * @Please Vinnitsa ITA
 * @Version 1.0
 *  
 */
package com.intita.dao;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.intita.domain.Resiver;



@Repository
public class ResiverDaoImpl extends GenericDaoImpl<Resiver,Integer> implements ResiverDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<Resiver> readExamById(Integer id) {
		//System.out.println(id);
		Query query=getSessionFactory().getCurrentSession().createQuery(
				"FROM Resiver where userId=:id").setInteger("id", id);
		
		return  query.list(); 
	}
	@SuppressWarnings("unchecked")
	@Override
	
	public List<Resiver> readByGroupId(Integer id){

		Query query=getSessionFactory().getCurrentSession().createQuery(
				"FROM Resiver where groupId=:id").setInteger("id", id);
		
		return query.list();
	}

	public Resiver readUserByRowId(Integer id){

		Query query=getSessionFactory().getCurrentSession().createQuery(
				"FROM Resiver where rowId=:id").setInteger("id", id);
		
		return ((Resiver) query.uniqueResult());
	}
}
