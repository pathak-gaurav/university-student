package com.spring.college.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "college")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "address")
	@Pattern(regexp = "[ a-zA-Z ]*", message = "Should contain A to Z characters only")
	@NotNull(message = "name is required")
	private String address;

	@Column(name = "state")
	@NotNull(message = "State cannot be empty")
	@Pattern(regexp = "[ a-zA-Z ]*", message = "Should contain A to Z characters only")
	private String state;

	@Column(name = "city")
	@NotNull(message = "city cannot be empty")
	@Pattern(regexp = "[ a-zA-Z ]*", message = "Should contain A to Z characters only")
	private String city;

	@Column(name = "phone")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Phone No. Cannot be more that 10 digits")
	@NotNull(message = "Phone No. cannot be empty")
	@Size(min = 10, max = 10, message = "10 digits are required")
	private String phone;

	@Column(name = "name")
	@Pattern(regexp = "[ a-zA-Z ]*", message = "Should contain A to Z characters only")
	@NotNull(message = "name is required")
	private String name;

	public College() {
	}

	public College(Integer id,
			@Pattern(regexp = "[ a-zA-Z ]*", message = "Should contain A to Z characters only") @NotNull(message = "name is required") String address,
			@NotNull(message = "State cannot be empty") @Pattern(regexp = "[ a-zA-Z ]*", message = "Should contain A to Z characters only") String state,
			@NotNull(message = "city cannot be empty") @Pattern(regexp = "[ a-zA-Z ]*", message = "Should contain A to Z characters only") String city,
			@Pattern(regexp = "(^$|[0-9]{10})", message = "Phone No. Cannot be more that 10 digits") @NotNull(message = "Phone No. cannot be empty") @Size(min = 10, max = 10, message = "10 digits are required") String phone,
			@Pattern(regexp = "[ a-zA-Z ]*", message = "Should contain A to Z characters only") @NotNull(message = "name is required") String name) {
		super();
		this.id = id;
		this.address = address;
		this.state = state;
		this.city = city;
		this.phone = phone;
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", address=" + address + ", state=" + state + ", city=" + city + ", phone=" + phone
				+ ", name=" + name + "]";
	}

}
