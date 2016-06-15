package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.User;

public interface iUserDAO {

	public int insert(User use);
	public int update(User use);
	public int delete(int ID);
	public int select_id(User use);
	public List<User> select(String condt); 
	
}
