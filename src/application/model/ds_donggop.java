// @author becacabe2002

package application.model;

import java.sql.Date;

public class ds_donggop {
    
    private int ID;
    private String ma_donggop;
    private String nguoi_tao;
    private String ten_ds_donggop;
    private Date ngay_tao; // default curdate()
    
    public ds_donggop() {
    }
    
    
    public ds_donggop(int ID, String ma_donggop, String creator,String ten_ds, Date ngay_tao) {
    	this.ID = ID;
    	this.ma_donggop = ma_donggop;
    	this.nguoi_tao = creator;
    	this.ten_ds_donggop = ten_ds;
    	this.ngay_tao = ngay_tao;
    
    }


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getMa_donggop() {
		return ma_donggop;
	}


	public void setMa_donggop(String ma_donggop) {
		this.ma_donggop = ma_donggop;
	}


	public String getNguoi_tao() {
		return nguoi_tao;
	}


	public void setNguoi_tao(String nguoi_tao) {
		this.nguoi_tao = nguoi_tao;
	}


	public String getTen_ds_donggop() {
		return ten_ds_donggop;
	}


	public void setTen_ds_donggop(String ten_ds_donggop) {
		this.ten_ds_donggop = ten_ds_donggop;
	}


	public Date getNgay_tao() {
		return ngay_tao;
	}


	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
    
    public String toString() {
    	String returnStr;
    	returnStr = "Danh sách Đóng Góp "+ this.ten_ds_donggop + " - " +this.ma_donggop
    			+ "\n Người tạo: " + this.nguoi_tao
    			+ "\n Ngày tạo: " + this.ngay_tao.toString();
    	return returnStr;
    }
   
}
