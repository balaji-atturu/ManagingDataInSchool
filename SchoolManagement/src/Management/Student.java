package Management;

public class Student {
private int id;
private String name;
private int fees;
private int paidFees;
Student(int id,String name,int fees)
{
	this.id=id;
	this.name=name;
	this.fees=fees;
	paidFees=0;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getFees() {
	return fees;
}
public void setFees(int fees) {
	this.fees = fees;
}
public int getPaidFees() {
	return paidFees;
}
public void payFee(int paidFees) {
	this.paidFees+=paidFees;
}
public int getReaminfees()
{
	return fees-paidFees;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", fees=" + fees + ", paidFees=" + paidFees + ", getReaminfees()="
			+ getReaminfees() + "]";
}

}
