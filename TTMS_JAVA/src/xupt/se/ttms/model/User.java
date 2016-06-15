package xupt.se.ttms.model;

public class User {

	private  int user_id;
	private  String user_name;
	private  String user_sex;
	private  String user_password;
	private  int user_vip;
	private  double user_money;
	
	public void set_user_id(int id){
			this.user_id = id;
	}
	public void set_user_name(String name){
			this.user_name = name;
	}
	public void set_user_sex(String se){
			this.user_sex = se;
	}
	public void set_user_password(String paswd){
			this.user_password = paswd;
	}	
	public void set_user_vip(int vip){
			this.user_vip = vip;
	}
	public void set_user_money(double my){
			this.user_money = my;
	}
	
	public int get_user_id(){
		return user_id;
	}
	public String  get_user_name(){
		return user_name;
	}
	public String   get_user_sex(){
		return  user_sex;
	}
	public  String  get_user_password(){
		return user_password;
	}
	public int  get_user_vip(){
		return user_id;
	}
	
	public double get_money(){
		return user_money;
	}
	
	

	
}