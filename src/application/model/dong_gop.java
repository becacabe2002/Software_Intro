// @author becacabe2002

package application.model;

import java.sql.Date;

public class dong_gop {
	private int ID;// not null
    private int id_nk;// not null
    private String ma_donggop;// not null
    private Date ngay_donggop;// default current date
    private int tien_donggop;// not null

    public dong_gop() {
    	
    }
    
    public dong_gop(int inputID, int inputID_nk, String inputMa, int inputTien) {
    	this.ID = inputID;
    	this.id_nk = inputID_nk;
    	this.ma_donggop = inputMa;
    	this.tien_donggop = inputTien;
    	java.util.Date CurrDate = new java.util.Date();
		 this.ngay_donggop = new Date(CurrDate.getTime());
    }
    
    
    public dong_gop(int inputID, int inputID_nk, String inputMa, Date inputNgay, int inputTien) {
    	this.ID = inputID;
    	this.id_nk = inputID_nk;
    	this.ma_donggop = inputMa;
    	this.ngay_donggop = inputNgay;
    	this.tien_donggop = inputTien;
    }
    
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getId_nk() {
		return id_nk;
	}
	public void setId_nk(int id_nk) {
		this.id_nk = id_nk;
	}
	public String getMa_donggop() {
		return ma_donggop;
	}
	public void setMa_donggop(String ma_donggop) {
		this.ma_donggop = ma_donggop;
	}
	public Date getNgay_donggop() {
		return ngay_donggop;
	}
	public void setNgay_donggop(Date ngay_donggop) {
		this.ngay_donggop = ngay_donggop;
	}
	public int getTien_donggop() {
		return tien_donggop;
	}
	public void setTien_donggop(int tien_donggop) {
		this.tien_donggop = tien_donggop;
	}
    
}
