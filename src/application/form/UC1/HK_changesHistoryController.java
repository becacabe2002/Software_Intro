// @author becacabe2002

package application.form.UC1;

import java.sql.Date;
// import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
// import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import application.model.changes_history;
import application.model.so_ho_khau;
import application.database.ConnectDatabase;

public class HK_changesHistoryController {
	private so_ho_khau selectedSHK = new so_ho_khau();
	Connection con = ConnectDatabase.getConnection();
	ObservableList<changes_history> changesOfSelectedHK = FXCollections.observableArrayList();
	
    @FXML
    private TableView<changes_history> ChangesHisTable;

    @FXML
    private TableColumn<changes_history, Integer> ChangesHisTable_ID;

    @FXML
    private TableColumn<changes_history, String> ChangesHisTable_creator;

    @FXML
    private TableColumn<changes_history, Date> ChangesHisTable_date;

    @FXML
    private TableColumn<changes_history, String> ChangesHisTable_kind;

    @FXML
    private TableColumn<changes_history, String> ChangesHisTable_newInfo;

    @FXML
    private TableColumn<changes_history, String> ChangesHisTable_oldInfo;

    @FXML
    private Label selected_HK;
    
    public void setSelected(so_ho_khau inputSHK) {
    	this.selectedSHK = inputSHK;
    	displayChangesHis();
    }
    
    public ObservableList<changes_history> loadDataChangesHis() {
    	String sql = "select * from changes_history where id_hk = ?;";
    	ObservableList<changes_history> tempList = FXCollections.observableArrayList();
    	
    	try {
	    	PreparedStatement ppStm = con.prepareStatement(sql);
	    	ppStm.setInt(1, this.selectedSHK.getID());
	    	
	    	ResultSet res = ppStm.executeQuery();
	    	
//changes_history(int ID,String username,int id_hk, String changed_info, 
//					String old_info, String new_info, Date change_date)
	    	while(res.next()) {
	    		changes_history tempChange = new changes_history(res.getInt("ID"),
	    													res.getString("username"),
	    													res.getInt("id_hk"),
	    													res.getString("changed_info"),
	    													res.getString("old_info"),
	    													res.getString("new_info"),
	    													res.getDate("change_date"));
	    		tempList.add(tempChange);
	    	}
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return tempList;
    }
    
    public void displayChangesHis() {
    	
    	changesOfSelectedHK = loadDataChangesHis();
    	ChangesHisTable_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	ChangesHisTable_creator.setCellValueFactory(new PropertyValueFactory<>("username"));
    	ChangesHisTable_date.setCellValueFactory(new PropertyValueFactory<>("change_date"));
    	ChangesHisTable_kind.setCellValueFactory(new PropertyValueFactory<>("changed_info"));
    	ChangesHisTable_newInfo.setCellValueFactory(new PropertyValueFactory<>("new_info"));
    	ChangesHisTable_oldInfo.setCellValueFactory(new PropertyValueFactory<>("old_info"));
        
        ChangesHisTable.setItems(changesOfSelectedHK);
        selected_HK.setText(selectedSHK.getMa_shk() +" <<>> ID = "+ selectedSHK.getID());
        
    }
    
}
