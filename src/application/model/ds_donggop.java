package application.model;

import java.sql.Date;

public class ds_donggop {
	private int ID; //primary key auto_increment,
	private int id_nk;//not null, -- foreign key NhanKhau('ID')
    private String ma_donggop; //not null, -- foreign key DSDotDongGop('MaDSDongGop')
    private Date ngay_donggop; //not null, -- default curdate()
    private int tien_donggop; //not null
    
    public ds_donggop() {
    }
    
    public ds_donggop(int ID, int id_nk, String ma_donggop, int tien_donggop) {
    	
    	this.ID = ID;
    	this.id_nk = id_nk;
    	this.ma_donggop =  ma_donggop;
    	this.tien_donggop = tien_donggop;
    	// default curDate
    	java.util.Date CurrDate = new java.util.Date();
		 this.ngay_donggop = new Date(CurrDate.getTime());
    }
    
    public ds_donggop(int ID, int id_nk, String ma_donggop,Date ngay_donggop, int tien_donggop) {
    	
    	this.ID = ID;
    	this.id_nk = id_nk;
    	this.ma_donggop =  ma_donggop;
    	this.ngay_donggop = ngay_donggop;
    	this.tien_donggop = tien_donggop;
    	// default curDate
    	java.util.Date CurrDate = new java.util.Date();
		this.ngay_donggop = new Date(CurrDate.getTime());
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
