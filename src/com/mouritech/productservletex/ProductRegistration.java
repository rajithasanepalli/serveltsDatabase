package com.mouritech.productservletex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductRegistration
 */
@WebServlet("/ProductRegistration")
public class ProductRegistration extends HttpServlet {
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
			int productId;
			productId=Integer.parseInt(request.getParameter("pid"));
			String productName = request.getParameter("pname");
			int productPrice;
			 productPrice = Integer.parseInt(request.getParameter("pprice"));
			String productBrand = request.getParameter("pbrand");
			String productCategory = request.getParameter("pcategory");
			out.println("<h1> Product Id="+productId+ "Product Name = " +productName + "Product Price = "+productPrice+
					"Product Brand = "+productBrand +"Product Category="+productCategory+"</h1>");
			con = DBConnection.getDBConnection();
			String insertCustomer = "insert into product_reg values(?,?,?,?,?);";
			
			pstmt = con.prepareStatement(insertCustomer);
			pstmt.setInt(1, productId);
			pstmt.setString(2, productName);
			pstmt.setInt(3, productPrice);
			pstmt.setString(4, productBrand);
			pstmt.setString(5, productCategory);
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
