/**
 * 
 */
package com.intita.dao;

import java.util.List;

import com.intita.domain.Subject;
import com.intita.domain.User;

/**
 * @author Саня
 * @author Dmitriy Pyasetskiy
 */
public interface SubjectDao extends GenericDao<Subject, Integer>
{
	List<Subject> getSubjects(int userId);
	List<Subject> findBySubject(User userId);
	void deleteSubject(Integer subjectId);
	void deleteAllSubject(Integer userId);
}
