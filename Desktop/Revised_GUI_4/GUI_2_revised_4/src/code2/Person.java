package code2;
//elab-source: Person.java
import java.util.*;

public class Person{
	private String ID;
	private String name;
	private String lastname;
	private String gender;
	private int age;
	public Person(Person other){
		this.ID =other.ID;
        this.name = other.name;
		this.lastname = other.lastname;
		this.gender = other.gender;
		this.age = other.age;
	}
	public void switchPerson(Person other){
		String ID,name,lastname,gender;
		int age;
		ID =other.ID;
        name = other.name;
		lastname = other.lastname;
		gender = other.gender;
		age = other.age;
		
		other.age= this.age;
	    other.gender = this.gender;
	    other.ID = this.ID;
	    other.lastname = this.lastname;
	    other.name = this.name;
		
		this.ID =ID;
        this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
        
	}
	public Person clone(){
		return new Person(this.ID, this.name,  this.lastname,  this.gender,  this.age);
	}
	public Person(){
		this.ID ="";
        this.name = "";
		this.lastname = "";
		this.gender = "";
		this.age = 0;
	}
	public Person(String ID, String name, String lastname, String gender, int age) {
		super();
		this.ID = ID;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;  
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return getID() +", " +getName()+" "+getLastname()+", "+ getGender()+", "+ getAge();
	}
}