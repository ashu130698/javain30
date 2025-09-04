import java.io.*;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminLoginSe")
public class AdminLoginSe extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
           String n=request.getParameter("aname"); 
           String p=request.getParameter("pass");
       
           if(AdminLogin.validate(n, p)){
out.print("done");
RequestDispatcher rd=request.getRequestDispatcher("Adminpanel.html");
rd.forward(request,response);
           }
else{
out.print("Sorry username or password error");
RequestDispatcher rd=request.getRequestDispatcher("index.html");
rd.include(request,response);
}
out.close();
    }
}