function post(){
	 var formData = new FormData(document.forms.personForm);
	 var xhr = new XMLHttpRequest();
	  xhr.open("POST", "/admin/add/person");
	  xhr.send(formData);
}