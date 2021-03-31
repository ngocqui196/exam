package com.exam.exam.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 2,max = 20,message = "độ dài từ 2 đến 20 ký tự")
    @NotNull(message = "không được để trống")
    private String name;
    @ManyToOne
    private Country country;
    @NotNull(message = "không được để trống")
    private double area;
    @NotNull(message = "không được để trống")
    private Long population;
    @NotNull(message = "không được để trống")
    private Long GDP;
    @NotNull(message = "không được để trống")
    @Size(min = 200,max = 3000,message = "độ dài từ 50 đến 300 ký tự")
    private String cityDetail;


    public City() {
    }

    public City(Long id, String name, Country country, double area, Long population, Long GDP, String cityDetail) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.cityDetail = cityDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getCityDetail() {
        return cityDetail;
    }

    public void setCityDetail(String cityDetail) {
        this.cityDetail = cityDetail;
    }
}
