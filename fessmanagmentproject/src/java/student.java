import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Student")
public class student extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String n=request.getParameter("name");
        String e=request.getParameter("email");
        String c=request.getParameter("courses");
        String f=request.getParameter("fees");
        String p=request.getParameter("contact");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
               PreparedStatement ps =con.prepareStatement("insert into student values(?,?,?,?,?)");
ps.setString(1,n); 
ps.setString(2,e);
ps.setString(3,c);
ps.setString(4,f);
ps.setString(5,p);
int i=ps.executeUpdate();
if(i>0)
    out.print("You are Successfully registered");
RequestDispatcher rd=request.getRequestDispatcher("addStudent.html");
rd.forward(request,response);

        } catch (Exception e2) {System.out.println(e2); }
        out.close();
        
    }
}