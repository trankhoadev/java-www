package crud_examination.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import crud_examination.dao.StudentDao;
import crud_examination.entity.Student;

/**
 * Servlet implementation class StudentControler
 */
@WebServlet("/students")
public class StudentControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;
   
    public StudentControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			studentDao = new StudentDao(dataSource);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch (theCommand) {
			case "LIST": {
				listStudent(request, response);
				break;
			}
			case "UPDATE": {
				updateStudent(request, response);
				break;
			}
			case "ADD": {
				addStudent(request, response);
				break;
			}
			case "LOAD": {
				loadStudent(request, response);
				break;
			}
			case "DELETE": {
				deleteStudent(request, response);
				break;
			}
			default:
				listStudent(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Student> students = studentDao.getListStudent();
		for(int i = 0; i < students.size(); ++i) {
			System.out.println("Student: " + students.get(i));
		}
		
		request.setAttribute("Student_List", students);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list-student.jsp");
		
		requestDispatcher.forward(request, response);
	}
	
	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String theStudentId = request.getParameter("studentId");
			System.out.println("Load Student..."+ theStudentId);
			Student student = studentDao.getStudent(theStudentId);
			
			System.out.println("Load Student...");
			request.setAttribute("The_Student", student);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update-student-form.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email"); 
		
		Student student = new Student(id, firstName, lastName, email);
		
		studentDao.updateStudent(student);
		System.out.println("Update successful");
		listStudent(request, response);
	}
	
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			
			Student student = new Student(firstName, lastName, email);
			
			studentDao.addStudent(student);
			
			System.out.println("Add Successful");
			
			listStudent(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String id = request.getParameter("studentId");
			System.out.println(id);
			studentDao.deleteStudent(id);
			System.out.println("Delete thanh cong");
			listStudent(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
