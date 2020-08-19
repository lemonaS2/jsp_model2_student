package kr.ac.green.dao;

public interface Constants{
	String DRIVER = "com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/test";

	String UID = "root";
	String UPW = "1234";
	
	String[] SQLS = {
		"INSERT INTO student (s_name, s_tel, s_grade, s_class) VALUES (?,?,?,?)",
		"SELECT * FROM student ORDER BY s_id DESC",
		"UPDATE student SET s_tel = ?, s_grade = ?, s_class = ? WHERE s_id = ?",
		"DELETE FROM student WHERE s_id = ?",
		"SELECT * FROM student WHERE s_id = ?",
		"SELECT * FROM student where s_id like ? ORDER BY s_id DESC",
		"SELECT * FROM student where s_name like ? ORDER BY s_id DESC",
		"SELECT * FROM student where s_class like ? ORDER BY s_id DESC"
	};
	
	int INSERT = 0;
	int SELECT = 1;
	int UPDATE = 2;
	int DELETE = 3;
	int SELECT_ONE = 4;
	int SEARCH_ID = 5;
	int SEARCH_NAME = 6;
	int SEARCH_CLASS = 7;
}
