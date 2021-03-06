package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.model.Play;
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.idao.iPlayDAO;
import xupt.se.util.DBUtil;

public class PlayDAO implements iPlayDAO{

	@Override
	public int insert(Play ply) {
		try {
			String sql = "insert into play(play_name,play_introduction,play_image,play_ticket_price,play_status,play_length)"
					+ " values( '"  + ply.getname()
					+ "' , '" +ply.getIntroduction()
					+ "' , '" +ply.getimage()
					+ "' , " +ply.getprice()
					+ ", " +ply.getstatus()
					+ ", " +ply.getlength()
					+ " );";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				ply.setID(rst.getInt(1));
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
	public int update(Play ply) {
		
		int rtn=0;
		try {
			String sql = "update play set " + " play_name ='"
					+ ply.getname() + "', " + "play_length = "
					+ ply.getlength() + ", " + " play_ticket_price = "
					+ ply.getprice() + ", " + " play_introduction = '"
					+ ply.getIntroduction() + "'," + "play_image = '" 
					+ ply.getimage() + "'";

			sql += " where play_id = " + ply.getID() + ";";
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
			String sql = "delete from play ";
			sql += " where play_id = " + ID + ";";
			
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
	public List<Play> select(String condt) {
		
		List<Play> stuList = null;
		stuList=new LinkedList<Play>();
		try {
			String sql = "select play_id, play_name, play_introduction, play_image, play_length, play_ticket_price, play_status from play ";
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
					Play ply= new Play();
					ply.setID(rst.getInt("play_id"));
					ply.setname(rst.getString("play_name"));
					ply.setIntroduction(rst.getString("play_introduction"));
					ply.setimage(rst.getString("play_image"));
					ply.setIntroduction(rst.getString("play_length"));
					ply.setprice(rst.getDouble("play_ticket_price"));
					ply.setstatus(rst.getInt("play_status"));
					
					stuList.add(ply);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return stuList;
	}

	@Override
	public int select_id(Play stu) {
		
		int id = -1;
		try {
			String sql = "select play_id  from play ";
			
			sql+= " where " + "play_name = '" + stu.getname() + "';" ;
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.print("fail to connect database");
				return -1;
			}
			ResultSet rst = db.execQuery(sql);
			rst.next();
			id = rst.getInt("play_id");
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
		
}
