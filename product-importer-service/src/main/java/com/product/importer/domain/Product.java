package com.product.importer.domain;

import java.io.Serializable;

public class Product implements Serializable {

    private String uuid;
    private String name;
    private String description;
    private String provider;
    private String available;
    private String MeasurementUnits;
    private String createdDate;
    private String createdUser;

    public Product() {
    }

    public Product(String uuid, String name, String description, String provider, String available, String measurementUnits, String createdDate, String createdUser) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.provider = provider;
        this.available = available;
        MeasurementUnits = measurementUnits;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (uuid != null ? !uuid.equals(product.uuid) : product.uuid != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (provider != null ? !provider.equals(product.provider) : product.provider != null) return false;
        if (available != null ? !available.equals(product.available) : product.available != null) return false;
        if (MeasurementUnits != null ? !MeasurementUnits.equals(product.MeasurementUnits) : product.MeasurementUnits != null)
            return false;
        if (createdDate != null ? !createdDate.equals(product.createdDate) : product.createdDate != null) return false;
        return createdUser != null ? createdUser.equals(product.createdUser) : product.createdUser == null;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        result = 31 * result + (MeasurementUnits != null ? MeasurementUnits.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        return result;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getMeasurementUnits() {
        return MeasurementUnits;
    }

    public void setMeasurementUnits(String measurementUnits) {
        MeasurementUnits = measurementUnits;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", provider='" + provider + '\'' +
                ", available='" + available + '\'' +
                ", MeasurementUnits='" + MeasurementUnits + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", createdUser='" + createdUser + '\'' +
                '}';
    }
}
