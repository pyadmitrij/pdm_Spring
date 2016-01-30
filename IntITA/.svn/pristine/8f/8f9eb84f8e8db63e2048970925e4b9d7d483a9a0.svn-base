package com.intita.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.intita.dao.FolderDao;
import com.intita.dao.GroupDAO;
import com.intita.dao.SubjectDao;
import com.intita.dao.UserDAO;
import com.intita.domain.Folder;
import com.intita.domain.Group;
import com.intita.domain.Role;
import com.intita.domain.Subject;
import com.intita.domain.User;

/**
 * FoldersServiceImpl implements interaction between controllers FolderDao, 
 * and some other DAO classes.
 * @author Zhuk Maxim
 *
 */
@Service
public class FoldersServiceImpl implements FoldersService {
	@Autowired
	private FolderDao folderDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private SubjectDao subjDao;	
	@Autowired
	private GroupDAO groupDao;	
	@Autowired
	private FilesService filesService;

	private final static String MADE_HOMETASKS = "made home tasks";
	private final static String HOME_TASKS = "home tasks";	
	private final static String TEACHER_ROLE_NAME = "teacher";	
	private final static String ADMIN_ROLE_NAME = "admin";	
	private final static String STUDENT_ROLE_NAME = "student";	
	
	/**
	 * @return the userDao
	 */
	public UserDAO getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the subjDao
	 */
	public SubjectDao getSubjDao() {
		return subjDao;
	}

	/**
	 * @param subjDao the subjDao to set
	 */
	public void setSubjDao(SubjectDao subjDao) {
		this.subjDao = subjDao;
	}

	/**
	 * @return the groupDao
	 */
	public GroupDAO getGroupDao() {
		return groupDao;
	}

	/**
	 * @param groupDao the groupDao to set
	 */
	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}


	/**
	 * Save instance of Folder into database.
	 * @param folder new instance of Folder
	 * @return saved Folder
	 */
	@Transactional
	public Folder save(Folder folder) {
		folderDao.create(folder);
		return folder;
	}

	/**
	 * @return the folderDao
	 */
	public FolderDao getDao() {
		return folderDao;
	}

	/**
	 * @param folderDao
	 *            the folderDao to set
	 */
	public void setDao(FolderDao dao) {
		this.folderDao = dao;
	}

	/**
	 * Read instance of folder from database
	 * @param id primary key.
	 * @return instance of folder.
	 * @see Folder
	 */
	@Override
	@Transactional
	public Folder read(Integer id) {
		return folderDao.read(id);
	}
	
	/**
	 * Find folder with specific name from database. Name must be unique.
	 * @param name Folder name.
	 * @return instance of Folder from database.
	 * @see Folder FolderDao
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Folder findByName(String name) {
		return folderDao.findByName(name);
	}

	/**
	 * Find folder with specific name from database. Name must be unique.
	 * @param name Folder name.
	 * @param childrenFetchMode Child folders fetch mode.
	 * @param parentFetchMode	Parent folder fetch mode.
	 * @see Folder FolderDao
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Folder findByName(String name, FetchMode ChildrenFetchMode, FetchMode parentFetchMode) {
		return folderDao.findByName(name, ChildrenFetchMode, parentFetchMode);
	}

	public Folder findSubFolderByName(Folder parent, String subFolderName) {
		for (Folder f : parent.getChildren())
			if (f.getName().equals(subFolderName))
				return f;
		return null;
	}

	/**
	 * Creates folder structure for new User in database.
	 * @param newUser New user.
	 * @see User
	 */
	@Override
	@Transactional
	public void createFolders(User newUser) {
		String roleName = ((Role) newUser.getRoles().toArray()[0]).getName();
		if (roleName.equals(STUDENT_ROLE_NAME)) {
			String studentName = getStudentName(newUser);
			String groupName = newUser.getGroup().getName();
			// Add student folders into folders with his group name
			for (Folder groupF : getGroupFolders(groupName)) {
				Folder studentF = new Folder(studentName);
				studentF.setParent(groupF);
				save(studentF);
			}
		}
	}

	/**
	 * Delete folders for old user that will be removed from database.
	 * @param oldUser Old user.
	 * @see User Folder
	 */
	@Override
	@Transactional
	public void deleteFolders(User oldUser) {
		if (hasRole(oldUser, STUDENT_ROLE_NAME)){
			String groupName = oldUser.getGroup().getName();
			for (Folder groupF : getGroupFolders(groupName)) {
				Folder studentF = findSubFolderByName(groupF, getStudentName(oldUser));
				del(studentF);
			}
		}else if (hasRole(oldUser, TEACHER_ROLE_NAME)) {
			for(Subject subject : subjDao.findBySubject(oldUser))
				deleteFolders(subject);
		}
		
	}
	

	/**
	 * Find all folders with specified group name.
	 * @param groupName Name of group.
	 * @return List of group folders with specified group name.
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Folder> getGroupFolders(String groupName) {
		List<Folder> folders = folderDao.getSubjectsFolders(FetchMode.SELECT, FetchMode.SELECT);
		List<Folder> groupFolders = new LinkedList<>();
		for (Folder subjectF : folders) {
			Folder madeHomeTasksF = findSubFolderByName(subjectF, MADE_HOMETASKS);
			groupFolders.add(findSubFolderByName(madeHomeTasksF, groupName));
		}
		return groupFolders;
	}

	/**
	 * Delete folder, its children and files.
	 * @param folder Folder for delete.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void del(Folder folder) {
		filesService.delete(folder);
		if (folder.getChildren().size() > 0)
			for (Folder child : folder.getChildren())
				del(child);
		folderDao.delete(folder);
	}

	/**
	 * Create folder structure for new group in database.
	 * @param newGroup New group.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void createFolders(Group newGroup) {
		List<Folder> folders = folderDao.getSubjectsFolders(FetchMode.SELECT, FetchMode.SELECT);
		for (Folder f : folders) {
			Folder groupF = new Folder(newGroup.getName());
			save(groupF);
			findSubFolderByName(f, MADE_HOMETASKS).getChildren().add(groupF);
		}
	}

	/**
	 * Delete folder structure for old group from database.
	 * @param oldGroup	Old group.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteFolders(Group oldGroup) {
		System.out.println("deleteFolders(Group oldGroup)");
		// TODO write query for fetching group folders with specific name
		for (Folder sFolder : folderDao.getSubjectsFolders(FetchMode.JOIN, FetchMode.SELECT))
			del(findSubFolderByName(findSubFolderByName(sFolder, FoldersServiceImpl.MADE_HOMETASKS), oldGroup.getName()));
	}

	/**
	 * Create folder structure for new subject in database.
	 * @param newSubject New subject.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void createFolders(Subject newSubject) {
		Folder sFolder = new Folder(newSubject.getName());
		save(sFolder);
		Folder homeTaskFolder = new Folder(FoldersServiceImpl.HOME_TASKS);
		save(homeTaskFolder);
		sFolder.getChildren().add(homeTaskFolder);
		Folder mhtFolder = new Folder(FoldersServiceImpl.MADE_HOMETASKS);
		save(mhtFolder);
		sFolder.getChildren().add(mhtFolder);
		for(Group group : groupDao.readAll()){
			Folder groupFolder = new Folder(group.getName());
			save(groupFolder);
			mhtFolder.getChildren().add(groupFolder);
			for(User studentUser : userDao.findByGroupId(group)){
				Folder studentFolder = new Folder(getStudentName(studentUser));
				save(studentFolder);
				groupFolder.getChildren().add(studentFolder);
			}				
		}
	}

	/**
	 * Delete folder structure for old subject from database.
	 * @param oldSubject	Old subject.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteFolders(Subject oldSubject) {
		del(findByName(oldSubject.getName()));

	}

	/**
	 * Read from database and generate folder structure for current authenticated user.
	 * @return Root folder for current authenticated user.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	@PreAuthorize("isAuthenticated()")
	public Folder getFolderStrudture() {		
		User user = userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Role role = null;
		for (Role r : user.getRoles())
			role = r;
		Folder root = new Folder();
		if (role.getName().equals(ADMIN_ROLE_NAME)) {
			for (Folder f : folderDao.getSubjectsFolders(FetchMode.SELECT, FetchMode.JOIN))
				// Weird behavior FetchMode.SELECT doesn't work like expected
				root.getChildren().add(f);
		} else if (role.getName().equals(STUDENT_ROLE_NAME)) {
			List<Folder> list = folderDao.getSubjectsFolders(FetchMode.SELECT, FetchMode.SELECT);
			for (Folder folder : list) {
				folderDao.detach(folder);
				Folder madeHomeTasks = findSubFolderByName(folder, MADE_HOMETASKS);
				Folder groupFolder = findSubFolderByName(madeHomeTasks, user.getGroup().getName());
				madeHomeTasks.getChildren().clear();
				madeHomeTasks.getChildren().add(groupFolder);
				Folder studentFolder = findSubFolderByName(groupFolder, getStudentName(user));
				groupFolder.getChildren().clear();
				groupFolder.getChildren().add(studentFolder);
				root.getChildren().add(folder);
			}
		} else {
			for (Subject subj : subjDao.getSubjects(user.getUserId()))
				root.getChildren().add(folderDao.findByName(subj.getName(), FetchMode.JOIN, FetchMode.JOIN));
		}
		return root;
	}

	/**
	 * @return the filesService
	 */
	public FilesService getFilesService() {
		return filesService;
	}

	/**
	 * @param filesService
	 *            the filesService to set
	 */
	public void setFilesService(FilesService filesService) {
		this.filesService = filesService;
	}
	
	/**
	 * Determinate whether current authenticated user has permission to delete or create files in specified folder.
	 * @param folder Folder where user want to create or delete files.
	 * @return true if can delete files in specified folder.
	 */
	@Override
	@PreAuthorize("isAuthenticated()")
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean canDelFiles(Folder folder) {
		if(folder == null)
			return false;
		String roleName = ((GrantedAuthority) SecurityContextHolder.getContext().getAuthentication().getAuthorities()
				.toArray()[0]).getAuthority();
		if (roleName.equals(ADMIN_ROLE_NAME))
			return true;
		User user = userDao.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		if (roleName.equals(STUDENT_ROLE_NAME) && folder.getName().equals(getStudentName(user)))
			return true;
		if (roleName.equals(TEACHER_ROLE_NAME)) {
			while (folder.getParent() != null)
				folder = folder.getParent();
			for (Subject s : subjDao.getSubjects(user.getUserId()))
				if (folder.getName().equals(s.getName()))
					return true;
		}
		return false;
	}
		
	private String getStudentName(User student){
		return student.getSurname() + " " + student.getName();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private boolean hasRole(User user, String roleName) {
		if (roleName.equals(((Role) user.getRoles().toArray()[0]).getName()))
			return true;
		return false;

	}
}
