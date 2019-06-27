$(function() {
	var genresSection = $("#genres-filter-select-section");
	var allGenresRequest = "/genre/all";
	
	$.get(allGenresRequest, function(data) {
		var fieldSet = $("<fieldset>");
		var legend = $("<legend>Genres</legend>");
		fieldSet.append(legend);
		genresSection.append(fieldSet);

		$.each(data, function(i, val) {
			var checkbox = $("<input type='radio'>");
			var label = $("<label>");
			checkbox.prop("id", "genre-radio-" + i);
			checkbox.prop("name", "genre-radio");
			label.prop("for", "genre-radio-" + i);
			checkbox.attr("key", val.name);	
			label.html(val.name);
			fieldSet.append(checkbox);
			fieldSet.append(label);
			fieldSet.controlgroup();
			checkbox.checkboxradio();
			if (window.location.pathname.startsWith("/filter/genre/") &&
					window.location.pathname.endsWith(val.name)) {
				checkbox.prop("checked", true);
				checkbox.button("refresh");
			}
			
			checkbox.on("change", onRadioChangeHandler);
		});
	});
	
	function onRadioChangeHandler(event) {
		window.location.href = "/filter/genre/" + this.getAttribute("key");
	}
});