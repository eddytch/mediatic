angular.module('ModuleGlobal').filter('DateFormat', [ function() {
	return function(input) {
		if (input) {
			return input.split("T")[0];
		}
		return;
	}
} ]);

angular.module('ModuleGlobal').filter('NomPrenom', [ function() {
	return function(input) {
		if (input) {
			return input.nom + " " + input.prenom;
		}
		return "-";
	}
} ]);