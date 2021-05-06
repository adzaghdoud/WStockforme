package com.WSREST.service;

public interface LoginsService {
	boolean updatepassword(String password,String login);
	boolean checkexistancemail(String mail);
	boolean insertgeneratedcode(String code , String user);
	String getloginfromemail(String email);

}
