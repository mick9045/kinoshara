package ua.step.kino.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
@DiscriminatorValue("2")
public class Director extends Personality {
	
}