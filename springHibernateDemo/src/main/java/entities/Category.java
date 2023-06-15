package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Category")
public class Category {
	@Id
	@Column(name = "cateId")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cateId;
	@Column(name = "cateName")
	private String cateName;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(Integer cateId, String cateName) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
}
