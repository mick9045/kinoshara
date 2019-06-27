insert into directors (id, name, birthday, country_id) VALUES (1,'F. Gary Gray', '1969-06-17', 1)
insert into directors (id, name, birthday, country_id) VALUES (2,'Christopher Nolan ', '1970-07-30', 2)
insert into directors (id, name, birthday, country_id) VALUES (3,'Gordon Din', '1986-02-01', 4)
insert into directors (id, name, birthday, country_id) VALUES (4,'John Smight', '1991-10-21', 3)
insert into directors (id, name, birthday, country_id) VALUES (5,'Scott Derrickson', '1966-07-16', 2)
insert into directors (id, name, birthday, country_id) VALUES (6,'Taika Waititi', '1975-08-16', 2)
insert into directors (id, name, birthday, country_id) VALUES (7,'Anthony Russo', '1970-02-03', 2)
insert into directors (id, name, birthday, country_id) VALUES (8,'Joseph Russo', '1971-07-08', 2)
insert into directors (id, name, birthday, country_id) VALUES (9,'Zack Snyder', '1966-03-01', 2)
insert into directors (id, name, birthday, country_id) VALUES (10,'Frank Darabont', '1959-01-28', 2)
insert into directors (id, name, birthday, country_id) VALUES (11,'Scott Speer', '1982-06-02', 2)

insert into films(id, title, image_Small_Path, release_Year) VALUES (1, 'Men in Black: International', 'MIB.jpg', 2019)
insert into films(id, title, image_Small_Path, release_Year) VALUES (2, 'Inception', 'inception.jpg', 2010)
insert into films(id, title, image_Small_Path, release_Year) VALUES (3, 'Thor 3: Ragnarok', 'thor_3.jpg', 2017)
insert into films(id, title, image_Small_Path, release_Year) VALUES (4, 'Avengers', 'avengers_3.jpg', 2018)
insert into films(id, title, image_Small_Path, release_Year) VALUES (5, 'Green Mile', 'green_mile.jpg', 1999)
insert into films(id, title, image_Small_Path, release_Year) VALUES (6, 'Interstellar', 'Interstellar.jpg', 2014)
insert into films(id, title, image_Small_Path, release_Year) VALUES (7, 'Midnight sun', 'midnight_sun.jpg', 2018)
insert into films(id, title, image_Small_Path, release_Year) VALUES (8, 'Man of steel', 'Man_of_Steel.jpg', 2013)
insert into films(id, title, image_Small_Path, release_Year) VALUES (9, 'Doctor Strange', 'Doctor_Strange_poster.jpg', 2016)

insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (1,1)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (2,2)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (3,6)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (4,7)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (4,8)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (5,10)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (6,2)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (7,11)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (8,9)
insert into DIRECTORS_FILMS  (films_id, director_id) VALUES (9,5)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(1, 'Chris', 'Hemsworth', '1983-08-11', 2)
insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(2, 'Scarlett', 'Johansson', '1984-11-22', 2)
insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(3, 'Chris', 'Evans', '1981-07-13', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(4, 'Leonardo', 'DiCaprio', '1974-11-11', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(5, 'Tessa', 'Thompson', '1983-10-03', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(6, 'Benedict', 'Cumberbatch', '1976-07-19 ', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(7, 'Henry', 'Cavill', '1983-05-05 ', 2)
insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(8, 'Amy', 'Adams', '1974-08-20 ', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(9, 'Tom', 'Hanks', '1956-07-09 ', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(10, 'Joseph', 'Gordon-Levitt', '1981-02-17 ', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(11, 'Bella', 'Thorne', '1997-10-8 ', 2)

insert into Actors (id, first_Name, last_Name, date_Of_Birthday, country_id) VALUES(12, 'Matthew', 'McConaughey', '1969-11-04', 2)


insert into ACTORS_FILMS (films_id, actor_id) VALUES (1,1)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (1,5)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (2,4)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (2,10)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (3,1)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (3,5)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (4,3)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (4,2)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (5,9)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (6,12)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (7,11)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (8,7)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (8,8)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (9,1)
insert into ACTORS_FILMS (films_id, actor_id) VALUES (9,6)


insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (1, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (2, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (3, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (4, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (6, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (5, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (7, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (8, 2)
insert into FILMS_COUNTRIES (film_id, countries_id) VALUES (9, 2)

insert into Genres (id, name) VALUES (1, 'superhero')
insert into Genres (id, name) VALUES (2, 'adventure')
insert into Genres (id, name) VALUES (3, 'fantasy ')
insert into Genres (id, name) VALUES (4, 'crime')
insert into Genres (id, name) VALUES (5, 'action ')
insert into Genres (id, name) VALUES (6, 'thriller')
insert into Genres (id, name) VALUES (7, 'drama')
insert into Genres (id, name) VALUES (8, 'romance')
insert into Genres (id, name) VALUES (9, 'horror')
insert into Genres (id, name) VALUES (10, 'comedy')



insert into FILMS_GENRES (film_id, genres_id) VALUES (1, 1)
insert into FILMS_GENRES (film_id, genres_id) VALUES (1, 2)
insert into FILMS_GENRES (film_id, genres_id) VALUES (2, 5)
insert into FILMS_GENRES (film_id, genres_id) VALUES (2, 6)
insert into FILMS_GENRES (film_id, genres_id) VALUES (3, 1)
insert into FILMS_GENRES (film_id, genres_id) VALUES (3, 2)
insert into FILMS_GENRES (film_id, genres_id) VALUES (4, 1)
insert into FILMS_GENRES (film_id, genres_id) VALUES (4, 2)
insert into FILMS_GENRES (film_id, genres_id) VALUES (5, 3)
insert into FILMS_GENRES (film_id, genres_id) VALUES (5, 4)
insert into FILMS_GENRES (film_id, genres_id) VALUES (6, 2)
insert into FILMS_GENRES (film_id, genres_id) VALUES (6, 5)
insert into FILMS_GENRES (film_id, genres_id) VALUES (6, 7)
insert into FILMS_GENRES (film_id, genres_id) VALUES (7, 7)
insert into FILMS_GENRES (film_id, genres_id) VALUES (7, 8)
insert into FILMS_GENRES (film_id, genres_id) VALUES (8, 1)
insert into FILMS_GENRES (film_id, genres_id) VALUES (8, 2)
insert into FILMS_GENRES (film_id, genres_id) VALUES (9, 1)

