package id.ac.uvers.l_ewash.model;

import java.util.List;

public class ResponseLaundryList {
	private String msg;
	private List<LaundrylistsItem> ldrylist;
	private int idLaundry;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setLaundrylists(List<LaundrylistsItem> laundrylists){
		this.ldrylist = laundrylists;
	}

	public List<LaundrylistsItem> getLaundrylists(){
		return ldrylist;
	}

	public void setIdLaundry(int idLaundry){
		this.idLaundry = idLaundry;
	}

	public int getIdLaundry(){
		return idLaundry;
	}
}