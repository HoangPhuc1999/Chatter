drop database chatter;

create database chatter COLLATE Latin1_General_100_CI_AI_KS_WS_SC;

use chatter;;

CREATE TABLE users (
	username char(50) primary key,
	password char(50) NOT NULL,
	firstname varchar(50) NOT NULL,
	lastname varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	gender bit NOT NULL, 
	avatar char(50) NOT NULL
) ;

CREATE TABLE messages (
	id int identity(1,1) primary key,
	sender char(50) NOT NULL references users(username),
	receiver char(50) references users(username),
	message nvarchar(max) NOT NULL,
	message_type char(100) NOT NULL,
	created_at datetime default current_timestamp,
	seen bit NOT NULL,
) ;

CREATE TABLE friends (
	user_id char(50) references users(username),
	friend_id char(50) references users(username),
	date_modified datetime default current_timestamp
) ;

create table groups(
	id int identity(1,1) primary key,
	groupname varchar(50) NOT NULL,
	user_id references users(username) NOT NULL,
	avatar char(50);
	) ;

select * from users
delete from users where username = 'a1'

--users
insert into users values('a1','a1','fly','cow','user1@fpt.edu.vn',1,'boy.jpg');
insert into users values('a2','a2','slow','dog','user2@fpt.edu.vn',0,'girl.jpg');
insert into users values('a3','a3','fast','cat','user3@fpt.edu.vn',1,'boy.jpg');
insert into users values('a4','a4','gey','bird','user4@fpt.edu.vn',0,'girl.jpg');
----friends

insert into friends(user_id,friend_id) values('a1','a2'),
('a2','a1'),
('a1','a3'),
('a3','a1'),
('a4','a2'),
('a2','a4'),
('a1','a4'),
('a4','a1');

--message
--a1 vs a2
insert into messages(sender, receiver, message, message_type,seen) 
	values('a1','a2','a1 chào a2','text',0),
--a2 vs a1
	('a2','a1','bruhhhhhhhh','text',0),
	('a2','a1','a2 hello a1 - lan 2','text',0),
	('a2','a1','a2 hello a1 - lan 3','text',0),
	('a1','a2','a1 hello a2 - lan 2','text',0),
--a3 vs a1
	('a3','a1','a3 hello a1','text',0),
--a3 vs a2
	('a3','a2','a3 hello a2','text',0);

--messages in conversation con heo
insert into messages(sender, message, message_type, conversations_id) 
	values('a1','a1 hello group con heo', 'text',1);
	('a2','a2 hello group con heo', 'text',1);
	('a2','a2 hello group con heo-lan 2', 'text',1);
	('a3','a3 hello group con heo', 'text',1);

--check
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

--delete user from conversation
delete from conversations_users 
where username = 'a2' 
and conversations_id = 1;

--find conversation by keyword
select c.id, c.name, c.avatar
from conversations c join conversations_users cu
on cu.conversations_id = c.id
where c.name like '%con heo%'
and cu.username = 'a1'
