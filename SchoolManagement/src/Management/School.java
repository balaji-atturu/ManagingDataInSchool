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



public class School {
private List<Teacher> teachers;
private List<Student> students;
static private int moneyEarned;
static private int moneySpent;
static private int totalMoney;
public School(List<Teacher> teachers, List<Student> students) {
	this.teachers = teachers;
	this.students = students;
	moneyEarned=0;
	moneySpent=0;
	totalMoney=0;
}
public List<Teacher> getTeachers() {
	return teachers;
}
public void setTeachers(List<Teacher> teachers) {
	this.teachers = teachers;
}
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}
@Override
public String toString() {
	return "School [teachers=" + teachers + ", students=" + students + ", moneyEarned=" + moneyEarned + ", moneySpent="
			+ moneySpent + ", totalMoney=" + totalMoney + "]";
}
public int getMoneyEarned() {
	return moneyEarned;
}
public static void updateMoneyEarned(int money)
{
	moneyEarned+=money;
	totalMoney+=money;
}
public static void updateMoneySpent(int money)
{
	moneySpent+=money;
	totalMoney-=money;
}
public int getMoneySpent() {
	return moneySpent;
}
public void payfees(int fees,int id)
{
	int res=SchoolDao.updateFee(fees, id);
	System.out.println(res);
	if(res>0)
		SchoolDao.updateMoneyEarned(fees);
}
public void paysalary(int salary,int id)
{
	int res=SchoolDao.updateSalary(salary, id);
	if(res>0)
		SchoolDao.updateMoneySpent(salary);
}
public void getTotalMoney() {
	SchoolDao.getMoney();
}public void addteacher()
{
	SchoolDao.insertteacher();
}
public void addStudent()
{
	SchoolDao.insertStudent();
}
public void getAllstudents()
{
	List<Student> students=SchoolDao.getStudents();
}
public void getAllteachers()
{
	List<Teacher> teachers=SchoolDao.getTeachers();
}


}
