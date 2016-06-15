package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iemployee;
import xupt.se.ttms.model.Employee;
import xupt.se.ttms.model.Play;
import xupt.se.util.DBUtil;

public class EmployeeDAO implements iemployee{

	@Override
	public int insert(Employee emp) {
		try {
			String sql = "insert into employee(emp_no,emp_name,emp_tel_num,emp_addr,emp_email,emp_password)"
					+ " values( '"  + emp.getName()
					+ "' , '" +emp.getcName()
					+ "' , '" +emp.getTel()
					+ "' , '" +emp.get_addr()
					+ "',' "  +emp.get_email()
					+ "',' " +emp.getPassword()
					+ " );";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if (rst!=null && rst.first()) {
				emp.setId(rst.getInt(1));
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
	public int update(Employee emp) {

		int rtn=0;
		try {
			String sql = "update employee set " + " emp_no ='"
					+ emp.getcName()+ "', " + "emp_name = ' "
					+ emp.getName() + "', " + "emp_tel_num  = '"
					+ emp.getTel() + "', " + "emp_addr = "
					+ emp.get_addr() + "', " + "emp_email = '" 
					+ emp.get_email() + "','"    + "emp_password = '"
					+ emp.getPassword()+ "'";
			sql += " where play_id = " + emp.getId() + ";";
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
			String sql = "delete from employee ";
			sql += " where emp_id = " + ID + ";";
			
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
	public int select_id(Employee use) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> select(String condt) {
		List<Employee> empList = null;
		empList=new LinkedList<Employee>();
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
					Employee emp= new Employee();
					emp.setId(rst.getInt("emp_id"));
					//emp.setno(10);
					emp.setName(rst.getString("emp_name"));
					emp.setTel(rst.getString("emp_tel_num"));
					emp.set_addr(rst.getString("emp_addr"));
					emp.set_email(rst.getString("emp_email"));
					emp.setPassword(rst.getString("emp_password"));
					
					
					empList.add(emp);
				}
			}
			db.close(rst);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			
		}
		
		return empList;
	}

}
