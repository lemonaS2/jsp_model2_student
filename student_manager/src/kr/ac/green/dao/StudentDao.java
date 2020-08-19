package kr.ac.green.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.green.dto.Student;


public class StudentDao implements Constants {
	
	private StudentDao(){
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static StudentDao dao = new StudentDao();
	
	public static StudentDao getDao(){
		return dao;
	}
	
	public Connection connect(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, UID, UPW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void disconnect(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 등록
	public int insertInfo(Connection con, Student student){
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[INSERT]);
			pStmt.setString(1, toEn(student.getS_name()));
			pStmt.setString(2, toEn(student.getS_tel()));
			pStmt.setInt(3, student.getS_grade());
			pStmt.setInt(4, student.getS_class());
			result = pStmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pStmt);
		}
		
		return result;
	}
	
	// 검색
	public Student[] searchAll(Connection con, String option, String search_desc) {
		Student[] list = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			if(option.equals("s_id")){
				pStmt = con.prepareStatement(SQLS[SEARCH_ID]);
				pStmt.setString(1, "%"+search_desc+"%");
			}else if(option.equals("s_name")) {
				pStmt = con.prepareStatement(SQLS[SEARCH_NAME]);
				pStmt.setString(1, "%"+search_desc+"%");
			}else if(option.equals("s_class")) {	
				pStmt = con.prepareStatement(SQLS[SEARCH_CLASS]);
				pStmt.setString(1, "%"+search_desc+"%");
			}
			
			rs = pStmt.executeQuery();
			
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			
			list = new Student[count];
			
			int idx = 0;
			while(rs.next()){
				int s_id = rs.getInt("s_id");
				String s_name = toKor(rs.getString("s_name"));
				String s_tel = toKor(rs.getString("s_tel"));
				int s_grade = rs.getInt("s_grade");
				int s_class = rs.getInt("s_class");
				
				list[idx] = new Student(s_id, s_name, s_tel, s_grade, s_class);
				idx++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs); 
			close(pStmt);
		}
		
		return list;
	}
	
	// 모든 목록
	public Student[] selectAll(Connection con){
		Student[] list = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			pStmt = con.prepareStatement(SQLS[SELECT]);
			rs = pStmt.executeQuery();
			
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			
			list = new Student[count];
			
			int idx = 0;
			while(rs.next()){
				int s_id = rs.getInt("s_id");
				String s_name = toKor(rs.getString("s_name"));
				String s_tel = toKor(rs.getString("s_tel"));
				int s_grade = rs.getInt("s_grade");
				int s_class = rs.getInt("s_class");
				
				list[idx] = new Student(s_id, s_name, s_tel, s_grade, s_class);
				idx++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(rs);
			close(pStmt);
		}
		
		return list;
	}
	
	// 한명 찾기
	public Student selectOne(Connection con, int id){
		Student list = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = con.prepareStatement(SQLS[SELECT_ONE]);
			pStmt.setInt(1, id);
			rs = pStmt.executeQuery();
			
			list = new Student();
			
			if(rs.next()){
				int s_id = rs.getInt("s_id");
				String s_name = toKor(rs.getString("s_name"));
				String s_tel = toKor(rs.getString("s_tel"));
				int s_grade = rs.getInt("s_grade");
				int s_class = rs.getInt("s_class");
				list = new Student(s_id, s_name, s_tel, s_grade, s_class);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(rs);
			close(pStmt);
		}
		
		return list;
	}
	
	// 수정
	public int UpdateInfo(Connection con, Student student){
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[UPDATE]);
			pStmt.setString(1, student.getS_tel());
			pStmt.setInt(2, student.getS_grade());
			pStmt.setInt(3, student.getS_class());
			pStmt.setInt(4, student.getS_id());
			result = pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pStmt);
		}
		
		return result;
	}
	
	
	// 삭제
	public int DeleteInfo(Connection con, int id){
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[DELETE]);
			pStmt.setInt(1, id);
			result = pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pStmt);
		}
		
		
		return result;
	}
	
	public String toKor(String en){
		String kor = null;

		try {
			kor = new String(en.getBytes("8859_1"), "euc_kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return kor;
	}
	
	public String toEn(String kor){
		String en = null;

		try {
			en = new String(kor.getBytes("euc_kr"), "8859_1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return en;
	}
	
	
	public void close(PreparedStatement pStmt){
		try {
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
