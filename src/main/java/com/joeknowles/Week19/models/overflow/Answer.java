package com.joeknowles.Week19.models.overflow;

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
@Table(name="answers")
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4307132945219087396L;
	private Long id;
	private String answer;
	private Date created;
	private Date updated;
	private Question question;
	
	public Answer() {}
	public Answer(String s) { answer = s; }
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="answer_id", unique=true, nullable=false, updatable=false)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name="answer")
	public String getAnswer() { return answer; }
	public void setAnswer(String answer) { this.answer = answer; }
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
	public Question getQuestion() {return question; }
	public void setQuestion(Question question) { this.question = question; }

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
