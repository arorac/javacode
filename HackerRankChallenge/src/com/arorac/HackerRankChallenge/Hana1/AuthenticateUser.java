package com.arorac.HackerRankChallenge.Hana1;

import java.util.HashMap;
import java.util.Map;

//Class that keesp the Client records and Authenticate if the user is allow to or not
class AuthenticateUser{
 private static Map<Integer,ClientDetails> userMap ;
 static{
     userMap = new HashMap<Integer,ClientDetails>(); 
     userMap.put(1,new ClientDetails(1,"LOW"));
     userMap.put(3,new ClientDetails(3,"MEDIUM"));
     userMap.put(5,new ClientDetails(4,"HIGH"));
     userMap.put(7,new ClientDetails(7,""));
 }
 
 public static boolean isAuthenticUser(Integer i){
     return userMap.containsKey(i);
 }
 
 public static ClientDetails getClient(int id){
     return userMap.get(id);
 }
}