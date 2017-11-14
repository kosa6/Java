package com.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.packages.*;
import com.packages.Package;

public class Storage {
	private Stack<Package>[][] storage;
	private final int SIZE_X, SIZE_Y, SIZE_Z;
	private List<PreviousMove> storagePreviousMoves;
	private HashMap<Integer,Package> hashMapOfPackages;
	private HashMap<TypeOfPackage, Package> enumHash;
	
	Storage(int sizeX,int sizeY,int sizeZ) {
		this.SIZE_X = sizeX;
		this.SIZE_Y = sizeY;
		this.SIZE_Z = sizeZ;
		this.storage = (Stack<Package>[][]) new Stack[this.SIZE_X][this.SIZE_Y];
		this.enumHash = new HashMap<TypeOfPackage, Package>();
		this.hashMapOfPackages = new HashMap<Integer,Package>();
		this.storagePreviousMoves = new ArrayList<PreviousMove>();
	}
	private Package addPackage(TypeOfPackage type, int PRIORTY , String description) {
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
	private void addToHashMap(Package tempPackage) {
		this.enumHash.put(tempPackage.getType(), tempPackage);
		this.hashMapOfPackages.put(tempPackage.getID(), tempPackage);
	}
	private Package getPackageByNumber(int number) {
		return this.hashMapOfPackages.get(number);
	}
	private List<Package> getAllPackageByType(TypeOfPackage type) {
		List<Package> tempList = new ArrayList<Package>();
		tempList.add(this.enumHash.get(type));
		return tempList;
	}
	private void getHistoryOfPreviousMoves() {
		for(int i=0; i<this.storagePreviousMoves.size(); i++) {
			System.out.println("Move number: "+(i+1));
			this.storagePreviousMoves.get(i).toString();
		}
	}
}
