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
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   PersonDao personDao;    
   
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		personDao = new PersonDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int num = Integer.parseInt(request.getParameter("no"));
		String ename = request.getParameter("ename");
		String contactno = request.getParameter("contactno");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		System.out.println(num+" "+ename+" "+contactno);
		
		pw.println("<html><head><style type=text/css>table{width:50%;border-collapse:collapse;background-color:wheat;border-spacing:10px;}table,tr,td{ border:1px solid blue;}th, td{padding:20px;}</style></head><body>");
		pw.println("<form action=UpdateServlet method=POST><h1 style=background-color: maroon; color =white; padding =20px; text-align: center;>");
		pw.println("Welcome to Registration Page</h1>");
		pw.println("<table align=center><tr>");
		pw.println("<input type=hidden name=pid value="+num+">");
		pw.println("<td>Enter name:</td>");
		pw.println("<td><input type=text name=ename value="+ename+"></td>");
		pw.println("</tr><tr><td>Enter contact number:</td>");
		pw.println("<td><input type=text name=contactno value="+contactno+"></td>");
		pw.println("</tr><tr><td>Email id:</td>");
		pw.println("<td><input type=text name=email value="+email+"></td>");
		pw.println("</tr><tr><td>Gender</td><td>");
		if(gender.equals("Male")) {
			pw.println("<input type=radio name=gender value=Male>Male");
			pw.println("<input type=radio name=gender value=off>Female</td>");
			
		}else {
			pw.println("<input type=radio name=gender value=off>Male");
			pw.println("<input type=radio name=gender value=Female>Female</td>");
		}
		pw.println("</tr><tr><td>Address:</td><td>");
		pw.println("<textarea name=address rows=5 cols=20>"+address+"</textarea></td>");
		pw.println("</tr><tr><td colspan=2 align=center><input type=submit value=click></td></tr>");
		pw.println("</table></form></body></html>");
            
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int num = Integer.parseInt(request.getParameter("pid"));
		String ename = request.getParameter("ename");
		String contactno = request.getParameter("contactno");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		Person person = new Person();
		person.setPid(num);
		person.setEname(ename);
		person.setContactno(contactno);
		person.setEmail(email);
		person.setGender(gender);
		person.setAddress(address);
		
		if(personDao.updatePerson(person)) {
			pw.println("<h3 style=color:blue>Updated successfully</h3>");
			
		}
		else {
			pw.println("<h3 style=color:red>Try again</h3>");
		}
	}

}
