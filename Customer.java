package term_project_22300245;

public class Customer {
	 private String id;
	 private String name;
	 private String phone_num;
	 private String email;
	 private String cam_type;
	 private String cam_prob;
	 private String status;

	 public Customer(String id, String name, String phone_num, String email, String cam_type, String cam_prob, String status) {
		 this.id=id;
	     this.name=name;
	     this.phone_num=phone_num;
	     this.email=email;
	     this.cam_type=cam_type;
	     this.cam_prob=cam_prob;
	     this.status=status;
	 }
	 
	 public String getId(){ 
		 return id; 
	 }
	 
	 public String getName(){ 
		 return name; 
	 }
	 
	 public void setName(String name) { 
		 this.name=name; 
	 }
	 
	 public String getPhone_num(){ 
		 return phone_num; 
	 }
	 
	 public void setPhone_num(String phone_num) { 
		 this.phone_num=phone_num; 
	 }
	 
	 public String getEmail() {
		 return email;
	 }
	 
	 public void setEmail(String email) {
		 this.email=email;
	 }
	 
	 public String getCam_type(){ 
		 return cam_type; 
	 }
	 
	 public void setCam_type(String cam_type) { 
		 this.cam_type=cam_type; 
	 }
	 
	 public String getCam_prob(){ 
		 return cam_prob; 
	 }
	 
	 public void setCam_prob(String cam_prob) { 
		 this.cam_prob=cam_prob; 
	 }
	 
	 public String getStatus(){ 
		 return status; 
	 }
	 
	 public void setStatus(String status) { 
		 this.status=status; 
	 }
	 
	 public String getRecord() {
		 return "ID: "+id+ "\nName: "+name+ "\nPhone Number: "+phone_num+
				 "\nEmail: "+email+"\nCamera Type: "+cam_type+"\nCamera Problem: "+
				 cam_prob+"\nRepair Status:"+status+"\n";
	 }
	 
}