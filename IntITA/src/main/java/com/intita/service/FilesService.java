package com.intita.service;

import java.io.IOException;
import java.util.List;

import com.intita.domain.File;
import com.intita.domain.Folder;

public interface FilesService {
	Integer save(File newFile);
	File read(Integer file_id);
	void delete(Integer id);
	List<com.intita.domain.File> getFiles(int folderId);
	//*delete all files in folder
	void delete(Folder folder);
	byte[] getFileBody(File file) throws IOException;
}
