package id.ac.uvers.l_ewash.model;

import java.util.List;

public class ResponsePriceList {
	private String msg;
	private List<PricelistItem> pricelist;
	private int id;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setPricelist(List<PricelistItem> pricelist){
		this.pricelist = pricelist;
	}

	public List<PricelistItem> getPricelist(){
		return pricelist;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}