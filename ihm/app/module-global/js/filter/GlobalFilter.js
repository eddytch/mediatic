angular.module('ModuleGlobal').filter('DateFormat', [ function() {
	return function(input) {
		if (input) {
			return input.split("T")[0];
		}
		return;
	}
}]);

angular.module('ModuleGlobal').filter('NomPrenom', [ function() {
	return function(input) {
		if (input) {
			return input.nom + " " + input.prenom;
		}
		return;
	}
}]);

angular.module('ModuleGlobal').filter('for', [ function() {
	return function(input, total) {
		if(!total){
			input.push(0);
		}else{
			nb = parseInt(total);
			for (var i=0; i<nb; i++) {
				input.push(i);
			}
		}
		return input;
	};
}]);