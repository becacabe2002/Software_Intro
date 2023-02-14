# NOTE FOR FINAL PROJECT INTRO-SOFTWARE

## Database 
* [x] Construct tables in DB
* [x] Insert data to tables
* Create procedures: 
	* Case Study 1: Quan ly nhan khau, ho khau 
		- [ ] Proc1: Summary Information - *proc used to return summary information for UC1 TongQuat Pane*
			+ **OUT**: total NK, total HK, TamTru, TamVang
		- [ ] Proc2: Add CCCD to NK - *proc used to add a new cccd item for nhan_khau, whose id was passed through UC1 - form addCCCD*
			+ **IN**: id_NK, so_cccd, ngay_cap, noi_cap
		- [ ] Proc3: Add new NK - *proc used to add new nhan_khau, with passed information from UC1 - form add Nhan_khau*
			+ **IN**: ho_ten, dob, nationality, sex, ethnic_group, religion (nullable), hoc_van (nullable), occupation (nullable), work_address (nullable), address (nullable), relation_owner (nullable), nguoi_tao
		- [ ] Proc4: create new HK
		- [ ] Proc5: add NK to HK - *proc used to add an exist nhan_khau into so_ho_khau by changing the id_hk field of that nhan_khau to be the same  with selected so_ho_khau(ID), and change its relation_owner to "Nguoi than". It may need to be called multiple times as user wants to add many people.*
		- [ ] Proc6: create new HK from exist HK - *proc used to split exist hk to create a new HK with nhan_khau from the previous so_ho_khau. First, it creates new HK with passed information from UC1 - form tach HK. Them, it changes selected nhan_khau id_hk field to recently created HK (by call add NK to HK proc), with selected nhan_khau relation_owner to "Chu ho", and other to "Nguoi than"*
		- [ ] Proc7: move HK to another place - *proc used to change dia_chi field of selected so_ho_khau*
		- [ ] Proc8: change chu ho - *proc used to change relation_owner of nhan_khau inside selected so_ho_khau. Selected nhan_khau to become new chu ho changes its relation_owner -> "Chu ho", other relation_owner -> "Nguoi than"*
		- [ ] Proc9: add new tam_vang
		- [ ] Proc10: add new tam_tru
		- [ ] Proc11: Khai tu
		- [ ] Proc12: filter thongke - *proc used to return resultset based on passed information like: sex, time range, tam_tru or tam_vang from UC1 - Pane Thongke*
	* Case Study 2: Quan ly thu phi, dong gop
		- [ ] Proc13: Summary Information - *proc return summary information of UC2 - Thongke Pane*
		- [ ] Proc14: create new DS thu phi - *proc used to create new item in ds_phi, and also create new item in thu_phi table, which show how many money does a HK need to pay.*
		- [ ] Proc15: ghi nhan thu phi - *proc used to change thu_phi pay_state of selected ds_phi to true, with iput id_hk*
		- [ ] Proc16: create new DS dong gop - *proc used to create new ds_donggop with passed information*
		- [ ] Proc17: ghi nhan dong gop - "proc used to create new donggop record with ma_donggop from selected ds_donggop and input information from UC2 - form add new dong_gop "

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


