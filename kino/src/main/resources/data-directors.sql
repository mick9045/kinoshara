insert into directors (id, name, birthday, country_id) VALUES (1,'John King', '1965-03-12', 1)
insert into directors (id, name, birthday, country_id) VALUES (2,'Vill Smight', '1973-11-15', 2)
insert into directors (id, name, birthday, country_id) VALUES (3,'Gordon Din', '1986-02-01', 4)
insert into directors (id, name, birthday, country_id) VALUES (4,'John Smight', '1991-10-21', 3)

insert into films(id, title) VALUES (1,'Armaggedon')
insert into films(id, title) VALUES (2,'Averangrs')
insert into films(id, title) VALUES (3, 'asdfs')

insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (1,2)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (2,2)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (3,2)