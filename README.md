# NOTE FOR FINAL PROJECT INTRO-SOFTWARE

## Database 
* [] Construct tables in DB
* [] Insert data to tables
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
* Borderpane for UC1: sidebar{Trang chu btn, Nhan Khau btn, Ho Khau btn} 
	- Trang chu: tong so nhan khau, tong so ho khau, nhan khau tam tru, nhan khau tam vang
	- stackpane Nhan khau:search bar, TableView Nhan Khau, them moi btn, DK tam vang btn, DK tam tru btn, Khai tu btn.
		+ (Popup scene in new Stage) Screen them moi nhan khau:
		+ (Popup scene in new Stage) Screen dk tam vang
		+ (Popup scene in new Stage) Screen dk tam tru
		+ (Popup scene in new Stage) Screen khai tu
	- stackpane Ho Khau: search bar, TableView Ho Khau, them moi btn, tach HK btn, chuyen di btn, doi chu ho btn. 
		+ (Popup scene in new Stage) Screen them moi ho khau: Table view Nhan Khau chua o trong Ho Khau
		+ (Popup scene in new Stage) Screen tach HK btn: table view Ho Khau, Ma Ho Khau moi, chu ho moi
		+ (Popup scene in new Stage) Screen chuyen Ho Khau di 

	- Thong ke: table view, search do tuoi, search gioi tich, search tam tru, tam vang

* Borderpane for UC2: sidebar{Thu phi, Dong gop, Thong ke}
	- Thong Ke: 2 Sections:
		+ Sec 1 - Thu Phi: table view ds_phi, pane for (so ho dong)/(tong so ho), pane for tong so tien thu cua selected phi.
		+ Sec 2 - Dong gop: table view ds_donggop, pane for so luong dong gop, tong so tien for selected donggop.




