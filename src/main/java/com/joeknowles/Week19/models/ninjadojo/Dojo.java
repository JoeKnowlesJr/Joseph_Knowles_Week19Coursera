package com.joeknowles.Week19.models.ninjadojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="dojos")
public class Dojo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2247348036356740709L;
	private Long id;
	private String name;
	private Date created;
	private Date updated;
    private List<Ninja> ninjas;
	
	public Dojo() { ninjas = new ArrayList<>(); }
	public Dojo(String n) { name = n; ninjas = new ArrayList<>(); }
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dojo_id", unique=true, nullable=false, updatable=false)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name="name")
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
    @Temporal(TemporalType.DATE)
    @Column(name = "created")
	public Date getCreated() { return created; }
	public void setCreated(Date created) { this.created = created; }
	
    @Temporal(TemporalType.DATE)
    @Column(name = "updated")
	public Date getUpdated() { return updated; }
	public void setUpdated(Date updated) { this.updated = updated; }

    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	public List<Ninja> getNinjas() { return ninjas; }
	public void setNinjas(List<Ninja> ninjas) { this.ninjas = ninjas; }

	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }	
	
	public int addNinja(Ninja n) {
		if (ninjas == null) ninjas = new ArrayList<>();
		ninjas.add(n);
		return ninjas.size();
	}
}
