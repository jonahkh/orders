CREATE TABLE `customer` (   `CUST_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,   `NAME` varchar(100) NOT NULL,   `AGE` int(10) unsigned NOT NULL,   PRIMARY KEY (`CUST_ID`) ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into customer values ('10','dev-john',30);
insert into customer values ('11','dev-Smith',30);
insert into customer values ('12','dev-Johnson',30);
insert into customer values ('13','dev-Jones',30);