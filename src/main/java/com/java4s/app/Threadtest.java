package com.java4s.app;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadtest {
	static int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
	public static void main(String[] args) throws InterruptedException {
		
//		ExecutorService executor = Executors.newFixedThreadPool(5000);
//		
//		CountDownLatch latch = new CountDownLatch(5000);
//		
//		for(int i=0;i<5000;i++) {
//		executor.submit(new LatchExamp(latch,i));
//		latch.countDown();
		
		
		
		
		union(4,3);
		union(6, 5);
		union(3, 5);
		for(int i=0;i<intArray.length;i++) {
			System.out.println(intArray[i]);
		}
		
		
		

	}
	
	public static void union(int x, int y) {
		
		int temp =x;
		
		for(int i=0;i<intArray.length;i++) {
			if(intArray[i]==x) {
				intArray[i]=y;
			}
		}
		
	}
		
	
	
	
	
}


