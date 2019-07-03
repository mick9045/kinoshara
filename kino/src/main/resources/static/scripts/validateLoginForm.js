function validateLoginForm() {
		
        var username = document.forms["my-form"]["username"].value;
        var password = document.forms["my-form"]["password"].value;

        if (username==null || username=="")
        {
            alert("Please enter your username");
            return false;
        }
        else if (password==null || password=="")
        {
            alert("Please enter your password");
            return false;
        }

    }