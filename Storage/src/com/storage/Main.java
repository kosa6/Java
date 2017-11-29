package com.storage;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import com.packages.*;
import com.packages.Package;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Storage cube = new Storage(10,10,10);
		Instant start = Instant.now();
		for(int i=0; i<1000; i++) {
			Random generator = new Random();
			int random2 = generator.nextInt(2);
			random2 += 1;
			System.out.println(random2);
			cube.addPackageNew(TypeOfPackage.toys , random2, "kupa");
		}
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end));
		//Package tempPackage = cube.getPackageByNumber(378);
		System.out.println("Done");
		//System.out.println(tempPackage.getID());
		//System.out.println(tempPackage.getDate());
		//tempPackage.ShowDateOfAllMoves();
	}

}
