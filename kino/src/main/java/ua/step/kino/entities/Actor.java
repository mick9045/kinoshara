package ua.step.kino.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Kojevin
 *
 */
@Entity
@Table(name = "actors")
@DiscriminatorValue("1")
public class Actor extends Personality {
	
}
