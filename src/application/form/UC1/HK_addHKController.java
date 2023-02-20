package application.form.UC1;

import java.sql.Connection;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import application.database.*;
import application.model.nhan_khau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

public class HK_addHKController implements Initializable{

	Connection con = ConnectDatabase.getConnection();
	ObservableList<nhan_khau> chuHo = FXCollections.observableArrayList();
	
    @FXML
    private TableView<nhan_khau> chuHoTable;

    @FXML
    private TableColumn<nhan_khau, Integer> chuHoTable_id;

    @FXML
    private TableColumn<nhan_khau, String> chuHoTable_name;

    @FXML
    private TextArea input_diaChi;

    @FXML
    private TextField input_maKV;

    @FXML
    private TextField input_maSHK;

    @FXML
    private Label notiLabel;

    @FXML
    private Button taoMoiBtn;

    @FXML
    void press_taoMoiBtn(ActionEvent event) {
    	String maHK, maKV, diaChi, username;
    	String noti;
    	int idOwner;
    	
    	idOwner = chuHoTable.getSelectionModel().getSelectedItem().getID();
    	maHK = input_maSHK.getText();
    	maKV = input_maKV.getText();
    	diaChi = input_diaChi.getText();
    	
    	username = UserSession.getInstance().getUsername();
    	
    	String sql = "call create_hk(?,?,?,?,?)";
    	try {
//create_hk(IN ma_shk varchar(20), IN ma_kv varchar(20), 
// 	IN dia_chi varchar(100), IN id_owner int, IN username varchar(20))
    	CallableStatement cllStm = con.prepareCall(sql);
    	
    	cllStm.setString(1, maHK);
    	cllStm.setString(2, maKV);
    	cllStm.setString(3, diaChi);
    	cllStm.setInt(4, idOwner);
    	cllStm.setString(5, username);
    	
    	cllStm.execute();
    	
    	notiLabel.setTextFill(Color.GREEN);
    	notiLabel.setText("Hộ khẩu đã được tạo mới");
    	
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public ObservableList<nhan_khau> loadChuHo() {
    	ObservableList<nhan_khau> temp = FXCollections.observableArrayList();
    	String sql = "select * from nhan_khau where id_hk is null;";
    	try {
	    	PreparedStatement ppStm = con.prepareStatement(sql);
	    	ResultSet resChuHo = ppStm.executeQuery();
	    	
	    	while(resChuHo.next()) {
				String name = resChuHo.getString("ho_ten");
				String creator = resChuHo.getString("nguoi_tao");
				Date dob = resChuHo.getDate("dob");
				int id = resChuHo.getInt("ID");
				int maHK = resChuHo.getInt("id_hk");
				String nation = resChuHo.getString("id_hk");
				String relation = resChuHo.getString("relation_owner");
				String sex = resChuHo.getString("sex");
				Date createDate = resChuHo.getDate("create_date");
				
				nhan_khau tempNK = new nhan_khau(id,maHK,name, dob, nation,sex,relation,creator,createDate);
				temp.add(tempNK);
	    	}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return temp;
    }
    
    public void displayChuHo() {
    	chuHo = loadChuHo();
        chuHoTable_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        chuHoTable_name.setCellValueFactory(new PropertyValueFactory<>("ho_ten"));
        chuHoTable.setItems(chuHo);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		displayChuHo();
		
	}

}

