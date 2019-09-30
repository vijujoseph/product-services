package com.product.aggregator.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Product implements Serializable {

    @Id
    private String uuid;

    private String name;
    private String description;
    private String provider;
    private String available;
    private String measurementUnit;
    private Date createdDate;
    private Date updatedDate;
    private String createdUser;

    public Product() {
    }

    public Product(String uuid, String name, String description, String provider, String available, String measurementUnit, String createdUser) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.provider = provider;
        this.available = available;
        this.measurementUnit = measurementUnit;
        this.createdUser = createdUser;
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

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @PrePersist
    public void setCreatedDate() {
        this.createdDate = new Date();
    }

    public Date getUpdatedDate() {
        return updatedDate = new Date();
    }

    @PreUpdate
    public void setUpdatedDate() {
        this.updatedDate = new Date();
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
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
        if (measurementUnit != null ? !measurementUnit.equals(product.measurementUnit) : product.measurementUnit != null)
            return false;
        if (createdDate != null ? !createdDate.equals(product.createdDate) : product.createdDate != null) return false;
        if (updatedDate != null ? !updatedDate.equals(product.updatedDate) : product.updatedDate != null) return false;
        return createdUser != null ? createdUser.equals(product.createdUser) : product.createdUser == null;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (available != null ? available.hashCode() : 0);
        result = 31 * result + (measurementUnit != null ? measurementUnit.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", provider='" + provider + '\'' +
                ", available='" + available + '\'' +
                ", measurementUnit='" + measurementUnit + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", createdUser='" + createdUser + '\'' +
                '}';
    }
}
