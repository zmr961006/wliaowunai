package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iSeatDAO;
import xupt.se.ttms.model.Seat;
import xupt.se.ttms.model.Studio;
import xupt.se.util.DBUtil;

public class SeatDAO implements iSeatDAO{

	@Override
	public int insert(Seat sea) {
		try {
			String sql = "insert into seat(studio_id,seat_row,seat_column,status)"
					+ " values(" + sea.get_studio_id()
					+ ", " + sea.get_seat_row()
					+ ", "  + sea.get_seat_column() 
					+ ", " + sea.get_status()
					+ " )";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				sea.set_seat_id(rst.getInt(1));
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
	public int update(Seat sea) {
		int rtn=0;
		try {
			String sql = "update seat set " + " studio_id = "
					+ sea.get_studio_id() + ", " + " seat_row = "
					+ sea.get_seat_row() + ", " + " seat_column = "
					+ sea.get_seat_column() + ", " + " status ="
					+ sea.get_status();

			sql += " where studio_id = " + sea.get_seat_id();
			//System.out.println("studio_id : " + stu.getID());
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
			String sql = "delete from  seat ";
			sql += " where seat_id = " + ID;
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
	public List<Seat> select(String condt) {
		List<Seat> seaList = null;
		seaList=new LinkedList<Seat>();
		try {
			String sql = "select seat_id,studio_id,seat_row,seat_column ,status from studio ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt;
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.print("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if (rst!=null) {
				while(rst.next()){
					Seat sea=new Seat();
					sea.set_seat_id(rst.getInt("seat_id"));
					sea.set_studio_id(rst.getInt("studio_id"));
					sea.set_seat_row(rst.getInt("seat_row"));
					sea.set_seat_column(rst.getInt("seat_column"));
					sea.set_status(rst.getInt("status"));
					seaList.add(sea);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return seaList;
	}

	
}
