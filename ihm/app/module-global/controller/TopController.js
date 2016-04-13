
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleGlobal').controller('TopController', 'LoginService', ['$location', '$rootScope', function($location, $rootScope, LoginService) {
	
	var myCtrl = this;
	
	// Fonction getProduit()
	myCtrl.isConnected = function() {
		return LoginService.isConnected();
	};
	
	
}]);