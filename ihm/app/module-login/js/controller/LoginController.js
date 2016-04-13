
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleLogin').controller('LoginController', ['$location', '$rootScope', '$scope','LoginService', function($location, $rootScope, $scope, LoginService) {
	var myCtrl = this;
	
	// Je défini l'attribut PAGE pas si il n'ai pas déjà défini
	$rootScope.page = $rootScope.page || {};
	// Je défini l'attribut TITRE de PAGE
	$rootScope.page.titre = "Login";	
	
	myCtrl.validForm = function(){
    	if ($scope.myFormLogin.$invalid) {
    		console.warn('Erreur : formulaire invalide');
		} else {
			var login = myCtrl.login;
			var mdp = myCtrl.pwd;
			
			LoginService.connect(login, mdp);
		}
	}
}]);