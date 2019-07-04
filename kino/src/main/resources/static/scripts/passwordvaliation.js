var password = document.getElementById("password");

password.addEventListener("input", function (event) {
  if (password.validity.patternMismatch) {
    password.setCustomValidity("Password too weak!");
  } else {
    password.setCustomValidity("");
  }
});