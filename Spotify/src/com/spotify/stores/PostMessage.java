package com.spotify.stores;

public class PostMessage {

		
		String Tweet;
	    String User;
	    String message;
	    
	    public String getTweet(){
	    return Tweet;
	    }
	    public String getUser(){
	    return User;
	    }
	    public String getMessage(){
	    	
	    	return message;
	    }
	    
	    public void setMessage(String message){
	    	
	    	this.message= message;
	    }
	    
	    public void setTweet(String Tweet){
	    this.Tweet=Tweet;
	    }
	    public void setUser(String User){
	    this.User=User;
	    }

	}


