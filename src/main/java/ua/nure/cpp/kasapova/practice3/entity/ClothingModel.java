package ua.nure.cpp.kasapova.practice3.entity;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

public class ClothingModel extends Fabric {
    protected int modelNumber;
    protected BigDecimal modelConsumption;
    protected BigDecimal tailoringPrice;


    public ClothingModel() {
        super();
    }

    public ClothingModel(String name, int fabricNumber, BigDecimal width,
                         BigDecimal pricePerMetre, int modelNumber, BigDecimal consumption,
                         BigDecimal tailoringPrice) {
        super(name, fabricNumber, width, pricePerMetre);
        this.modelNumber = modelNumber;
        this.modelConsumption = consumption;
        this.tailoringPrice = tailoringPrice;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public BigDecimal getModelConsumption() {
        return modelConsumption;
    }

    public void setModelConsumption(BigDecimal modelConsumption) {
        this.modelConsumption = modelConsumption;
    }

    public BigDecimal getTailoringPrice() {
        return tailoringPrice;
    }

    public void setTailoringPrice(BigDecimal tailoringPrice) {
        this.tailoringPrice = tailoringPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClothingModel that = (ClothingModel) o;
        if (this.modelConsumption == null) return that.modelConsumption == null;
        if (this.tailoringPrice == null) return that.tailoringPrice == null;
        return modelNumber == that.modelNumber && Objects.equals(modelConsumption, that.modelConsumption) && Objects.equals(tailoringPrice, that.tailoringPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelNumber, modelConsumption, tailoringPrice);
    }

    @Override
    public String toString() {
        return "\nClothingModel{" +
                "modelNumber=" + modelNumber +
                ", consumption=" + modelConsumption +
                ", tailoringPrice=" + tailoringPrice +
                ", name='" + fabricName + '\'' +
                ", fabricNumber=" + fabricNumber +
                ", width=" + fabricWidth +
                ", pricePerMetre=" + fabricPricePerMetre +
                '}';
    }

    @Override
    public int compareTo(@NotNull Fabric o) {
        int anotherModelNumber = ((ClothingModel) o).getModelNumber();
        if (anotherModelNumber == modelNumber) return 0;
        return (modelNumber > anotherModelNumber) ? 1 : -1;
    }
}

