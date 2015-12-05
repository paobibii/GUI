package code;
import java.util.*;
public class Database {

	public ArrayList<String> member ;
	public ArrayList<String> member_Lastname ;
	public ArrayList<Integer> member_age ;
	public ArrayList<String> gender ;
	public ArrayList<String> getMember_Lastname() {
		return member_Lastname;
	}
	public void setMember_Lastname(ArrayList<String> member_Lastname) {
		this.member_Lastname = member_Lastname;
	}
	public ArrayList<Integer> getMember_age() {
		return member_age;
	}
	public void setMember_age(ArrayList<Integer> member_age) {
		this.member_age = member_age;
	}
	public ArrayList<String> getGender() {
		return gender;
	}
	public void setGender(ArrayList<String> gender) {
		this.gender = gender;
	}
	public void addMember(String mem){
    	member.add(mem);
    }
	public ArrayList<String> getMember() {
		return member;
	}
	public void setMember(ArrayList<String> member) {
		this.member = member;
	}
}
