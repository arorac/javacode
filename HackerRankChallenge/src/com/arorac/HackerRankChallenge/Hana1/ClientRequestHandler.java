package com.arorac.HackerRankChallenge.Hana1;

import java.util.concurrent.Callable;

class ClientRequestHandler implements Callable<String> {
    
    int clientId ; 
    ClientDetails cliDetails; 
    
    public ClientRequestHandler(int clientId){
        this.clientId = clientId;
        
    }
    
    @Override
	public String call() throws Exception{

    	if (null == AuthenticateUser.getClient(clientId)){
    		return clientId +": Client Not Authorised " ;
    	}else{
    		this.cliDetails = AuthenticateUser.getClient(clientId);
    	}
    	
    	return clientId + " : Can service the request or can check for liscense usage" ;
    }
}