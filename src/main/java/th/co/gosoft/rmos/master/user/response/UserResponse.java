package th.co.gosoft.rmos.master.user.response;

import th.co.gosoft.rmos.master.user.User;

public class UserResponse{
	private String website;
	private String address;
	private String addressGeo;
	private String phone;
	private String companyName;
	private String name;
	private Long id;
	private String email;
	private String username;

	public UserResponse(User user) {
		this.id = user.getId();
		this.username = user.getUserName();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.companyName = user.getCompany().getName();
		this.website = user.getWebsite();
		//this.address = user.getAddress().getStreet();
		//this.addressGeo = user.getAddress().getGeo().getLat()+", "+ user.getAddress().getGeo().getLng();
	}

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setAddressGeo(String addressGeo){
		this.addressGeo = addressGeo;
	}

	public String getAddressGeo(){
		return addressGeo;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
