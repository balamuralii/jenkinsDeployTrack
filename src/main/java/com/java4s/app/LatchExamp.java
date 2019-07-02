package com.java4s.app;

import java.util.concurrent.CountDownLatch;

public class LatchExamp implements Runnable {

	CountDownLatch latch = null;
	int i ;
	
	
	public LatchExamp() {
		// TODO Auto-generated constructor stub
	}
	
	public LatchExamp(CountDownLatch latch,int i){
		
		this.latch = latch;
		this.i = i;
	}
	@Override
	public void run() {
		System.out.println("waiting "+Thread.currentThread().getName()+"  "+i);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("started ---"+Thread.currentThread().getName());

	}

}
