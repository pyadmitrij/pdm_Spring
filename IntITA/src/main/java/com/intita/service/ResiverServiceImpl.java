/**
 * @Author Sergey "yakudza" Tatarnikov 
 * @Date 30.02.2013
 * @Please Vinnitsa ITA
 * @Version 1.0
 *  
 */
package com.intita.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intita.dao.ResiverDAO;
import com.intita.domain.Exam;
import com.intita.domain.ExamConnector;
import com.intita.domain.Group;
import com.intita.domain.Resiver;
import com.intita.domain.User;

@Service
public class ResiverServiceImpl implements ResiverService {
	@Autowired
	private ResiverDAO resiverDAO;
	@Autowired
	private GroupService groupService;
	
	public ResiverDAO getResiverDAO() {
		return resiverDAO;
	}
  
	public void setResiverDAO(ResiverDAO resiverDAO) {
		this.resiverDAO = resiverDAO;
	}
	
	@Override
	@Transactional
	public void addResiver(Resiver resiver) {
	resiverDAO.create(resiver);
	}
	@Override
	@Transactional
	public List<Resiver> readExamById(Integer id) {
		return resiverDAO.readExamById(id);
	}
	
	@Override
	@Transactional
	public List<Resiver> readByGroupId(Integer id) {
		return resiverDAO.readByGroupId(id);
	}
	
	@Transactional
	@Override
	public void update(Resiver resiver) 
	{
		resiverDAO.update(resiver);		
	}

	@Transactional
	@Override
	public Resiver readUserByRowId(Integer id)
	{
		return resiverDAO.readUserByRowId(id);
	}
	
	@Transactional
	@Override
 public void parsAndSaveInDB(ExamConnector examConnector,String status)
   {
		String[] userId = examConnector.getUserIdStr().split(",");
		String[] name = examConnector.getName().split(",");
		String[] surname = examConnector.getSurname().split(",");
		String[] mark = examConnector.getUserMark().split(",");
		String[] type = examConnector.getType().split(",");
		String[] subjectName = examConnector.getSubjectName().split(",");
		Integer len=name.length;
		
		List<Resiver> temp=readByGroupId(examConnector.getGroupId());
		List<Resiver> toSending = new ArrayList<Resiver>();
		if(temp.isEmpty())
		{
			for (int i=0;i<len;i++)
			{
				Resiver resiver = new Resiver();
				resiver.setUserId(Integer.parseInt(userId[i]));
				resiver.setName(name[i]);
				resiver.setSurname(surname[i]);
				resiver.setUserMark(mark[i]);
				resiver.setType(type[i]);
				resiver.setSubjectName(subjectName[i]);
				resiver.setGroupId(examConnector.getGroupId());
				resiver.setTime(examConnector.getTime());
				if(mark[i].equals("2")||mark[i].equals("X"))
				resiver.setStatus("open");
				else resiver.setStatus(status);
				addResiver(resiver);
				if(status.equals("close"))
					toSending.add(resiver);
			}
			
		}else
		{
			String[] rowId = examConnector.getRowIdStr().split(",");
			for (int i = 0; i < len; i++) {
				Resiver result = readUserByRowId(Integer.parseInt(rowId[i]));

			if (result.getUserMark().equals("X")) 
				result.setUserMark(mark[i]);
			else 
				if (!mark[i].equals("X"))
					result.setUserMark(mark[i]);

				if(result.getUserMark().equals("2")||result.getUserMark().equals("X"))
					result.setStatus("null");
				else 	result.setStatus(status);
			update(result);
			if(status.equals("close"))
				toSending.add(result);
			}
		}
		if(!toSending.isEmpty())
			{
			examConnector.setResiver(toSending);
			insertInFile(examConnector);
			}
		
   }
	
	@Transactional
	@Override
	public List <ExamConnector> readFromFile(ExamConnector examConnector)
	{
		String time = examConnector.getTime().toString().replace(":", "_");
		Group group=groupService.readGroup(examConnector.getGroupId());
		//List <Resiver> result = new ArrayList<Resiver>();
		try{
			Scanner file=new Scanner(new File(examConnector.getType()+"/"+examConnector.getSubjectName()+"/"+group.getName()+"/"+time+"/"+examConnector.getStatement()+".txt"));
			List<String> fileLine= new ArrayList<String>();
			
			while (file.hasNextLine())
			{	fileLine.add(file.nextLine());
			}
			file.close();
			List <ExamConnector> result = new ArrayList<>();
			
			for (String string : fileLine) {
				String[] tempList = string.split(",");
				ExamConnector tempObject = new ExamConnector();
				tempObject.setUserId(Integer.parseInt(tempList[0]));
				tempObject.setName(tempList[1]);
				tempObject.setSurname(tempList[2]);
				tempObject.setUserMark(tempList[3]);
				result.add(tempObject);
			}
			return result;	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("trauble !!!");
			return null;		
		}
	}
	
	@Transactional
	@Override
	public void insertInFile(ExamConnector incomeList)
	{
		Group group=groupService.readGroup(incomeList.getResiver().get(0).getGroupId());
		String time=incomeList.getResiver().get(0).getTime().toString().replace(":", "_");
		File dir = new File (incomeList.getResiver().get(0).getType()+"/"+incomeList.getResiver().get(0).getSubjectName()+"/"+group.getName()+"/"+time);dir.mkdirs();
		String[] fileName = incomeList.getStatement().split(",");
		try {
			PrintWriter out = new PrintWriter(dir+"/"+fileName[0]+".txt");
			
			for (Resiver incomObj : incomeList.getResiver()) 
			{
				out.println(incomObj.getUserId()+","+incomObj.getName()+","+incomObj.getSurname()+","+incomObj.getUserMark());
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
	
	@Transactional
	@Override
	public List <Resiver> readFromExamTable(ExamConnector examConnector)
	{
		List<Resiver> tableList = new ArrayList<Resiver>();
		List<Resiver> tempList = readByGroupId(examConnector.getGroupId());
		for (Resiver resiver : tempList) {
			if(resiver.getSubjectName().equals(examConnector.getSubjectName())&& 
					resiver.getType().equals(examConnector.getType())&&
					resiver.getTime().equals(examConnector.getTime()))
			{tableList.add(resiver);System.out.println("find");}
		}
		return tableList;
	}
}
