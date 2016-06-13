package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.List;

import xupt.se.ttms.idao.iTicketDAO;
import xupt.se.ttms.model.Ticket;
import xupt.se.util.DBUtil;

public class TicketDAO implements iTicketDAO{

	@Override
	public int insert(Ticket tic) {
		try {
			String sql = "insert into ticket(seat_id, sched_id, ticket_price, ticket_status,ticket_locked_time )"
					+ " values('" + tic.getSeat_id()
					+ "', " + tic.get_sched_id()
					+ ", "  + tic.get_price()
					+ ", '" + tic.getTicket_sold()
					+ ", '" + tic.getTicket_date()
					+ "' );";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				tic.setTicket_id(rst.getInt(1));
			}
			db.close(rst);
			db.close();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(Ticket tic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int ID) {
		int rtn=0;		
		try{
			String sql = "delete from  ticket ";
			sql += " where ticket_id = " + ID;
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn=db.execCommand(sql);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;	
	}

	@Override
	public List<Ticket> select(String condt) {
		// TODO Auto-generated method stub
		return null;
	}

}
