package com.cg.ofda.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Category_Table")
public class CategoryDto {
	
	
		@Id
		@Column(name="Cartegory_Id",length = 5)
		@NotNull(message="Category id cannot be null")
		String catId;
		@Column(name="Category_Name",length = 20)
		@NotBlank(message="category name cannot be blank")
		String categoryName;
		
		public CategoryDto() {
			super();
		}
		public CategoryDto(String catId, String categoryName) {
			super();
			this.catId = catId;
			this.categoryName = categoryName;
		}
		public String getCatId() {
			return catId;
		}
		public void setCatId(String catId) {
			this.catId = catId;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		@Override
		public String toString() {
			return "Category [catId=" + catId + ", categoryName=" + categoryName + "]";
		}


}
