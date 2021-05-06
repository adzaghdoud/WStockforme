package com.WSREST.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WSREST.dao.FournisseurDao;
import com.WSREST.dao.LoginsDao;
@Service("LoginsService")
@Transactional
public class LoginsServiceImpl implements LoginsService {
	@Autowired
    private LoginsDao dao;
	public boolean updatepassword(String password, String login) {
		// TODO Auto-generated method stub
		return dao.updatepassword(password, login);
	}
	public boolean checkexistancemail(String mail) {
		// TODO Auto-generated method stub
		return dao.checkexistancemail(mail);
	}
	public boolean insertgeneratedcode(String code, String user) {
		// TODO Auto-generated method stub
		return dao.insertgeneratedcode(code, user);
	}
	public String getloginfromemail(String email) {
		// TODO Auto-generated method stub
		return dao.getloginfromemail(email);
	}

}
