package com.apptrics.studentdetailswork.StudentHibernateWork;

public class Marks {
	
	private int id;
	private double m1;
	private double m2;
	private double m3;
	private double m4;
	
	
	@Override
	public String toString() {
		return "Marks [id=" + id + ", m1=" + m1 + ", m2=" + m2 + ", m3=" + m3 + ", m4=" + m4 + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double getM1() {
		return m1;
	}
	public void setM1(double m1) {
		this.m1 = m1;
	}
	public double getM2() {
		return m2;
	}
	public void setM2(double m2) {
		this.m2 = m2;
	}
	public double getM3() {
		return m3;
	}
	public void setM3(double m3) {
		this.m3 = m3;
	}
	public double getM4() {
		return m4;
	}
	public void setM4(double m4) {
		this.m4 = m4;
	}

	
	

}
