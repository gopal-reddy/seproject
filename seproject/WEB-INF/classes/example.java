import java.sql.*;
import java.io.*;
class example{
public static void main(String args[])
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/srinu","root","");
PreparedStatement ps=con.prepareStatement("insert into request values(?,?,?,?)");
ps.setString(2,"fdt");
pw.println(s[i]);
pw.println(sip);
ps.executeUpdate();
}
catch(Exception e){System.out.print(e);}   
}
}