// @author becacabe2002

package application.model;

import java.sql.Date;

public class khai_tu {
	private int ID; // pk,
	private int id_mat; //not null, -- foreign key toi NhanKhau('ID')
	private int id_khai;//not null, -- foreign key toi NhanKhau('ID') 
	private Date ngay_mat;//not null
	private Date ngay_khai; //not null default curdate()
	private String note; //default null -- nguyen nhan mat
	
	public khai_tu() {}
	
	public khai_tu(int ID, int id_mat, int id_khai, Date ngay_mat) {
		this.ID = ID;
		this.id_mat = id_mat;
		this.id_khai = id_khai;
		this.ngay_mat = ngay_mat;
		
		java.util.Date CurrDate = new java.util.Date();
		 this.ngay_khai = new Date(CurrDate.getTime());
	}
	
	public khai_tu(int ID, int id_mat, int id_khai, Date ngay_mat, String note) {
		this.ID = ID;
		this.id_mat = id_mat;
		this.id_khai = id_khai;
		this.ngay_mat = ngay_mat;
		this.note = note;
		
		java.util.Date CurrDate = new java.util.Date();
		 this.ngay_khai = new Date(CurrDate.getTime());
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getId_mat() {
		return id_mat;
	}

	public void setId_mat(int id_mat) {
		this.id_mat = id_mat;
	}

	public int getId_khai() {
		return id_khai;
	}

	public void setId_khai(int id_khai) {
		this.id_khai = id_khai;
	}

	public Date getNgay_mat() {
		return ngay_mat;
	}

	public void setNgay_mat(Date ngay_mat) {
		this.ngay_mat = ngay_mat;
	}

	public Date getNgay_khai() {
		return ngay_khai;
	}

	public void setNgay_khai(Date ngay_khai) {
		this.ngay_khai = ngay_khai;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
