// @author becacabe2002

package application.model;

import java.sql.Date;

public class tam_vang {
	private int ID;//primary key auto_increment,
	private int id_nk;//not null, -- foreign key toi NhanKhau('ID')
    private Date start_date;// not null,
    private Date end_date;// not null,
    private String destination;// varchar(100) not null,
    private String note; //default null
    
    public tam_vang() {}
    
    public tam_vang(int ID, int ID_nk, Date start, Date end, String dest) {
    	this.ID = ID;
    	this.id_nk = ID_nk;
    	this.start_date = start;
    	this.end_date = end;
    	this.destination = dest;
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

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
    
}
