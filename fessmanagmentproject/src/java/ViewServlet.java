import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @WebServlet("/ViewServlet")
 
public class ViewServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
           out.println("a<href='index.html'>Add New Accountant</a>");
           out.println("<h1>Accountant List</h1>");
           try
           {
               Class.forName("com.mysql.jdbc.Driver");
               Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
               Statement stmt=con.createStatement();
               ResultSet rs=stmt.executeQuery("select * from accountant");
               out.println("<table border=1 width=50%height=50%>");
               out.println("<tr><th>AccountantEmail</th>");
               while (rs.next())
               {
                   String n=rs.getString("email");
                   String nm=rs.getString("password");
                   
                   out.println("<tr><td>"+n+"</td><tr>"+nm+"</td><td>");
               }
               out.println("</table>");
               out.println("</html></body>");
               con.close();
           }
           catch (Exception e)
           {
               out.println("error");
           }
        }
    }

   