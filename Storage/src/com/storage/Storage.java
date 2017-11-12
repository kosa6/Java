package com.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.packages.*;
import com.packages.Package;

public class Storage {
	private Stack<Package[][]> storage;
	private final int SIZE_X, SIZE_Y, SIZE_Z;
	private List<PreviousMove> storagePreviousMoves;
	
	Storage(int sizeX,int sizeY,int sizeZ) {
		this.SIZE_X = sizeX;
		this.SIZE_Y = sizeY;
		this.SIZE_Z = sizeZ;
		this.storage = new Stack<Package[][]>();
	}
	private Package addPackage(TypeOfPackage type, int PRIORTY , String description) {
		if(PRIORTY<=5 && PRIORTY>=1) {
			if(description==null) {
				return new Package(type,PRIORTY);
			}
			else {
				return new Package(type,PRIORTY,description);
			}
		}
		else {
			System.out.println("Package wasn't added, becouse priorty must be a number between 1 to 5");
			return null;
		}
	}
	private Package getPackageByNumber(int number) {
		for(int i=0; i<storage.size(); i++) {
			for(int j=0; j<this.SIZE_X; j++) {
				for(int k=0; k<this.SIZE_Y; k++) {
					if(storage.elementAt(i)[j][k].getID() == number) {
						return storage.elementAt(i)[j][k];
					}
				}
			}
		}
		return null;
	}
	private List<Package> getAllPackageByType(TypeOfPackage type) {
		List<Package> tempList = new ArrayList<Package>();
		for(int i=0; i<storage.size(); i++) {
			for(int j=0; j<this.SIZE_X; j++) {
				for(int k=0; k<this.SIZE_Y; k++) {
					if(storage.elementAt(i)[j][k].getType() == type) {
						tempList.add(storage.elementAt(i)[j][k]);
					}
				}
			}
		}
		return tempList;
	}
	private void getHistoryOfPreviousMoves() {
		for(int i=0; i<this.storagePreviousMoves.size(); i++) {
			System.out.println("Move number: "+(i+1));
			System.out.println("Package with id: "+this.storagePreviousMoves.get(i).getId()+" was moved to:");
			System.out.println("Position x: "+ this.storagePreviousMoves.get(i).getPositionX());
			System.out.println("Position y: "+ this.storagePreviousMoves.get(i).getPositionY());
			System.out.println("Position z: "+ this.storagePreviousMoves.get(i).getPositionZ());
			System.out.println("Date of this move: "+ this.storagePreviousMoves.get(i).getDate());
		}
	}
}
