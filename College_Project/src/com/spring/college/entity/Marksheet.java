package com.spring.college.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "marksheet")
public class Marksheet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "rollno")
	@Pattern(regexp = "[ a-zA-Z0-9]*", message = "Should contain only valid aphanumeric combination.")
	@Size(min = 10, max = 10, message = "10 digit rollno. are required.")
	private String rollno;

	@Column(name="name")
	@Pattern(regexp="[ a-zA-Z ]*",message="Only Characters are allowed.")
	private String name;

	@Column(name="physics")
	private String physics;

	@Column(name="chemistry")
	private String chemistry;

	@Column(name="maths")
	private String maths;

	@Column(name="studentId")
	private Integer studentId;

	public Marksheet() {
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhysics() {
		return physics;
	}

	public void setPhysics(String physics) {
		this.physics = physics;
	}

	public String getChemistry() {
		return chemistry;
	}

	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}

	public String getMaths() {
		return maths;
	}

	public void setMaths(String maths) {
		this.maths = maths;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Marksheet [rollNo=" + rollno + ", name=" + name + ", id=" + id + ", physics=" + physics + ", chemistry="
				+ chemistry + ", maths=" + maths + ", studentId=" + studentId + "]";
	}

}
