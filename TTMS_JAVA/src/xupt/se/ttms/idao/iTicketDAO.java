package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Ticket;;

public interface iTicketDAO {

	public int insert(Ticket stu);
	public int update(Ticket stu);
	public int delete(int ID);
	public List<Ticket> select(String condt);
	
}
