package com.cg.ofda.dto;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="FoodCart_Table")
public class FoodCartDto {
	@Id
	@Column(name="Cart_Id",length = 5)
	@NotNull(message="cart id cannot be null")
	String cartId;
	
	@OneToOne
	@JoinColumn(name="Customer_Id")
	CustomerDto customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "foodCart_items", joinColumns = { @JoinColumn(name = "cartId") }, inverseJoinColumns = { @JoinColumn(name = "item_id") })
	List<ItemDto> items = new ArrayList<ItemDto>();
		
		public FoodCartDto(String cartId, CustomerDto customer, List<ItemDto> itemList) {
			super();
			this.cartId = cartId;
			this.customer = customer;
			this.items = itemList;
		}
		
		
		public FoodCartDto(String cartId, CustomerDto customer) {
			super();
			this.cartId = cartId;
			this.customer = customer;
		}


		public FoodCartDto() {
			super();
		}

		public String getCartId() {
			return cartId;
		}

		public void setCartId(String cartId) {
			this.cartId = cartId;
		}

		public CustomerDto getCustomer() {
			return customer;
		}

		public void setCustomer(CustomerDto customer) {
			this.customer = customer;
		}

		public List<ItemDto> getItemList() {
			return items;
		}

		public void setItemList(List<ItemDto> itemList) {
			this.items = itemList;
		}

		@Override
		public String toString() {
			return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", itemList=" + items + "]";
		}


		public Object thenReturn(FoodCartDto fc1) {
			// TODO Auto-generated method stub
			return null;
		}



}
