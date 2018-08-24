package com.arorac.HackerRankChallenge.Hana1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Hana1 {
    
  
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);
        Thread listener = new Thread(new DataListener(queue));
        listener.start();
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        while(true){
        	
        	Integer i = queue.take();
        	Future f = executor.submit(new ClientRequestHandler(i));
        	results.add(f);
        	
        	System.out.println(results.remove(0).get());
        	
        }
        
    }
}
    
