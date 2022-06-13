package id.ac.uvers.l_ewash.model;

import java.util.List;

public class ResponseLaundryList {
	private String msg;
	private List<LaundrylistsItem> laundrylists;
	private int idLaundry;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setLaundrylists(List<LaundrylistsItem> laundrylists){
		this.laundrylists = laundrylists;
	}

	public List<LaundrylistsItem> getLaundrylists(){
		return laundrylists;
	}

	public void setIdLaundry(int idLaundry){
		this.idLaundry = idLaundry;
	}

	public int getIdLaundry(){
		return idLaundry;
	}
}