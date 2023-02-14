package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainUC1Controller {

    @FXML
    private Button HoKhauBtn;

    @FXML
    private Button HoKhau_addBtn;

    @FXML
    private Button HoKhau_changeOwnerBtn;

    @FXML
    private Button HoKhau_moveBtn;

    @FXML
    private TextField HoKhau_searchField;

    @FXML
    private Button HoKhau_splitBtn;

    @FXML
    private TableView<?> HoKhau_table;

    @FXML
    private TableColumn<?, ?> HoKhau_table_diaChi;

    @FXML
    private TableColumn<?, ?> HoKhau_table_id;

    @FXML
    private TableColumn<?, ?> HoKhau_table_maHK;

    @FXML
    private TableColumn<?, ?> HoKhau_table_maKV;

    @FXML
    private TableColumn<?, ?> HoKhau_table_ngayChuyen;

    @FXML
    private TableColumn<?, ?> HoKhau_table_ngayLap;

    @FXML
    private TableColumn<?, ?> HoKhau_table_nguoiTao;

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
    private TableView<?> NhanKhau_table;

    @FXML
    private TableColumn<?, ?> NhanKhau_table_Name;

    @FXML
    private TableColumn<?, ?> NhanKhau_table_creator;

    @FXML
    private TableColumn<?, ?> NhanKhau_table_dob;

    @FXML
    private TableColumn<?, ?> NhanKhau_table_id;

    @FXML
    private TableColumn<?, ?> NhanKhau_table_maHK;

    @FXML
    private TableColumn<?, ?> NhanKhau_table_nationality;

    @FXML
    private TableColumn<?, ?> NhanKhau_table_relation;

    @FXML
    private TableColumn<?, ?> NhanKhau_table_sex;

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
    private TableView<?> ThongKe_table;

    @FXML
    private TableColumn<?, ?> ThongKe_table_creator;

    @FXML
    private TableColumn<?, ?> ThongKe_table_dob;

    @FXML
    private TableColumn<?, ?> ThongKe_table_id;

    @FXML
    private TableColumn<?, ?> ThongKe_table_maHoKhau;

    @FXML
    private TableColumn<?, ?> ThongKe_table_name;

    @FXML
    private TableColumn<?, ?> ThongKe_table_nationality;

    @FXML
    private TableColumn<?, ?> ThongKe_table_relationOwner;

    @FXML
    private TableColumn<?, ?> ThongKe_table_sex;

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

    @FXML
    void switchWindowUC1(ActionEvent event) {
    	if(event.getSource() == TongQuanBtn) {
    		paneTongQuan.setVisible(true);
    		paneThongKe.setVisible(false);
    		paneNhanKhau.setVisible(false);
    		paneHoKhau.setVisible(false);
    	} else if(event.getSource() == NhanKhauBtn ) {
    		paneTongQuan.setVisible(false);
    		paneThongKe.setVisible(false);
    		paneNhanKhau.setVisible(true);
    		paneHoKhau.setVisible(false);
    	}else if(event.getSource() == HoKhauBtn ) {
    		paneTongQuan.setVisible(false);
    		paneThongKe.setVisible(false);
    		paneNhanKhau.setVisible(false);
    		paneHoKhau.setVisible(true);
    	}else {
    		paneTongQuan.setVisible(false);
    		paneThongKe.setVisible(true);
    		paneNhanKhau.setVisible(false);
    		paneHoKhau.setVisible(false);
    	}
    }

}

