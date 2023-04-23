package Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	List<Teacher> teacher=new ArrayList<>();
	List<Student> student=new ArrayList<>();
	School maharshi=new School(teacher,student);
	System.out.println("------->WELCOME TO MAHARSHI SCHOOL<>--------");
	System.out.println();
	maharshi.setStudents(SchoolDao.getStudents());
	maharshi.setTeachers(SchoolDao.getTeachers());
	while(true)
	{
		System.out.println();
		System.out.println();
		System.out.println("Enter 1 : To add Student\nEnter 2 : To add Teacher\nEnter 3 : To get Student list\nEnter 4 : To get Teacher List\nEnter 5 : To get SchoolList\nEnter 6 : To get TotalMoney\nEnter 7 : To pay Student fees\nEnter 8 : To give salary\nEnter 9 : To exit");
		int res=sc.nextInt();
		switch(res)
		{
		case 1:
			maharshi.addStudent();
			break;
		case 2:
			maharshi.addteacher();
			break;
		case 3:
			maharshi.getStudents();
			break;
		case 4:
			maharshi.getTeachers();
			break;
		case 5:
			System.out.println(maharshi);
			break;
		case 6:
			maharshi.getTotalMoney();
			break;
		case 7:
			System.out.println("Enter the student id");
			int id=sc.nextInt();
			System.out.println("Enter the money u want to pay");
			int fee=sc.nextInt();
			maharshi.payfees(fee, id);
			break;
		case 8:
			System.out.println("Enter the teacher id");
			int teachid=sc.nextInt();
			System.out.println("Enter the salary you want to give");
			int salary=sc.nextInt();
			maharshi.paysalary(salary, teachid);
			break;
		case 9:
			System.exit(0);
			break;
		}
	}
}
}
