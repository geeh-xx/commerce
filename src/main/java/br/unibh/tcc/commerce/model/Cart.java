package br.unibh.tcc.commerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mysql.fabric.xmlrpc.base.Array;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany
	@JoinTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	@Column(nullable = false)
	private List<Product> products;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public void addProduct(Product product) {
		if (this.products == null) 
			products = new ArrayList<>();
			
		this.products.add(product);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
