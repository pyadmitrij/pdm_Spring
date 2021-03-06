
package com.intita.dao;

import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.intita.domain.Group;

/**
 * @author Dmitriy
 *
 */
public class TestGroupDaoImpl 
{
	@Autowired
	private ApplicationContext appContext;
	
	private Group group = null;
	private GroupDAOImpl dao = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Before");
		dao = (GroupDAOImpl) appContext.getBean("groupDAO");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("After");
		dao = null;
	}

	/**
	 * Test method for {@link com.intita.dao.GroupDAOImpl#findById(java.lang.Integer)}.
	 */
	@Test
	public void testFindById() 
	{
		Date year = new Date("2013/03/20");
		group = new Group();
		group.setGroupId(100);
		group.setName("Test");
		group.setYear(year);
		assertNull(dao.findById(group.getGroupId()));
	}

	/**
	 * Test method for {@link com.intita.dao.GroupDAOImpl#deleteGroup(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteGroup() 
	{
		
	}

}
