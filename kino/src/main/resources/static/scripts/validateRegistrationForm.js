function validateRegistrationForm() {

        var login = document.forms["my-form"]["login"].value;
        var password = document.forms["my-form"]["password"].value;
        var passwordConfirm = document.forms["my-form"]["confirm-password"].value;
        var emailAddress = document.forms["my-form"]["email"].value;
        var yearOfBirthday = document.forms["my-form"]["birthday"].value;

        if (login==null || login=="")
        {
            alert("Please enter your login");
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