package application.model;

import java.time.*;

public class so_ho_khau {
	// id duoc set tang tu dong sau khi do du lieu
	private String ma_shk;
	private String ma_kv;
	private String dia_chi;
	private LocalDate ngay_lap;
	private LocalDate ngay_chuyen;
	private String nguoi_tao;
	
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
	public LocalDate getNgay_lap() {
		return ngay_lap;
	}
	public void setNgay_lap(LocalDate ngay_lap) {
		this.ngay_lap = ngay_lap;
	}
	public LocalDate getNgay_chuyen() {
		return ngay_chuyen;
	}
	public void setNgay_chuyen(LocalDate ngay_chuyen) {
		this.ngay_chuyen = ngay_chuyen;
	}
	public String getNguoi_tao() {
		return nguoi_tao;
	}
	public void setNguoi_tao(String nguoi_tao) {
		this.nguoi_tao = nguoi_tao;
	}
}
