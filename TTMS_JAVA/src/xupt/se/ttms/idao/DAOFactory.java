package xupt.se.ttms.idao;
import xupt.se.ttms.dao.*;

public class DAOFactory {
	public static iStudioDAO creatStudioDAO(){      /*演出厅工厂类*/
		return new StudioDAO();
	}
	
	public static iPlayDAO createPlayDAO(){         /*电影类*/
		return new PlayDAO();
	}
	
	public static iSaleDAO createSaleDAO(){          /*定单*/
		return new SaleDAO();
	}

/*	public static iTicket createTicketDAO(){
		return new TicketDAO();
	}
*/
	public static iUserDAO createUserDAO(){
		return new UserDAO();
	}
	public static iemployee createemployeeDAO(){
		return new EmployeeDAO();
	}
	public static IScheduleDAO createScheduleDAO(){
		return new ScheduleDAO();
	}
	public static iSake_itemDAO createSale_itemDAO(){
		return new Sale_itemDAO();
		
	}
	public static iSeatDAO createSeatDAO(){
		return new SeatDAO();
	}
}

