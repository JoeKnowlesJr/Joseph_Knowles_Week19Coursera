package com.joeknowles.Week19.models.ninjadojo;

public class NinjaFormObject {
	private String firstName;
	private String lastName;
	private int age;
	private Long dojo_id;
	
	public NinjaFormObject() {}
	
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public Long getDojo_id() { return dojo_id; }
	public void setDojo_id(Long dojo_id) { this.dojo_id = dojo_id; }
	public Ninja getNinja(Dojo d) { return new Ninja(firstName, lastName, age, d); }
}
