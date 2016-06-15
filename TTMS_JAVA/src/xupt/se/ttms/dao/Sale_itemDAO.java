package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iSake_itemDAO;
import xupt.se.ttms.model.Sale_item;
import xupt.se.ttms.model.Studio;
import xupt.se.util.DBUtil;

public class Sale_itemDAO implements iSake_itemDAO {

	@Override
	public int insert(Sale_item sal) {
		try {
			String sql = "insert into sale_item(ticket_id,sale_id,sale_item_price)"
					+ " values(" + sal.get_ticket_id()
					+ ", " + sal.get_sale_id() 
					+ ", "  + sal.get_sale_item_price() 
					+ " )";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				sal.set_sale_item_id(rst.getInt(1));
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
	public int update(Sale_item sal) {
		int rtn=0;
		try {
			String sql = "update sale_item set " + "sale_item_id = " 
					+ sal.get_sale_id() + ", ticket_id = "
					+ sal.get_ticket_id()  + ", sale_id = "
					+ sal.get_sale_id()    + ", sale_item_price = "
					+ sal.get_sale_item_price() + ";";

			sql += " where studio_id = " + sal.get_sale_item_id();
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
			String sql = "delete from sale_item ";
			sql += " where sale_item_id = " + ID;
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
	public List<Sale_item> select(String condt) {
		List<Sale_item> salList = null;
		salList=new LinkedList<Sale_item>();
		try {
			String sql = "select sale_item_id,sale_id,ticket_id,sale_item_price from sale_item ";
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
					Sale_item sal=new Sale_item();
					sal.set_sale_item_id(rst.getInt("sale_item_id"));
					sal.set_sale_id(rst.getInt("sale_id"));
					sal.set_ticket_id(rst.getInt("ticket_id"));
					//sal.set_sale_item_price(rst.getDouble("sale-item_pprice"));
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

	
	
	
}
