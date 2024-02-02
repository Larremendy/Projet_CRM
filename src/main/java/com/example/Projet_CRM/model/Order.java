package com.example.Projet_CRM.metier;

import com.example.Projet_CRM.service.OrderState;
import jakarta.persistence.*;
@Entity
@Table(name="orders")
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String typePresta;
        private String designation;
        @ManyToOne
        @Column(name="client_id")
        private Integer clientId;
        @Column(name="nb_days")
        private Integer nbDays;
        private Double Price;
        @Column(name="total_exclude_taxe")
        private Double totalExcludeTaxe;
        @Column(name="total_with_taxe")
        private Double totalWithTaxe;
        @Column(name="state")
        private OrderState orderstate; //(0,1,2) (CANCELED, OPTION, CONFIRMED)


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Double totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Double getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Double totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public OrderState getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(OrderState orderstate) {
        this.orderstate = orderstate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", clientId=" + clientId +
                ", nbDays=" + nbDays +
                ", Price=" + Price +
                ", totalExcludeTaxe=" + totalExcludeTaxe +
                ", totalWithTaxe=" + totalWithTaxe +
                ", orderstate=" + orderstate +
                '}';
    }
}
