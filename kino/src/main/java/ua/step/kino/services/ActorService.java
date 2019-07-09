package ua.step.kino.services;

import java.util.List;

import ua.step.kino.entities.Actor;


public interface ActorService {
	List<Actor> findAll();
	Actor getById(int id);
	List<Actor> findByName();
}