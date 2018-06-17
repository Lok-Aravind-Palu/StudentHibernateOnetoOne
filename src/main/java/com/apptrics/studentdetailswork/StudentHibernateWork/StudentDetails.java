package com.apptrics.studentdetailswork.StudentHibernateWork;

public class StudentDetails {

	private String sName;
	private int sId;
	private Marks marks;
	
	@Override
	public String toString() {
		return "StudentDetails [sName=" + sName + ", sId=" + sId + ", marks=" + marks.toString() + "]";
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public Marks getMarks() {
		return marks;
	}
	public void setMarks(Marks marks) {
		this.marks = marks;
	}
	
	
	
}
