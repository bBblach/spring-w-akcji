package org.rart.springwakcji.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {
    private final  Long id;
    private final String message;
    private final LocalDateTime time;
    private Double latitude;
    private Double longitude;


    public Spittle(String message, LocalDateTime time) {
        this(message, time, null, null);
    }

    public Spittle(String message, LocalDateTime time, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("MMM d yyyy");
        return time;
    }


    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id" , "time");

    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
