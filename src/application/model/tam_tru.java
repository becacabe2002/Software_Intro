package application.model;

import java.sql.Date;

public class tam_tru {
	private int ID;  
	private int id_nk;//not null, -- foreign key toi NhanKhau('ID')
    private int sdt; //default null,
    private Date start_date; //not null,
    private Date end_date;// not null,
    private String note; //default null

    public tam_tru() {
    	
    }
    
    public tam_tru(int ID, int ID_nk, Date start, Date end) {
    	this.ID = ID;
    	this.id_nk = ID_nk;
    	this.start_date = start;
    	this.end_date = end;
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

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
    
    
    
}
