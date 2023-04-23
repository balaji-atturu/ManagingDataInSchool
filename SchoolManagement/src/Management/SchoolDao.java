package Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolDao {
	 static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/school"; 
	 static String username="root";
	static String password="Balaji@3456";
	static List<Student> students=new ArrayList<Student>();
	static List<Teacher> teachers=new ArrayList<Teacher>();
public static List<Student> getStudents()
{
	
	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from students");
	while(rs.next())
	{
		int id=rs.getInt(1);
		String name=rs.getString(2);
		int fees=rs.getInt(3);
		Student student=new Student(id,name,fees);
		
		students.add(student);
	}
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return students;
}
public static List<Teacher> getTeachers()
{
	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from teachers");
	while(rs.next())
	{
		int id=rs.getInt(1);
		String name=rs.getString(2);
		int salary=rs.getInt(3);
		Teacher teacher=new Teacher(id,name,salary);
		
		teachers.add(teacher);
	}
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return teachers;
}
public static void insertStudent()
{
	 Scanner sc=new Scanner(System.in);

	System.out.println("Enter the id");
	int id=sc.nextInt();
	System.out.println("Enter the name");
	String name=sc.next();
	System.out.println("Enter the fees");
	int fees=sc.nextInt();
	try {
		
		Class.forName(driver);
		
		Connection con=DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
        String sql = "INSERT INTO students(id,name,fees) "+ "VALUES(?,?,?)";
PreparedStatement pstmt=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
pstmt.setInt(1, id);
pstmt.setString(2,name);
pstmt.setInt(3, fees);

int rs=pstmt.executeUpdate();
		if(rs>0) {
			System.out.println("Added succesfully");
		}
		else
		{
			System.out.println("Unsuccessful");
		}
	
	con.close();
	} 
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}
public static void insertteacher()
{
	Scanner sc=new Scanner(System.in);

	System.out.println("Enter the id");
	int id=sc.nextInt();
	System.out.println("Enter the name");
	String name=sc.next();
	System.out.println("Enter the salary");
	int salary=sc.nextInt();

	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
        String sql = "INSERT INTO teachers(id,name,salary) "+ "VALUES(?,?,?)";
PreparedStatement pstmt=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
pstmt.setInt(1, id);
pstmt.setString(2,name);
pstmt.setInt(3, salary);
int rs=pstmt.executeUpdate();
		if(rs>0) {
			System.out.println("Added succesfully");
		}
		else
		{
			System.out.println("Unsuccessful");
		}
	
	con.close();
	} 
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public static void getMoney()
{
	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from money");
	while(rs.next())
	{
		int moneyEarned=rs.getInt(1);
		int moneySpent=rs.getInt(2);
		int totalMoney=rs.getInt(3);
		System.out.println("moneyEarned : Rs."+moneyEarned);
		System.out.println("moneySpent  : Rs."+moneySpent);
		System.out.println("totalMoney  : Rs."+totalMoney);
	}
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}
public static void updateMoneySpent(int money)
{
	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from money");
		int earned=0;
		int spent=money;
		int totalMoney=0;
	while(rs.next())
	{
		 earned+=rs.getInt(1);
		 spent+=rs.getInt(2);
		 totalMoney+=rs.getInt(3);
	}
	totalMoney-=money;
	 // String query = "update table money set moneyEarned=earned where id=1";
	  PreparedStatement st= con.prepareStatement("update money set moneyEarned =? ,moneySpent=?,totalMoney=? where id=? "); 
	  st.setInt(1, earned);
	  st.setInt(2, spent);
	  st.setInt(3, totalMoney);
      st.setInt(4, 1);
      //st.setInt(3, totalMoney);
	  st.executeUpdate();
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public static void updateMoneyEarned(int money)
{
	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from money");
		int earned=money;
		int spent=0;
		int totalMoney=money;
	while(rs.next())
	{
		 earned+=rs.getInt(1);
		 spent+=rs.getInt(2);
		 totalMoney+=rs.getInt(3);
	}
	 // String query = "update table money set moneyEarned=earned where id=1";
	  PreparedStatement st= con.prepareStatement("update money set moneyEarned =? ,moneySpent=?,totalMoney=? where id=? "); 
	  st.setInt(1, earned);
	  st.setInt(2, spent);
	  st.setInt(3, totalMoney);
      st.setInt(4, 1);
      //st.setInt(3, totalMoney);
	  st.executeUpdate();
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public static int updateFee(int money,int id)
{
	int res=0;
	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from students");
		int studentfees=0;
		while(rs.next())
		{
			if(rs.getInt(1)==id)
			{
				studentfees=rs.getInt(3);
				break;
			}
		}
		studentfees-=money;
	  PreparedStatement st= con.prepareStatement("update students set fees=? where id=? "); 
	  st.setInt(1, studentfees);
	  st.setInt(2, id);
      //st.setInt(3, totalMoney);
	  res=st.executeUpdate();
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return res;
}
public static int updateSalary(int salary,int id)
{
	int res=0;
	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, username, password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from teachers");
		int teachsalary=0;
		while(rs.next())
		{
			if(rs.getInt(1)==id)
			{
				teachsalary=rs.getInt(3);
				break;
			}
		}
		teachsalary-=salary;
	  PreparedStatement st= con.prepareStatement("update teachers set salary=? where id=? "); 
	  st.setInt(1, teachsalary);
	  st.setInt(2, id);
	  res=st.executeUpdate();
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return res;
}
}
