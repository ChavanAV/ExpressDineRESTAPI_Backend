package com.akshay.Express_Dine.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long oid;

    @ManyToOne
    private User user;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
//
//    @Column(name = "delivery_time", n-ullable = false)
//    private String deliveryTime;

    @Column(name = "train_name", nullable = false)
    private String trainName;

    @Column(name = "compartment", nullable = false)
    private String compartment;

    @Column(name = "seat_no", nullable = false)
    private String seatNo;

    @Column(name = "contact_no", nullable = false)
    private long contactNo;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    private Menu menu;	
    

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getCompartment() {
		return compartment;
	}

	public void setCompartment(String compartment) {
		this.compartment = compartment;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}