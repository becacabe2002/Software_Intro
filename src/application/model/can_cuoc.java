// @author becacabe2002

package application.model;

import java.sql.Date;

public class can_cuoc {
	 private int ID; // not null
	 private String id_nk; // not null
	 private String so_cccd; // not null
	 private Date ngay_cap;// default current date
	 private String noi_cap;// default null
	 
	 public can_cuoc() {
		 
	 }
	 
	 public can_cuoc(int inputID, String inputID_nk, String input_cccd) {
		 this.ID = inputID;
		 this.id_nk = inputID_nk;
		 this.so_cccd = input_cccd;
		 // assume that nhan_khau have just created
		 java.util.Date CurrDate = new java.util.Date();
		 this.ngay_cap = new Date(CurrDate.getTime());
	 }
	 
	 public can_cuoc(int inputID,String inputID_nk, String input_cccd, Date ngay_cap) {
		 this.ID = inputID;
		 this.id_nk = inputID_nk;
		 this.so_cccd = input_cccd;
		 this.ngay_cap = ngay_cap;
	 }
	 
	 public can_cuoc(int inputID,String inputID_nk, String input_cccd, Date ngay_cap, String noi_cap) {
		 this.ID = inputID;
		 this.id_nk = inputID_nk;
		 this.so_cccd = input_cccd;
		 this.ngay_cap = ngay_cap;
		 this.noi_cap = noi_cap;
	 }
	
	public int getID() {
		return ID;
	}
	
	public String getId_nk() {
		return id_nk;
	}
	public void setId_nk(String id_nk) {
		this.id_nk = id_nk;
	}
	public String getSo_cccd() {
		return so_cccd;
	}
	public void setSo_cccd(String so_cccd) {
		this.so_cccd = so_cccd;
	}
	public Date getNgay_cap() {
		return ngay_cap;
	}
	public void setNgay_cap(Date ngay_cap) {
		this.ngay_cap = ngay_cap;
	}
	public String getNoi_cap() {
		return noi_cap;
	}
	public void setNoi_cap(String noi_cap) {
		this.noi_cap = noi_cap;
	}
	 
	 
}
