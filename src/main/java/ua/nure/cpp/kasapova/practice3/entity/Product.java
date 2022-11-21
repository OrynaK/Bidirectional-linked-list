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
        this.productSize=Size.valueOf(size);
        numberOfProducts++;
    }

    public void setProductSize(String productSize) {
        this.productSize=Size.valueOf(productSize);
    }

    public Size getProductSize() {
        return productSize;
    }

    public String getStringProductSize() {
        return productSize.getValue();
    }

    public int isGreaterThan(Object other) {
        int num1= this.productSize.ordinal();
        int num2=((Product)other).productSize.ordinal();
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
