package ua.step.kino.entities;

import javax.persistence.*;

@Entity
@Table(name = "actors")

@DiscriminatorValue("1")
public class Actor extends Personality {

	
}
