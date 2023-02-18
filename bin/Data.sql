drop database if exists cnpm;
create database cnpm;
use cnpm;

-- Cac primary key, key va foreign key 
-- se duoc them vao sau khi do du lieu
-- Cac primary key chu yeu se la ID cua cac bang
-- Foreign key idNhanKhau --> NhauKhau(ID)
-- Foreign key idHK --> SoHoKhau(ID)

create table users( -- info cua admin
ID int(11) unique not null,
 username varchar(20) unique not null , -- Key username
 pass varchar(45) not null,
 admin_name varchar(100) not null
);


-- do du lieu cho bang users
insert into users(id, username, pass, admin_name)
values (1, "becacabe", "29123498", "Ngo Minh Tu"),
(2, "admin", "12345678", "Admin");


create table so_ho_khau( -- info cua SHK
ID int(11) unique not null,
ma_shk varchar(20) unique not null,
ma_kv varchar(20) not null,
dia_chi varchar(100) not null,
ngay_lap date not null, -- can insert curdate()
ngay_chuyen date default null, -- can insert curdate()
lydo_chuyen varchar(100) default null, 
nguoi_tao varchar(100) not null -- lien ket voi username cua users
);

-- do du lieu cho bang so_ho_khau

insert into so_ho_khau(id, ma_shk, ma_kv, dia_chi, ngay_lap, nguoi_tao)
values (1, 'DD-001', 'HN', 'so 8 ngo 2 Phuong Mai',curdate(), 'admin'),
(2, 'DD-002', 'HN', 'so 9 ngo 3 Phuong Mai', date('2022-12-01'),'admin'),
(3, 'DD-003', 'HN', 'so 10 ngo 4 Phuong Mai',curdate(), 'admin'),
(4, 'DD-004', 'HN', 'so 11 ngo 5 Phuong Mai', curdate(),'admin'),
(5, 'DD-005', 'HN', 'so 12 ngo 6 Phuong Mai', curdate(),'admin');

create table changes_history( -- lich su thay doi thong tin SHK (ko qua uu tien)
ID int(11) unique not null,
 username varchar(20) not null,  -- foreign key toi Users(username)
 id_hk int(11) not null, -- foreign key toi so_ho_khau(ID)
 changed_info varchar(100) not null,
 old_info varchar(100) not null,
 new_info varchar(100) not null,
 change_date date not null-- default curdate()
);

-- do du lieu cho bang changes_history

create table nhan_khau( -- thong tin cua nhan khau
ID int(11) unique not null,
 id_hk int(11) default null, -- foreign key toi ho_khau(ID)
 ho_ten varchar(100) not null,
 dob date not null,
 nationality varchar(100) default 'VN',
 sex varchar(10) not null,
 ethnic_group varchar(20) not null,
 religion varchar(20) default null,
 hoc_van varchar(20) default null,
 occupation varchar(100) default null,
 work_address varchar(100) default null,
 address varchar(100) default null,
 relation_owner varchar(20) default null, -- moi quan he voi chu ho
 nguoi_tao varchar(20) not null, -- foreign key to users(username)
 create_date date not null,
 note varchar(100) default null -- == 'Quadoi' neu nguoi da qua doi
);


-- do du lieu cho bang nhan_khau

insert into nhan_khau(id, id_hk, ho_ten, dob, ethnic_group, sex, religion, hoc_van, relation_owner, nguoi_tao, create_date)
values (1, 1, 'Ngo Minh Tu', str_to_date('2002 12 29', '%Y %m %d'), 'Kinh', 'Male', null, '12/12', 'Nguoi than', 'admin', curdate()),
(2, 1, 'Ngo Nhat Minh', str_to_date('2012 04 03', '%Y %m %d'), 'Kinh', 'Male', null, '5/12', 'Nguoi than','admin', curdate()),
(3, 1, 'Ngo Quang Long', str_to_date('1975 07 15', '%Y %m %d'), 'Kinh', 'Male', null, '12/12', 'Chu ho','admin', curdate()),
(4, 1, 'Phung Thi Ngoan', str_to_date('1978 12 23', '%Y %m %d'), 'Kinh', 'Female', null, '12/12', 'Nguoi than','admin', curdate()),
(5, 2, 'Nguyen Quynh Anh', str_to_date('1999 07 15', '%Y %m %d'), 'Kinh', 'Female', null, '12/12', 'Nguoi than', 'admin', curdate()),
(6, 2, 'Pham Trung Thanh', str_to_date('1997 12 20', '%Y %m %d'), 'Kinh', 'Male', null, '12/12', 'Chu ho', 'admin', curdate()),
(7, 3, 'Ngo Tung Khanh', str_to_date('1968 05 10', '%Y %m %d'), 'Kinh', 'Male', null, '12/12', 'Chu ho', 'admin', curdate()),
(8, 3, 'Nguyen Khanh Huyen', str_to_date('1970 10 30', '%Y %m %d'), 'Kinh', 'Female', null, '12/12', 'Nguoi than', 'admin', curdate()),
(9, 3, 'Ngo Minh Truong', str_to_date('2006 12 20', '%Y %m %d'), 'Kinh', 'Male', null, '11/12','Nguoi than','admin', curdate()),
(10, 4, 'Bui Minh Khang', str_to_date('1980 08 23', '%Y %m %d'), 'Kinh', 'Male', null, '12/12','Chu ho','admin', curdate()),
(11, 4, 'Nguyen Tuyet Linh', str_to_date('1985 06 12', '%Y %m %d'), 'Kinh', 'Female', null, '12/12', 'Nguoi than','admin', curdate()),
(12, 4, 'Bui Khanh Trang', str_to_date('2010 12 29', '%Y %m %d'), 'Kinh', 'Female', null, '7/12', 'Nguoi than', 'admin', curdate()),
(13, 4, 'Bui Gia Khang', str_to_date('2012 03 01', '%Y %m %d'), 'Kinh', 'Male', null, '5/12', 'Nguoi than', 'admin', curdate()),
(14, 5, 'Hoang Bao Viet', str_to_date('1968 11 15', '%Y %m %d'), 'Kinh', 'Male', null, '12/12', 'Chu ho', 'admin', curdate()),
(15, 5, 'Nguyen Thuy Hanh', str_to_date('1974 8 24', '%Y %m %d'), 'Kinh', 'Female', null, '12/12', 'Nguoi than','admin', curdate()),
(16, 5, 'Hoang Bao Khanh', str_to_date('2001 4 3', '%Y %m %d'), 'Kinh', 'Male', null, '12/12', 'Nguoi than', 'admin', curdate());

create table can_cuoc( 
ID int(11) unique not null,
 id_nk int unique not null, -- foreign key toi nhan_khau(ID)
 so_cccd int(11), -- Can cuoc cong dan
 ngay_cap date default null, 
 noi_cap varchar(100) default null
);

-- do du lieu cho bang can_cuoc
insert into can_cuoc(id, id_nk, so_cccd, ngay_cap, noi_cap)
values (1, 1, 123456, '2022-01-01', 'Hanoi'),
(2, 2, 654321, '2022-02-01', 'Haiphong'),
(3, 3, 111111, '2022-03-01', 'Da Nang'),
(4, 4, 222222, '2022-04-01', 'Ho Chi Minh'),
(5, 11, 333333, '2022-05-01', 'Can Tho'),
(6, 6, 444444, '2022-06-01', 'Hai Duong'),
(7, 7, 555555, '2022-07-01', 'Nam Dinh'),
(8, 8, 666666, '2022-08-01', 'Quang Ninh'),
(9, 9, 777777, '2022-09-01', 'Thai Binh'),
(10, 10, 888888, '2022-10-01', 'Thanh Hoa');

create table khai_tu( 
ID int(11) primary key auto_increment,
id_mat int(11) unique not null, -- foreign key toi NhanKhau('ID')
id_khai int(11) not null, -- foreign key toi NhanKhau('ID') 
ngay_mat date not null,
ngay_khai date not null,
note varchar(100) default null -- nguyen nhan mat
);

create table tam_tru(
	ID int(11) primary key auto_increment, 
	id_nk int(11) not null, -- foreign key toi NhanKhau('ID')
    sdt int default null,
    start_date date not null,
    end_date date not null,
    note varchar(100) default null
);

create table tam_vang(
	ID int(11) primary key auto_increment,
	id_nk int(11) not null, -- foreign key toi NhanKhau('ID')
    start_date date not null,
    end_date date not null,
    destination varchar(100) not null,
    note varchar(100) default null
);

create table ds_phi(
	ID int(11) primary key auto_increment,
	ma_phi varchar(10) unique not null,
    ten_phi varchar(100) not null,
    tien_per_nk bigint not null, -- So tien can dong voi moi nhan khau
    nguoi_tao varchar(20) not null, -- foreign key toi users(username)
    ngay_tao date not null -- default curdate()
);

-- do du lieu cho bang ds_phi

set @curdate = curdate();

create table thu_phi(
	ID int(11) primary key auto_increment,
	id_hk int(11) not null, -- foreign key HoKhau('ID')
    ma_phi varchar(10) not null, -- foreign key ds_phi(ma_phi)
    fee_hk int(11) not null, -- = tien_per_nk * so NhanKhau
    pay_state boolean default false, -- true cho da dong, false cho chua dong
    pay_date date default null
);

-- do du lieu cho bang thu_phi

create table ds_donggop(
	ID int(11) primary key auto_increment,
	ma_donggop varchar(100) unique not null,
    nguoi_tao varchar(20) not null,-- foreign key toi users(username)
    ten_ds_donggop varchar(100) not null,
    ngay_tao date not null  -- default curdate()
);

-- do du lieu cho bang ds_donggop

create table dong_gop(
	ID int(11) primary key auto_increment,
	id_nk int not null, -- foreign key NhanKhau('ID')
    ma_donggop varchar(100) not null, -- foreign key DSDotDongGop('MaDSDongGop')
    ngay_donggop date not null, -- default curdate()
    tien_donggop int not null
);

-- >> tao chi muc cho cac bang da do du lieu
-- cho bang users

alter table users
	add primary key (ID);
    
alter table users
modify ID int(11) auto_increment, auto_increment = 3;

-- cho bang so_ho_khau
alter table so_ho_khau
	add primary key (ID),
    -- add key index_username (nguoi_tao),
    modify ID int(11) auto_increment, auto_increment = 6;

-- cho bang changes_history
alter table changes_history
	add primary key (ID),
    -- add key index_username (username),
    -- add key index_id_ho_khau (id_hk),
    modify ID int(11) auto_increment;
    
-- cho bang nhan_khau
alter table nhan_khau
	add primary key (ID),
    -- add key index_id_ho_khau (id_hk),
    -- add key index_username (nguoi_tao),
    modify ID int(11) auto_increment, auto_increment = 17;
    
-- cho bang can_cuoc
alter table can_cuoc
	add primary key(ID),
    -- add key index_id_nhan_khau(id_nk),
    modify ID int(11) auto_increment, auto_increment = 11;

-- cho bang khai_tu
-- alter table khai_tu
	-- add key index_id_nhan_khau_mat (id_mat),
    -- add key index_id_nhan_khau_khai (id_khai);

-- cho bang tam_tru
-- alter table tam_tru
	-- add key index_id_nhan_khau (id_nk);

-- cho bang tam_vang
-- alter table tam_vang
	-- add key index_id_nhan_khau (id_nk);

-- cho bang ds_phi
-- alter table ds_phi
	-- add key index_username (nguoi_tao);

-- cho bang thu_phi
-- alter table thu_phi
	-- add key index_id_ho_khau (id_hk),
    -- add key index_ma_phi (ma_phi);

-- cho bang ds_donggop
-- alter table ds_donggop
	-- add key index_username (nguoi_tao);

-- cho bang dong_gop
-- alter table dong_gop
	-- add key index_id_nhan_khau (id_nk),
    -- add key index_ma_donggop (ma_donggop);

-- >> tao cac rang buoc cho cac bang
-- cho bang so_ho_khau
alter table so_ho_khau
	add constraint so_ho_khau_ibfk1 foreign key (nguoi_tao) references users(username);

-- cho bang changes_history
alter table changes_history
	add constraint changes_history_ibfk1 foreign key (username) references users(username),
    add constraint changes_history_ibfk2 foreign key (id_hk) references so_ho_khau(ID);
    
-- cho bang nhan_khau
alter table nhan_khau
	add constraint nhan_khau_ibfk1 foreign key (id_hk) references so_ho_khau(ID),
	add constraint nhan_khau_ibfk2 foreign key (nguoi_tao) references users(username);

-- cho bang can_cuoc
alter table can_cuoc
	add constraint can_cuoc_ibfk1 foreign key (id_nk) references nhan_khau(ID);
    
-- cho bang khai_tu
alter table khai_tu
	add constraint khai_tu_ibfk1 foreign key (id_mat) references nhan_khau(ID),
    add constraint khai_tu_ibfk2 foreign key (id_khai) references nhan_khau(ID);
    
-- cho bang tam_tru
alter table tam_tru
	add constraint tam_tru_ibfk1 foreign key (id_nk) references nhan_khau(ID);
    
-- cho bang tam_vang
alter table tam_vang
	add constraint tam_vang_ibfk1 foreign key (id_nk) references nhan_khau(ID);
    
-- cho bang ds_phi
alter table ds_phi
	add constraint ds_phi_ibfk1 foreign key (nguoi_tao) references users(username);

-- cho bang thu_phi
alter table thu_phi
	add constraint thu_phi_ibfk1 foreign key (id_hk) references so_ho_khau(ID),
    add constraint thu_phi_ibfk2 foreign key (ma_phi) references ds_phi(ma_phi);

-- cho bang ds_donggop
alter table ds_donggop
	add constraint ds_donggop_ibfk1 foreign key (nguoi_tao) references users(username);

-- cho bang dong_gop
alter table dong_gop
	add constraint dong_gop_ibfk1 foreign key (id_nk) references nhan_khau(ID),
    add constraint dong_gop_ibfk2 foreign key (ma_donggop) references ds_donggop(ma_donggop);
    
-- >> tao cac procedure:

create procedure add_cccd_nk() -- proc2
begin
	
end;

/* -- select nhan khau chua co can cuoc
select nhan_khau.id as ID, nhan_khau.ho_ten as NKName
from nhan_khau
left join can_cuoc
on nhan_khau.id = can_cuoc.id_nk
where can_cuoc.id_nk is null;
*/

create procedure new_nk() -- proc3
begin
	
end;

create procedure new_hk() -- proc4
begin

end;

create procedure add_nk_hk() -- proc5
begin

end;

create procedure split_hk() -- proc6
begin

end;

create procedure move_hk() -- proc7
begin

end;

drop procedure if exists change_owner;

delimiter $$

create procedure change_owner(IN id_hk int, IN id_newCH int) -- proc8
begin
update nhan_khau
set relation_owner = 'Nguoi than'
where id_hk = id_hk;

update nhan_khau
set relation_owner = 'Chu ho'
where id_hk = id_hk and ID = id_newCH;
end $$

delimiter ;

-- select * from nhan_khau where id_hk in (select MIN(ID) from so_ho_khau);
-- call change_owner(1,1);
-- select * from nhan_khau where id_hk in (select MIN(ID) from so_ho_khau);

drop procedure if exists add_tam_vang;

delimiter $$

create procedure add_tam_vang(IN id_nguoi_khai int(11), IN startDate date, IN endDate date,IN dest varchar(100), INOUT notification varchar(100)) -- proc9
begin

select count(ID) into @count1 from nhan_khau
where ID = id_nguoi_khai and ID not in(select id_mat from khai_tu);

select count(ID) into @count2 from tam_vang
where id_nk = id_nguoi_khai and end_date > curdate();
if @count1 = 0 then
	set notification = 'ID nguoi khai da mat';
elseif @count2 >= 1 then
	set notification = 'Tam vang cua nguoi khai van con hieu luc';
else
	insert into tam_vang (id_nk, start_date, end_date, destination)
    values (id_nguoi_khai, startDate, endDate, dest);
    set notification = 'Tam vang da duoc them vao.';
end if;
end $$

delimiter ;

-- call add_tam_vang(15,str_to_date('2023 03 01', '%Y %m %d'), str_to_date('2023 03 11', '%Y %m %d'), 'so 8 ngho 2 Phuong Mai', @rtnVal);
-- select @rtnVal;

drop procedure if exists add_tam_tru;

delimiter $$
-- nhan thong tin tu form tam tru
-- kiem tra xem lieu id nguoi khai co con song hay khong (chua duoc)
-- kiem tra xem lieu id nguoi khai co tam tru trc hay khong (chua het tgian)
create procedure add_tam_tru(IN id_nguoi_khai int(11),IN sdt int(11), IN startDate date, IN endDate date, IN note varchar(100), INOUT notification varchar(100)) -- proc10
begin

select count(ID) into @count1 from nhan_khau
where ID = id_nguoi_khai and ID not in(select id_mat from khai_tu);

select count(ID) into @count2 from tam_tru
where id_nk = id_nguoi_khai and end_date > curdate();
if @count1 = 0 then
	set notification = 'ID nguoi khai da mat';
elseif @count2 >= 1 then
	set notification = 'Tam tru cua nguoi khai van con hieu luc';
else
	insert into tam_tru (id_nk, sdt, start_date, end_date, note)
    values (id_nguoi_khai, sdt, startDate, endDate, note);
    set notification = 'Tam tru da duoc them vao.';
end if;
end $$

delimiter ;

call add_tam_tru(11,900275,str_to_date('2023 03 01', '%Y %m %d'), str_to_date('2023 03 11', '%Y %m %d'), 'tham nha ong ba', @rtnVal);
select @rtnVal;
-- select count(ID) into @count1 from nhan_khau
-- where ID = 11 and ID not in(select id_mat from khai_tu);
-- select @count1;

drop procedure if exists khai_bao_tu;

delimiter $$ 
-- nhan thong tin tu form bao tu
-- check tinh hop le cua id nguoi khai va id nguoi mat
-- tra ve notification string 'Tao khai tu thanh cong' hoac 'Id nhap vao khong hop le'
create procedure khai_bao_tu(IN id_nguoi_mat int, IN id_nguoi_khai int, IN ngayMat date, IN lyDo varchar(100), OUT notification varchar(100)) -- proc11
BEGIN
declare checkID int; -- check the input IDs

select count(ID)
into checkID from nhan_khau 
where ID in (id_nguoi_mat, id_nguoi_khai)
and note is null ;
if checkID = 2 then
	insert into khai_tu(id_mat, id_khai, ngay_mat, ngay_khai, note)
	values (id_nguoi_mat, id_nguoi_khai, ngayMat, curdate(), lydo);

	update nhan_khau 
	set note = 'Quadoi',
    id_hk = null
	where ID = id_nguoi_mat;
	set notification = 'Tao khai tu thanh cong';
else 
	set notification = 'ID nhap vao khong hop le';
end if;

END $$

delimiter ;

-- call khai_bao_tu(11, 14, str_to_date('2012 03 01', '%Y %m %d'), 'Benh nang', @rtnVal);
-- select @rtnVal;
-- select count(ID) from nhan_khau where note is null;
-- select * from nhan_khau;

delimiter $$ -- need another delimiter for procedure

CREATE PROCEDURE filter_TK (IN inputSex VARCHAR(10), -- proc12
							IN startDate Date, IN endDate Date, IN tt_tv varchar(10))
BEGIN
declare todayDate Date;
set todayDate = curdate();

if tt_tv = 'tamtru' then 
  create table filterTable
  select nk.*
  from nhan_khau as nk
  left join tam_tru as tt on nk.ID = tt.id_nk
  where tt.ID is not null 
  and nk.sex = inputSex
  and nk.dob> startDate and nk.dob < endDate
  and tt.end_date > todayDate;
else 
  create table filterTable
  select nk.*
  from nhan_khau as nk
  left join tam_vang as tv on nk.ID = tt.id_nk
  where tv.ID is not null 
  and nk.sex = inputSex
  and nk.dob> startDate and nk.dob < endDate
  and tv.end_date > todayDate;
end if;
  select * from filterTable;
  drop table filterTable;
END $$

delimiter ;


create procedure summary_info_cs2() -- proc13
begin

end;

create procedure new_ds_phi() -- proc14
begin

end;

create procedure add_pay_record() -- proc15
begin

end;

create procedure new_ds_donggop() -- proc16
begin

end;

create procedure add_contribute_record() -- proc17
begin

end;
-- need a trigger to create a new phi list whenever a new ds_phi is created.


