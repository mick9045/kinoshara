package ua.step.kino.validation;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

public class UserDto {
	
	    @NotNull
	    @NotEmpty
	    private String login;
	    
	     
	    @NotNull
	    @Past
	    private LocalDate birthday;
	     
	    @NotNull
	    @NotEmpty
	    @Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$")
	    private String password;
	    private String confirm_password;
	     
	    @NotNull
	    @NotEmpty
	    private String email;

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public LocalDate getBirthday() {
			return (birthday);
		}

		public void setBirthday(String birthday) {
			
			this.birthday =  LocalDate.parse(birthday);
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirm_password() {
			return confirm_password;
		}

		public void setConfirm_password(String confirm_password) {
			this.confirm_password = confirm_password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	     
	    // standard getters and setters
	
}
