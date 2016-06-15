package xupt.se.ttms.idao;

import java.util.List;

import xupt.se.ttms.model.Schedule;;

public interface IScheduleDAO {

	public int insert(Schedule  sch);
	public int update(Schedule sch);
	public int delete(int ID);
	public int select_id(Schedule stu);
	public List<Schedule> select(String condt);
	
}
