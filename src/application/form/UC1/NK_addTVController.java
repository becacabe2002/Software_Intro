package application.form.UC1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

import application.database.ConnectDatabase;
import application.model.nhan_khau;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class NK_addTVController {
	Connection con = ConnectDatabase.getConnection();
	private nhan_khau selectedNK = new nhan_khau();
    
	@FXML
    private TextField input_Dest;

    @FXML
    private DatePicker input_endDate;

    @FXML
    private TextField input_note;

    @FXML
    private DatePicker input_startDate;

    @FXML
    private Label returnNoti;

    @FXML
    private Label selected_ID;

    @FXML
    private Label selected_name;

    @FXML
    private Button submitBtn;

    @FXML
    void pressSubmitBtn(ActionEvent event) {
    	Date startDate, endDate;
    	String note, nameKhai, Dest;
    	String Notification;
    	int idKhai;
    	
    	startDate = Date.valueOf((LocalDate) input_startDate.getValue());
    	endDate = Date.valueOf((LocalDate) input_endDate.getValue());
    	
    	note = input_note.getText();
    	nameKhai = selectedNK.getHo_ten();
    	idKhai = selectedNK.getID();
    	
    	Dest = input_Dest.getText();
    	
    	/*
    	 * add_tam_tru procedure
    	 * 1. id_nguoi_khai
    	 * 2. startDate
    	 * 3. endDate
    	 * 4. Destination
    	 * 5. note
    	 * 6. (out) notification
    	 */
    	String sql = "call add_tam_vang(?,?,?,?,?,?);";
    	try {
    		CallableStatement callStm = con.prepareCall(sql);
    		callStm.setInt(1, idKhai);
    		callStm.setString(4, Dest);
    		callStm.setDate(2, startDate);
    		callStm.setDate(3, endDate);
    		callStm.setString(5, note);
    		
    		callStm.registerOutParameter(6, Types.VARCHAR);
    		
    		callStm.execute();
    		
    		Notification =  callStm.getString(6);
    		
    		if(Notification.equals("ID nguoi khai da mat")|| Notification.equals("Tam vang cua nguoi khai van con hieu luc")) {
    			returnNoti.setTextFill(Color.TOMATO);
    		} else {
    			returnNoti.setTextFill(Color.GREEN);
    		}
    		
    		returnNoti.setText(Notification);
    		
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void setSelectedNK(nhan_khau inputNK) {
    	this.selectedNK = inputNK;
    	selected_ID.setText(Integer.toString(this.selectedNK.getID()));
    	selected_name.setText(this.selectedNK.getHo_ten());
    }

}
