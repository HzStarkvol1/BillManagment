package org.hzstark.billmanagment.databases.bills;

import jakarta.persistence.*;

@Entity
@Table(name = "bills")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Elements
    private String cost;
    private String date;
    private String category;

    //Jpa configuration
    public BillEntity(){}

    public BillEntity(String cost, String date, String category)
    {
        this.cost = cost;
        this.date = date;
        this.category = category;
    }

    //Getter&Setter
    public Long getId() {
        return id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    public String getDate(){
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
