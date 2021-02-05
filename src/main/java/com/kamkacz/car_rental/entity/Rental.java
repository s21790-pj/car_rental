package com.kamkacz.car_rental.entity;

import javax.persistence.*;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "car_id")
    private int carId;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    public Rental() {
    }

    public Rental(int id, int userId, int carId, String startDate, String endDate) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Rental(int userId, int carId, String startDate, String endDate) {
        this.userId = userId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", userId=" + userId +
                ", carId=" + carId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
