package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Sale;



public interface iSaleDAO {
	public int insert(Sale stu);
	public int update(Sale stu);
	public int delete(int ID);
	public List<Sale> select(String condt); 
}
