package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iSaleDAO;
import xupt.se.ttms.model.Sale;
import xupt.se.ttms.model.Studio;
import xupt.se.util.DBUtil;

public class SaleDAO implements iSaleDAO {

	@Override
	public int insert(Sale sal) {
		try {
			String sql = "insert into studio(emp_id,sale_time,sale_payment,sale_change, sale_type,sale_status )"
					+ " values(" + sal.get_emp_ID()
					+ ", '" + sal.get_sale_time()
					+ "', " + sal.get_change() 
					+ ", "  + sal.get_sale_type()
					+ ", "  + sal.get_sale_status()
					+ " );";
			
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				sal.setID(rst.getInt(1));
			}
			db.close(rst);
			db.close();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
		
	}

	@Override   /*订单修改暂定只能修改订单状态，修改其它无意义*/
	public int update(Sale sal) {
		int rtn=0;
		try {
			String sql = "update sale set " + " sale_status = " +sal.get_sale_status();
                     
			sql += " where studio_id = " + sal.getID() + ";";
			
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
			String sql = "delete from sale ";
			sql += " where sale_id = " + ID + ";";
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn=db.execCommand(sql);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;	
	}
	

	@Override          /*订票查询未确定，暂时不定*/
	public List<Sale> select(String condt) {
		List<Sale> salList = null;
		salList=new LinkedList<Sale>();
		try {
			String sql = "select * from Sale ";
			condt.trim();
			if(!condt.isEmpty())
				sql+= " where " + condt + ";";
			DBUtil db = new DBUtil();
			if(!db.openConnection()){
				System.out.print("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if (rst!=null) {
				while(rst.next()){
					Sale sal=new Sale();
					sal.setID(rst.getInt("sale_ID"));
					sal.set_emp_ID(rst.getInt("emp_id"));
					sal.set_sale_time(rst.getString("sale_time"));
					sal.set_payment(rst.getDouble("sale_change"));
					sal.set_sale_type(rst.getInt("sale_type"));
					sal.set_sale_status(rst.getInt("sale_status"));
					salList.add(sal);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return salList;
	}
	
	public int select_id(Sale stu){    /*交易ID查询根据售票员和售票的时间唯一确定*/
		int id = 0;
		try{
		String sql = "select sale_ID from Sale " ;
		
		sql += "where emp_id  = " + stu.get_emp_ID() + "and  sale_time = " + stu.get_sale_time() + ";";
		
		DBUtil db = new DBUtil();
		
		if(!db.openConnection()){
			System.out.print("db connect is failed\n");
			return -1;
		}
		ResultSet rst = db.execQuery(sql);
		rst.next();
		id = rst.getInt("sale_ID");
		db.close(rst);
		db.close();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return id;
		
	}
	
}


