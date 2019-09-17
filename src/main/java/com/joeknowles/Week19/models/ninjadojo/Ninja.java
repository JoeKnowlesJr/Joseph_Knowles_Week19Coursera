package com.joeknowles.Week19.models.ninjadojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ninjas")
public class Ninja implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6948365650170649120L;
	private Long id;
	private String first_name;
	private String last_name;
	private int age;
	private Date created;
	private Date updated;
	private Dojo dojo;
	
	public Ninja() {}
	public Ninja(String f, String l, int a, Dojo d) {
		first_name = f;
		last_name = l;
		age = a;
		dojo = d;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ninja_id", unique=true, nullable=false, updatable=false)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name="first_name")
	public String getFirstName() { return first_name; }
	public void setFirstName(String first_name) { this.first_name = first_name; }
	
	@Column(name="last_name")
	public String getLastName() { return last_name; }
	public void setLastName(String last_name) { this.last_name = last_name; }
	
	@Column(name="age")
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
	public Dojo getDojo() { return dojo; }
	public void setDojo(Dojo dojo_id) { this.dojo = dojo_id; }
	
    @Temporal(TemporalType.DATE)
    @Column(name = "created")
	public Date getCreated() { return created; }
	public void setCreated(Date created) { this.created = created; }
	
    @Temporal(TemporalType.DATE)
    @Column(name = "updated")
	public Date getUpdated() { return updated; }
	public void setUpdated(Date updated) { this.updated = updated; }
	
	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }	
}
