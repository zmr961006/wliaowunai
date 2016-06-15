package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iTicketDAO;
import xupt.se.ttms.model.Play;
import xupt.se.ttms.model.Ticket;
import xupt.se.util.DBUtil;

public class TicketDAO implements iTicketDAO{

	@Override
	public int insert(Ticket tic) {
		try {
			String sql = "insert into ticket(seat_id, sched_id, ticket_price, ticket_status,ticket_locked_time)"
					+ " values(" + tic.getSeat_id()
					+ ", " + tic.get_sched_id()
					+ ", "  + tic.get_price()
					+ ", " + tic.getTicket_sold()
					+ ", '" + tic.getTicket_date()
					+ "' );";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				tic.setTicket_id(rst.getInt(1));
				/*是否在这里设计了ID 的值？*/
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
		
		int rtn=0;
		try {
			String sql = "update ticket set " + " seat_id = "
	                     + tic.getSeat_id() + " , sched_id = "
	                     + tic.get_sched_id() + ", ticket_price = "
	                     + tic.getTicket_sold() + ", ticket_locked_time = '"
	                     + tic.getTicket_date() + "' ";

			sql += " where ticket_id = " + tic.getTicket_id() + ";";
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn =db.execCommand(sql);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;

	}

	@Override
	public int delete(int ID) {
		int rtn=0;		
		try{
			String sql = "delete from  ticket ";
			sql += " where ticket_id = " + ID + ";";
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
		List<Ticket> ticList = null;
		ticList=new LinkedList<Ticket>();
		try {
			String sql = "select ticket_id,seat_id,sched_id,ticket_price,ticket_status,ticket_locked_time from play ";
			condt.trim();
			if(!condt.isEmpty()) {
				sql+= " where " + condt + ";";
			} else {
				sql += ";";
			}
			
			System.out.println(sql);
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.print("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if (rst!=null) {
				while(rst.next()){
					Ticket tic= new Ticket();
					tic.setTicket_id(rst.getInt("ticket_id"));
					tic.setSeat_id(rst.getInt("seat_id"));
					tic.set_sched_id(rst.getInt("sched_id"));
					tic.set_price(rst.getDouble("ticket_price"));
					tic.setTicket_sold(rst.getInt("ticket_status"));
					tic.setTicket_date(rst.getString("ticket_locked_time"));
					ticList.add(tic);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
		}
		
		return ticList;
	}

	@Override
	public int select_id(Ticket stu) {
		// TODO Auto-generated method stub
		return 0;
	}

}
