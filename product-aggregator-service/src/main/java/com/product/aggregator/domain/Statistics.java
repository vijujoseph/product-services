package com.product.aggregator.domain;

public class Statistics {

    private int totalCreated;
    private int totalUpdated;
    private String message;

    public int getTotalCreated() {
        return totalCreated;
    }

    public void setTotalCreated(int totalCreated) {
        this.totalCreated = totalCreated;
    }

    public int getTotalUpdated() {
        return totalUpdated;
    }

    public void setTotalUpdated(int totalUpdated) {
        this.totalUpdated = totalUpdated;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statistics that = (Statistics) o;

        if (totalCreated != that.totalCreated) return false;
        if (totalUpdated != that.totalUpdated) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = totalCreated;
        result = 31 * result + totalUpdated;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "totalCreated=" + totalCreated +
                ", totalUpdated=" + totalUpdated +
                ", message='" + message + '\'' +
                '}';
    }
}
