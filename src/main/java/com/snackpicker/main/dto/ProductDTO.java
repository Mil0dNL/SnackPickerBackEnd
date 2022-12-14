package com.snackpicker.main.dto;

import com.snackpicker.main.model.Product;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public class ProductDTO {

    public long id;
    public String name;
    public String barcode;
    public String imageData;

    public ProductDTO(Product product)
    {
        this.id = product.getId();
        this.name = product.getName();
        this.barcode = product.getBarcode();

    }


}
