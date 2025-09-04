import java.sql.*;
public class Accountantloginp
{
public static boolean validate(String name,String password) {
    boolean status=false;
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
            PreparedStatement ps =con.prepareStatement("select * from accountant where name=? and password=?");
ps.setString(1,name); 
ps.setString(2,password);

ResultSet rs=ps.executeQuery();
status=rs.next();

}catch(Exception e) {System.out.println(e);}

return status;
}
}