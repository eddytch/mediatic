angular.module('ModuleMedia').filter('TypeIcon', [ function() {
	return function(input) {
		switch (input) {
		case "CD":
			return "glyphicon glyphicon-cd";
		case "DVD":
			return "glyphicon glyphicon-film";
		case "Livre":
			return "glyphicon glyphicon-book";
		default:
			return "glyphicon glyphicon-remove-sign";
		}
	}
} ]);