package com.storage;

import java.util.Random;

import com.packages.*;
import com.packages.Package;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Storage cube = new Storage(10,10,10);
		for(int i=0; i<990; i++) {
			Random generator = new Random();
			int random2 = generator.nextInt(2);
			random2 += 1;
			System.out.println(random2);
			cube.addPackage(TypeOfPackage.toys , random2, "kupa");
		}
		Package tempPackage = cube.getPackageByNumber(378);
		//System.out.println(tempPackage.getID());
		//System.out.println(tempPackage.getDate());
		tempPackage.ShowDateOfAllMoves();
		for(int i=0; i<cube.outsideStorage.size(); i++) {
			System.out.println(cube.outsideStorage.get(i).getID());
		}
	}

}
