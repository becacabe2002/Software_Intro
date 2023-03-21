// @author becacabe2002

package application.form.UC1;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import application.database.ConnectDatabase;

public class NK_addKTController {
	
	Connection con = ConnectDatabase.getConnection();
	
    @FXML
    private TextField input_IDKhai;

    @FXML
    private TextField input_IDMat;

    @FXML
    private TextArea lyDo;

    @FXML
    private DatePicker ngayMat;

    @FXML
    private Label notiLabel;

    @FXML
    void pressSubmit(ActionEvent event) {
    	String returnNoti = null;
    	int ID_khai, ID_mat;
    	String ly_do;
    	Date ngay_mat;
    	
    	String sql = "call khai_bao_tu(?,?,?,?,?);";
    	
    	ID_khai = Integer.parseInt(input_IDKhai.getText());
    	ID_mat = Integer.parseInt(input_IDMat.getText());
    	ly_do = lyDo.getText();
    	ngay_mat = Date.valueOf((LocalDate) ngayMat.getValue());
    	
    	try {
			CallableStatement newCal = con.prepareCall(sql);
			newCal.setInt(1, ID_mat);
			newCal.setInt(2, ID_khai);
			newCal.setDate(3, ngay_mat);
			newCal.setString(4, ly_do);
			
			newCal.registerOutParameter(5, Types.VARCHAR);
			
			newCal.execute();
			
			returnNoti = newCal.getString(5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	notiLabel.setText(returnNoti);
    }

}