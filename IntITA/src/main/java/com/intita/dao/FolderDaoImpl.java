package com.intita.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intita.domain.Folder;

/**
 * FolderDaoImpl implements interaction between Folder entity and database.
 * @author Zhuk Maxim
 *
 */
@Repository
public class FolderDaoImpl extends GenericDaoImpl<Folder, Integer> implements
		FolderDao {
	/**
	 * Find folder with specific name from database. Name must be unique.
	 * @param name Folder name.
	 * @return instance of Folder from database.
	 * @see Folder
	 */
	@Override
	public Folder findByName(String name) {
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("FROM Folder where name = :name")
				.setString("name", name);
		return ((Folder) query.uniqueResult());
	}
	
	/**
	 * Find folder with specific name from database. Name must be unique.
	 * @param name Folder name.
	 * @param childrenFetchMode Child folders fetch mode.
	 * @param parentFetchMode	Parent folder fetch mode.
	 * @see Folder
	 */
	@Override
	public Folder findByName(String name, FetchMode childrenFetchMode,
			FetchMode parentFetchMode) {
		Criteria criteria = currentSession().createCriteria(Folder.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.setFetchMode("children", childrenFetchMode);
		criteria.setFetchMode("parent", parentFetchMode);
		return (Folder) criteria.uniqueResult();
	}

	/**
	 * Find subject folders in database.
	 * @param childrenFetchMode Child folders fetch mode.
	 * @param parentFetchMode	Parent folder fetch mode.
	 * @see Folder
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Folder> getSubjectsFolders(FetchMode childrenFetchMode,
			FetchMode parentFetchMode) {		
		return currentSession().createCriteria(Folder.class)
				.add(Restrictions.isNull("parent"))
				.setFetchMode("children", childrenFetchMode)
				.setFetchMode("parent", parentFetchMode)
				.list();
	}

	/**
	 * Detach instance of Folder. Object will be disconnected from database. Changes in object have no influence on database.
	 *@param  folder Transient instance of Folder.
	 *@return Detached folder.
	 *@see Folder
	 */
	@Override
	public Folder detach(Folder folder) {
		currentSession().evict(folder);
		return folder;
	}

}
