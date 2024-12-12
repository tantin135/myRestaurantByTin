package com.myRestaurant.manager.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "tables")
public class TableEntities {
    @Id
    @Column(name = "table_id")
    private String tableId;

    @Column(name = "seats")
    private int seats;

    @Column(name = "table_status")
    private boolean tableStatus;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private AreaEntities areaEntities;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public AreaEntities getAreaEntities() {
        return areaEntities;
    }

    public void setAreaEntities(AreaEntities areaEntities) {
        this.areaEntities = areaEntities;
    }
}