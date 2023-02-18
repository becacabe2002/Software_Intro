# NOTE FOR FINAL PROJECT INTRO-SOFTWARE

## Database 
* [x] Construct tables in DB
* [x] Insert data to tables
* Create procedures: 
	* Case Study 1: Quan ly nhan khau, ho khau 
		- [x] Proc1: add NK to HK - *proc used to add an exist nhan_khau into so_ho_khau by changing the id_hk field of that nhan_khau to be the same  with selected so_ho_khau(ID), and change its relation_owner to "Nguoi than". It may need to be called multiple times as user wants to add many people.*
		- [x] Proc2: create HK - *proc used to create a new HK, add Owner nhan_khau to that HK*
			+ Split HK = create HK(@param from old HK) + N * (add NK to HK) 
				+ N is the number of member in that family
		- [x] Proc3: move HK to another place - *proc used to change dia_chi field of selected so_ho_khau*
		- [x] Proc4: change chu ho - *proc used to change relation_owner of nhan_khau inside selected so_ho_khau. Selected nhan_khau to become new chu ho changes its relation_owner -> "Chu ho", other relation_owner -> "Nguoi than"*
		- [x] Proc5: add new tam_vang - *proc used to add new tam_vang for selected nhan_khau, after checking its validity*
		- [x] Proc6: add new tam_tru - *proc used to add new tam_tru for selected nhan_khau, after checking its validity*
		- [x] Proc7: Khai bao tu - *proc used to add new khai_tu after checking the validity of input information*
		- [x] Proc8: filter thongke - *proc used to return resultset based on passed information like: sex, time range, tam_tru or tam_vang from UC1 - Pane Thongke*
	
	* Case Study 2: Quan ly thu phi, dong gop
		- [x] Trigger1: insert_phi_list - *auto calculate the fee that each family have to pay for newly inserted ds_phi and add it to the thu_phi table*

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
		+ [ ] Form tach HK : table view Ho Khau, Ma Ho Khau moi, chu ho moi (Popup scene in Stage FormStage_UC1)
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


