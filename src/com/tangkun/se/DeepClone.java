package com.tangkun.se;

public class DeepClone {

	public static void main(String[] args) {

		Student stu1 = new Student("tangkun", 18);
		Professor stu1P = new Professor("zhanglong", 20);
		stu1.setProfessor(stu1P);

		Student stu2 = (Student) stu1.clone();
//		stu2.setName("tangmingzhi");
//		stu2.getProfessor().setName("zhangxiaoxiang");
//		System.out.println("stu2===="+stu2.toString());
		System.out.println(stu1.getProfessor() == stu2.getProfessor());

	}
}

class Student implements Cloneable {

	private String name;
	private Integer age;
	private Professor professor;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public Object clone() {

		Student stu = null;
		try {
			stu = (Student) super.clone();
			stu.setProfessor((Professor) professor.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return stu;
	}

	@Override
	public String toString() {

		return this.name + "\n" + this.age + "\n" + this.getProfessor().getName() + "\n" + this.getProfessor().getAge();
	}

}

class Professor implements Cloneable {

	private String name;
	private int age;

	public Professor(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public Object clone() {

		Object pro = null;

		try {
			pro = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return pro;
	}

}