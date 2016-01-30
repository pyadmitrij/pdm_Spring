package com.intita.web;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.intita.domain.Folder;
import com.intita.domain.User;
import com.intita.formModels.FileCheckModel;
import com.intita.service.FilesService;
import com.intita.service.FoldersService;
import com.intita.service.UserService;

/**
 * FileManagerController handle requests connected with file_manager.jsp. 
 * @author Zhuk Maxim
 *
 */
@Controller
public class FileManagerController {
	@Autowired
	FoldersService foldersService;
	@Autowired
	FilesService filesService;
	@Autowired
	UserService userService;

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Handle file downloading from file repository. 
	 * Download file with specified id if authorized user has required permissions.
	 * @param fileId File id for downloading.
	 * @return Requested file or redirect to home page.
	 */
	@RequestMapping(value = "/fm", method = RequestMethod.GET, params = "fileId")
	public HttpEntity<byte[]> fileDownload(@RequestParam("fileId") Integer fileId) {
		//TODO delegate this work to service and DAO
		int curFolderId = filesService.read(fileId).getFolderid();
		Folder currFolder = foldersService.read(curFolderId);
		if(!foldersService.canDelFiles(currFolder))
			//TODO made HttpEntity with header Location that redirect to home page
			return null;
		byte[] documentBody = null;
		com.intita.domain.File file = filesService.read(fileId);
		try {
			documentBody = filesService.getFileBody(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpHeaders header = new HttpHeaders();
		header.set("Content-Disposition", "attachment; filename=" + file.getName());
		header.setContentLength(documentBody.length);
		// header.setContentType(new MediaType("application", "pdf"));
		return new HttpEntity<>(documentBody, header);
	}

	/**
	 * Handle file removing from file repository. 
	 * Remove file with specified id if authorized user has required permissions.
	 * @param id File id for removing.
	 * @return to File Manager on success or to home page if user hasn't required permissions.
	 */
	@RequestMapping(value = "/fm/remove", params = "fileId", method = RequestMethod.GET)
	public String fileRemove(@RequestParam("fileId") Integer id) {
		// TODO delegate this work to service and DAO
		int curFolderId = filesService.read(id).getFolderid();
		if(foldersService.canDelFiles(foldersService.read(curFolderId))){			
			filesService.delete(id);
		}else
			return "redirect:/";
		return "redirect:/fm?folderId=" + curFolderId;
	}

	/**
	 * Handle files uploading into file repository.
	 * Upload file into specified folder if authorized user has required permissions.
	 * @param file 		File for uploading.
	 * @param curFoldId Folder id, in which file will be shown in File Manger.
	 * @return to File Manager on success or to home page if user hasn't required permissions.
	 */
	@RequestMapping(value = "/fm", method = RequestMethod.POST)
	public String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "curFolder", required = true) int curFoldId) {
		//TODO delegate this work to service and DAO
		if(foldersService.canDelFiles(foldersService.read(curFoldId))){
			String fileName = StringEscapeUtils.unescapeHtml(file.getOriginalFilename());
			com.intita.domain.File file2 = new com.intita.domain.File(fileName, "/", curFoldId);
			Integer id = filesService.save(file2);
			try {
				File f = new File("fileRespository/" + id);
				FileUtils.writeByteArrayToFile(f, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else
			return "redirect:/";
		return "redirect:/fm?folderId=" + curFoldId;
	}

//	@RequestMapping(value = "/fmf", method = RequestMethod.POST)
//	public String fileUpload(FileCheckModel fileCheckModel) {
//		for (Integer id : fileCheckModel.getIds())
//			System.out.println(id);
//
//		return "redirect:/fm";
//	}
	/**
	 * Generate folder and file structure for current authorized user.
	 * @return file manager page or home page if user is not authorized. 
	 */
	@RequestMapping(value = "/fm", method = RequestMethod.GET)
	public String fmGet(HttpServletRequest request, Model model) {
		Folder root = foldersService.getFolderStrudture();
		model.addAttribute("root", root);
		Integer selectedFoldId = 0;
		if (request.getParameter("folderId") == null) {
			model.addAttribute("delFile", false);
		} else {
			selectedFoldId = Integer.parseInt(request.getParameter("folderId"));
		}
		model.addAttribute("curFolder", selectedFoldId);
		model.addAttribute("files", filesService.getFiles(selectedFoldId));
		model.addAttribute("delFile", foldersService.canDelFiles(foldersService.read(selectedFoldId)));
		
		// model for new folder cretion form
		// model.addAttribute("folder", new Folder("asgaerg"));

		// model.addAttribute("filesCheck", new FileCheckModel());

		return "file_manager";
	}

	/**
	 * @return the foldersService
	 */
	public FoldersService getFoldersService() {
		return foldersService;
	}

	/**
	 * @param foldersService
	 *            the foldersService to set
	 */
	public void setFoldersService(FoldersService foldersService) {
		this.foldersService = foldersService;
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

}
