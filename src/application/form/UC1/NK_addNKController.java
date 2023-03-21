// @author becacabe2002

package application.form.UC1;

import java.sql.Connection;
import java.sql.Date;
import application.database.UserSession;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import application.database.*;

public class NK_addNKController {
	
	Connection con = ConnectDatabase.getConnection();
	
    @FXML
    private Button addNKBtn;

    @FXML
    private DatePicker input_DOB;

    @FXML
    private TextField input_DanToc;

    @FXML
    private TextField input_GioiTinh;

    @FXML
    private TextField input_HoTen;

    @FXML
    private TextField input_HocVan;

    @FXML
    private TextField input_NgheNghiep;

    @FXML
    private TextField input_NoiLV;

    @FXML
    private TextField input_TonGiao;
    
    @FXML
    private Label labelNoti;

    @FXML
    void pressAddBtn(ActionEvent event) {
    	String name, ethnicGroup, religion, hocVan, occupation;
    	String workAddress, sex;
    	Date dob, createDate;
    	
    	String creator = UserSession.getInstance().getUsername();
    	java.util.Date CurrDate = new java.util.Date();
		createDate = new Date(CurrDate.getTime());
		
		name = input_HoTen.getText();
		ethnicGroup = input_DanToc.getText();
		religion = input_TonGiao.getText();
		hocVan = input_HocVan.getText();
		occupation = input_NgheNghiep.getText();
		workAddress = input_NoiLV.getText();
		sex = input_GioiTinh.getText();
    	
		dob = Date.valueOf((LocalDate) input_DOB.getValue());
    	
    	String sql = "insert into nhan_khau(ho_ten, dob, sex, ethnic_group, religion, hoc_van,occupation, work_address, nguoi_tao, create_date)\n"
    				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    	try {
    	PreparedStatement preStm = con.prepareStatement(sql);
    	preStm.setString(1,name);
    	preStm.setDate(2, dob);
    	preStm.setString(3,sex);
    	preStm.setString(4,ethnicGroup);
    	preStm.setString(5, religion);
    	preStm.setString(6, hocVan);
    	preStm.setString(7, occupation);
    	preStm.setString(8, workAddress);
    	preStm.setString(9, creator);
    	preStm.setDate(10, createDate);
    	
    	preStm.execute();
    	
    	labelNoti.setText("Nhân khẩu đã được tạo mới.");
    	
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

}