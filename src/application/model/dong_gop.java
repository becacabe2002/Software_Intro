package application.model;

import java.util.Date;

public class dong_gop {
	private int ID;
    private int id_nk;
    private String ma_donggop;
    private Date ngay_donggop;
    private int tien_donggop;
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
