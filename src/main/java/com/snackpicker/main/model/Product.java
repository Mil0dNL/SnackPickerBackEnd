package com.snackpicker.main.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String sku;

    private String barcode;

    public String getName() {return name;}

    public void setName(String name) {  this.name = name;}

    public String getSku() {return sku;}

    public void setSku(String sku) {this.sku = sku;}

    public String getBarcode() { return barcode;}

    public void setBarcode(String barcode) {this.barcode = barcode;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Product() {}

}
