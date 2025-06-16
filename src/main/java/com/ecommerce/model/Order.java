package com.ecommerce.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders") // "order" is reserved in SQL, so use "orders"
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_email")
    private String customerEmail;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference  // ✅ prevents infinite loop
    private List<OrderItem> items;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;

        // ✅ Maintain back-reference
        if (items != null) {
            for (OrderItem item : items) {
                item.setOrder(this);
            }
        }
    }
}
