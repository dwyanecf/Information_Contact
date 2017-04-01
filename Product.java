package bucky;

public class Product {

    private String name;
    private String lastname;
    private String middle;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String email;
    private int zipcode;
    private long phone;
    private boolean prof;
    private String date;
    public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	private String year,month,day;
    
    public Product(){
        this.name = "";
      
        this.lastname = "";
        this.middle = "";
        this.address1 = "";       
        this.address2 = "";
        this.city = "";
        this.state = "";        
        this.email = "";
        this.zipcode= 75000;
        this.phone = 8888880;
        this.prof = false;
        this.date = "today";
 
        
    }
    public Product(String name,String address1,String address2,String city,String date,
    		String email,String lastname,String middle,long phone,int zipcode,String state,boolean prof)
    
    {
        this.name = name;
       
        this.lastname = lastname;
        this.middle = middle;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.email = email;      
        this.phone = phone;
        this.zipcode = zipcode;
        this.date = date;
        this.prof = prof;
        
    }
    
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
    public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long l) {
		this.phone = l;
	}

	public boolean isProf() {
		return prof;
	}

	public void setProf(boolean prof) {
		this.prof = prof;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


    public Product(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  

}