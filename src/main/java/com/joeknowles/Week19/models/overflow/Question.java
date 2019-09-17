package com.joeknowles.Week19.models.overflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="questions")
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6771474605513512906L;
	private Long id;
	private String question;
	private Date created;
	private Date updated;
	private List<Answer> answers;
	private List<Tag> tags;
	
	public Question() { answers = new ArrayList<>(); setTags(new ArrayList<>()); }
	public Question(String q) { answers = new ArrayList<>(); setTags(new ArrayList<>()); question = q; }

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id", unique=true, nullable=false, updatable=false)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name="question")
	public String getQuestion() { return question; }
	public void setQuestion(String question) { this.question = question; }
	
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	public List<Answer> getAnswers() { return answers; }
	public void setAnswers(List<Answer> answers) { this.answers = answers; }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "questions_tags", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    public List<Tag> getTags() {return tags; }
	public void setTags(List<Tag> tags) { this.tags = tags; }

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
	
	@Transient
	public String getTagsDisplay() { 
		StringBuilder sb = new StringBuilder();
		Iterator<Tag> itr = tags.iterator();
		while (itr.hasNext()) {
			Tag t = (Tag) itr.next();
			sb.append(t.getSubject());
			if (itr.hasNext()) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	
	public void addAnswer(Answer a) { a.setQuestion(this); answers.add(a); }
	
	public void addTag(Tag t) { tags.add(t); }
	
	
	
	
}
