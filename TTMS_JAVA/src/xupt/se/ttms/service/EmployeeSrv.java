package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iStudioDAO;
import xupt.se.ttms.idao.iemployee;
import xupt.se.ttms.model.Employee;
import xupt.se.ttms.model.Studio;

public class EmployeeSrv {

private iemployee empDAO=DAOFactory.createemployeeDAO();
	
	public int add(Employee emp){
		return empDAO.insert(emp); 		
	}
	
	public int modify(Employee emp){
		return empDAO.update(emp); 		
	}
	
	public int delete(int ID){
		return empDAO.delete(ID); 		
	}
	
	public List<Employee> Fetch(String condt){
		return empDAO.select(condt);		
	}
	
	public List<Employee> FetchAll(){
		return empDAO.select("");		
	}
	
}
