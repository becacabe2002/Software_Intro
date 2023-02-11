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
ngay_lap TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
ngay_chuyen TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update current_timestamp,
lydo_chuyen varchar(100) default null, 
nguoi_tao varchar(100) -- lien ket voi username cua users
);

-- do du lieu cho bang so_ho_khau

insert into so_ho_khau(id, ma_shk, ma_kv, dia_chi, nguoi_tao)
values (1, 'DD-001', 'HN', 'so 8 ngo 2 Phuong Mai', 'admin'),
(2, 'DD-002', 'HN', 'so 9 ngo 3 Phuong Mai', 'admin'),
(3, 'DD-003', 'HN', 'so 10 ngo 4 Phuong Mai', 'admin'),
(4, 'DD-004', 'HN', 'so 11 ngo 5 Phuong Mai', 'admin'),
(5, 'DD-005', 'HN', 'so 12 ngo 6 Phuong Mai', 'admin');


create table changes_history( -- lich su thay doi thong tin SHK (ko qua uu tien)
ID int(11) unique not null,
 username varchar(20),  -- foreign key toi Users(username)
 id_hk int(11) not null, -- 
 changed_info varchar(100),
 old_info varchar(100),
 new_info varchar(100),
 change_date varchar(100)
);

-- do du lieu cho bang changes_history

create table nhan_khau( -- thong tin cua nhan khau
ID int(11) unique not null,
 id_hk bigint default null, -- foreign key toi ho_khau(ma_shk)
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
 nguoi_tao varchar(20), -- foreign key to users(username)
 create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 note varchar(100) -- == 'Quadoi' neu nguoi da qua doi
);

-- do du lieu cho bang nhan_khau

insert into nhan_khau(id, id_hk, ho_ten, dob, ethnic_group, sex, religion, hoc_van, relation_owner, nguoi_tao)
values (1, 1, 'Ngo Minh Tu', '2002-12-29', 'Kinh', 'Male', null, '12/12', 'Nguoi than', 'admin'),
(2, 1, 'Ngo Nhat Minh', '2012-04-03', 'Kinh', 'Male', null, '5/12', 'Nguoi than','admin'),
(3, 1, 'Ngo Quang Long', '1975-07-15', 'Kinh', 'Male', null, '12/12', 'Chu ho','admin'),
(4, 1, 'Phung Thi Ngoan', '1978-12-23', 'Kinh', 'Female', null, '12/12', 'Nguoi than','admin'),
(5, 2, 'Nguyen Quynh Anh', '1999-07-15', 'Kinh', 'Female', null, '12/12', 'Nguoi than', 'admin'),
(6, 2, 'Pham Trung Thanh', '1997-12-20', 'Kinh', 'Male', null, '12/12', 'Chu ho', 'admin'),
(7, 3, 'Ngo Tung Khanh', '1968-5-10', 'Kinh', 'Male', null, '12/12', 'Chu ho', 'admin'),
(8, 3, 'Nguyen Khanh Huyen', '1970-10-30', 'Kinh', 'Female', null, '12/12', 'Nguoi than', 'admin'),
(9, 3, 'Ngo Minh Truong', '2006-12-20', 'Kinh', 'Male', null, '11/12','Nguoi than','admin'),
(10, 4, 'Bui Minh Khang', '1980-8-23', 'Kinh', 'Male', null, '12/12','Chu ho','admin'),
(11, 4, 'Nguyen Tuyet Linh', '1985-6-12', 'Kinh', 'Female', null, '12/12', 'Nguoi than','admin'),
(12, 4, 'Bui Khanh Trang', '2010-12-29', 'Kinh', 'Female', null, '7/12', 'Nguoi than', 'admin'),
(13, 4, 'Bui Gia Khang', '2012-3-1', 'Kinh', 'Male', null, '5/12', 'Nguoi than', 'admin'),
(14, 5, 'Hoang Bao Viet', '1968-11-15', 'Kinh', 'Male', null, '12/12', 'Chu ho', 'admin'),
(15, 5, 'Nguyen Thuy Hanh', '1974-8-24', 'Kinh', 'Female', null, '12/12', 'Nguoi than','admin'),
(16, 5, 'Hoang Bao Khanh', '2001-4-3', 'Kinh', 'Male', null, '12/12', 'Nguoi than', 'admin');


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
ID int(11) unique not null,
id_mat int(11), -- foreign key toi NhanKhau('ID')
id_khai int(11), -- foreign key toi NhanKhau('ID')
ngay_mat date,
ngay_khai date,
note varchar(100) -- nguyen nhan mat
);

create table tam_tru(
	ID int(11) unique not null, 
	id_nk int(11), -- foreign key toi NhanKhau('ID')
    sdt int,
    start_date date,
    end_date date,
    note varchar(100)
);

create table tam_vang(
	ID int(11) unique not null,
	id_nk int(11), -- foreign key toi NhanKhau('ID')
    start_date date,
    end_date date,
    destination varchar(100),
    note varchar(100)
);

create table ds_phi(
	ID int(11) unique not null,
	ma_phi varchar(10) unique not null,
    ten_phi varchar(100),
    tien_per_nk bigint, -- So tien can dong voi moi nhan khau
    nguoi_tao varchar(20), -- foreign key toi users(username)
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- do du lieu cho bang ds_phi

create table thu_phi(
	ID int(11) unique not null,
	id_hk int(11) not null, -- foreign key HoKhau('ID')
    ma_phi varchar(10) not null, -- foreign key ds_phi(ma_phi)
    fee_hk bigint, -- = tien_per_nk * so NhanKhau
    pay_state boolean, -- true cho da dong, false cho chua dong
    pay_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- do du lieu cho bang thu_phi

create table ds_donggop(
	ID int(11) unique not null,
	ma_donggop varchar(100),
    nguoi_tao varchar(20),-- foreign key toi users(username)
    ten_ds_donggop varchar(100),
    ngay_tao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- do du lieu cho bang ds_donggop

create table dong_gop(
	ID int(11) unique not null,
	id_nk int, -- foreign key NhanKhau('ID')
    ma_donggop varchar(100), -- foreign key DSDotDongGop('MaDSDongGop')
    ngay_donggop TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tien_donggop int
);

-- >> tao chi muc cho cac bang da do du lieu
-- cho bang users


-- cho bang so_ho_khau

-- cho bang nhan_khau

-- cho bang can_cuoc

-- cho bang khai_tu

-- cho bang tam_tru

-- cho bang tam_vang

-- cho bang ds_phi

-- cho bang thu_phi

-- cho bang ds_donggop

-- cho bang dong_gop


-- >> tao cac rang buoc cho cac bang

-- >> tao cac procedure:

create procedure summary_info_cs1() -- proc1
begin

end;

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

create procedure change_owner() -- proc8
begin

end;

create procedure add_tam_vang() -- proc9
begin

end;

create procedure add_tam_tru() -- proc10
begin

end;

create procedure khai_tu() -- proc11
begin

end;

create procedure summary_info_cs2() -- proc12
begin

end;

create procedure new_ds_phi() -- proc13
begin

end;

create procedure add_pay_record() -- proc14
begin

end;

create procedure new_ds_donggop() -- proc15
begin

end;

create procedure add_contribute_record() -- proc16
begin

end;




