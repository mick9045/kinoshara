$(function() {
	var searchButton = $("#searchButton");
	var searchTextBox = $("#searchTextBox");
	
	searchTextBox.autocomplete({
		source: function(request, response) {
			$.get( "/search/" + request.term, function(data) {
				var titles = [data.length];
				for (var i = 0; i < data.length; i++) {
					titles[i] = {
							label: data[i].title,
							value: data[i].title,
							data: data[i]
					};
				}
				for (var i = 0; i < titles.length; i++) {
					response(titles);
				}
			});
		},
		select: function(event, ui) {
			window.location.href="/films/?id="+ui.item.data.id;
		}
	});
})