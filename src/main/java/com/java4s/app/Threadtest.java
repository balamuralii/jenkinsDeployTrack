package com.java4s.app;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadtest {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(5000);
		
		CountDownLatch latch = new CountDownLatch(5000);
		
		for(int i=0;i<5000;i++) {
		executor.submit(new LatchExamp(latch,i));
		latch.countDown();
		}
		
		

	}

}


