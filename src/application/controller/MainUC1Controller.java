package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import application.database.ConnectDatabase;
import application.model.*;

public class MainUC1Controller implements Initializable{
	Connection con = null;
	ObservableList<nhan_khau> ObListNK = FXCollections.observableArrayList();
	ObservableList<so_ho_khau> ObListHK = FXCollections.observableArrayList();
	ObservableList<nhan_khau> filterListTK = FXCollections.observableArrayList();
	
	// node on HoKhau Pane
	
    @FXML
    private Button HoKhauBtn;

    @FXML
    private Button HoKhau_addBtn;

    @FXML
    private Button HoKhau_changeOwnerBtn;

    @FXML
    private Button HoKhau_moveBtn;
    
    @FXML
    private Button HoKhau_splitBtn;
    
    @FXML
    private TextField HoKhau_searchField;

    @FXML
    private TableView<so_ho_khau> HoKhau_table;

    @FXML
    private TableColumn<so_ho_khau, String> HoKhau_table_diaChi;

    @FXML
    private TableColumn<so_ho_khau, Integer> HoKhau_table_id;

    @FXML
    private TableColumn<so_ho_khau, String> HoKhau_table_maHK;

    @FXML
    private TableColumn<so_ho_khau, String> HoKhau_table_maKV;

    @FXML
    private TableColumn<so_ho_khau, Date> HoKhau_table_ngayChuyen;

    @FXML
    private TableColumn<so_ho_khau, Date> HoKhau_table_ngayLap;

    @FXML
    private TableColumn<so_ho_khau, String> HoKhau_table_nguoiTao;

// ---- nodes on NhanKhau Pane
    
    @FXML
    private Button NhanKhauBtn;

    @FXML
    private Button NhanKhau_addBtn;

    @FXML
    private Button NhanKhau_addKhaiTuBtn;

    @FXML
    private Button NhanKhau_addTamTruBtn;

    @FXML
    private Button NhanKhau_addTamVangBtn;

    @FXML
    private TextField NhanKhau_searchField;

    @FXML
    private TableView<nhan_khau> NhanKhau_table;

    @FXML
    private TableColumn<nhan_khau, String> NhanKhau_table_Name;

    @FXML
    private TableColumn<nhan_khau, String> NhanKhau_table_creator;

    @FXML
    private TableColumn<nhan_khau, Date> NhanKhau_table_dob;

    @FXML
    private TableColumn<nhan_khau, Integer> NhanKhau_table_id;

    @FXML
    private TableColumn<nhan_khau, String> NhanKhau_table_maHK;

    @FXML
    private TableColumn<nhan_khau, String> NhanKhau_table_nationality;

    @FXML
    private TableColumn<nhan_khau, String> NhanKhau_table_relation;

    @FXML
    private TableColumn<nhan_khau , String> NhanKhau_table_sex;

 // ---- nodes on ThongKe Pane
    
    @FXML
    private Button ThongKeBtn;

    @FXML
    private RadioButton ThongKe_FemaleFilter;

    @FXML
    private Button ThongKe_FilterBtn;

    @FXML
    private RadioButton ThongKe_MaleFilter;

    @FXML
    private TextField ThongKe_MaxAgeFilter;

    @FXML
    private RadioButton ThongKe_TamTruFilter;

    @FXML
    private RadioButton ThongKe_TamVangFilter;

    @FXML
    private TextField ThongKe_minAgeFilter;

    @FXML
    private TableView<nhan_khau> ThongKe_table;

    @FXML
    private TableColumn<nhan_khau, String> ThongKe_table_creator;

    @FXML
    private TableColumn<nhan_khau, Date> ThongKe_table_dob;

    @FXML
    private TableColumn<nhan_khau, Integer> ThongKe_table_id;

    @FXML
    private TableColumn<nhan_khau, String> ThongKe_table_maHoKhau;

    @FXML
    private TableColumn<nhan_khau, String> ThongKe_table_name;

    @FXML
    private TableColumn<nhan_khau, String> ThongKe_table_nationality;

    @FXML
    private TableColumn<nhan_khau, String> ThongKe_table_relationOwner;

    @FXML
    private TableColumn<nhan_khau, String> ThongKe_table_sex;
    
    // ---- nodes on TongQuan Pane
    
    @FXML
    private Button TongQuanBtn;

    @FXML
    private Label TongQuan_totalHK;

    @FXML
    private Label TongQuan_totalNK;

    @FXML
    private Label TongQuan_totalTamTru;

    @FXML
    private Label TongQuan_totalTamVang;

    
    @FXML
    private AnchorPane paneHoKhau;

    @FXML
    private AnchorPane paneNhanKhau;

    @FXML
    private AnchorPane paneThongKe;

    @FXML
    private AnchorPane paneTongQuan;
    
    //--- switch between pane
    // need a func to refresh data in table after switching
    @FXML
    void switchWindowUC1(ActionEvent event) {
    	if(event.getSource() == TongQuanBtn) {
    		paneTongQuan.setVisible(true);
    		paneThongKe.setVisible(false);
    		paneNhanKhau.setVisible(false);
    		paneHoKhau.setVisible(false);
    		displayTongQuan();
    		
    	} else if(event.getSource() == NhanKhauBtn ) {
    		paneTongQuan.setVisible(false);
    		paneThongKe.setVisible(false);
    		paneNhanKhau.setVisible(true);
    		paneHoKhau.setVisible(false);
    		displayNK();
    	}else if(event.getSource() == HoKhauBtn ) {
    		paneTongQuan.setVisible(false);
    		paneThongKe.setVisible(false);
    		paneNhanKhau.setVisible(false);
    		paneHoKhau.setVisible(true);
    		displayHK();
    	}else {
    		paneTongQuan.setVisible(false);
    		paneThongKe.setVisible(true);
    		paneNhanKhau.setVisible(false);
    		paneHoKhau.setVisible(false);
    	}
    }


    //--- load nhan khau data from db to 
    public ObservableList<nhan_khau> loadDataNhanKhau(){
    	ObservableList<nhan_khau> tempObList = FXCollections.observableArrayList();
    	String script1 = "select * from nhan_khau where note is null;";
    	PreparedStatement ppSt = null;
    	ResultSet RSetNK = null;
    	try {
			ppSt = con.prepareStatement(script1);
			RSetNK = ppSt.executeQuery();
			while(RSetNK.next()) {
//			    private TableColumn<nhan_khau, String> NhanKhau_table_Name;
				String name = RSetNK.getString("ho_ten");
//			    private TableColumn<nhan_khau, String> NhanKhau_table_creator;
				String creator = RSetNK.getString("nguoi_tao");
//			    private TableColumn<nhan_khau, Date> NhanKhau_table_dob;
				Date dob = RSetNK.getDate("dob");
//			    private TableColumn<nhan_khau, Integer> NhanKhau_table_id;
				int id = RSetNK.getInt("ID");
//			    private TableColumn<nhan_khau, String> NhanKhau_table_maHK;
				int maHK = RSetNK.getInt("id_hk");
//			    private TableColumn<nhan_khau, String> NhanKhau_table_nationality;
				String nation = RSetNK.getString("id_hk");
//			    private TableColumn<nhan_khau, String> NhanKhau_table_relation;
				String relation = RSetNK.getString("relation_owner");
//			    private TableColumn<nhan_khau , String> NhanKhau_table_sex;
				String sex = RSetNK.getString("sex");
				Date createDate = RSetNK.getDate("create_date");
				
				nhan_khau tempNK = new nhan_khau(id,maHK,name, dob, nation,sex,relation,creator,createDate);
				tempObList.add(tempNK);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return tempObList;
    	
    }
    
    public void displayNK() {
    	ObListNK = loadDataNhanKhau();
	    System.out.println(ObListNK.size());
	    NhanKhau_table_Name.setCellValueFactory(new PropertyValueFactory<>("ho_ten"));
	    NhanKhau_table_creator.setCellValueFactory(new PropertyValueFactory<>("nguoi_tao"));
	    NhanKhau_table_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
	    NhanKhau_table_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
	    NhanKhau_table_maHK.setCellValueFactory(new PropertyValueFactory<>("id_hk"));
	    NhanKhau_table_nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
	    NhanKhau_table_relation.setCellValueFactory(new PropertyValueFactory<>("relation_owner"));
	    NhanKhau_table_sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
	    
		NhanKhau_table.setItems(ObListNK);
    }
    
    public ObservableList<so_ho_khau> loadDataHoKhau(){
    	ObservableList<so_ho_khau> tempObList = FXCollections.observableArrayList();
    	String script1 = "select * from so_ho_khau;";
    	PreparedStatement ppSt = null;
    	ResultSet RSetHK = null;
    	try {
    	ppSt = con.prepareStatement(script1);
    	RSetHK = ppSt.executeQuery();
    	while(RSetHK.next()) {

    		so_ho_khau temp = new so_ho_khau(RSetHK.getInt("ID"),
						    				RSetHK.getString("ma_shk"), 
						    				RSetHK.getString("ma_kv"), 
						    				RSetHK.getString("dia_chi"), 
						    				RSetHK.getDate("ngay_lap"), 
						    				RSetHK.getString("nguoi_tao"));
    		tempObList.add(temp);
    	}
    	
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return tempObList; 
    }
    
    public void displayHK() {
    	ObListHK = loadDataHoKhau();
	    HoKhau_table_diaChi.setCellValueFactory(new PropertyValueFactory<>("dia_chi"));	    
	    HoKhau_table_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
	    HoKhau_table_maHK.setCellValueFactory(new PropertyValueFactory<>("ma_shk"));
	    HoKhau_table_maKV.setCellValueFactory(new PropertyValueFactory<>("ma_kv"));
	    HoKhau_table_ngayChuyen.setCellValueFactory(new PropertyValueFactory<>("ngay_chuyen"));
	    HoKhau_table_ngayLap.setCellValueFactory(new PropertyValueFactory<>("ngay_lap"));
	    HoKhau_table_nguoiTao.setCellValueFactory(new PropertyValueFactory<>("nguoi_tao"));
	    
	    HoKhau_table.setItems(ObListHK);
    }

    public void displayTongQuan() {
    	PreparedStatement ppSt = null;
    	ResultSet res = null;
        String totalHKScript = "select count(ID) from so_ho_khau;";
        String totalNKScript = "select count(ID) from nhan_khau where note is null;";
        String totalTamTruScript = "select count(ID) from tam_tru where end_date > curdate();";
        String totalTamVangScript = "select count(ID) from tam_vang where end_date > curdate();";
        try {
        ppSt = con.prepareStatement(totalHKScript);
        res = ppSt.executeQuery();
        if(res.next()) {
        	TongQuan_totalHK.setText(Integer.toString(res.getInt("count(ID)")));
        }
        res.close();
        ppSt.close();

        ppSt = con.prepareStatement(totalNKScript);
        res = ppSt.executeQuery();
        if(res.next()) {
        	TongQuan_totalNK.setText(Integer.toString(res.getInt("count(ID)")));
        }
        res.close();
        ppSt.close();
        
        ppSt = con.prepareStatement(totalTamTruScript);
        res = ppSt.executeQuery();
        if(res.next()) {
        	TongQuan_totalTamTru.setText(Integer.toString(res.getInt("count(ID)")));
        }
        res.close();
        ppSt.close();

        ppSt = con.prepareStatement(totalTamVangScript);
        res = ppSt.executeQuery();
        if(res.next()) {
        	TongQuan_totalTamVang.setText(Integer.toString(res.getInt("count(ID)")));
        }
        res.close();
        ppSt.close();
        
        } catch(SQLException e) {
        	e.printStackTrace();
        }
    }
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// connect db
		con = ConnectDatabase.getConnection();
	    displayHK();
		displayNK();
		displayTongQuan();
	}

}

