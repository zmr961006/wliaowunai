package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Sale_item;
import xupt.se.ttms.model.Studio;

public interface iSake_itemDAO {

	public int insert(Sale_item sal);
	public int update(Sale_item sal);
	public int delete(int ID);
	public List<Sale_item> select(String condt);
	
}
