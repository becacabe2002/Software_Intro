// @author becacabe2002

package application.form.UC1;

import application.model.*;
import application.database.*;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class HK_changeOwnerController {
	private so_ho_khau selectedSHK = new so_ho_khau();
	Connection con = ConnectDatabase.getConnection();
	String username = UserSession.getInstance().getUsername();
	ObservableList<nhan_khau> newChuHo = FXCollections.observableArrayList();

    @FXML
    private TableView<nhan_khau> newChuHoTable;

    @FXML
    private TableColumn<nhan_khau, Integer> newChuHoTable_id;

    @FXML
    private TableColumn<nhan_khau, Integer> newChuHoTable_name;

    @FXML
    private TextArea oldChuHoInfo;

    @FXML
    private Label returnNoti;

    @FXML
    private Button submitBtn;

    @FXML
    void pressSubmitBtn(ActionEvent event) {
    	// IN id_hk int, IN id_newCH int, IN username varchar(20)
    	String sql = "call change_owner(?,?,?);";
    	try {
    		CallableStatement callStm = con.prepareCall(sql);
    		callStm.setInt(1, this.selectedSHK.getID());
    		callStm.setInt(2, this.newChuHoTable.getSelectionModel().getSelectedItem().getID());
    		callStm.setString(3, username);
    		
    		ResultSet temp = callStm.executeQuery();
    		
    		returnNoti.setText("Chu ho da duoc thay doi!");
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void setSelected(so_ho_khau input) {
    	this.selectedSHK = input;
    	oldChuHoInfo.setText(this.selectedSHK.toString());
    	displayDataNewChuHo();
    }
    
    public ObservableList<nhan_khau> loadDataNewChuHo() {
    	ObservableList<nhan_khau> returnObList = FXCollections.observableArrayList();
    	
    	String sql = "select * from nhan_khau where id_hk = ? and relation_owner = 'Nguoi than';";
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql);
    		ppStm.setInt(1, this.selectedSHK.getID());
    		
    		ResultSet rs = ppStm.executeQuery();
    		
    		while(rs.next()) {
    			String name = rs.getString("ho_ten");
				String creator = rs.getString("nguoi_tao");
				Date dob = rs.getDate("dob");
				int id = rs.getInt("ID");
				int maHK = rs.getInt("id_hk");
				String nation = rs.getString("id_hk");
				String relation = rs.getString("relation_owner");
				String sex = rs.getString("sex");
				Date createDate = rs.getDate("create_date");
				
				nhan_khau tempNK = new nhan_khau(id,maHK,name, dob, nation,sex,relation,creator,createDate);
				returnObList.add(tempNK);
    		}
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return returnObList;
    }
    
    public void displayDataNewChuHo() {
    	newChuHo = loadDataNewChuHo();
    	newChuHoTable_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	newChuHoTable_name.setCellValueFactory(new PropertyValueFactory<>("ho_ten"));
    	
    	newChuHoTable.setItems(newChuHo);
    }

}

