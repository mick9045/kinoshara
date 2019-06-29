function validateRegistrationForm() {

        var username = document.forms["my-form"]["username"].value;
        var password = document.forms["my-form"]["password"].value;
        var passwordConfirm = document.forms["my-form"]["confirm-password"].value;
        var emailAddress = document.forms["my-form"]["email-address"].value;
        var yearOfBirthday = document.forms["my-form"]["year_of_birth"].value;

        if (username==null || username=="")
        {
            alert("Please enter your username");
            return false;
        }else if (password==null || password=="")
        {
            alert("Please enter your password");
            return false;
        }else if (passwordConfirm==null || passwordConfirm=="")
        {
            alert("Please enter your confirm password");
            return false;
        }else if (emailAddress==null || emailAddress=="")
        {
            alert("Please enter your email");
            return false;
        }else if (yearOfBirthday==null || yearOfBirthday=="")
        {
            alert("Please enter your year of birthday");
            return false;
        }

    }