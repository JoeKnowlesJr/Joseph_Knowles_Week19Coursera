package com.joeknowles.Week19.models.prodcat;

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

@Entity
@Table(name="prodcat")
public class CategoryProduct implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7627016290278298163L;

    private Long id;
    private Product product;
    private Category category;
    private Date created;
    private Date updated;
    
    public CategoryProduct() {}
    
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false, updatable=false)
    public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
	public Product getProduct() { return product; }
	public void setProduct(Product product) { this.product = product; }
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
	public Category getCategory() { return category; }
	public void setCategory(Category category) { this.category = category; }
	
	@Column(name="created")
	public Date getCreated() { return created; }
	public void setCreated(Date created) { this.created = created; }
	
	@Column(name="updated")
	public Date getUpdated() { return updated; }
	public void setUpdated(Date updated) { this.updated = updated; }
	
	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }
}