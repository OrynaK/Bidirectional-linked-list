package ua.nure.cpp.kasapova.practice3.entity;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Fabric implements Serializable, Comparable<Fabric>{

    protected String fabricName;
    protected int fabricNumber;
    protected BigDecimal fabricWidth;
    protected BigDecimal fabricPricePerMetre;


    public Fabric() {
        super();
    }

    public Fabric(String name, int fabricNumber, BigDecimal width, BigDecimal pricePerMetre) {
        this.fabricName = name;
        this.fabricNumber = fabricNumber;
        this.fabricWidth = width;
        this.fabricPricePerMetre = pricePerMetre;
    }

    public String getFabricName() {
        return fabricName;
    }

    public void setFabricName(String fabricName) {
        this.fabricName = fabricName;
    }

    public int getFabricNumber() {
        return fabricNumber;
    }

    public void setFabricNumber(int fabricNumber) {
        this.fabricNumber = fabricNumber;
    }

    public BigDecimal getFabricWidth() {
        return fabricWidth;
    }

    public void setFabricWidth(BigDecimal fabricWidth) {
        this.fabricWidth = fabricWidth;
    }

    public BigDecimal getFabricPricePerMetre() {
        return fabricPricePerMetre;
    }

    public void setFabricPricePerMetre(BigDecimal fabricPricePerMetre) {
        this.fabricPricePerMetre = fabricPricePerMetre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fabric fabric = (Fabric) o;
        if (this.fabricName == null) return fabric.fabricName == null;
        if (this.fabricWidth == null) return fabric.fabricWidth == null;
        if (this.fabricPricePerMetre == null) return fabric.fabricPricePerMetre == null;
        return fabricNumber == fabric.fabricNumber &&
                Objects.equals(fabricName, fabric.fabricName)
                && Objects.equals(fabricWidth, fabric.fabricWidth)
                && Objects.equals(fabricPricePerMetre, fabric.fabricPricePerMetre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fabricName, fabricNumber, fabricWidth, fabricPricePerMetre);
    }

    @Override
    public String toString() {
        return "Fabric{" +
                "fabricNumber=" + fabricNumber + '\'' +
                ", name='" + fabricName +
                ", width=" + fabricWidth +
                ", pricePerMetre=" + fabricPricePerMetre +
                "}";
    }


    @Override
    public int compareTo(@NotNull Fabric o) {
        int anotherFabricNumber = o.getFabricNumber();
        if (anotherFabricNumber == fabricNumber) return 0;
        return (fabricNumber > anotherFabricNumber) ? 1 : -1;
    }
}
