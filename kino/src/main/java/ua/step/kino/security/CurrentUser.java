package ua.step.kino.security;


import org.springframework.security.core.authority.AuthorityUtils;

import ua.step.kino.entities.Role;
import ua.step.kino.entities.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
	
	private static final long serialVersionUID = 1L;
	private User user;

	public CurrentUser(User user) {
		super(user.getName(), user.getPassword(), user.isEnabled(), true, true, true, 
				AuthorityUtils.createAuthorityList(user.getRole().getName()));
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	public Integer getId() {
		return user.getId();
	}
	
	public Role getRole() {
		return user.getRole();
	}
	
	 @Override
	    public String toString() {
	        return "CurrentUser{" +
	                "user=" + user +
	                "} " + super.toString();
	 }
}
