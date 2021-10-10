package com.example.demot;

public class UsingLambda {

	public static void main(String[] args) {

		Runnable task=() ->{
			
			for(int i=0;i<+10;i++) {
				System.out.println(i);
			}
		};

		Thread thread = new Thread(task);
		thread.start();
	}

}
