package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDao;
import com.model.Person;

/**
 * Servlet implementation class UserRegServlet
 */
public class UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PersonDao personDao;
    public UserRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		personDao = new PersonDao();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String ename = request.getParameter("ename");
		String contactno = request.getParameter("contactno");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		Person p = new Person();
		p.setEname(ename);
		p.setContactno(contactno);
		p.setEmail(email);
		p.setGender(gender);
		p.setAddress(address);
		if(personDao.addPerson(p)) {
			pw.println("<h1 style=background-color:maroon;color:white;padding:20px;text-align:center;>your registraion successs</h1>");
			
		}
		else {
			pw.println("<h1 style=color:red>try again</h1>");
		}
		
	}
}
