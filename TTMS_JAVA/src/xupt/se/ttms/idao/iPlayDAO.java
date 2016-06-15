package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Play;

public interface iPlayDAO {

	public int insert(Play stu);
	public int update(Play stu);
	public int delete(int ID);
	public int select_id(Play stu);
	public List<Play> select(String condt);
	
}
