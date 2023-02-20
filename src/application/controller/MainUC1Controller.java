package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import application.database.ConnectDatabase;
import application.database.UserSession;
import application.form.UC1.*;
import application.model.*;

public class MainUC1Controller implements Initializable{
	/*
	 * formStage is used for creating new popup window
	 * whenever user press buttons;
	 */
	Connection con = null;
	ObservableList<nhan_khau> ObListNK = FXCollections.observableArrayList();
	ObservableList<nhan_khau> filterListNK = FXCollections.observableArrayList();
	ObservableList<so_ho_khau> ObListHK = FXCollections.observableArrayList();
	ObservableList<so_ho_khau> filterListHK = FXCollections.observableArrayList();
	ObservableList<nhan_khau> filterListThongKe = FXCollections.observableArrayList();
	
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
    private Button HoKhau_addNKHKBtn;
    
    @FXML
    private Button HoKhau_changeHistory;
    
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

    
    //--- load data from db to 
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
	    // System.out.println(ObListNK.size());
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
	
    public ObservableList<nhan_khau> loadDataThongKe(){
    	ObservableList<nhan_khau> tempObList = FXCollections.observableArrayList();
    	//filter_TK (IN inputSex VARCHAR(10),IN startDate Date, IN endDate Date, IN tt_tv varchar(10))
    	String script1 = "call filter_TK(?,?,?,?);";
    	CallableStatement callSt = null;
    	ResultSet RSetNK = null;
    	
    	String input_sex = null;
		Date input_startDate, input_endDate;
		String input_status = null;
		
		// -- get info sex filter
		if (ThongKe_FemaleFilter.isSelected() && !ThongKe_MaleFilter.isSelected()) {
			input_sex = "Female";
		} else if (!ThongKe_FemaleFilter.isSelected() && ThongKe_MaleFilter.isSelected()) {
			input_sex = "Male";
		}else {
			input_sex = null;
		}
		
		//-- get info status filter
		if (ThongKe_TamVangFilter.isSelected() && !ThongKe_TamTruFilter.isSelected()) {
			input_status = "tamvang";
		} else if (!ThongKe_TamVangFilter.isSelected() && ThongKe_TamTruFilter.isSelected()) {
			input_status = "tamtru";
		}else {
			input_status = null;
		}
		
		//-- get info age filter
		if (ThongKe_MaxAgeFilter.getText() != null && ThongKe_minAgeFilter.getText() == "") {
			String maxYearString = ThongKe_minAgeFilter.getText();
			maxYearString = maxYearString + "-12-31";
			input_endDate = Date.valueOf(maxYearString);
			
			String minYearString = "1900-01-01";
			input_startDate = Date.valueOf(minYearString);
		}else if (ThongKe_minAgeFilter.getText() != null && ThongKe_MaxAgeFilter.getText() == "") {
			String minYearString = ThongKe_minAgeFilter.getText();
			minYearString = minYearString + "-01-01";
			input_startDate = Date.valueOf(minYearString);
			
			java.util.Date CurrDate = new java.util.Date();
			input_endDate = new Date(CurrDate.getTime());
		}else if (ThongKe_minAgeFilter.getText() == "" && ThongKe_MaxAgeFilter.getText() == "") {
			String minYearString = "1900-01-01";
			input_startDate = Date.valueOf(minYearString);
			
			java.util.Date CurrDate = new java.util.Date();
			input_endDate = new Date(CurrDate.getTime());
		}else {// not null
			String maxYearString = ThongKe_MaxAgeFilter.getText();
			maxYearString = maxYearString + "-12-31";
			input_endDate = Date.valueOf(maxYearString);
			
			String minYearString = ThongKe_minAgeFilter.getText();
			minYearString = minYearString + "-01-01";
			input_startDate = Date.valueOf(minYearString);
		}
    	
    	try {
			callSt = con.prepareCall(script1);
			// data from filter
			/*
			 * sex: Male or Female
			 * startDate
			 * endDate
			 * status: tamtru or tamvang or null
			 */
			
			callSt.setString(1, input_sex);
			callSt.setDate(2, input_startDate);
			callSt.setDate(3, input_endDate);
			callSt.setString(4, input_status);
			
			RSetNK = callSt.executeQuery();
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
    
    
    public void displayThongKe() {
    	filterListThongKe = loadDataThongKe();
    	
    	ThongKe_table_name.setCellValueFactory(new PropertyValueFactory<>("ho_ten"));
	    ThongKe_table_creator.setCellValueFactory(new PropertyValueFactory<>("nguoi_tao"));
	    ThongKe_table_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
	    ThongKe_table_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
	    ThongKe_table_maHoKhau.setCellValueFactory(new PropertyValueFactory<>("id_hk"));
	    ThongKe_table_nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
	    ThongKe_table_relationOwner.setCellValueFactory(new PropertyValueFactory<>("relation_owner"));
	    ThongKe_table_sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
	    
	    ThongKe_table.setItems(filterListThongKe);
    }
    
// --> Button event handler for Pane Nhan Khau
    @FXML
    public void pressBtn_addKT(ActionEvent e) {
			try {
				Parent formPar = FXMLLoader.load(getClass().getResource("/application/form/UC1/NK_addKT.fxml"));
				Stage formStage = new Stage();
	    		formStage.setScene(new Scene(formPar));
	    		formStage.setTitle("Khai tử");
	    		formStage.show();
	    		
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   	}
    
    
    @FXML
    public void pressBtn_newNK(ActionEvent e) {
		try {
			Parent formPar = FXMLLoader.load(getClass().getResource("/application/form/UC1/NK_addNK.fxml"));
			Stage formStage = new Stage();
    		formStage.setScene(new Scene(formPar));
    		formStage.setTitle("Thêm Nhân khẩu");
    		formStage.show();
    		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    @FXML
    public void pressBtn_addTT(ActionEvent e) {
		try {
			FXMLLoader ld = new FXMLLoader(getClass().getResource("/application/form/UC1/NK_addTT.fxml"));
			Parent formPar = ld.load();
			NK_addTTController tempCtrl = ld.getController();
			tempCtrl.setSelectedNK(NhanKhau_table.getSelectionModel().getSelectedItem());
			Stage formStage = new Stage();
    		formStage.setScene(new Scene(formPar));
    		formStage.setTitle("Đăng kí tạm trú");
    		formStage.show();
    		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    @FXML
    public void pressBtn_addTV(ActionEvent e) {
		try {
			FXMLLoader ld = new FXMLLoader(getClass().getResource("/application/form/UC1/NK_addTV.fxml"));
			Parent formPar = ld.load();
			NK_addTVController tempCtrl = ld.getController();
			tempCtrl.setSelectedNK(NhanKhau_table.getSelectionModel().getSelectedItem());
			Stage formStage = new Stage();
    		formStage.setScene(new Scene(formPar));
    		formStage.setTitle("Đăng kí tạm vắng");
    		formStage.show();
    		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
// --> Button event handler for Pane Ho Khau
    
    //Done
    @FXML
    public void pressBtn_addHK(ActionEvent e) {
    	try {
			Parent formPar = FXMLLoader.load(getClass().getResource("/application/form/UC1/HK_addHK.fxml"));
			Stage formStage = new Stage();
    		formStage.setScene(new Scene(formPar));
    		formStage.setTitle("Tạo sổ hộ khẩu mới");
    		formStage.show();
    		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    //Done
    @FXML
    public void pressBtn_addNKHK(ActionEvent e) {
    	try {
    		FXMLLoader ld = new FXMLLoader(getClass().getResource("/application/form/UC1/HK_addNK_HK.fxml"));
			Parent formPar = ld.load();
			HK_addNK_HKController ctr = ld.getController();
			ctr.setSelected(HoKhau_table.getSelectionModel().getSelectedItem());
			Stage formStage = new Stage();
    		formStage.setScene(new Scene(formPar));
    		formStage.setTitle("Thêm Nhân Khẩu vào Hộ Khẩu");
    		formStage.show();
    		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    @FXML
    public void pressBtn_splitHK(ActionEvent e) {
    	
    }
    
    @FXML
    public void pressBtn_moveHK(ActionEvent e) {
    	TextInputDialog dialog = new TextInputDialog();
    	so_ho_khau tempHK = HoKhau_table.getSelectionModel().getSelectedItem();
    	dialog.setTitle("Thay đổi địa chỉ hộ khẩu");
    	dialog.setHeaderText(null);
    	Label oldAddress = new Label("Địa chỉ hiện tại của hộ:\n" + "*" +tempHK.getDia_chi()+"*");
    	
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	
    	TextField newAddress = new TextField();
    	newAddress.setPromptText("Địa chỉ mới");
    	TextField reason = new TextField();
    	reason.setPromptText("Lý do chuyển");
    	
    	grid.add(oldAddress, 0, 0);
    	grid.add(new Label("Nhập địa chỉ:"), 0, 1);
    	grid.add(newAddress, 1, 1);
    	grid.add(new Label("Nhập lý do:"), 0, 2);
    	grid.add(reason, 1, 2);

    	dialog.getDialogPane().setContent(grid);

    	Optional<String> result = dialog.showAndWait();
    	if (result.isPresent()) {
    	    String newDiaChi = newAddress.getText();
    	    String lyDo = reason.getText();
    	    // IN id_hk int, IN newDest varchar(100),IN lydo varchar(100), IN username varchar(100)
    	    String sql = "call move_hk(?,?,?,?);";
    	    try {
    	    CallableStatement callStm = con.prepareCall(sql); 
    	    callStm.setInt(1, tempHK.getID());
    	    callStm.setString(2, newDiaChi);
    	    callStm.setString(3, lyDo);
    	    callStm.setString(4, UserSession.getInstance().getUsername());
    	    
    	    callStm.execute();
    	    
    	    } catch(SQLException exc) {
    	    	exc.printStackTrace();
    	    }
    	}
    }
    
    
    @FXML
    public void pressBtn_changeOwner(ActionEvent e) {
    	try {
    		FXMLLoader ld = new FXMLLoader(getClass().getResource("/application/form/UC1/HK_changeOwner.fxml"));
			Parent formPar = ld.load();
			HK_changeOwnerController ctr = ld.getController();
			ctr.setSelected(HoKhau_table.getSelectionModel().getSelectedItem());
			Stage formStage = new Stage();
    		formStage.setScene(new Scene(formPar));
    		formStage.setTitle("Thay đổi chủ hộ của hộ khẩu");
    		formStage.show();
    		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    // Done
    @FXML
    public void pressBtn_changesHis(ActionEvent e) {
    	try {
    		FXMLLoader ld = new FXMLLoader(getClass().getResource("/application/form/UC1/HK_changesHistory.fxml"));
			Parent formPar = ld.load();
			HK_changesHistoryController ctr = ld.getController();
			ctr.setSelected(HoKhau_table.getSelectionModel().getSelectedItem());
			Stage formStage = new Stage();
    		formStage.setScene(new Scene(formPar));
    		formStage.setTitle("Lịch sử thay đổi sổ hộ khẩu");
    		formStage.show();
    		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    
// --> Button event handler for Pane Thong Ke
    @FXML
    public void pressFilterBtn(ActionEvent e) {
    	displayThongKe();
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// connect db
		con = ConnectDatabase.getConnection();
	    displayHK();
		displayNK();
		displayTongQuan();
		
		// display detail nhan khau on double click
		NhanKhau_table.setOnMouseClicked(event->{
			if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
				Alert dialog = new Alert(AlertType.INFORMATION);
				dialog.setTitle("Thông tin nhân khẩu");
				dialog.setContentText(NhanKhau_table.getSelectionModel().getSelectedItem().toString());
				dialog.showAndWait();
			}
		});
		HoKhau_table.setOnMouseClicked(event ->{
			if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
				Alert dialog = new Alert(AlertType.INFORMATION);
				dialog.setTitle("Thông tin hộ khẩu");
				dialog.setContentText(HoKhau_table.getSelectionModel().getSelectedItem().toString());
				dialog.showAndWait();
			}
		});
	}

}

