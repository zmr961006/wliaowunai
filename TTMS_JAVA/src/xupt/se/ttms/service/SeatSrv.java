package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.idao.DAOFactory;
import xupt.se.ttms.idao.iSeatDAO;
import xupt.se.ttms.model.Seat;


public class SeatSrv {

	private iSeatDAO SeatDAO = DAOFactory.createSeatDAO(); 
	
	public int add(Seat sea){
		return SeatDAO.insert(sea);	
	}
	
	public int delete(int ID){
		return SeatDAO.delete(ID);
	}
	
	public int modify(Seat sea){
		return SeatDAO.update(sea);
	}
	public List<Seat> Fetch(String condt){
		return SeatDAO.select(condt);		
	}
	
	public List<Seat> FetchAll(){
		return SeatDAO.select("");		
	}
	
	
}
