package com.intita.dao;


import java.util.List;

import org.hibernate.FetchMode;

import com.intita.domain.Folder;

public interface FolderDao extends GenericDao<Folder, Integer>{
	Folder findByName(String name);
	Folder findByName(String name, FetchMode fetchMode, FetchMode parentFetchMode);
	List<Folder> getSubjectsFolders(FetchMode childrenFetchMode, FetchMode parentFetchMode);
	Folder detach(Folder folder);
//	List<Folder> getMadeHomeTasksFolders(FetchMode fetchMode);
}
