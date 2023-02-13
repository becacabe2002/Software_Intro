package application.model;

import java.time.LocalDate;

public class can_cuoc {
	 private int ID;
	 private String id_nk;
	 private String so_cccd;
	 private LocalDate ngay_cap;
	 private String noi_cap;
	 
	 
	 public can_cuoc(int inputID, String inputID_nk, String input_cccd) {
		 this.ID = inputID;
		 this.id_nk = inputID_nk;
		 this.so_cccd = input_cccd;
	 }
	 
	 public can_cuoc(int inputID,String inputID_nk, String input_cccd, LocalDate ngay_cap) {
		 this.ID = inputID;
		 this.id_nk = inputID_nk;
		 this.so_cccd = input_cccd;
		 this.ngay_cap = ngay_cap;
	 }
	 
	 public can_cuoc(int inputID,String inputID_nk, String input_cccd, LocalDate ngay_cap, String noi_cap) {
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
	public LocalDate getNgay_cap() {
		return ngay_cap;
	}
	public void setNgay_cap(LocalDate ngay_cap) {
		this.ngay_cap = ngay_cap;
	}
	public String getNoi_cap() {
		return noi_cap;
	}
	public void setNoi_cap(String noi_cap) {
		this.noi_cap = noi_cap;
	}
	 
	 
}
