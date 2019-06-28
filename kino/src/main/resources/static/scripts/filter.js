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
				checkbox.attr("on", true);
				checkbox.button("refresh");
			} else {
				checkbox.attr("on", false);
			}
			
			checkbox.on("change", onRadioChangeHandler);
			checkbox.on("click", function (event) {
				var t = $(this);
				if (t.attr("on") == "true") {
					t.prop("checked", false);
					t.attr("on", false);
					
					t.button("refresh");
					window.location.href = "/";
				} else {
					t.prop("checked", true);
					t.button("refresh");
					
					t.attr("on", true);
					window.location.href = "/filter/genre/" + this.getAttribute("key");
				}
			});
		});
	});
	
	function onRadioChangeHandler(event) {
		/*
		if (event.target.checked) {
			window.location.href = "/filter/genre/" + this.getAttribute("key");
		} else {
			window.location.href = "/" 	 	;
		}
		*/
	}
});