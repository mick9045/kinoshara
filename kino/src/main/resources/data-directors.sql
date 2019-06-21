insert into directors (id, name, birthday, country_id) VALUES (1,'John King', '1965-03-12', 1)
insert into directors (id, name, birthday, country_id) VALUES (2,'Vill Smight', '1973-11-15', 2)
insert into directors (id, name, birthday, country_id) VALUES (3,'Gordon Din', '1986-02-01', 4)
insert into directors (id, name, birthday, country_id) VALUES (4,'John Smight', '1991-10-21', 3)

insert into films(id, title) VALUES (1,'Armaggedon')
insert into films(id, title) VALUES (2,'Averangrs')
insert into films(id, title) VALUES (3, 'Green Mile')
insert into films(id, title) VALUES (4, 'Long way home')
insert into films(id, title) VALUES (5, 'Midnight sun')
insert into films(id, title) VALUES (6, 'Man of steel')
insert into films(id, title) VALUES (7, 'Kingdom')
insert into films(id, title) VALUES (8, 'Alise')


insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (1,2)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (2,2)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (3,2)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (4,1)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (5,1)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (6,4)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (7,4)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (8,3)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(1, 'Крис', 'Хемсворт', '1983-08-11', 1)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(2, 'Скарлетт', 'Йоханссон', '1984-11-22', 1)
insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(3, 'Крис', 'Эванс', '1981-07-13', 1)

insert into ACTORS_FILMS (films_id, actor_id) VALUES (1,1)
