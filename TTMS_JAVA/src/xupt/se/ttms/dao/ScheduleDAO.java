package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.IScheduleDAO;
import xupt.se.ttms.model.Play;
import xupt.se.ttms.model.Schedule;
import xupt.se.util.DBUtil;

public class ScheduleDAO implements IScheduleDAO {

	@Override
	public int insert(Schedule sch) {
		try {
			String sql = "insert into schedule(studio_id,play_id,sched_time,sched_ticket_price)"
					+ " values( "  + sch.get_studio_id()
					+ ","   + sch.get_play_id()
					+ ",'"  + sch.get_studio_string()
			        + "',"  + sch.get_ticket_price()
					+ " );";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				sch.set_sched_id(rst.getInt(1));
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
	public int update(Schedule sch) {
		int rtn=0;
		try {
			String sql = "update schedule set " + " studio_id = "
						 +sch.get_sched_id() + ", play_id = "
						 +sch.get_play_id()  + ",sched_time = '"
						 +sch.get_studio_string() + "',sched_ticket_price = "
						 +sch.get_ticket_price() ;
					
			sql += " where play_id = " + sch.get_sched_id() + ";";
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
			String sql = "delete from schedule ";
			sql += " where sched_id = " + ID + ";";
			
			System.out.println(sql);
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
	public int select_id(Schedule stu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Schedule> select(String condt) {
		List<Schedule> schList = null;
		schList=new LinkedList<Schedule>();
		try {
			String sql = "select sched_id,studio_id,play_id,sched_time,sched_ticket_price from play ";
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
					Schedule sch= new Schedule();
					sch.set_sched_id(rst.getInt("sched_id"));
					sch.set_studio_id(rst.getInt("studio_id"));
					sch.set_play_id(rst.getInt("sched_id"));
					sch.set_sched_time(rst.getString("sched_time"));
					sch.set_sched_ticket_price(rst.getDouble("sched_ticket_price"));
					schList.add(sch);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return schList;
	}

}
