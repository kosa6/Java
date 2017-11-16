package com.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.packages.*;
import com.packages.Package;

public class Storage {
	public FixedSizeStack<Package>[][] storage;
	private FixedSizeStack<Package> temp;
	private final int SIZE_X, SIZE_Y, SIZE_Z;
	private List<PreviousMove> storagePreviousMoves;
	private HashMap<Integer,Package> hashMapOfPackages;
	private HashMap<TypeOfPackage, Package> enumHash;
	
	@SuppressWarnings("unchecked")
	Storage(int sizeX,int sizeY,int sizeZ) {
		this.SIZE_X = sizeX;
		this.SIZE_Y = sizeY;
		this.SIZE_Z = sizeZ;
		this.temp = new FixedSizeStack<Package>(SIZE_Z);
		this.storage = (FixedSizeStack<Package>[][]) new FixedSizeStack[this.SIZE_X][this.SIZE_Y];
		this.enumHash = new HashMap<TypeOfPackage, Package>();
		this.hashMapOfPackages = new HashMap<Integer,Package>();
		this.storagePreviousMoves = new ArrayList<PreviousMove>();
	}
	public Package addPackage(TypeOfPackage type, int PRIORTY , String description) {
		while(PRIORTY>5 && PRIORTY<1) {
			System.out.println("Priorty must be a number between 1 to 5,"
					+ " please write correct number: ");
			Scanner reader = new Scanner(System.in);
			int n = reader.nextInt();
			PRIORTY = n;
			reader.close(); 
		}
		Package tempPackage = new Package(type,PRIORTY,description);
		addToHashMap(tempPackage);
		return tempPackage;
	}
	public boolean moveToFreePosition(Package packageToMove) {
		for(int indexX=0; indexX<=SIZE_X; indexX++) {
			for(int indexY=0; indexY<=SIZE_Y; indexY++) {
				if(this.storage[indexX][indexY].peek()==null) {
					this.storage[indexX][indexY].push(packageToMove);
					return true;
				}
				else {
					if(this.storage[indexX][indexY].peek().getPRIORTY() > packageToMove.getPRIORTY()) {
						indexY++;
						this.storage[indexX][indexY].getMAX_SIZE();
					}
					else {
						this.storage[indexX][indexY].push(packageToMove);
					}
				}
			}
		}
		return false;
	}
	private void addToHashMap(Package tempPackage) {
		this.enumHash.put(tempPackage.getType(), tempPackage);
		this.hashMapOfPackages.put(tempPackage.getID(), tempPackage);
	}
	public Package getPackageByNumber(int number) {
		return this.hashMapOfPackages.get(number);
	}
	public List<Package> getAllPackageByType(TypeOfPackage type) {
		List<Package> tempList = new ArrayList<Package>();
		tempList.add(this.enumHash.get(type));
		return tempList;
	}
	public void getHistoryOfPreviousMoves() {
		for(int i=0; i<this.storagePreviousMoves.size(); i++) {
			System.out.println("Move number: "+(i+1));
			this.storagePreviousMoves.get(i).toString();
		}
	}
}

