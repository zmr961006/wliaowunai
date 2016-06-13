package xupt.se.ttms.model;

public class Schedule {

	private int sched_id;
	private int studio_id;
	private int play_id;
	private String sched_time;
	private double sched_ticket_price;
	
	
	public void set_sched_id(int id){ 
		this.sched_id = id;
	}
	public void set_studio_id(int id){ 
		this.studio_id = id;
	}
	public void set_play_id(int id){ 
		this.play_id = id;
	}
	public void set_sched_time(String data){ 
		this.sched_time = data;
	}
	public void set_sched_ticket_price(double price){ 
		this.sched_ticket_price = price;
	}
	public int  get_sched_id(){
		return sched_id;
	}
	public int  get_play_id(){
		return play_id;
	}
	public int  get_studio_id(){
		return  studio_id; 
	}
	public String  get_studio_string(){
		return sched_time;
	}
	public double  get_ticket_price(){
		return sched_ticket_price;
	}
}
