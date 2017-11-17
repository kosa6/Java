package com.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.packages.*;
import com.packages.Package;

public class Storage {
	public FixedSizeStack<Package>[][] storage;
	private final int SIZE_X, SIZE_Y, SIZE_Z;
	private List<PreviousMove> storagePreviousMoves;
	private HashMap<Integer,Package> hashMapOfPackages;
	private HashMap<TypeOfPackage, Package> enumHash;
	
	public int temp = 0;
	
	@SuppressWarnings("unchecked")
	Storage(int sizeX,int sizeY,int sizeZ) {
		this.SIZE_X = sizeX;
		this.SIZE_Y = sizeY;
		this.SIZE_Z = sizeZ;
		this.storage = (FixedSizeStack<Package>[][]) new FixedSizeStack[this.SIZE_X][this.SIZE_Y];
		for(int i=0; i<SIZE_X; i++)
		{
			for(int j=0; j<SIZE_Y; j++) 
			{
				this.storage[i][j] = new FixedSizeStack<Package>(SIZE_Z);
			}
		}
		this.enumHash = new HashMap<TypeOfPackage, Package>();
		this.hashMapOfPackages = new HashMap<Integer,Package>();
		this.storagePreviousMoves = new ArrayList<PreviousMove>();
	}
	public void addPackage(TypeOfPackage type, int priority , String description) 
	{
		if(priority >= 5 && priority <= 1)
		{
			System.out.println("Priorty must be a number between 1 to 5");
			return;
		}
		if(moveToFreePosition(type,priority,description))
		{
			System.out.println("Package was added");
		}
		else
		{
			System.out.println("Package wasn't added");
			temp++;
		}
	}
	private Package createPackage(TypeOfPackage type, int priority,String description, int positionX,int positionY,int positionZ) {
		Package tempPackage = new Package(type,priority,description,positionX,positionY,positionZ);
		storagePreviousMoves.add(tempPackage.getPreviousMove());
		addToHashMaps(tempPackage);
		return tempPackage;
	}
	private boolean moveToFreePosition(TypeOfPackage type, int priority , String description) 
	{
		for(int indexX=0; indexX<SIZE_X; indexX++)
		{
			for(int indexY=0; indexY<SIZE_Y; indexY++) 
			{
				if(checkIfStackIsNotFull(indexX, indexY))
				{
					if(this.storage[indexX][indexY].size() == 0)
					{
						this.storage[indexX][indexY].push(createPackage(type,priority,description,indexX,indexY,
								(this.storage[indexX][indexY].getMAX_SIZE() - this.storage[indexX][indexY].size())-1));
						return true;
					}
					else 
					{
						if(this.storage[indexX][indexY].peek().getPRIORTY() <= priority) 
						{
							this.storage[indexX][indexY].push(createPackage(type,priority,description,indexX,indexY,
									(this.storage[indexX][indexY].getMAX_SIZE() - this.storage[indexX][indexY].size())-1));
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean checkIfStackIsNotFull(int indexX, int indexY)
	{
		if(this.storage[indexX][indexY].getMAX_SIZE() != this.storage[indexX][indexY].size())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	private void addToHashMaps(Package tempPackage) {
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
			System.out.println(this.storagePreviousMoves.get(i).toString());
		}
	}
}

