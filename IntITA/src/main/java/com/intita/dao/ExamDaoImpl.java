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

import com.intita.domain.Exam;


	@Repository
	public class ExamDaoImpl extends GenericDaoImpl<Exam,Integer> implements ExamDao{
		
		@SuppressWarnings("unchecked")
		@Override
		public List<Exam> readLessonType(String type) {

			
						Query query = getSessionFactory().getCurrentSession().createQuery(
					"FROM Exam where type=:type").setString("type",type);
			return  query.list(); 
		}
		
//		@SuppressWarnings("unchecked")
//		@Override
//		public List<Exam> readExamById(Integer id) {
//			Query query=getSessionFactory().getCurrentSession().createQuery(
//					"FROM Exam where sudent_id=:id").setString("id",String.valueOf(id));
//			
//			return  query.list(); 
//		}

		
}
