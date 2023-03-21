// @author becacabe2002

package application.model;

import java.sql.Date;
import application.database.UserSession;

public class changes_history {
	private int ID ;// unique not null,
	private String username; //not null,  -- foreign key toi Users(username)
	private int id_hk; //not null, -- foreign key toi so_ho_khau(ID)
	private String changed_info;//not null,
	private String old_info; //not null,
	private String new_info; //not null,
	private Date change_date; //not null-- default curdate()
	
	public changes_history() {}
	
	public changes_history(int ID, int id_hk, String changed_info, String old_info, String new_info) {
		this.ID = ID;
		this.username = UserSession.getInstance().getUsername();// set creator for current user
		this.id_hk = id_hk;
		this.changed_info = changed_info;
		this.old_info = old_info;
		this.new_info = new_info;
		// set the change_date by default is current date
		java.util.Date CurDate = new java.util.Date();
		this.change_date = new Date(CurDate.getTime());
	}
	
	public changes_history(int ID,String username,int id_hk, String changed_info, String old_info, String new_info, Date change_date) {
		this.ID = ID;
		this.username = username;
		this.id_hk = id_hk;
		this.changed_info = changed_info;
		this.old_info = old_info;
		this.new_info = new_info;
		this.change_date = change_date;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId_hk() {
		return id_hk;
	}
	public void setId_hk(int id_hk) {
		this.id_hk = id_hk;
	}
	public String getChanged_info() {
		return changed_info;
	}
	public void setChanged_info(String changed_info) {
		this.changed_info = changed_info;
	}
	public String getOld_info() {
		return old_info;
	}
	public void setOld_info(String old_info) {
		this.old_info = old_info;
	}
	public String getNew_info() {
		return new_info;
	}
	public void setNew_info(String new_info) {
		this.new_info = new_info;
	}
	public Date getChange_date() {
		return change_date;
	}
	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}
	
	
}
