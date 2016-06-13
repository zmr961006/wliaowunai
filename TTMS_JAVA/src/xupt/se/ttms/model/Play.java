package xupt.se.ttms.model;

public class Play {

	private  int   play_id = 0;
	private  int   play_type_id = 0;
	private  int   play_lang_id = 0;

	private  String play_name = " ";
	private  String play_introduction = " ";
	private  String play_image = " ";   /*image ???*/
	
	private  int  play_length = 0;
	private  double play_ticket_price = 0;   /*the price decimal*/
	private  int play_status  = 0;
	
	
	public void  setID(int id){
		play_id = id;
	}
	
	public int getID(){
		
		return play_id;
		
	}
	
	public void setname(String Name){
	
		this.play_name = Name;
	
	}
	
	public String getname(){
		
		return play_name;
		
	}
	
	public void set_type_id(int id){
		
		this.play_type_id = id;
		
	}
	
	public int get_type_id(){
		
		return play_type_id;
		
	}
	
	public void set_lang_id(int id){
		
		this.play_lang_id = id;
		
	}
	
	public int get_lang_id(){
		
		return play_lang_id;
		
	}
	
	public void setIntroduction(String inr){
		
		this.play_introduction = inr;
		
	}
	
	public String getIntroduction(){
		
		return play_introduction;
		
	}
	
	public void setimage(String image){
		
		this.play_image = image;
		
	}
	
	public String getimage(){
		
		return play_image;
		
	}
	
	public void setlength(int length){
	
		this.play_length = length;
		
	}
	
	public int getlength(){
		
		return  play_length;
		
	}
	
    public void setprice(double price){
	
		this.play_ticket_price = price;
		
	}
	
	public double getprice(){
		
		return play_ticket_price;
		
	}
	
    public void setstatus(int status){
	
		this.play_status = status;
		
	}
	
	public int getstatus(){
		
		return play_status;
		
	}
	
	
	
}
