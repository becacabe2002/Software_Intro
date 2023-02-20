package application.form.UC1;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.time.LocalDate;

import application.model.nhan_khau;
import application.database.ConnectDatabase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class NK_addTTController{
	Connection con = ConnectDatabase.getConnection();
	private nhan_khau selectedNK = new nhan_khau();

    @FXML
    private TextField input_Note;

    @FXML
    private TextField input_SDT;

    @FXML
    private DatePicker input_endDate;

    @FXML
    private DatePicker input_startDate;

    @FXML
    private Label returnNoti;

    @FXML
    private Label selectedID;

    @FXML
    private Label selectedName;

    @FXML
    private Button submitBtn;

    @FXML
    void pressSubmitBtn(ActionEvent event) {
    	Date startDate, endDate;
    	String note, nameKhai;
    	String Notification;
    	int idKhai, sdt;
    	
    	startDate = Date.valueOf((LocalDate) input_startDate.getValue());
    	endDate = Date.valueOf((LocalDate) input_endDate.getValue());
    	
    	note = input_Note.getText();
    	nameKhai = selectedNK.getHo_ten();
    	idKhai = selectedNK.getID();
    	
    	sdt = Integer.parseInt(input_SDT.getText());
    	
    	/*
    	 * add_tam_tru procedure
    	 * 1. id_nguoi_khai
    	 * 2. sdt
    	 * 3. startDate
    	 * 4. endDate
    	 * 5. note
    	 * 6. (out) notification
    	 */
    	String sql = "call add_tam_tru(?,?,?,?,?,?);";
    	try {
    		CallableStatement callStm = con.prepareCall(sql);
    		callStm.setInt(1, idKhai);
    		callStm.setInt(2, sdt);
    		callStm.setDate(3, startDate);
    		callStm.setDate(4, endDate);
    		callStm.setString(5, note);
    		
    		callStm.registerOutParameter(6, Types.VARCHAR);
    		
    		callStm.execute();
    		
    		Notification =  callStm.getString(6);
    		
    		if(Notification.equals("ID nguoi khai da mat")|| Notification.equals("Tam tru cua nguoi khai van con hieu luc")) {
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
    	selectedID.setText(Integer.toString(this.selectedNK.getID()));
    	selectedName.setText(this.selectedNK.getHo_ten());
    }
        
}

