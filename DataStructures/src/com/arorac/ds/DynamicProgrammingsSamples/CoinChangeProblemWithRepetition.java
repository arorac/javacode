package com.arorac.ds.DynamicProgrammingsSamples;

import java.util.Arrays;

public class CoinChangeProblemWithRepetition {
	
	public static  long sum = 166 ;
	public static  long[] coinArray = {5,37,8,39,33,17,22,32,13, 7 ,10 ,35 ,40 ,2 ,43 ,49 ,46 ,19 ,41 ,1 ,12 ,11 ,28};
	public static long countTimes = 0 ; 
	public static long[][] memoCoinArray ;
	public static void main(String[] args) {
		
		
		long starttime1 = System.currentTimeMillis();
		
		//Memoisation
		memoCoinArray = new long[((int)sum + 1)][coinArray.length];
		//Initialisation
		for(long[] a : memoCoinArray){
			Arrays.fill(a, -1l);
		}
		Arrays.fill(memoCoinArray[0], 0l);
		
		//Sort the coins in asc order
		Arrays.sort(coinArray, 0, coinArray.length);
		long starttime = System.currentTimeMillis();
//		findSumCountWhile(sum,0);
//		findSumCountFor(sum,0);
//		countTimes = findSumCountReturn(sum,0,memoCoinArray);
		countTimes = findSumCountReturnDP(sum,0,memoCoinArray);
		long endtime = System.currentTimeMillis();
		
		System.out.println("Total number of times: " + countTimes +
				"\n total time taken (milsec): "+ (endtime - starttime1) +
				"\n Function time for coin (milsec): "+ (endtime -starttime ));
	}
	
	public static long findSumCountReturnDP(long sum , int i,long[][]memoCoin ){
		
		if (sum < 0 || i >= coinArray.length) return 0;
		if (sum == 0) return 1;
		if(memoCoin[(int)sum][i] >= 0 ) return  memoCoin[(int)sum][i];
		
		long a = findSumCountReturnDP(sum-coinArray[i], i, memoCoin);
		long b = findSumCountReturnDP(sum, i+1, memoCoin);
		memoCoin[(int)sum][i] = a+b ;
		return a+b;
	}
	
	
	public static long findSumCountReturn(long sum , int i,long[][]memoCoin ){
		int localCount = 0 ; 
		int localpoint = i;
		if (memoCoin[(int)sum][i] >= 0) return memoCoin[(int)sum][i];
		for(; localpoint < coinArray.length ; localpoint++){
			
			if(sum < coinArray[localpoint]){
				break;
			}else if(sum == coinArray[localpoint]){
				++localCount;
			}else if(sum > coinArray[localpoint]){
				localCount +=  findSumCountReturn(sum-coinArray[localpoint] , localpoint,memoCoin);
			}
		}
		memoCoin[(int)sum][i] = localCount;
		return localCount;
		
	}
	
	
	public static void findSumCountFor(long sum , int i){
		
		int localpoint = i;
		for(; localpoint < coinArray.length ; localpoint++){
			
			if(sum < coinArray[localpoint]){
				//Do nothing
			}else if(sum == coinArray[localpoint]){
				++countTimes;
			}else if(sum > coinArray[localpoint]){
				findSumCountFor(sum-coinArray[localpoint] , localpoint);
			}
		}
	}

	
	
	public static void findSumCountWhile(long sum , int i){
		
		int localpoint = i;
		while(localpoint < coinArray.length){
			
			if(sum < coinArray[localpoint]){
				++localpoint;
				continue;
			}
			
			if(sum == coinArray[localpoint]){
				++countTimes;
				++localpoint;
				continue;
			}
			
			if(sum > coinArray[localpoint]){
				findSumCountWhile(sum-coinArray[localpoint] , localpoint);
				++localpoint;
			}
		}
		
	}
	
	
	

}
