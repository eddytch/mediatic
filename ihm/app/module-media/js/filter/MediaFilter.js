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

angular.module('ModuleMedia').filter('DateFormat', [ function() {
	return function(input) {
		if (input) {
			return input.split(" ")[0];
		}
		return;
	}
} ]);

angular.module('ModuleMedia').filter('Emprunteur', [ function() {
	return function(input) {
		if (input) {
			return input.nom + " " + input.prenom;
		}
		return "-";
	}
} ]);