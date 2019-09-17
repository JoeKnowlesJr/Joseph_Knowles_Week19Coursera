package com.joeknowles.Week19.models.prodcat;

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

@Entity
@Table(name="categories")
public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3101293029172005997L;
	private Long id;
	private String name;
	private Date created;
	private Date updated;
	private List<Product> products;
	
	public Category() { products = new ArrayList<>(); }
	public Category(String n) { name = n; products = new ArrayList<>(); }
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id", unique=true, nullable=false, updatable=false)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name="name")
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Column(name="created")
	public Date getCreated() { return created; }
	public void setCreated(Date created) { this.created = created; }
	
	@Column(name="updated")
	public Date getUpdated() { return updated; }
	public void setUpdated(Date updated) { this.updated = updated; }
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))     
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> p) { products = p; }
    public void addProduct(Product p) { products.add(p); }
	
	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }
}
