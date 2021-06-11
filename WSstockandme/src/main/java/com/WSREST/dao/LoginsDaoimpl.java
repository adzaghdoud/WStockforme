package com.WSREST.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
@Repository("LoginsDao")
public class LoginsDaoimpl  extends AbstractDao implements LoginsDao{

	public boolean updatepassword(String password , String login) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("update logins set password= AES_ENCRYPT('"+ password +"', UNHEX(SHA2('My secret passphrase',512))) where login = '" + login +"';");
		query.executeUpdate();
		int status=query.executeUpdate();
		
		boolean flag=false;
		if (status >0) {
		flag=true;	
			
		}
		else {
			flag=false;	
		}
		return flag;
	}

	public boolean checkexistancemail(String mail) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Query query = getSession().createSQLQuery("select email from logins where email ='"+mail+"';");
		if (query.list().size()==0) {
			flag=false;
			 
		}else {
		flag=true;
		}
	   
		return flag;
	}

	public boolean insertgeneratedcode(String code,String user) {
		// TODO Auto-generated method stub	
		Query query = getSession().createSQLQuery("INSERT INTO tempologin (login, code) VALUES (:val1,:val2);");
		query.setParameter("val1", user);
		query.setParameter("val2", code);
		int status=query.executeUpdate();
		boolean flag=false;
		if (status >0) {
		flag=true;	
			
		}
		else {
			flag=false;	
		}
		return flag;
	}

	public String getloginfromemail(String email) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("select login from logins where email =  '"+email+"';");
		return (String) query.uniqueResult();
	}
	}


