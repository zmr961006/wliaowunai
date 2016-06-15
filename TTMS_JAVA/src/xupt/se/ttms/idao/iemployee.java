package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Employee;;

public interface iemployee {

	public int insert(Employee use);
	public int update(Employee use);
	public int delete(int ID);
	public int select_id(Employee use);
	public List<Employee> select(String condt); 
	
}
