package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.IScheduleDAO;
import xupt.se.ttms.idao.iStudioDAO;
import xupt.se.ttms.model.Schedule;
import xupt.se.ttms.model.Studio;

public class ScheduleSrv {

private IScheduleDAO schDAO=DAOFactory.createScheduleDAO();
	
	public int add(Schedule sch){
		return schDAO.insert(sch); 		
	}
	
	public int modify(Schedule sch){
		return schDAO.update(sch); 		
	}
	
	public int delete(int ID){
		return schDAO.delete(ID); 		
	}
	
	public List<Schedule> Fetch(String condt){
		return schDAO.select(condt);		
	}
	
	/*public List<Studio> FetchAll(){
		return schDAO.select("");		
	}*/
	
}
