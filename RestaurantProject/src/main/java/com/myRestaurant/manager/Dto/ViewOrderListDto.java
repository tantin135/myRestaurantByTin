package com.myRestaurant.manager.Dto;

public class ViewOrderListDto {

    private String tableId;
    private long minutesElapsed;

    public ViewOrderListDto(String tableId, long minutesElapsed) {
        this.tableId = tableId;
        this.minutesElapsed = minutesElapsed;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public long getMinutesElapsed() {
        return minutesElapsed;
    }

    public void setMinutesElapsed(long minutesElapsed) {
        this.minutesElapsed = minutesElapsed;
    }
}
