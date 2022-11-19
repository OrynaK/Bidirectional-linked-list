package ua.nure.cpp.kasapova.practice3.entity;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

public class Product extends ClothingModel {
    protected Size productSize;
    private static int numberOfProducts;

    static {
        numberOfProducts = 0;
    }

    private enum Size {
        XXS("XXS"),
        XS("XS"),
        S("S"),
        M("M"),
        L("L"),
        XL("XL"),
        XXL("XXL"),
        XXXL("XXXL"),
        FREESIZE("Free size");

        private String value;

        Size(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }


    }

    public Product() {
        super();
    }

    public Product(String name, int fabricNumber, BigDecimal width,
                   BigDecimal pricePerMetre, int modelNumber, BigDecimal consumption,
                   BigDecimal tailoringPrice, String size) {
        super(name, fabricNumber, width, pricePerMetre, modelNumber, consumption, tailoringPrice);
        switch (size) {
            case ("XXS") -> this.productSize = Size.XXS;
            case ("XS") -> this.productSize = Size.XS;
            case ("S") -> this.productSize = Size.S;
            case ("M") -> this.productSize = Size.M;
            case ("L") -> this.productSize = Size.L;
            case ("XL") -> this.productSize = Size.XL;
            case ("XXL") -> this.productSize = Size.XXL;
            case ("XXXL") -> this.productSize = Size.XXXL;
            default -> this.productSize = Size.FREESIZE;
        }
        numberOfProducts++;
    }

    public void setProductSize(String productSize) {
        switch (productSize) {
            case ("XXS") -> this.productSize = Size.XXS;
            case ("XS") -> this.productSize = Size.XS;
            case ("S") -> this.productSize = Size.S;
            case ("M") -> this.productSize = Size.M;
            case ("L") -> this.productSize = Size.L;
            case ("XL") -> this.productSize = Size.XL;
            case ("XXL") -> this.productSize = Size.XXL;
            case ("XXXL") -> this.productSize = Size.XXXL;
            default -> this.productSize = Size.FREESIZE;
        }
    }

    public Size getProductSize() {
        return productSize;
    }

    public String getStringProductSize() {
        return productSize.getValue();
    }

    public int isGreaterThan(Object other) {
        int num1;
        switch (this.getStringProductSize()) {
            case ("XXS") -> num1 = 1;
            case ("XS") -> num1 = 2;
            case ("S") -> num1 = 3;
            case ("M") -> num1 = 4;
            case ("L") -> num1 = 5;
            case ("XL") -> num1 = 6;
            case ("XXL") -> num1 = 7;
            case ("XXXL") -> num1 = 8;
            default -> num1 = 0;
        }
        int num2;
        switch (((Product) other).getStringProductSize()) {
            case ("XXS") -> num2 = 1;
            case ("XS") -> num2 = 2;
            case ("S") -> num2 = 3;
            case ("M") -> num2 = 4;
            case ("L") -> num2 = 5;
            case ("XL") -> num2 = 6;
            case ("XXL") -> num2 = 7;
            case ("XXXL") -> num2 = 8;
            default -> num2 = 0;
        }
        if (num1 == num2) return 0;
        return num1 > num2 ? 1 : -1;
    }

    public static int getNumberOfProducts() {
        return numberOfProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        if (this.productSize == null) return product.productSize == null;
        return productSize == product.productSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productSize);
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "modelNumber=" + modelNumber +
                ", modelConsumption=" + modelConsumption +
                ", tailoringPrice=" + tailoringPrice +
                ", fabricName='" + fabricName + '\'' +
                ", fabricNumber=" + fabricNumber +
                ", fabricWidth=" + fabricWidth +
                ", fabricPricePerMetre=" + fabricPricePerMetre +
                ", size=" + productSize +
                '}';
    }

    @Override
    public int compareTo(@NotNull Fabric o) {
        Product product=((Product)o);
        if (this.getProductSize() == product.getProductSize()) return 0;
        return this.isGreaterThan(product);
    }
}
