package com.mouritech.studentservelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mouritech.productservletex.DBConnection;


/**
 * Servlet implementation class StudentDataservelet
 */
@WebServlet("/StudentDataservelet")
public class StudentDataservelet extends HttpServlet {
	static Connection con; // = null;
	static PreparedStatement pstmt; // = null;
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			//Here the text to be printed on the browser
			PrintWriter out = response.getWriter();
			//read the data entered in the html
			
			int studentId;
			studentId=Integer.parseInt(request.getParameter("sid"));
			String studentName = request.getParameter("sname");
			String date=request.getParameter("sdob");
			
			String studenEmail = request.getParameter("semail");
			Long studentPhone;
			studentPhone=Long.parseLong(request.getParameter("stel"));
			String studentCourse = request.getParameter("scourse");
			

			
			out.println("<h1> Student Id="+studentId+ "Student Name = " +studentName + "Student DoB ="+date+
					
		"Student Email = "+studenEmail +"Student phone="+studentPhone+"Student Course="+studentCourse+"</h1>");
			
			con = DBConnection.getDBConnection();
			String insertCustomer = "insert into student_reg values(?,?,?,?,?,?);";
			
			pstmt = con.prepareStatement(insertCustomer);
			pstmt.setInt(1, studentId);
			pstmt.setString(2, studentName);
			pstmt.setString(3,date);
			pstmt.setString(4, studenEmail);
			pstmt.setLong(5, studentPhone);
			pstmt.setString(6, studentCourse);
			int i = pstmt.executeUpdate();
			if(i != 0) {
				out.println("inserted successfully");
			}else {
				out.println("Not inserted");
			}
		
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
