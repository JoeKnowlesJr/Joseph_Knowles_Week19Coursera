package com.joeknowles.Week19.models.overflow;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tags")
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100818394805826813L;
	
	private Long id;
	private String subject;
	private Date created;
	private Date updated;
	private List<Question> questions;
	
	public Tag() { questions = new ArrayList<>(); }
	public Tag(String s) { questions = new ArrayList<>(); subject = s;}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tag_id", unique=true, nullable=false, updatable=false)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name="subject")
	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "questions_tags", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))	
    public List<Question> getQuestions() { return questions; }
	public void setQuestions(List<Question> questions) { this.questions = questions; }

	@Temporal(TemporalType.DATE)
	@Column(name="created")
	public Date getCreated() { return created; }
	public void setCreated(Date created) { this.created = created; }
	
    @Temporal(TemporalType.DATE)
	@Column(name="updated")
	public Date getUpdated() { return updated; }
	public void setUpdated(Date updated) { this.updated = updated; }
	
	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }
	
	
}
