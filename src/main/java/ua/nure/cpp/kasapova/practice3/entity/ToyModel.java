package ua.nure.cpp.kasapova.practice3.entity;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

public class ToyModel extends Fabric {

    protected int modelNumber;
    protected String filler;
    protected BigDecimal modelConsumption;
    protected BigDecimal tailoringPrice;


    public ToyModel() {
        super();
    }

    public ToyModel(String name, int fabricNumber, BigDecimal width,
                    BigDecimal pricePerMetre, int modelNumber, String filler,
                    BigDecimal modelConsumption, BigDecimal tailoringPrice) {
        super(name, fabricNumber, width, pricePerMetre);
        this.modelNumber = modelNumber;
        this.filler = filler;
        this.modelConsumption = modelConsumption;
        this.tailoringPrice = tailoringPrice;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
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
        ToyModel toyModel = (ToyModel) o;
        if (this.filler == null) return toyModel.filler == null;
        if (this.modelConsumption == null) return toyModel.modelConsumption == null;
        if (this.tailoringPrice == null) return toyModel.tailoringPrice == null;
        return modelNumber == toyModel.modelNumber && Objects.equals(filler, toyModel.filler) &&
                Objects.equals(modelConsumption, toyModel.modelConsumption) && Objects.equals(tailoringPrice, toyModel.tailoringPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelNumber, filler, modelConsumption, tailoringPrice);
    }

    @Override
    public String toString() {
        return "\nToyModel{" +
                "modelNumber=" + modelNumber + '\'' +
                ", fabricName='" + fabricName +
                ", fabricNumber=" + fabricNumber +
                ", fabricWidth=" + fabricWidth +
                ", fabricPricePerMetre=" + fabricPricePerMetre +
                ", filler='" + filler + '\'' +
                ", modelConsumption=" + modelConsumption +
                ", tailoringPrice=" + tailoringPrice +
                '}';
    }

    @Override
    public int compareTo(@NotNull Fabric o) {
        int anotherModelNumber = ((ToyModel) o).getModelNumber();
        if (anotherModelNumber == modelNumber) {
            return 0;
        }
        return (modelNumber > anotherModelNumber) ? 1 : -1;
    }
}
