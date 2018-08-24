package com.arorac.HackerRankChallenge.Hana1;

public enum LiscenceTypeEnum{
    LOW(10),
    MEDIUM(20),
    HIGH(50) ;
    
    private int rate;
    
    LiscenceTypeEnum(int rate){
        this.rate = rate;
    }
    
    public int getRate(){
        return this.rate;
    }
    
    public static LiscenceTypeEnum getByName(String name){
    	
    	for(LiscenceTypeEnum a : LiscenceTypeEnum.values()){
    		if (a.equals(name)) 
    			return a;
    	}
		return null;
    }
  
}