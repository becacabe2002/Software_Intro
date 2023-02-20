package application.form.UC1;

import java.sql.Connection;
import java.sql.Date;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.database.ConnectDatabase;
import application.database.UserSession;
import application.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class HK_addNK_HKController implements Initializable{
	String username = UserSession.getInstance().getUsername();
	Connection con = ConnectDatabase.getConnection();
	private so_ho_khau selectedSHK = new so_ho_khau();
	private ObservableList<nhan_khau> selectMembers = FXCollections.observableArrayList();
	
    @FXML
    private Label HKLabel;
    
    @FXML
    private Label NotiLabel;

    @FXML
    private TableView<nhan_khau> newMemTable;

    @FXML
    private TableColumn<nhan_khau, Integer> newMemTable_ID;

    @FXML
    private TableColumn<nhan_khau, String> newMemTable_name;

    @FXML
    private Button submitBtn;

    @FXML
    void pressSubmitBtn(ActionEvent event) {
    	String sql = "call add_nk_hk(?,?,?,?);";
    	try {
    		CallableStatement callStm = con.prepareCall(sql);
    		ObservableList<nhan_khau> selectedNKList = newMemTable.getSelectionModel().getSelectedItems();
    		
    		for(int i = 0; i < selectedNKList.size(); i++) {
    			nhan_khau temp = selectedNKList.get(i);
    			callStm.setInt(1, this.selectedSHK.getID());
    			callStm.setInt(2, temp.getID());
    			callStm.setString(3, "Nguoi than");
    			callStm.setString(4, username);
    			
    			callStm.execute();
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	NotiLabel.setText("Nhân khẩu đã được thêm vào hộ khẩu !");
    }
    
    public ObservableList<nhan_khau> loadListNK(){
    	String sql = "select * from nhan_khau where id_hk is null;";
    	ObservableList<nhan_khau> temp = FXCollections.observableArrayList();
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql);
    		ResultSet res = ppStm.executeQuery();
    		
    		while(res.next()) {
				String name = res.getString("ho_ten");
				String creator = res.getString("nguoi_tao");
				Date dob = res.getDate("dob");
				int id = res.getInt("ID");
				int maHK = res.getInt("id_hk");
				String nation = res.getString("id_hk");
				String relation = res.getString("relation_owner");
				String sex = res.getString("sex");
				Date createDate = res.getDate("create_date");
				
				nhan_khau tempNK = new nhan_khau(id,maHK,name, dob, nation,sex,relation,creator,createDate);
				temp.add(tempNK);
	    	}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return temp;
    }
    
    public void displayNewMember() {
    	selectMembers = loadListNK();
    	
    	newMemTable_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	newMemTable_name.setCellValueFactory(new PropertyValueFactory<>("ho_ten"));
    	
    	newMemTable.setItems(selectMembers);
    	
    }
    
    public void setSelected(so_ho_khau inputSHK) {
    	this.selectedSHK = inputSHK;
    	HKLabel.setText(this.selectedSHK.getMa_shk());
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		displayNewMember();
		newMemTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

}
