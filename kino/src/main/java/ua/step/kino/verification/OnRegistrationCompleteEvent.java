package ua.step.kino.verification;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import ua.step.kino.entities.User;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
	
    private User user;
 
    public OnRegistrationCompleteEvent(
      User user) {
        super(user);
        this.user = user;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
     
}
