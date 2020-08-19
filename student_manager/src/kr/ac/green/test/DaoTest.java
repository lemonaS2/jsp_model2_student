package kr.ac.green.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.ac.green.dao.StudentDao;
import kr.ac.green.dto.Student;

public class DaoTest {

	private static StudentDao dao;
	private Connection con;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = StudentDao.getDao();
	}

	@Before
	public void setUp() throws Exception {
		con = dao.connect();
	}

	@Test
	public void testInsertInfo() {
		Student student = new Student(1,"kim","010-3334-3333",3,2);
		
		Assert.assertEquals(1, dao.insertInfo(con, student));
	}
	
	@Test
	public void testSelectAll() throws Exception {
		Assert.assertEquals(7, dao.selectAll(con).length);
	}
	
	@Test 
	public void testDeleteInfo(){
		int s_id = 1;
		Assert.assertEquals(1, dao.DeleteInfo(con, s_id));
	}
	
	@Test
	public void testUpdateInfo(){ 
		Student student = new Student(2,"0000","010-0000-0000", 0, 0);
		Assert.assertEquals(1, dao.UpdateInfo(con, student));
	}
	
	@Test
	public void testSelectOne() throws Exception {
		int s_id = 16;  
		Assert.assertEquals(1, dao.selectOne(con, s_id));
	}
	
	@After
	public void tearDown() throws Exception {
		dao.disconnect(con);
	}
}
