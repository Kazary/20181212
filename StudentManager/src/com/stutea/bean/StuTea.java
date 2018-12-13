package com.stutea.bean;

public class StuTea {

	private String name;
	private String birthday;
	private int age;
	private double score;
	private int classid;
	private int id;
	private String teachername;
	private String course;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "StuTea [name=" + name + ", birthday=" + birthday + ", age=" + age + ", score=" + score + ", classid="
				+ classid + ", id=" + id + ", teachername=" + teachername + ", course=" + course + "]";
	}
	public StuTea(String name, String birthday, int age, double score, int classid, int id, String teachername,
			String course) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.age = age;
		this.score = score;
		this.classid = classid;
		this.id = id;
		this.teachername = teachername;
		this.course = course;
	}
	public StuTea() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
