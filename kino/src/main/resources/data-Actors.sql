insert into films(id, title) VALUES (1, 'Alise')

insert into Countries (id, name) VALUES(1, 'USA')
insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(1, 'Крис', 'Хемсворт', '1983-08-11', 1)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(2, 'Скарлетт', 'Йоханссон', '1984-11-22', 1)
insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(3, 'Крис', 'Эванс', '1981-07-13', 1)

insert into ACTORS_FILMS (films_id, actor_id) VALUES (1,1)