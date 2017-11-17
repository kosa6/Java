package com.storage;

import java.util.Random;

import com.packages.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Storage cube = new Storage(10,10,10);
		for(int i=0; i<1000; i++) {
			Random generator = new Random();
			int random2 = generator.nextInt(2);
			random2 += 1;
			System.out.println(random2);
			cube.addPackage(TypeOfPackage.toys , random2, "kupa");
		}
		System.out.println(cube.temp);
		int temp1=0;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(cube.storage[i][j].size()==10) {
					temp1++;
				}
			}
		}
		System.out.println(temp1);
	}

}
