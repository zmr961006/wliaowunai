package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Seat;


public interface iSeatDAO {

	public int insert(Seat sea);
	public int update(Seat sea);
	public int delete(int ID);
	public List<Seat> select(String condt);
	
}
