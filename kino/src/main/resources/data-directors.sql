insert into directors (id, name, birthday, country_id) VALUES (1,'F. Gary Gray', '1969-06-17', 1)
insert into directors (id, name, birthday, country_id) VALUES (2,'test director 2', '1973-11-15', 2)
insert into directors (id, name, birthday, country_id) VALUES (3,'Gordon Din', '1986-02-01', 4)
insert into directors (id, name, birthday, country_id) VALUES (4,'John Smight', '1991-10-21', 3)

insert into films(id, title, image_Small_Path) VALUES (1,'Men in Black International', '/images/1.jpg')
insert into films(id, title, image_Small_Path) VALUES (2, 'Kingdom', '/images/2.jpg')
insert into films(id, title, image_Small_Path) VALUES (3, 'Alise', '/images/3.jpg')
insert into films(id, title) VALUES (4,'Averangrs')
insert into films(id, title) VALUES (5, 'Green Mile')
insert into films(id, title) VALUES (6, 'Long way home')
insert into films(id, title) VALUES (7, 'Midnight sun')
insert into films(id, title) VALUES (8, 'Man of steel')

insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (1,1)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (2,2)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (3,2)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (4,1)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (5,1)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (6,4)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (7,4)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (8,3)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(1, 'Chris', 'Hemsworth', '1983-08-11', 2)
insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(2, 'Scarlett', 'Johansson', '1984-11-22', 2)
insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(3, 'Chris', 'Evans', '1981-07-13', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(4, 'Leonardo', 'DiCaprio', '1974-11-11', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(5, 'Tessa', 'Thompson', '1983-10-03', 2)

insert into ACTORS_FILMS (films_id, actor_id) VALUES (1,1)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (1,5)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (2,4)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (3,5)

insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (1, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (2, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (3, 2)

insert into Genres (name) VALUES ('superhero')
insert into Genres (name) VALUES ('adventure')

insert into FILMS_GENRES (film_id, genres_id) VALUES (1, 1)
insert into FILMS_GENRES (film_id, genres_id) VALUES (1, 2)

