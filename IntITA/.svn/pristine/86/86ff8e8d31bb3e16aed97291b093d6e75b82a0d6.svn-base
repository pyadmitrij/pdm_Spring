package com.intita.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.intita.dao.FilesDao;
import com.intita.dao.FolderDao;
import com.intita.domain.File;
import com.intita.domain.Folder;

@Service
public class FilesServiceImpl implements FilesService{
	@Autowired
	private FilesDao filesDao;
	@Autowired
	private FoldersService foldersService; 
	@Autowired
	private FolderDao folderDao; 
	
	
	
	
	public FilesServiceImpl() {
	
	}

	/**
	 * @return the folderDao
	 */
	public FolderDao getFolderDao() {
		return folderDao;
	}

	/**
	 * @param folderDao the folderDao to set
	 */
	public void setFolderDao(FolderDao folderDao) {
		this.folderDao = folderDao;
	}

	/**
	 * @return the foldersService
	 */
	public FoldersService getFoldersService() {
		return foldersService;
	}

	/**
	 * @param foldersService the foldersService to set
	 */
	public void setFoldersService(FoldersService foldersService) {
		this.foldersService = foldersService;
	}

	/**
	 * @return the filesDao
	 */
	public FilesDao getFilesDao() {
		return filesDao;
	}

	/**
	 * @param filesDao the filesDao to set
	 */
	public void setFilesDao(FilesDao filesDao) {
		this.filesDao = filesDao;
	}

	@Override
	@Transactional
	public Integer save(File newFile) {
		return filesDao.create(newFile);
	}

	@Override
	@Transactional
	public File read(Integer file_id) {
		return filesDao.read(file_id);
	}

	@Override
	@Transactional
	public List<File> getFiles(int folderId) {		
		return filesDao.getFiles(folderId);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		filesDao.delete(filesDao.read(id));	
		try {
			Files.deleteIfExists(Paths.get("fileRespository/" + id));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Folder folder) {
		List<File> files = getFiles(folder.getId());
		for(File f : files)
			delete(f.getId());		
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	@Transactional(propagation = Propagation.REQUIRED)
	public byte[] getFileBody(File file) throws IOException {
		if(foldersService.canDelFiles(folderDao.read(file.getFolderid()))){
			return FileUtils.readFileToByteArray(new java.io.File("fileRespository/" + file.getId()));
		}
		return null;
	}
}
