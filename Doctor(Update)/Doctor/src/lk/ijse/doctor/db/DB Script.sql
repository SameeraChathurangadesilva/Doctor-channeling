
drop database DoctorChanneling;
create database DoctorChanneling;
use DoctorChanneling;

create table patient(
	ptid varchar(10)not null,
	name varchar(30),
	address varchar(50),
	gender varchar(10),
	nic varchar(13),
	age int,
	teleno int,
	constraint primary key(ptid)
)engine=innodb;

create table Registration(
	rgid varchar(10)not null,
	name varchar(30),
	address varchar(50),
	gender varchar(10),
	nic varchar(13),
	age int,
	teleno int,
	constraint primary key(rgid)
)engine=innodb;

create table hospital(
	hpid varchar(10)not null,
	name varchar(30),
	constraint primary key(hpid)
)engine=innodb;

create table speciality(
	spid varchar(30)not null,
	name varchar(30),
	constraint primary key(spid)
)engine=innodb;

create table days(
	dayid varchar(30)not null,
	days varchar(100),
	constraint primary key(dayid)
)engine=innodb;

create table doctor(
	dcid varchar(10)not null,
	hpid varchar(10)not null,
	spid varchar(30)not null,
	name varchar(30),
	gender varchar(10),
	dcfree decimal(10,2),
	constraint primary key(dcid),
	constraint foreign key(hpid) references hospital(hpid)
	on delete cascade on update cascade,
	constraint foreign key(spid) references speciality(spid)
	on delete cascade on update cascade
)engine=innodb;

create table schedule(
	scid varchar(10)not null,
	dcid varchar(10)not null,
	dayid varchar(10)not null,
	doctorin varchar(10),
	doctorout varchar(10),
	patientcount int,
	constraint primary key(scid),
	constraint foreign key(dcid) references doctor(dcid)
	on delete cascade on update cascade,
	constraint foreign key(dayid) references days(dayid)
	on delete cascade on update cascade
)engine=innodb;

create table appoinment(
	apid varchar(10)not null,
	dcid varchar(10)not null,
	ptid varchar(10)not null,
	apno varchar(30),
	time varchar(10),
	date varchar(30),
	constraint primary key(apid),
	constraint foreign key(dcid) references doctor(dcid)
	on delete cascade on update cascade,
	constraint foreign key(ptid) references patient(ptid)
	on delete cascade on update cascade
)engine=innodb;

create table payment(
	payid varchar(10)not null,
	apid varchar(10)not null,
	amount varchar(30),
	date varchar(30),
	constraint primary key(payid),
	constraint foreign key(apid) references appoinment(apid)
	on delete cascade on update cascade
)engine=innodb;


