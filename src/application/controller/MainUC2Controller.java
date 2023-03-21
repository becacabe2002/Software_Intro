// @author becacabe2002

package application.controller;

import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

//import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.collections.FXCollections;

import application.database.*;
import application.form.UC2.*;
import application.model.*;

import java.sql.Date;


public class MainUC2Controller implements Initializable{
	Connection con = ConnectDatabase.getConnection();
	String currentUser = UserSession.getInstance().getUsername();
	ObservableList<ds_donggop> ObListDSDongGop = FXCollections.observableArrayList();
	ObservableList<ds_phi> ObListDSPhi = FXCollections.observableArrayList();
	ObservableList<thu_phi> ObListThuPhi = FXCollections.observableArrayList();
	ObservableList<dong_gop> ObListDongGop = FXCollections.observableArrayList();
	
// --> DongGop Pane
    @FXML
    private AnchorPane PaneDongGop;
	
    @FXML
    private Button DongGop_addDSBtn;

    @FXML
    private Button DongGop_addRecordBtn;

    @FXML
    private TableView<ds_donggop> DongGop_tableDS;

    @FXML
    private TableColumn<ds_donggop, Integer> DongGop_tableDS_ID;

    @FXML
    private TableColumn<ds_donggop, String> DongGop_tableDS_ma;

    @FXML
    private TableColumn<ds_donggop, Date> DongGop_tableDS_ngayTao;

    @FXML
    private TableColumn<ds_donggop, String> DongGop_tableDS_nguoiTao;

    @FXML
    private TableColumn<ds_donggop, String> DongGop_tableDS_tenDS;

    @FXML
    private TableView<dong_gop> DongGop_tableRecord;

    @FXML
    private TableColumn<dong_gop, Integer> DongGop_tableRecord_ID;

    @FXML
    private TableColumn<dong_gop, Integer> DongGop_tableRecord_Sotien;

    @FXML
    private TableColumn<dong_gop, Integer> DongGop_tableRecord_idNK;

    @FXML
    private TableColumn<dong_gop, String> DongGop_tableRecord_maDonggop;

    @FXML
    private TableColumn<dong_gop, Date> DongGop_tableRecord_ngayDong;

    @FXML
    private Label DongGop_total_label;

    @FXML
    private Button DonggopBtn;

// --> Phi Pane
    
    @FXML
    private AnchorPane PanePhi;

    @FXML
    private Button PhiBtn;

    @FXML
    private Button Phi_addPhiBtn;

    @FXML
    private Button Phi_addRecordBtn;

    @FXML
    private TableView<ds_phi> Phi_tableDS;

    @FXML
    private TableColumn<ds_phi, Integer> Phi_tableDS_ID;

    @FXML
    private TableColumn<ds_phi, String> Phi_tableDS_Ma;

    @FXML
    private TableColumn<ds_phi, String> Phi_tableDS_Ten;

    @FXML
    private TableColumn<ds_phi, Date> Phi_tableDS_ngayTao;

    @FXML
    private TableColumn<ds_phi, String> Phi_tableDS_nguoiTao;

    @FXML
    private TableView<thu_phi> Phi_tableRecord;

    @FXML
    private TableColumn<thu_phi, Integer> Phi_tableRecord_ID;

    @FXML
    private TableColumn<thu_phi, Integer> Phi_tableRecord_fee;

    @FXML
    private TableColumn<thu_phi, Integer> Phi_tableRecord_idHK;

    @FXML
    private TableColumn<thu_phi, Date> Phi_tableRecord_ngayDong;

    @FXML
    private TableColumn<thu_phi, Boolean> Phi_tableRecord_status;

    @FXML
    private Label Phi_total_label;

//--> Thong Ke Pane
    @FXML
    private AnchorPane PaneThongKe;

    @FXML
    private Button ThongKeBtn;

    @FXML
    private TableView<ds_donggop> Thongke_tableDongGop;

    @FXML
    private TableColumn<ds_donggop, Integer> Thongke_tableDongGop_ID;

    @FXML
    private TableColumn<ds_donggop, String> Thongke_tableDongGop_TenDS;

    @FXML
    private TableColumn<ds_donggop, String> Thongke_tableDongGop_maDG;

    @FXML
    private TableColumn<ds_donggop, Date> Thongke_tableDongGop_ngayTao;

    @FXML
    private TableColumn<ds_donggop, String> Thongke_tableDongGop_nguoiTao;

    @FXML
    private TableView<ds_phi> Thongke_tablePhi;

    @FXML
    private TableColumn<ds_phi, Integer> Thongke_tablePhi_ID;

    @FXML
    private TableColumn<ds_phi, String> Thongke_tablePhi_maPhi;

    @FXML
    private TableColumn<ds_phi, Date> Thongke_tablePhi_ngayTao;

    @FXML
    private TableColumn<ds_phi, String> Thongke_tablePhi_nguoiTao;

    @FXML
    private TableColumn<ds_phi, String> Thongke_tablePhi_tenPhi;

    @FXML
    private Label percentageNumberPhi;

    @FXML
    private StackPane stackPaneUC2;

    @FXML
    private Label totalDongGop;

    @FXML
    private Label totalNumberDG;

    @FXML
    private Label totalPhi;

    @FXML
    void switchWindowUC2(ActionEvent event) {
    	if(event.getSource() == ThongKeBtn) {
    		PaneThongKe.setVisible(true);
    		PanePhi.setVisible(false);
    		PaneDongGop.setVisible(false);
    		displayDSPhi_TKPane();
    		displayDSDonggop_TKPane();
    	}else if(event.getSource() == PhiBtn) {
    		PaneThongKe.setVisible(false);
    		PanePhi.setVisible(true);
    		PaneDongGop.setVisible(false);
    		displayDSPhi_PhiPane();
    	} else {
    		PaneThongKe.setVisible(false);
    		PanePhi.setVisible(false);
    		PaneDongGop.setVisible(true);
    		displayDSDonggop_DonggopPane();
    	}
    }
    
    // load data from db
    public ObservableList<ds_phi> loadDS_Phi(){
    	ObservableList<ds_phi> temp = FXCollections.observableArrayList();
    	
    	String sql = "select * from ds_phi;";
    	try {
    	PreparedStatement ppStm = con.prepareStatement(sql);
    	ResultSet res = ppStm.executeQuery();
// public ds_phi(int ID, String ma_phi, String ten_phi, int tien_per_nk, String creator, Date ngay_tao)
    	while(res.next()) {
    		ds_phi tempDsPhi = new ds_phi(res.getInt("ID"), res.getString("ma_phi"), res.getString("ten_phi")
    				,res.getInt("tien_per_nk"), res.getString("nguoi_tao"), res.getDate("ngay_tao"));
    		
    		temp.add(tempDsPhi);
    	}
    	
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return temp;
    }
    
    public ObservableList<ds_donggop> loadDS_Donggop(){
    	ObservableList<ds_donggop> temp = FXCollections.observableArrayList();
    	String sql = "select * from ds_donggop;";
    	
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql);
    		ResultSet res = ppStm.executeQuery();
// ds_donggop(int ID, String ma_donggop, String creator,String ten_ds, Date ngay_tao)
    		while (res.next()) {
    			ds_donggop tempDsDonggop = new ds_donggop(res.getInt("ID"),
    													res.getString("ma_donggop"),
    													res.getString("nguoi_tao"),
    													res.getString("ten_ds_donggop"),
    													res.getDate("ngay_tao"));
    			temp.add(tempDsDonggop);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return temp;
    }
    
    public void displayDSDonggop_TKPane() {
    	ObListDSDongGop = loadDS_Donggop();
    	Thongke_tableDongGop_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	Thongke_tableDongGop_maDG.setCellValueFactory(new PropertyValueFactory<>("ma_donggop"));
    	Thongke_tableDongGop_ngayTao.setCellValueFactory(new PropertyValueFactory<>("ngay_tao"));
    	Thongke_tableDongGop_nguoiTao.setCellValueFactory(new PropertyValueFactory<>("nguoi_tao"));
    	Thongke_tableDongGop_TenDS.setCellValueFactory(new PropertyValueFactory<>("ten_ds_donggop"));
    	
    	Thongke_tableDongGop.setItems(ObListDSDongGop);
    }
    
    public void displayDSDonggop_DonggopPane() {
    	ObListDSDongGop = loadDS_Donggop();
    	DongGop_tableDS_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	DongGop_tableDS_ma.setCellValueFactory(new PropertyValueFactory<>("ma_donggop"));
    	DongGop_tableDS_ngayTao.setCellValueFactory(new PropertyValueFactory<>("ngay_tao"));
    	DongGop_tableDS_nguoiTao.setCellValueFactory(new PropertyValueFactory<>("nguoi_tao"));
    	DongGop_tableDS_tenDS.setCellValueFactory(new PropertyValueFactory<>("ten_ds_donggop"));
    	
    	DongGop_tableDS.setItems(ObListDSDongGop);
    }
    
    public void displayDSPhi_TKPane() {
    	ObListDSPhi = loadDS_Phi();
    	Thongke_tablePhi_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	Thongke_tablePhi_maPhi.setCellValueFactory(new PropertyValueFactory<>("ma_phi"));;
    	Thongke_tablePhi_ngayTao.setCellValueFactory(new PropertyValueFactory<>("ngay_tao"));
    	Thongke_tablePhi_nguoiTao.setCellValueFactory(new PropertyValueFactory<>("nguoi_tao"));
    	Thongke_tablePhi_tenPhi.setCellValueFactory(new PropertyValueFactory<>("ten_phi"));
        
        Thongke_tablePhi.setItems(ObListDSPhi);
    }
    
    public void displayDSPhi_PhiPane() {
    	ObListDSPhi = loadDS_Phi();
    	Phi_tableDS_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	Phi_tableDS_Ma.setCellValueFactory(new PropertyValueFactory<>("ma_phi"));;
    	Phi_tableDS_ngayTao.setCellValueFactory(new PropertyValueFactory<>("ngay_tao"));
    	Phi_tableDS_nguoiTao.setCellValueFactory(new PropertyValueFactory<>("nguoi_tao"));
    	Phi_tableDS_Ten.setCellValueFactory(new PropertyValueFactory<>("ten_phi"));
        
    	Phi_tableDS.setItems(ObListDSPhi);
    }
 // Pane Phi
    
    public ObservableList<thu_phi> loadSelectedPhi(ds_phi inputDs){
    	ObservableList<thu_phi> temp = FXCollections.observableArrayList();
    	String input_maPhi = inputDs.getMa_phi();
    	String sql = "select * from thu_phi where ma_phi = ? and pay_state is not null;";
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql);
    		ppStm.setString(1, input_maPhi);
    		
    		ResultSet res = ppStm.executeQuery();
// thu_phi(int ID, int id_hk, String ma_phi, int total_fee, boolean state) 
    		while(res.next()) {
    			thu_phi tempRecord = new thu_phi(res.getInt("ID"), 
    											res.getInt("id_hk"), 
    											res.getString("ma_phi"),
    											res.getInt("fee_hk"),
    											res.getBoolean("pay_state"),
    											res.getDate("pay_date"));
    			temp.add(tempRecord);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return temp;
    }
    
    public void displayselectPhi(ds_phi inputDS) {
    	ObListThuPhi = loadSelectedPhi(inputDS);
        Phi_tableRecord_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Phi_tableRecord_fee.setCellValueFactory(new PropertyValueFactory<>("fee_hk"));
        Phi_tableRecord_idHK.setCellValueFactory(new PropertyValueFactory<>("id_hk"));
        Phi_tableRecord_ngayDong.setCellValueFactory(new PropertyValueFactory<>("pay_date"));
        Phi_tableRecord_status.setCellValueFactory(new PropertyValueFactory<>("pay_state"));
        Phi_tableRecord.setItems(ObListThuPhi);
        
        Phi_tableRecord.setItems(ObListThuPhi);
    }
    
    public int getTotalPaidPhi(String ma_phi) {
    	int res = 0;
    	
    	String sql = "select sum(fee_hk) from thu_phi where ma_phi = ? and pay_state = true;";
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql);
    		
    		ppStm.setString(1, ma_phi);
    		
    		ResultSet RSSet = ppStm.executeQuery();
    		while(RSSet.next()) {
    			res = RSSet.getInt("sum(fee_hk)");	
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return res;
    }

    @FXML 
    public void pressAddDSPhiBtn(ActionEvent e) {
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Thêm DS thu phí");
    	dialog.setHeaderText("Tạo DS thu phí mới");
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	
    	TextField newMaPhi = new TextField();
    	TextField newTenPhi = new TextField();
    	TextField newTienPhi = new TextField();
    	
    	grid.add(new Label("Mã phí mới: "), 0, 0);
    	grid.add(newMaPhi, 1, 0);
    	grid.add(new Label("Tên phí mới: "), 0, 1);
    	grid.add(newTenPhi, 1, 1);
    	grid.add(new Label("Tiền cần đóng/nhân khẩu: "), 0, 2);
    	grid.add(newTienPhi, 1, 2);
    	
    	dialog.getDialogPane().setContent(grid);
    	Optional<String> result = dialog.showAndWait();
    	if(result.isPresent()) {
    		String StrMaPhi = newMaPhi.getText();
    		String StrTenPhi = newTenPhi.getText();
    		int IntTienPhi = Integer.parseInt(newTienPhi.getText());
    		
    		java.util.Date CurrDate = new java.util.Date();
   		 	Date tempDate = new Date(CurrDate.getTime());
    		
    		String sql = "insert into ds_phi(ma_phi, ten_phi, tien_per_nk, nguoi_tao, ngay_tao)"
    				+ "values (?,?,?,?,?)";
    		try {
    			PreparedStatement ppStm = con.prepareStatement(sql);
    			ppStm.setString(1, StrMaPhi);
    			ppStm.setString(2, StrTenPhi);
    			ppStm.setInt(3, IntTienPhi);
    			ppStm.setString(4, currentUser);
    			ppStm.setDate(5, tempDate);
    			
    			ppStm.execute();
    			
    		} catch(SQLException exc) {
    			exc.printStackTrace();
    		}
    		
    	}
    }
    
    @FXML
    public void pressAddRecordPhiBtn(ActionEvent e) {
    	String selecteDS = Phi_tableDS.getSelectionModel().getSelectedItem().getMa_phi();
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Ghi nhận đóng phí");
    	dialog.setHeaderText(null);
    	dialog.setContentText("Nhập mã hộ khẩu:");

    	Optional<String> result = dialog.showAndWait();
    	if (result.isPresent()) {
    	    int inputMaSHK = Integer.parseInt(result.get());
    	    String sql = "update thu_phi set pay_state = true where ma_phi = ? and id_hk = ?;";
    	    try {
    	    PreparedStatement ppStm = con.prepareStatement(sql);
    	    ppStm.setInt(2, inputMaSHK);
    	    ppStm.setString(1, selecteDS);
    	    
    	    ppStm.execute();
    	    
    	    } catch(SQLException exc) {
    	    	exc.printStackTrace();
    	    }
    	}
    }
    
    public String getDisplayPaidRatio(String ma_phi) {
    	int paid = 0;
    	String sql1 = "select count(ID) from thu_phi where ma_phi = ? and pay_state = true;";
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql1);
    		
    		ppStm.setString(1, ma_phi);
    		
    		ResultSet RSSet = ppStm.executeQuery();
    		while(RSSet.next()) {
    			paid = RSSet.getInt("count(ID)");	
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	int total = 0;
    	String sql2 = "select count(ID) from thu_phi where ma_phi = ?;";
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql2);
    		
    		ppStm.setString(1, ma_phi);
    		
    		ResultSet RSSet = ppStm.executeQuery();
    		while(RSSet.next()) {
    			total = RSSet.getInt("count(ID)");	
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return paid + "/" + total;
    }
    
// Pane Dong gop
    public ObservableList<dong_gop> loadSelecteDonggop(ds_donggop inputDs){
    	ObservableList<dong_gop> temp = FXCollections.observableArrayList();
    	String input_maDonggop = inputDs.getMa_donggop();
    	String sql = "select * from dong_gop where ma_donggop = ?;";
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql);
    		ppStm.setString(1, input_maDonggop);
    		
    		ResultSet res = ppStm.executeQuery();
// dong_gop(int inputID, int inputID_nk, String inputMa, Date inputNgay, int inputTien)
    		while(res.next()) {
    			dong_gop tempRecord = new dong_gop(res.getInt("ID"), 
    											res.getInt("id_nk"), 
    											res.getString("ma_donggop"),
    											res.getDate("ngay_donggop"),
    											res.getInt("tien_donggop"));
    											
    			temp.add(tempRecord);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return temp;
    }
    
    public void displayselectDonggop(ds_donggop inputDS) {
    	ObListDongGop = loadSelecteDonggop(inputDS);
        DongGop_tableRecord_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        DongGop_tableRecord_Sotien.setCellValueFactory(new PropertyValueFactory<>("tien_donggop"));
        DongGop_tableRecord_idNK.setCellValueFactory(new PropertyValueFactory<>("id_nk"));
        DongGop_tableRecord_maDonggop.setCellValueFactory(new PropertyValueFactory<>("ma_donggop"));
        DongGop_tableRecord_ngayDong.setCellValueFactory(new PropertyValueFactory<>("ngay_donggop"));

        DongGop_tableRecord.setItems(ObListDongGop);
    }
    
    public int getTotalDonggop(String ma_donggop) {
    	int res = 0;
    	String sql = "select sum(tien_donggop) from dong_gop where ma_donggop = ?";
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql);
    		
    		ppStm.setString(1, ma_donggop);
    		
    		ResultSet RSSet = ppStm.executeQuery();
    		while(RSSet.next()) {
    			res = RSSet.getInt("sum(tien_donggop)");	
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return res;
    }
    
    @FXML
    public void pressAddDSDonggopBtn(ActionEvent e) {
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Thêm DS ghi nhận đóng góp");
    	dialog.setHeaderText("Tạo DS ghi nhận");
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	
    	TextField newMaDongGop = new TextField();
    	TextField newTenDongGop = new TextField();
    	
    	grid.add(new Label("Mã Đóng góp mới: "), 0, 0);
    	grid.add(newMaDongGop, 1, 0);
    	grid.add(new Label("Tên danh sách mới: "), 0, 1);
    	grid.add(newTenDongGop, 1, 1);
    	
    	dialog.getDialogPane().setContent(grid);
    	Optional<String> result = dialog.showAndWait();
    	if(result.isPresent()) {
    		String StrMaDonggop = newMaDongGop.getText();
    		String StrTenDonggop = newTenDongGop.getText();
    		
    		java.util.Date CurrDate = new java.util.Date();
   		 	Date tempDate = new Date(CurrDate.getTime());
    		
    		String sql = "insert into ds_donggop(ma_donggop, nguoi_tao, ten_ds_donggop, ngay_tao)"
    				+ "values (?,?,?,?)";
    		try {
    			PreparedStatement ppStm = con.prepareStatement(sql);
    			ppStm.setString(1, StrMaDonggop);
    			ppStm.setString(2, currentUser);
    			ppStm.setString(3, StrTenDonggop);
    			ppStm.setDate(4, tempDate);
    			
    			ppStm.execute();
    			
    		} catch(SQLException exc) {
    			exc.printStackTrace();
    		}
    		
    	}
    }
    
    @FXML
    public void pressAddRecordDonggopBtn(ActionEvent e) {
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Ghi nhận đóng góp cá nhân");
    	dialog.setHeaderText("Ghi nhận đóng góp:");
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	
    	TextField inputID_nk = new TextField();
    	TextField inputSoTien = new TextField();
    	
    	grid.add(new Label("Mã nhân khẩu đóng góp: "), 0, 0);
    	grid.add(inputID_nk, 1, 0);
    	grid.add(new Label("Số tiền đóng góp: "), 0, 1);
    	grid.add(inputSoTien, 1, 1);
    	
    	dialog.getDialogPane().setContent(grid);
    	Optional<String> result = dialog.showAndWait();
    	if(result.isPresent()) {
    		int IDNhanKhau = Integer.parseInt(inputID_nk.getText());
    		int SoTien = Integer.parseInt(inputSoTien.getText());
    		
    		java.util.Date CurrDate = new java.util.Date();
   		 	Date tempDate = new Date(CurrDate.getTime());
    		
   		 	String StrSelectDS = DongGop_tableDS.getSelectionModel().getSelectedItem().getMa_donggop();
   		 	
    		String sql = "insert into dong_gop(id_nk, ma_donggop, ngay_donggop, tien_donggop)"
    				+ "values (?,?,?,?)";
    		try {
    			PreparedStatement ppStm = con.prepareStatement(sql);
    			ppStm.setInt(1, IDNhanKhau);
    			ppStm.setString(2, StrSelectDS);
    			ppStm.setDate(3, tempDate);
    			ppStm.setInt(4, SoTien);
    			
    			ppStm.execute();
    			
    		} catch(SQLException exc) {
    			exc.printStackTrace();
    		}
    		
    	}
    }
    
    public int getNumberDonggop(String ma_donggop) {
    	int res = 0;
    	String sql = "select count(ID) from dong_gop where ma_donggop = ?";
    	try {
    		PreparedStatement ppStm = con.prepareStatement(sql);
    		
    		ppStm.setString(1, ma_donggop);
    		
    		ResultSet RSSet = ppStm.executeQuery();
    		while(RSSet.next()) {
    			res = RSSet.getInt("count(ID)");	
    		}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return res;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		displayDSPhi_TKPane();
		displayDSDonggop_TKPane();
		displayDSPhi_PhiPane();
		displayDSDonggop_DonggopPane();
		
		Thongke_tablePhi.setOnMouseClicked(event->{
			if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
				Alert dialog = new Alert(AlertType.INFORMATION);
				dialog.setTitle("Thông tin danh sách phí");
				dialog.setContentText(Thongke_tablePhi.getSelectionModel().getSelectedItem().toString());
				dialog.showAndWait();
			}else if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1) {
				ds_phi temp = Thongke_tablePhi.getSelectionModel().getSelectedItem();
				int total = getTotalPaidPhi(temp.getMa_phi());
				totalPhi.setText(total + ".$");
				percentageNumberPhi.setText(getDisplayPaidRatio(temp.getMa_phi()));
			}
		});
		Thongke_tableDongGop.setOnMouseClicked(event->{
			if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
				Alert dialog = new Alert(AlertType.INFORMATION);
				dialog.setTitle("Thông tin danh sách đóng góp");
				dialog.setContentText(Thongke_tableDongGop.getSelectionModel().getSelectedItem().toString());
				dialog.showAndWait();
			} else if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1){
				ds_donggop temp = Thongke_tableDongGop.getSelectionModel().getSelectedItem();
				int total = getTotalDonggop(temp.getMa_donggop());
				totalDongGop.setText(total + ".$");
				int number = getNumberDonggop(temp.getMa_donggop());
				totalNumberDG.setText(Integer.toString(number));
				
			}
		});
		
		Phi_tableDS.setOnMouseClicked(event->{
			if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
				Alert dialog = new Alert(AlertType.INFORMATION);
				dialog.setTitle("Thông tin danh sách phí");
				dialog.setContentText(Phi_tableDS.getSelectionModel().getSelectedItem().toString());
				dialog.showAndWait();
			}else if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1) {
				ds_phi temp = Phi_tableDS.getSelectionModel().getSelectedItem();
				displayselectPhi(temp);
				int total = getTotalPaidPhi(temp.getMa_phi());
				Phi_total_label.setText(total + ".$");
				
			}
		});
		
		DongGop_tableDS.setOnMouseClicked(event->{
			if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
				Alert dialog = new Alert(AlertType.INFORMATION);
				dialog.setTitle("Thông tin danh sách đóng góp");
				dialog.setContentText(DongGop_tableDS.getSelectionModel().getSelectedItem().toString());
				dialog.showAndWait();
			}else if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1) {
				ds_donggop temp = DongGop_tableDS.getSelectionModel().getSelectedItem();
				displayselectDonggop(temp);
				int total = getTotalDonggop(temp.getMa_donggop());
				DongGop_total_label.setText(total + ".$");
			}
		});
		
	
	}
    

}

