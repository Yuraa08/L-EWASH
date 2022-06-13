package id.ac.uvers.l_ewash.model;

public class LaundrylistsItem{
	private String userlaundry;
	private String jambuka;
	private String rating;
	private String jamtutup;
	private String idLaundry;
	private String selfdelivery;
	private String kurirdelivery;
	private String namalaundry;

	public void setUserlaundry(String userlaundry){
		this.userlaundry = userlaundry;
	}

	public String getUserlaundry(){
		return userlaundry;
	}

	public void setJambuka(String jambuka){
		this.jambuka = jambuka;
	}

	public String getJambuka(){
		return jambuka;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setJamtutup(String jamtutup){
		this.jamtutup = jamtutup;
	}

	public String getJamtutup(){
		return jamtutup;
	}

	public void setIdLaundry(String idLaundry){
		this.idLaundry = idLaundry;
	}

	public String getIdLaundry(){
		return idLaundry;
	}

	public void setSelfdelivery(String selfdelivery){
		this.selfdelivery = selfdelivery;
	}

	public String getSelfdelivery(){
		return selfdelivery;
	}

	public void setKurirdelivery(String kurirdelivery){
		this.kurirdelivery = kurirdelivery;
	}

	public String getKurirdelivery(){
		return kurirdelivery;
	}

	public void setNamalaundry(String namalaundry){
		this.namalaundry = namalaundry;
	}

	public String getNamalaundry(){
		return namalaundry;
	}
}
