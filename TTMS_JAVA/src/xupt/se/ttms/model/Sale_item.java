package xupt.se.ttms.model;

public class Sale_item {

	private  int sale_item_id;
	private  int ticket_id;
	private  int sale_id;
	private  double sale_item_price;
	
	
	public void set_sale_item_id(int id){
		this.sale_item_id = id;
	}
	public void set_ticket_id(int id){
		this.ticket_id = id;
	}
	public void set_sale_id(int id){
		this.sale_id = id; 
	}
	public void set_sale_item_price(double d){
		this.sale_item_price = d;
	}
	
	public int get_sale_item_id(){
		return sale_item_id;
	}
	public int get_ticket_id(){
		return ticket_id;
	}
	public int get_sale_id(){
		return sale_id;
	}
	public double get_sale_item_price(){
		return sale_item_price;
	}
}
