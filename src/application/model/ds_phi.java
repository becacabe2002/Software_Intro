package application.model;

import java.sql.Date;
import application.database.UserSession;

/*
 * Lop ghi lai cac danh sach cac khoan phi ma ho gia dinh phai dong
 * 
 */
public class ds_phi {
	private int ID;//primary key auto_increment,
	private String ma_phi; //unique not null,
    private String ten_phi; //not null,
    private float tien_per_nk; //not null, -- So tien can dong voi moi nhan khau
    private String nguoi_tao;//not null, -- foreign key toi users(username)
    private Date ngay_tao; //not null -- default curdate()
    
    public ds_phi() {
    	
    }
    
    public ds_phi(int ID, String ma_phi, String ten_phi, float tien_per_nk) {
    	this.ID = ID;
    	this.ma_phi = ma_phi;
    	this.ten_phi = ten_phi;
    	this.tien_per_nk = tien_per_nk;
    	this.nguoi_tao = UserSession.getInstance().getUsername();
    	
    	java.util.Date CurrDate = new java.util.Date();
		 this.ngay_tao = new Date(CurrDate.getTime());
		 
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMa_phi() {
		return ma_phi;
	}

	public void setMa_phi(String ma_phi) {
		this.ma_phi = ma_phi;
	}

	public String getTen_phi() {
		return ten_phi;
	}

	public void setTen_phi(String ten_phi) {
		this.ten_phi = ten_phi;
	}

	public float getTien_per_nk() {
		return tien_per_nk;
	}

	public void setTien_per_nk(float tien_per_nk) {
		this.tien_per_nk = tien_per_nk;
	}

	public String getNguoi_tao() {
		return nguoi_tao;
	}

	public void setNguoi_tao(String nguoi_tao) {
		this.nguoi_tao = nguoi_tao;
	}

	public Date getNgay_tao() {
		return ngay_tao;
	}

	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
    
    
}
