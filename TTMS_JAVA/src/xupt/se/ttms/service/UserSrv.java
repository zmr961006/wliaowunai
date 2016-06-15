package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.UserDAO;
import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iUserDAO;
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.model.User;

public class UserSrv {

	private iUserDAO userDAO = DAOFactory.createUserDAO();
	
	public int add(User use){
		return userDAO.insert(use);
	}
	public int update(User use){
		return userDAO.update(use);
	}
	public int delete(int ID){
		return userDAO.delete(ID);
	}
	public List<User> Fetch(String condt){
		return userDAO.select(condt);		
	}
	
	public List<User> FetchAll(){
		return userDAO.select("");		
	}
	
	
}
