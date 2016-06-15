package xupt.se.ttms.model;

public class Seat {

	private int seat_id;
	private int studio_id;
	private int seat_row;
	private int seat_column;
	private int status;
	
	public void set_seat_id(int id){
		this.seat_id = id;
	}
	public void set_studio_id(int id){
		this.studio_id = id;
	}
	public void set_seat_row(int row){
		this.seat_row = row;
	}
	public void set_seat_column(int col){
		this.seat_column = col;
	}
	public void set_status(int status){
		this.status = status;
	}
	public int   get_seat_id(){
		return  seat_id; 
	}
	public  int get_studio_id(){
		return  studio_id;
	}
	public  int  get_seat_row(){
		return  seat_row;
	}
	public  int get_seat_column(){
		return seat_column;
	}
	public  int  get_status(){
		return status;
	}
	
}
