package com.intita.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.intita.dao.FolderDaoImpl;
import com.intita.domain.Folder;

public class FolderServiceImplTest {
	FolderDaoImpl dao = new FolderDaoImpl();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("FolderServiceImplTest setUpBeforeClass() ");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindByNameStringFetchMode() {
		Folder folder = new Folder();
		folder.setName("TestFolderName");
//		dao.create(folder);		
		Folder folder2 = new Folder();
//		folder2.set
//		fail("Not yet implemented");
	}

}
