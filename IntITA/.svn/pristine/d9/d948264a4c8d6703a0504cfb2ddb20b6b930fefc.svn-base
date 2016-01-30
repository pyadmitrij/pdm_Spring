package com.intita.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intita.domain.File;
import com.intita.domain.Folder;

@Repository
public class FilesDaoImpl extends GenericDaoImpl<File, Integer> implements FilesDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<File> getFiles(int folderId) {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(File.class)
				.add(Restrictions.eq("folderId", folderId))				
				.list();
	}

}
