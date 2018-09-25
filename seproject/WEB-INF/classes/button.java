import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import java.sql.*;
public class button extends HttpServlet{
int i;
int[] p=new int[10];
int[] z=new int[10];
int[] f=new int[10];
String[] s=new String[10];
String[] k=new String[10];
String[] movies = {"latestmovies.html", "oldmovies.html", "tollywood.html", "hollywood.html"};
String[] music = {"latestmusic.html", "oldmusic.html", "best.html", "english.html"};
String[] languages = {"latestlanguages.html", "object.html", "procedure.html", "scripting.html"};
String[] tools = {"docker.html", "chef.html", "jenkins.html", "git.html"};
public void init(){
p[2]=0;
p[3]=0;
p[4]=0;
p[5]=0;
}
public void service(ServletRequest req,ServletResponse res)
throws IOException,ServletException{
PrintWriter pw =res.getWriter();
res.setContentType("text/html");
String sip=req.getLocalAddr();
String s1=req.getParameter("movies");
String s2=req.getParameter("music");
String s3=req.getParameter("languages");
String s4=req.getParameter("tools");
s[2]=s1;
s[3]=s2;
s[4]=s3;
s[5]=s4;
k[2]="movies.html";
k[3]="music.html";
k[4]="languages.html";
k[5]="tools.html";
f[2]=0;
f[3]=0;
f[4]=0;
f[5]=0;
i=2;
int no=0;
while(i<6)
{
if(s[i]!=null)
{
try
{
++p[i];
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/srinu","root","");
pw.println("before conn");
PreparedStatement psr=con.prepareStatement("select "+s[i]+" from request where ipadress='"+sip+"'");
ResultSet rs=psr.executeQuery();
while(rs.next())
{
no=rs.getInt(s[i]);
no++;
pw.println("button value"+no);
}
PreparedStatement ps=con.prepareStatement("update request set "+s[i]+"="+no+" where ipadress='"+sip+"'");
pw.println(sip);
ps.executeUpdate();
RequestDispatcher dis=req.getRequestDispatcher(k[i]);     
          dis.include(req, res);
PreparedStatement psrd=con.prepareStatement("select * from request where ipadress='"+sip+"'");
ResultSet rs3=psrd.executeQuery();
rs3.next();
z[2]=rs3.getInt(2);
z[3]=rs3.getInt(3);
z[4]=rs3.getInt(4);
z[5]=rs3.getInt(5);
 int max=((z[2]>z[3])&&(z[2]>z[4])&&(z[2]>z[5]))?z[2]:(((z[3]>z[4])&&(z[3]>z[5]))?z[3]:(z[4]>z[5])?z[4]:z[5]);
int min=((z[2]<z[3])&&(z[2]<z[4])&&(z[2]<z[5]))?z[2]:(((z[3]<z[4])&&(z[3]<z[5]))?z[3]:(z[4]<z[5])?z[4]:z[5]);
int a=(z[2]/min);
int m=(z[3]/min);
int k=(z[4]/min);
int l=(z[5]/min);
pw.println("least value"+min);
int j=2;
int sum=(z[2]+z[3]+z[4]+z[5]);
if(z[2]==max){
  for(int b=0;b<4;b++)
   {
pw.println("<html><body><br><a href="+movies[b]+">"+movies[b]+"</a><br></body></html>");
f[2]=1;
   }
 }
else if(z[3]==max){
for(int b=0;b<4;b++)
  {
pw.println("<html><body><br><a href="+music[b]+">"+music[b]+"</a><br></body></html>");
f[3]=1;
  }
 }
else if(z[4]==max){
for(int b=0;b<4;b++)
  {
pw.println("<html><body><br><a href="+languages[b]+">"+languages[b]+"</a><br></body></html>");
f[4]=1;
  }
 }
else if(z[5]==max){
for(int b=0;b<4;b++)
  {
pw.println("<html><body><br><a href="+tools[b]+">"+tools[b]+"</a><br></body></html>");
f[5]=1;
  }
 }
if(f[2]!=1)
 {
for(int b=0;b<a;b++)
  {
pw.println("<html><body><br><a href="+movies[b]+">"+movies[b]+"</a><br></body></html>");
f[2]=0;
  }
 }
if(f[3]!=1)
{
for(int b=0;b<m;b++)
  {
pw.println("<html><body><br><a href="+music[b]+">"+music[b]+"</a><br></body></html>");
f[3]=0;
  }
}
if(f[4]!=1)
{
for(int b=0;b<k;b++)
  {
pw.println("<html><body><br><a href="+languages[b]+">"+languages[b]+"</a><br></body></html>");
f[4]=0;
  }
}
if(f[5]!=1)
{
for(int b=0;b<l;b++)
{
pw.println("<html><body><br><a href="+tools[b]+">"+tools[b]+"</a><br></body></html>");
f[5]=0;
}
}
}
catch(Exception e){System.out.print(e);}   
}
i++;
}
}
public void destroy(){}
}