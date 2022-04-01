package crud_examination.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.xdevapi.PreparableStatement;

import crud_examination.entity.Student;

public class StudentDao {
	private DataSource dataSource;

	public StudentDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<Student> getListStudent() throws Exception {
		List<Student> students = new ArrayList<Student>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();

			String query = "Select * from students";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");

				Student student = new Student(id, firstName, lastName, email);

				students.add(student);

			}
			return students;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}

		return null;
	}

	public Student getStudent(String idStudent) throws Exception {
		Student student = new Student();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			int intID = Integer.parseInt(idStudent);
			conn = dataSource.getConnection();
			String query = "Select * from students where id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, intID);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				student = new Student(intID, firstName, lastName, email);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return student;

		
	}

	public void addStudent(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			String query = "insert into students (first_name, last_name, email) values (?,?,?)";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());

			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
	}
	
	public void updateStudent(Student student) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = dataSource.getConnection();
			String query = "update students set first_name = ?, last_name = ?, email = ? where id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			stmt.setInt(4, student.getId());
			
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(conn, stmt, null);
		}
	}
	
	public void deleteStudent(String id) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			int idInt = Integer.parseInt(id);
			String sql = "delete from students where id = ?";
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idInt);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			close(conn, stmt, null);
		}
	}

}
