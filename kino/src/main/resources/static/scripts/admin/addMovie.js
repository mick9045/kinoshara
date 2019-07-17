$(function() {
	var addedActors = $("#input-added-actors");
	var addedDirectors = $("#input-added-directors");
	var searchActors = $("#input-search-actors");
	var searchDirectors = $("#input-search-directors");
	
	var searchActorsButton = $("#button-search-actors");
	var searchDirectorsButton = $("#button-search-directors");
	
	var allActors = $("#input-all-actors");
	var allDirectors = $("#input-all-directors");
	
	var addActorButton = $("#button-add-actor");
	var addDirectorButton = $("#button-add-director");
	
	var removeActorButton = $("#button-remove-added-actor");
	var removeDirectorButton = $("#button-remove-added-director");
	
	search({
		searchButton: searchActorsButton,
		searchInput: searchActors,
		addButton: addActorButton,
		removeButton: removeActorButton,
		all: allActors,
		added: addedActors,
		getRequest: '/api/personality/Actor'
	});
	
	search({
		searchButton: searchDirectorsButton,
		searchInput: searchDirectors,
		addButton: addDirectorButton,
		removeButton: removeDirectorButton,
		all: allDirectors,
		added: addedDirectors,
		getRequest: '/api/personality/Actor'
	});
	
	
});


function search(context) {
	
	context.searchButton.click(function(e) {
		$.get(context.getRequest, function(data){
			context.all.empty();
			data = data.filter(filterById.bind(context));

			for (let i = 0; i < data.length; i++) {
				let element = data[i];
				var option = document.createElement("option");
				option.innerHTML = element.firstName + ' ' +  element.lastName;
				option.setAttribute('data-id', element.id);
				option.addEventListener('dblclick', onClick);
				context.all.append(option);
			}
		});
	});
	
	context.addButton.click(function(event) {
		var select = context.all[0];
		var option = $(select.options[select.selectedIndex]);
		option.detach();
		context.added.append(option);
	});
	
	context.removeButton.click(function(event) {
		var select = context.added[0];
		select.options[select.selectedIndex].remove();

	});
}

function onClick(event) {
	window.open("/actors/" + event.originalTarget.getAttribute("data-id"));
	//window.location.href = "/actors/" + event.originalTarget.getAttribute("data-id");
}

function Filter(context) {
	this.context = context;
	return this;
}

function filterById(item) {
	var alreadyAdded = false;
	this.added.children('option').each(function (index) {
		if (this.getAttribute("data-id") == item.id) {
			alreadyAdded = true;
			return false;
		}
		return true;
	});
	return alreadyAdded === false;
}


