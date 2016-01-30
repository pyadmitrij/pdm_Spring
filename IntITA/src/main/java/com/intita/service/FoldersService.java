package com.intita.service;

import org.hibernate.FetchMode;

import com.intita.domain.Folder;
import com.intita.domain.Group;
import com.intita.domain.Subject;
import com.intita.domain.User;

public interface FoldersService {
	Folder save(Folder folder);
	Folder read(Integer id);
	void del(Folder folder);
	Folder getFolderStrudture();
	Folder findByName(String name);
	Folder findByName(String name, FetchMode ChildrenFetchMode, FetchMode parentFetchMode);
	void createFolders(User newUser);
	void deleteFolders(User oldUser);
	void createFolders(Group newgroup);
	void deleteFolders(Group oldgroup);
	void createFolders(Subject newSubject);
	void deleteFolders(Subject oldSubject);
	boolean canDelFiles(Folder folder);	
}
