package com.example.Projet_CRM.model;

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
        @JoinColumn(name="client_id")
        private Client client;
        @Column(name="nb_days")
        private Integer nbDays;
        @Column(name="unit_price")
        private Double unitPrice;
        @Column(name="total_exclude_taxe")
        @Transient
        // ignore persistence ET récupération de la valeur dans la BDD
        // calcul nécessaire et affectation à l'objet java
        private Double totalExcludeTaxe;
        @Column(name="total_with_taxe")
        @Transient
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalExcludeTaxe() {
        return (getUnitPrice()*getNbDays());
    }
    // Check dans l'API si le setter est utile???

    public Double getTotalWithTaxe() {
        return (getTotalExcludeTaxe()*1.2);
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
                ", client=" + client +
                ", nbDays=" + nbDays +
                ", UnitPrice=" + unitPrice +
                ", totalExcludeTaxe=" + totalExcludeTaxe +
                ", totalWithTaxe=" + totalWithTaxe +
                ", orderstate=" + orderstate +
                '}';
    }
}
