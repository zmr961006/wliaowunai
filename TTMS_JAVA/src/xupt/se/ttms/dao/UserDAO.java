package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iUserDAO;
import xupt.se.ttms.model.Play;
import xupt.se.ttms.model.User;
import xupt.se.util.DBUtil;

public class UserDAO implements iUserDAO {

	@Override
	public int insert(User use) {
		try {
			String sql = "insert into user(user_name,user_sex,user_password,user_vip,user_money)"
					+ " values( "  + use.get_user_name()
					+ "' , '" +use.get_user_sex()
					+ "' , '" +use.get_user_password()
					+ "' , " +use.get_user_vip()
					+ ", " +use.get_money()
					+ " );";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				use.set_user_id(rst.getInt(1));
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
	public int update(User use) {
		int rtn=0;
		try {
			String sql = "update use set " + "user_name = '"
						  + use.get_user_name() + "', user_sex = '"
						  + use.get_user_sex()  + "' ,user_password = '"
						  + use.get_user_password() + "', user_vip = "
						  + use.get_user_vip()    + " ,user_money = "
						  + use.get_money();

			sql += " where play_id = " + use.get_user_id() + ";";
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
			String sql = "delete from user ";
			sql += " where user_id = " + ID + ";";
			
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
	public int select_id(User use) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> select(String condt) {
		List<User> useList = null;
		useList=new LinkedList<User>();
		try {
			String sql = "select user_id,user_name,user_sex,user_password,user_vip,user_money from play ";
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
					User use= new User();
					use.set_user_id(rst.getInt("user_id"));
					use.set_user_name(rst.getString("user_name"));
					use.set_user_sex(rst.getString("user_sex"));
					use.set_user_password(rst.getString("user_password"));
					use.set_user_vip(rst.getInt("user_vip"));
					use.set_user_money(rst.getDouble("user_money"));
					useList.add(use);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return useList;
	}

	
}
