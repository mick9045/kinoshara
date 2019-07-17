$(function() {
	var addedActors = $("#input-added-actors");
	var addedDirectors = $("#input-added-directors");
	var searchActors = $("#input-search-actors");
	var searchDirectors = $("#input-search-directors");
	
	var searchActorsButton = $("#button-search-actors");
	var searchDirectorsButton = $("#button-search-directors");
	
	var allActors = $("#input-all-actors");
	var allDirectors = $("#input-all-directors");
	
	
	
	search({
		searchButton: searchActorsButton,
		searchInput: searchActors,
		all: allActors,
		added: addedActors,
		getRequest: '/api/personality/Actor'
	});
	
	
});


function search(context) {
	context.searchButton.click(function(e) {
		$.get(context.getRequest, function(data){
			var option = document.createElement("option");
			alert(data);
		});
	});
}
