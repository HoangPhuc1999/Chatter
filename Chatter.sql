
create database chatter COLLATE Latin1_General_100_CI_AI_KS_WS_SC;
USE [chatter]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE users(
	users_id int identity(1,1) primary key,
	firstname varchar(50) NOT NULL,
	lastname varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	gender bit NOT NULL, 
	avatar varchar(50)
);

create table users_role(
	users_id int references users(users_id) NOT NULL,
	user_role varchar(50) NOT NULL
);

create table users_account(
	users_id int references users(users_id) NOT NULL,
	username varchar(50) NOT NULL,
	password varchar(50) NOT NULL
);

Create TABLE users_address(
	users_id int references users(users_id),
	home_address varchar(50) NOT NULL,
	district varchar(50) NOT NULL,
	city varchar(50) NOT NULL
);
CREATE TABLE banks_info(
	bank_id int identity(1,1) PRIMARY KEY,
	bank_name varchar(255) NOT NULL,
	bank_code varchar(50) NOT NULL
);

create table users_payment(
	users_id int references users(users_id) NOT NULL,
	bank_id int NOT NULL references banks_info(bank_id),
	account_number varchar(50) NOT NULL,
	expiry_date datetime
);

CREATE TABLE messages (
	messages_id int identity(1,1) primary key,
	sender int references users(users_id) NOT NULL,
	receiver int references users(users_id) NOT NULL
);

CREATE TABLE messages_content(
	messages_id int references messages(messages_id) NOT NULL,
	message_content nvarchar(max) NOT NULL,
	message_type char(100) NOT NULL,
	created_at datetime default current_timestamp,
	seen bit NOT NULL
);

CREATE TABLE deleted_messages(
	messages_id int references messages(messages_id) NOT NULL,
	message_content nvarchar(max) NOT NULL,
	message_type char(100) NOT NULL,
	deleted_at datetime default current_timestamp
);

CREATE TABLE users_friends (
	users_id int references users(users_id),
	friend_id int references users(users_id),
	date_modified datetime default current_timestamp
) ;

create table groups(
	group_id int identity(1,1) primary key,
	groupname varchar(50) NOT NULL,
	users_id int references users(users_id) NOT NULL,
	avatar char(50)
);


create table category(
	category_id int PRIMARY KEY IDENTITY(1,1),
	category_name varchar(255) NOT NULL
);

create table products(
	product_id int NOT NULL PRIMARY KEY IDENTITY(1,1),
	product_name varchar(255) NOT NULL,
	product_price float NOT NULL,
	product_title varchar(255) NOT NULL,
	product_description varchar(255) NOT NULL
);

create table products_image(
	product_id int references products(product_id),
	product_image_path varchar(50) NOT NULL,
	modified_at datetime default current_timestamp
);

create table products_inventory(
	product_id int references products(product_id),
	product_quantity int NOT NULL,
	modified_at datetime,
	created_at datetime default current_timestamp
);

create table products_category(
	product_id int NOT NULL references products(product_id),
	category_id int references category(category_id)
);

create table products_review (
	review_id int NOT NULL PRIMARY KEY IDENTITY(1,1),
	product_id int NOT NULL references products(product_id),
	title varchar(255) NOT NULL,
	review_content varchar(255) NOT NULL,
	rating varchar(255) NOT NULL,
	review_image_path varchar(255),
	created_at datetime default current_timestamp
);

Create table orders(
order_id int PRIMARY KEY IDENTITY(1,1),
order_by int REFERENCES users(users_id)
);

Create table orders_details(
order_id int references orders(order_id),
order_product_id int REFERENCES products(product_id),
order_amount int NOT NULL,
order_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);


Create table coupons(
coupon_code varchar(255) NOT NULL PRIMARY KEY,
product_discount_id int REFERENCES products(product_id),
discount_amount int NOT NULL,
expire_date datetime NOT NULL
);


create table users_cart(
	users_id varchar(50) references users(users_id) NOT NULL,
	product_id int NOT NULL references products(product_id),
	order_amount int NOT NULL,
	created_at datetime default current_timestamp
);

-----------------add data to users ---------------------
Insert into users(firstname,lastname,email,gender,avatar)
Values('mark','kass','user1@fpt.edu.vn',0,'images/girl.jpg'),
('john','viet','user2@fpt.edu.vn',1,'images/boy.jpg'),
('gary','bass','user3@fpt.edu.vn',1,'images/boy.jpg')

insert into users_role(users_id,user_role)
Values(1,'user'),
(2,'seller'),
(3,'seller')

insert into users_account(users_id,username,password)
Values(1,'user1','user1'),
(2,'user2','user2'),
(3,'user3','user3')

insert into users_address(users_id,home,district,city)
Values(1,'12 hang bai','Hoan Kiem' ,'Hanoi'),
(2,'55 Nguyen Hoang Ton','Bac Tu Liem' ,'Hanoi'),
(3,'2 Nguyen Trai','Quan 1' ,'Ho Chi Minh city')


insert into banks_info(bank_name,bank_code)
Values('Ngân hàng Nông nghiệp và Phát triển Nông thôn VN','Agribank'),
('Ngân hàng Xây dựng','CB'),
('Ngân hàng Đại Dương','OceanBank'),
('Ngân hàng Dầu Khí Toàn Cầu','GPBank'),
('Ngân hàng Đầu tư và Phát triển Việt Nam','BIDV'),
('Ngân hàng Công Thương Việt Nam ','Viettinbank'),
('Ngân hàng Ngoại Thương Việt Nam','Vietcombank'),
('Ngân hàng Việt Nam Thịnh Vượng','VP Bank'),
('Ngân hàng Quân Đội','MB'),
('Ngân hàng Tiên Phong','TP Bank'),
('Ngân hàng Kỹ Thương Việt Nam','Techcombank')










Insert into Category(Category_Name)
Values('foods'),
('drinks'),
('hats')

Insert into Products(Product_Name,Product_Image,Product_Price,Product_Title,Product_Description,Product_Size,cateID,sell_ID)
Values ('Nike Air Max 90','images/shoe1.jpg',1400.00,'nike air','new',100,1,3),	
('Jordan I High OG','images/shoe2.jpg',2600.00,'nike air','new',100,1,3)


Insert into Coupon(CouponCode,product_discount_id,Discount_Amount,Expire_Date)
Values('GIAM20',20,20,'2022-1-1'),
('GIAM50',50,'2022-1-1')	



----friends

insert into friends(user_id,friend_id) values('a1','a2'),
('a2','a1'),
('a1','a3'),
('a3','a1'),
('a4','a2'),
('a2','a4'),
('a1','a4'),
('a4','a1');

select * from users;

select * from friends;

select * from messages;

select * from conversations;

select * from conversations_users;


------------------------------------------------------------------------------
--load friends of user a1 (include requested friend)
select u.firstname+u.lastname
from users u inner join friends f
on u.username = f.user_id
where f.friend_id = 'a1' ;


--load messages of user a1 vs a2
select m.*
from messages m
where m.sender = 'a1'or m.receiver = 'a1'
order by created_at asc

--update seen 
update messages
set seen=1
where receiver='?'


--search friends
select u.lastname + ' ' + u.firstname
from users u 
where u.email like '%?%'

select u.lastname + ' ' + u.firstname
from users u 
where u.firstname like '%?%' or u.lastname like '%?%'


--send messages 
insert into messages 
Values(



--send group messages 
insert into messages 
Values(?,?



--a1 find friends to add into a group
select u2.username,u2.avatar,u2.gender 
from users u1 join friends f on u1.username = f.receiver 
join users u2 on u2.username = f.sender
where u1.username = 'a1' 
and f.status = 1
and u2.username like '%a%'
and u2.username not in (
	select u.username
	from users u join conversations_users cu
		on u.username = cu.username
	join conversations c
		on c.id = cu.conversations_id
	where c.id = 1
);

--load groups which a1 is joined
select c.id, c.name
from conversations c join conversations_users cu
	on c.id = cu.conversations_id
where cu.username = 'a1';

select g.
from groups g

--load users in con heo group
select u.username, u.avatar, u.gender
from users u join conversations_users cu
	on u.username = cu.username
join conversations c
	on c.id = cu.conversations_id
where c.id = 1

--load messages in con heo group 
select m.sender, u.avatar, m.message, m.receiver, m.message_type
from messages m join conversations c
on m.conversations_id = c.id
join users u on u.username = m.sender
where c.id = 1
order by created_at asc

--delete conversation by id
delete from conversations_users 
where conversations_id= 1;

delete from conversations 
where id = 1;

