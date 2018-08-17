package com.arorac.ThreadsExamples;

public class ThreadOnCommonObject {
	public static void main(String[] args) {
		
		Runnable obj = new Runnable(){
			@Override
			public void run(){
				for(int i = 0 ; i< 5 ; i++ ){
					System.out.println(Thread.currentThread().getName()+ " : " + i);
				}
			}
		};
		
		new Thread(obj).start();
		new Thread(obj).start();
		
	}
}
