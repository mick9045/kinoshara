insert into users (name, login, password, birthday, email, enabled, ROLE_ID) VALUES('Valery', 'valera228', 'valerabas', '1997-10-29', 'vasya@gmail.com', true, 1)
insert into users (name, login, password, birthday, email, enabled, ROLE_ID) VALUES('admin', 'admin', '$2a$10$RfpUhq/sOlN8e2j0JSRZZeCyCCmA06XC88dFGVYpA9NrFGqN46Wcu', '2000-10-29', 'kolia@gmail.com', true, 2)
insert into users (name, login, password, birthday, email, enabled, ROLE_ID) VALUES('AZavoruyev', 'AZavoruyev', 'admin', '1986-08-15','azavoruev@gmail.com', true, 1)

insert into users (name, login, password, birthday, email, enabled, ROLE_ID) VALUES('Mizanin', 'Mizanin', '$2a$10$ySqBjl.DJ8ycoGIuYQP9qOPDZoAIgLB9TCN.Y/PDFdWenby30uNbu', '1998-08-15','mizanin666@gmail.com', true, 1)



insert into reviews(id, text, is_good, film_id, user_id) values (1, 'i wish i forget about it and watch it again and again', true, 1, 1)
insert into reviews(id, text, is_good, film_id, user_id) values (2, 'Its plenty good, but actors play was terrible some moments', true, 2,1 )
insert into reviews(id, text, is_good, film_id, user_id) values (3, 'Its Brilliant', true, 3,1)
insert into reviews(id, text, is_good, film_id, user_id) values (4, 'You are all suck', false, 4,3)
insert into reviews(id, text, is_good, film_id, user_id) values (5, 'Hate it',false,5,3)
insert into reviews(id, text, is_good, film_id, user_id) values (6, 'Best movie ever',true,6,3)

