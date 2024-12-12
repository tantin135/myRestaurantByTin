	package com.myRestaurant.manager.Dto;
	
	import java.sql.Timestamp;
	
	public class ViewOrderListDto {

	    private String tableId; // Table ID
	    private long minutesElapsed; // Time elapsed since the order was placed (in minutes)

	    // Constructor
	    public ViewOrderListDto(String tableId, long minutesElapsed) {
	        this.tableId = tableId;
	        this.minutesElapsed = minutesElapsed;
	    }

	    // Getters and Setters
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
