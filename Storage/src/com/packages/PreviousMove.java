package com.packages;

import java.util.Date;

public final class PreviousMove {
	private int positionX, positionY, positionZ;
	private Date date;
	private final int id;
	
	PreviousMove(int positionX,int positionY,int positionZ, int id) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
		this.id = id;
		date = new Date();
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
	
	public int getPositionZ() {
		return positionZ;
	}

	public Date getDate() {
		return date;
	}
	public int getId() {
		return id;
	}
	public String toString() {
		String tempString = new String("Date: " + date + "/br" +"Position: "+positionX+" "+positionY+" "
	+positionZ);
		return tempString;
	}
	
}
