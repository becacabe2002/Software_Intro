package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MainUC2Controller {

// --> DongGop Pane
    @FXML
    private AnchorPane PaneDongGop;
	
    @FXML
    private Button DongGop_addDSBtn;

    @FXML
    private Button DongGop_addRecordBtn;

    @FXML
    private TableView<?> DongGop_tableDS;

    @FXML
    private TableColumn<?, ?> DongGop_tableDS_ID;

    @FXML
    private TableColumn<?, ?> DongGop_tableDS_ma;

    @FXML
    private TableColumn<?, ?> DongGop_tableDS_ngayTao;

    @FXML
    private TableColumn<?, ?> DongGop_tableDS_nguoiTao;

    @FXML
    private TableColumn<?, ?> DongGop_tableDS_tenDS;

    @FXML
    private TableView<?> DongGop_tableRecord;

    @FXML
    private TableColumn<?, ?> DongGop_tableRecord_ID;

    @FXML
    private TableColumn<?, ?> DongGop_tableRecord_Sotien;

    @FXML
    private TableColumn<?, ?> DongGop_tableRecord_idNK;

    @FXML
    private TableColumn<?, ?> DongGop_tableRecord_nameNK;

    @FXML
    private TableColumn<?, ?> DongGop_tableRecord_ngayDong;

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
    private TableView<?> Phi_tableDS;

    @FXML
    private TableColumn<?, ?> Phi_tableDS_ID;

    @FXML
    private TableColumn<?, ?> Phi_tableDS_Ma;

    @FXML
    private TableColumn<?, ?> Phi_tableDS_Ten;

    @FXML
    private TableColumn<?, ?> Phi_tableDS_ngayTao;

    @FXML
    private TableColumn<?, ?> Phi_tableDS_nguoiTao;

    @FXML
    private TableView<?> Phi_tableRecord;

    @FXML
    private TableColumn<?, ?> Phi_tableRecord_ID;

    @FXML
    private TableColumn<?, ?> Phi_tableRecord_fee;

    @FXML
    private TableColumn<?, ?> Phi_tableRecord_idHK;

    @FXML
    private TableColumn<?, ?> Phi_tableRecord_ngayDong;

    @FXML
    private TableColumn<?, ?> Phi_tableRecord_status;

    @FXML
    private Label Phi_total_label;

//--> Thong Ke Pane
    @FXML
    private AnchorPane PaneThongKe;

    @FXML
    private Button ThongKeBtn;

    @FXML
    private TableView<?> Thongke_tableDongGop;

    @FXML
    private TableColumn<?, ?> Thongke_tableDongGop_ID;

    @FXML
    private TableColumn<?, ?> Thongke_tableDongGop_TenDS;

    @FXML
    private TableColumn<?, ?> Thongke_tableDongGop_maDG;

    @FXML
    private TableColumn<?, ?> Thongke_tableDongGop_ngayTao;

    @FXML
    private TableColumn<?, ?> Thongke_tableDongGop_nguoiTao;

    @FXML
    private TableView<?> Thongke_tablePhi;

    @FXML
    private TableColumn<?, ?> Thongke_tablePhi_ID;

    @FXML
    private TableColumn<?, ?> Thongke_tablePhi_maPhi;

    @FXML
    private TableColumn<?, ?> Thongke_tablePhi_ngayTao;

    @FXML
    private TableColumn<?, ?> Thongke_tablePhi_nguoiTao;

    @FXML
    private TableColumn<?, ?> Thongke_tablePhi_tenPhi;

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
    	}else if(event.getSource() == PhiBtn) {
    		PaneThongKe.setVisible(false);
    		PanePhi.setVisible(true);
    		PaneDongGop.setVisible(false);
    	} else {
    		PaneThongKe.setVisible(false);
    		PanePhi.setVisible(false);
    		PaneDongGop.setVisible(true);
    	}
    }

}

