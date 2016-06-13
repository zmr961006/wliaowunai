package xupt.se.ttms.model;

public class Sale {

	private  int sale_ID = 0;
	private  int emp_id = 0;
	private  String sale_time = " ";
	private  double sale_payment = 0;
	private  double sale_change = 0;
	private  int sale_type = 0;
	private  int sale_status = 0;
	
	public void setID(int id){
	
		this.sale_ID = id;
		
	}
	
	public int getID(){
		
		return sale_ID;
		
	}
	
	
    public void set_emp_ID(int id){
		
    	this.emp_id = id;
    	
    	
	}
	
	public int get_emp_ID(){
		
		return emp_id;
		
	}
	
	
    public void set_sale_time(String a){
		
    	this.sale_time = a;
    	
	}
	
	public String get_sale_time(){
		
		return sale_time;
		
	}
	public void set_payment(double pay){
		
		this.sale_payment = pay;
		
	}
	
	public double get_payment(){
		
		return sale_payment;
	}
	public void set_change(double change){
		
		this.sale_change = change;
		
	}
	public double get_change(){
		
		return sale_change;
		
	}
	public void set_sale_type(int type){
			
		this.sale_type = type;
		
	}
	public double get_sale_type(){
		
		return sale_type;
		
	}
	public void set_sale_status(int status){
		
		this.sale_status = status;
		
	}
	public int set_sale_status(){
		
		return sale_status;
		
	}
	
}
