(function(window, location) {
	history.replaceState(null, document.title, location.pathname+"#!/history");
	history.pushState(null, document.title, location.pathname);

	var query = localStorage.getItem('query');
	var searchUrl = '/customer/kitchen/search?query=' + query.substring(1, query.length - 1);
	
	window.addEventListener("popstate", function() {
		if(location.hash === "#!/history") {
			history.replaceState(null, document.title, location.pathname);
			setTimeout(function(){
				location.replace(searchUrl);
			},0);
		}
	}, false);
}(window, location));