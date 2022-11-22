package com.snackpicker.main.dto;

public class ProductUpdateDTO {

    public long id;
    public String name;
    public String barcode;

    @Override
    public String toString()
    {
        return "id: " + id + " name:" + name + "barcode: " + barcode;
    }

}
