package com.joeknowles.Week19.models.prodcat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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
import javax.persistence.Transient;

@Entity
@Table(name="products")
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4565872235098417138L;
	
	private Long id;
	private String name;
	private String description;
	private double price;
    private List<Category> categories;
	private Date created;
	private Date updated;
	
	public Product() { categories = new ArrayList<>(); }
	public Product(String n, String d, double p) {
		name = n;
		description = d;
		price = p;
		categories = new ArrayList<>();
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id", unique=true, nullable=false, updatable=false)
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@Column(name="name")
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Column(name="description")
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	@Column(name="price")
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> c) { categories = c; }
	public void addCategory(Category category) { this.categories.add(category); }

	@Column(name="created", updatable=false)
	public Date getCreated() { return created; }
	public void setCreated(Date created) { this.created = created; }
	
	@Column(name="updated")
	public Date getUpdated() { return updated; }
	public void setUpdated(Date updated) { this.updated = updated; }
	
	@PrePersist
	protected void onCreate() { this.created = new Date(); }
	
	@PreUpdate
	protected void onUpdate() { this.updated = new Date(); }
	
	@Transient
	public String getDisplayName() { return String.format("%20s - %-10f", name, price); }
}
