package application.model;

import java.sql.Date;
import application.database.UserSession;
import testLogin.User;

public class nhan_khau {
	private int ID; // not null
	private int id_hk;// default null
	private String ho_ten;// not null
	private Date dob;// not null
	private String nationality = "VN";// default value
	private String sex; // not null
	private String ethnic_group; // not null
	private String religion; // default null
	private String hoc_van; // default null
	private String occupation;// default null
	private String work_address;// default null
	private String address;// default null -- the same with home
	private String relation_owner; // default null
	private String nguoi_tao;//not null
	private Date create_date;//not null
	private String note;//default null
	
	public nhan_khau() {}
	// this constructor used when adding nhan_khau
	public nhan_khau(int ID, int id_hk, String ho_ten, 
			Date dob, String sex, String ethnic_group) {
		this.ID = ID;
		this.id_hk = id_hk;
		this.ho_ten = ho_ten;
		this.dob = dob;
		this.sex = sex;
		this.ethnic_group = ethnic_group;
		this.nguoi_tao = UserSession.getInstance().getUsername();
		java.util.Date CurrDate = new java.util.Date();
		this.create_date = new Date(CurrDate.getTime());
	}
	
	public nhan_khau(int ID, int id_hk, String ho_ten, Date dob, String nation, String sex,
					String relation_owner, String creator, Date createDate) {
		this.ID = ID;
		this.id_hk = id_hk;
		this.ho_ten = ho_ten;
		this.dob = dob;
		this.nationality = nation;
		this.sex = sex;
		this.relation_owner = relation_owner;
		this.nguoi_tao = creator;
		this.create_date = createDate;
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
	public String getHo_ten() {
		return ho_ten;
	}
	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEthnic_group() {
		return ethnic_group;
	}
	public void setEthnic_group(String ethnic_group) {
		this.ethnic_group = ethnic_group;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getHoc_van() {
		return hoc_van;
	}
	public void setHoc_van(String hoc_van) {
		this.hoc_van = hoc_van;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getWork_address() {
		return work_address;
	}
	public void setWork_address(String work_address) {
		this.work_address = work_address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRelation_owner() {
		return relation_owner;
	}
	public void setRelation_owner(String relation_owner) {
		this.relation_owner = relation_owner;
	}
	public String getNguoi_tao() {
		return nguoi_tao;
	}
	public void setNguoi_tao(String nguoi_tao) {
		this.nguoi_tao = nguoi_tao;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String toString() {
		String temp = this.ho_ten.toUpperCase() 
				+ "\n- ID: " + this.ID 
				+ "\n- ID Hộ Khẩu: "+ this.id_hk
				+ "\n- Giới tính: " + sex
				+ "\n- Ngày sinh: " + this.dob
				+ "\n- Quốc tịch: " + this.nationality 
				+ "\n- Dân tộc: "+ this.ethnic_group
				+ "\n- Tôn giáo: "+ this.religion
				+ "\n- Tôn giáo: "+ this.hoc_van
				+ "\n- Nghề nghiệp: " + occupation
				+ "\n- Nơi làm việc: " + this.work_address
				+ "\n- Địa chỉ hiện tại: "+ this.address
				+ "\n- Mối quan hệ với chủ hộ: "+ this.relation_owner
				+ "\n- Người tạo: " + this.nguoi_tao
				+ "\n- Ngày tạo: " + this.create_date.toString()
				+ "\n- Ghi chú: "+ note;
		return temp;
	}
}
