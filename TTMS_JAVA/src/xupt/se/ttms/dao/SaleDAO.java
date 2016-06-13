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
			String sql = "insert into studio(sale_time,sale_payment, sale_change, sale_type,sale_status )"
					+ " values('" + sal.get_sale_time()
					+ "', " + sal.get_payment()
					+ ", "  + sal.get_change() 
					+ ", " + sal.set_sale_status()
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

	@Override
	public int update(Sale sal) {
		int rtn=0;
		/*try {
			String sql = "update sale set " + " studio_name ='"
					+ stu.getName() + "', " + " studio_row_count = "
					+ stu.getRowCount() + ", " + " studio_col_count = "
					+ stu.getColCount() + ", " + " studio_introduction = '"
					+ stu.getIntroduction() + "' ";
                     
			sql += " where studio_id = " + sal.getID();
			System.out.println("studio_id : " + sal.getID());
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn =db.execCommand(sql);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return rtn;
	}

	@Override
	public int delete(int ID) {
		int rtn=0;		
		try{
			String sql = "delete from sale ";
			sql += " where sale_id = " + ID;
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
		List<Sale> stuList = null;
		stuList=new LinkedList<Sale>();
		try {
			String sql = "select studio_id, studio_name, studio_row_count, studio_col_count, studio_introduction from studio ";
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
					Studio stu=new Studio();
					stu.setID(rst.getInt("studio_id"));
					stu.setName(rst.getString("studio_name"));
					stu.setRowCount(rst.getInt("studio_row_count"));
					stu.setColCount(rst.getInt("studio_col_count"));
					stu.setIntroduction(rst.getString("studio_introduction"));
				//	stuList.add(stu);
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
	}


