insert into users (name, login, password, birthday, ROLE_ID) VALUES('Valery', 'valera228', 'valerabas', '1997-10-29', 1)
insert into users (name, login, password, birthday, ROLE_ID) VALUES('AAdmin', 'admin', 'admin', '2000-10-29', 2)
insert into users (name, login, password, birthday, ROLE_ID) VALUES('AZavoruyev', 'AZavoruyev', 'admin', '1986-08-15', 1)


insert into reviews(id, review, is_good, film_id, user_id) values (1, 'i wish i forget about it and watch it again and again', true, 1, 1)
insert into reviews(id, review, is_good, film_id, user_id) values (2, 'Its plenty good, but actors play was terrible some moments', true, 2,1 )
insert into reviews(id, review, is_good, film_id, user_id) values (3, 'Its Brilliant', true, 3,1)
insert into reviews(id, review, is_good, film_id, user_id) values (4, 'You are all suck', false, 4,3)
insert into reviews(id, review, is_good, film_id, user_id) values (5, 'Hate it',false,5,3)
insert into reviews(id, review, is_good, film_id, user_id) values (6, 'Best movie ever',true,6,3)