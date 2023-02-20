package application.model;

import java.sql.Date;

public class thu_phi {
	private int ID; //primary key auto_increment,
	private int id_hk; //not null, -- foreign key HoKhau('ID')
    private String ma_phi; //varchar(10) not null, -- foreign key ds_phi(ma_phi)
    private int fee_hk;// not null, -- = tien_per_nk * so NhanKhau
    private boolean pay_state; //default false, -- true cho da dong, false cho chua dong
    private Date pay_date; //default null
    
    public thu_phi() {
    	
    }
    public thu_phi(int ID, int id_hk, String ma_phi, int total_fee) {
    	this.ID = ID;
    	this.id_hk = id_hk;
    	this.ma_phi = ma_phi;
    	this.fee_hk = total_fee;
    }
    
    public thu_phi(int ID, int id_hk, String ma_phi, int total_fee, boolean state, Date payDate) {
    	this.ID = ID;
    	this.id_hk = id_hk;
    	this.ma_phi = ma_phi;
    	this.fee_hk = total_fee;
    	this.pay_state = state;
		 this.pay_date = payDate;
    }
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getId_hk() {
		return id_hk;
	}
	public void setId_hk(int id_hk) {
		this.id_hk = id_hk;
	}
	public String getMa_phi() {
		return ma_phi;
	}
	public void setMa_phi(String ma_phi) {
		this.ma_phi = ma_phi;
	}
	public int getFee_hk() {
		return fee_hk;
	}
	public void setFee_hk(int fee_hk) {
		this.fee_hk = fee_hk;
	}
	public boolean isPay_state() {
		return pay_state;
	}
	public void setPay_state(boolean pay_state) {
		this.pay_state = pay_state;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
    
    
}
