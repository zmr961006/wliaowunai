package xupt.se.ttms.service;


import xupt.se.ttms.idao.*;
import xupt.se.ttms.model.Sale_item;


import java.util.List;

import xupt.se.ttms.dao.*;

public class Sale_itemSrv {

	private iSake_itemDAO  salDAO = DAOFactory.createSale_itemDAO();
	
	public int add(Sale_item sal){
		return salDAO.insert(sal);
	}
	
	public int delete(int id){
		return salDAO.delete(id);
	}
	
	public int modify(Sale_item sal){
		return salDAO.update(sal);
		
	}
	public List<Sale_item> Fetch(String condt){
		return salDAO.select(condt);		
	}
	
	public List<Sale_item> FetchAll(){
		return salDAO.select("");		
	}
	
}
