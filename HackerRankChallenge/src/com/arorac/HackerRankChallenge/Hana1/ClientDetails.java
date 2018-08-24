package com.arorac.HackerRankChallenge.Hana1;

//Client details class to hold client details
class ClientDetails{
  int clientID; 
  LiscenceTypeEnum liscenseDetails;
  
  public ClientDetails(){}
  
  public ClientDetails(int id , String liscenseDet){
      this.clientID = id;
      this.liscenseDetails = LiscenceTypeEnum.getByName(liscenseDet);
  }
  
}
