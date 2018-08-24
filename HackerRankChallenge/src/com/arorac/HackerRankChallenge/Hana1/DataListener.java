package com.arorac.HackerRankChallenge.Hana1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class DataListener implements Runnable{
    
    BlockingQueue queue ;
    private static boolean loop = true;
    
    public DataListener(BlockingQueue queue){
        this.queue = queue; 
    }
    
    @Override 
    public void run(){
    	readRequest();
        while(loop) {
            readRequest();
        }
    }
    
    //This can be converted to read via standard input. Currently running in self sustaining mode. generates random integer 
    public void readRequest(){
        Random rand = new Random();
        int userId = rand.nextInt(10)+1 ; 
        try{
        queue.add(userId);
        }catch(Exception c ){
            System.out.println("Service is running to full capacity. Try after some time");
            try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}