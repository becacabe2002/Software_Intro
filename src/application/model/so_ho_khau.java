package application.model;

import java.sql.Date;

public class so_ho_khau {
	private int ID; // not null
	private String ma_shk; // not null
	private String ma_kv; // not null
	private String dia_chi; // not null
	private Date ngay_lap; // not null
	private Date ngay_chuyen;// default null
	private String lydo_chuyen;// default null
	private String nguoi_tao;// not null
	
	public so_ho_khau() {
		
	}
	
	
	public so_ho_khau(int ID, String ma_shk, String ma_kv, String dia_chi, Date ngay_lap, String nguoi_tao) {
		this.ID = ID;
		this.ma_shk = ma_shk;
		this.ma_kv = ma_kv;
		this.dia_chi = dia_chi;
		this.ngay_lap = ngay_lap;
		this.nguoi_tao = nguoi_tao;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setNgay_lap(Date ngay_lap) {
		this.ngay_lap = ngay_lap;
	}
	public void setNgay_chuyen(Date ngay_chuyen) {
		this.ngay_chuyen = ngay_chuyen;
	}
	
	public Date getNgay_lap() {
		return ngay_lap;
	}
	public Date getNgay_chuyen() {
		return ngay_chuyen;
	}
	public String getMa_shk() {
		return ma_shk;
	}
	public void setMa_shk(String ma_shk) {
		this.ma_shk = ma_shk;
	}
	public String getMa_kv() {
		return ma_kv;
	}
	public void setMa_kv(String ma_kv) {
		this.ma_kv = ma_kv;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getNguoi_tao() {
		return nguoi_tao;
	}
	public void setNguoi_tao(String nguoi_tao) {
		this.nguoi_tao = nguoi_tao;
	}

	public String getLydo_chuyen() {
		return lydo_chuyen;
	}

	public void setLydo_chuyen(String lydo_chuyen) {
		this.lydo_chuyen = lydo_chuyen;
	}
	
}
