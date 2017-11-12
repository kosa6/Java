package com.packages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Package {
	
	private int positionX,positionY,positionZ;
	
	private static final DateFormat SDF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private TypeOfPackage type;
	private String description;
	private int countOfMoves;
	private List<PreviousMove> previous;
	private Date addedDate;
	private static int lastID=0;
	private final int ID;
	private final int PRIORTY;
	
	public Package(TypeOfPackage type, int PRIORTY) {
		lastNumberIncrement();
		this.ID = lastID;
		this.type = type;
		this.addedDate = new Date();
		this.PRIORTY = PRIORTY;
		this.addPreviousMove();
		
	}
	public Package(TypeOfPackage type, int PRIORTY , String description) {
		lastNumberIncrement();
		this.ID = lastID;
		this.description = description;
		this.type = type;
		this.PRIORTY = PRIORTY;
		this.addedDate = new Date();
		this.addPreviousMove();
		
	}
	
	private static void lastNumberIncrement() {
		lastID++;
	}

	public String getDescription() {
		return description;
	}

	public TypeOfPackage getType() {
		return type;
	}

	public int getCountOfMoves() {
		return countOfMoves;
	}

	public Date getDate() {
		return addedDate;
	}
	
	public void ShowAddedDate() {
		System.out.println(SDF.format(addedDate));
	}

	public int getID() {
		return ID;
	}

	public int getPRIORTY() {
		return PRIORTY;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public int getPositionZ() {
		return positionZ;
	}
	
	public void setPositionZ(int positionZ) {
		this.positionZ = positionZ;
	}
	
	public void addPreviousMove() {
		this.previous.add(new PreviousMove(positionX,positionY,positionZ,ID));
	}
	
}
