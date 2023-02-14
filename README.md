# NOTE FOR FINAL PROJECT INTRO-SOFTWARE

## Database 
* [x] Construct tables in DB
* [x] Insert data to tables
* Create procedures: 
	* Case Study 1: Quan ly nhan khau, ho khau 
		- [] Proc1: Summary Information
			+ **IN**: TodayDate
			+ **OUT**: total NK, total HK, TamTru, TamVang
		- [] Proc2: Add CCCD to NK
			+ **IN**: id_NK, so_cccd, ngay_cap, noi_cap
		- [] Proc3: Add new NK
			+ **IN**: ho_ten, dob, nationality, sex, ethnic_group, religion (nullable), hoc_van (nullable), occupation (nullable), work_address (nullable), address (nullable), relation_owner (nullable), nguoi_tao
		- [] Proc4: create new HK
		- [] Proc5: add NK to HK
		- [] Proc6: create new HK from exist HK
		- [] Proc7: move HK to another place
		- [] Proc8: change chu ho
		- [] Proc9: add new tam_vang
		- [] Proc10: add new tam_tru
		- [] Proc11: Khai tu
	* Case Study 2: Quan ly thu phi, dong gop
		- [] Proc12: Summary Information
		- [] Proc13: create new DS thu phi
		- [] Proc14: ghi nhan thu phi
		- [] Proc15: create new DS dong gop
		- [] Proc16: ghi nhan dong gop

## GUI

* Login Screen: (done)
* MainScreen with navigation bar(Quan ly nhan khau) and (Quan ly thu phi, dong gop), userdetail, log out
* StackPane for UC1: sidebar{Trang chu btn, Nhan Khau btn, Ho Khau btn} 
	- [x] Trang chu: tong so nhan khau, tong so ho khau, nhan khau tam tru, nhan khau tam vang
	- [x] AnchorPane Nhan khau:search bar, TableView Nhan Khau, them moi btn, DK tam vang btn, DK tam tru btn, Khai tu btn, add CCCD btn
		+ [ ] Form them moi nhan khau (Popup scene in Stage FormStage_UC1)
		+ [ ] Form dk tam vang (Popup scene in Stage FormStage_UC1)
		+ [ ] Form dk tam tru (Popup scene in Stage FormStage_UC1)
		+ [ ] Form khai tu (Popup scene in Stage FormStage_UC1)
		+ [ ] Form add CCCD: tableview nhan_khau haven't had cccd to select (Popup scene in Stage FormStage_UC1)
	- [x] AnchorPane Ho Khau: search bar, TableView Ho Khau, them moi btn, tach HK btn, chuyen di btn, doi chu ho btn. 
		+ [ ] Form them moi ho khau: Table view Nhan Khau chua o trong Ho Khau (Popup scene in Stage FormStage_UC1)
		+ [ ] Form tach HK btn: table view Ho Khau, Ma Ho Khau moi, chu ho moi (Popup scene in Stage FormStage_UC1)
		+ [ ] Form chuyen Ho Khau di (Popup scene in Stage FormStage_UC1)

	- [x] AnchorPane Thong ke: table view, search do tuoi, search gioi tich, search tam tru, tam vang

* StackPane for UC2: sidebar{Thu phi, Dong gop, Thong ke}
	- [x] AnchorPane Thong Ke: 2 Sections:
		+ [x] Sec 1 - Thu Phi: table view ds_phi, pane for pay percentage, pane for tong so tien thu cua selected phi.
		+ [x] Sec 2 - Dong gop: table view ds_donggop, pane for so luong dong gop of that selected donggop, tong so tien for selected donggop.
	- [ ] AnchorPane Phi: table view table view ds_phi, table view dong_phi, add ds_phi btn, add record fee paid btn, pane for total phi paid.
		+ [ ] Form add new ds_phi (Popup scene in Stage FormStage_UC2)
		+ [ ] Form add new record (Popup scene in Stage FormStage_UC2)
	- [ ] AnchorPane Donggop: table view ds_donggop, table view dong_gop, add ds_donggop btn, add dong_gop record, pane for total donggop of selected ds_donggop
		+ [ ] Form add new ds_donggop (Popup scene in Stage FormStage_UC2)
		+ [ ] Form add new dong_gop: table view ds_donggop (Popup scene in Stage FormStage_UC2)

## EventHandler
* 


