
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleLogin').controller('LoginController', ['$location', '$rootScope','LoginService', function($location, $rootScope,LoginService) {
	var myCtrl = this;
	
	// Je défini l'attribut PAGE pas si il n'ai pas déjà défini
	$rootScope.page = $rootScope.page || {};
	// Je défini l'attribut TITRE de PAGE
	$rootScope.page.titre = "Login";	
	
	LoginService.connect(login, mdp);
}]);