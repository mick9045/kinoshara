package ua.step.kino.security;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ua.step.kino.entities.Role;
import ua.step.kino.entities.User;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
	
	private static final long serialVersionUID = 1L;
	private User user;

	public CurrentUser(User user) {
		super(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().getName()));
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
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authoroties = new HashSet<>();
		authoroties.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName().toUpperCase()));
		return authoroties;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

	@Override
	    public String toString() {
	        return "CurrentUser{" +
	                "user=" + user +
	                "} " + super.toString();
	 }
}
