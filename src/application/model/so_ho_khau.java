package application.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.database.ConnectDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
	
	public String toString() {
		String returnStr;
		Connection con =  ConnectDatabase.getConnection();
		ObservableList<nhan_khau> tempObListNK = FXCollections.observableArrayList();
    	String sql = "select * from nhan_khau where id_hk = ?;";
    	try {
	    	PreparedStatement ppStm = con.prepareStatement(sql);
	    	ppStm.setInt(1, this.ID);
	    	ResultSet res = ppStm.executeQuery();
	    	
	    	while(res.next()) {
				String name = res.getString("ho_ten");
				String creator = res.getString("nguoi_tao");
				Date dob = res.getDate("dob");
				int id = res.getInt("ID");
				int maHK = res.getInt("id_hk");
				String nation = res.getString("id_hk");
				String relation = res.getString("relation_owner");
				String sex = res.getString("sex");
				Date createDate = res.getDate("create_date");
				
				nhan_khau tempNK = new nhan_khau(id,maHK,name, dob, nation,sex,relation,creator,createDate);
				tempObListNK.add(tempNK);
	    	}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	StringBuffer bufferMem = new StringBuffer();
    	for(int i = 0; i < tempObListNK.size(); i++) {
    		nhan_khau nk = tempObListNK.get(i);
    		bufferMem.append("\n- " + nk.getHo_ten() + " (" + nk.getRelation_owner() + ")");
    		if (nk.getNote() != null) {
    			bufferMem.append("\n    +" + nk.getNote().toUpperCase());
    		}
    	}
    	
    	returnStr = "* Sổ hộ khẩu: " + this.ma_shk
    				+ "\n* Mã khu vực: " + this.ma_kv
    				+ "\n* Địa chỉ hiện tại: " + this.dia_chi
    				+ "\n* Ngày lập: " + this.ngay_lap.toString()
    				+ "\n* Người tạo: " + this.nguoi_tao
    				+ "\n* Các thành viên trong gia đình:" + bufferMem.toString();
    	
    	if (this.ngay_chuyen != null && this.lydo_chuyen != null) {
    		returnStr = returnStr + "\n* Ngày chuyển đi gần nhất: " + this.ngay_chuyen.toString()
						+ "\n* Lý do chuyển:" + this.lydo_chuyen;
    	}
    	return returnStr;
	}
	
}
