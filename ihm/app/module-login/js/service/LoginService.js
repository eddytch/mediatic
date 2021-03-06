// Récupération du module global pour y ajouter le service du Panier

//Récupération du module global pour y ajouter le service du Panier
angular.module('ModuleLogin').service('LoginService', ['$http', '$q', function($http, $q) {
	
	var ctrl = this;
	
	var url = "http://10.34.10.140:8080/resource/connexion.login";
	var connected = false;
		
	// Fonction pour voir si l'user est connecté
	this.isConnected = function(){
		return connected;
	}
	
	// Fonction qui permet de se connecter
	this.connect = function(login, mdp){
		
		// Fonction qui permet de dire que l'user est connecté
		return $http.post(url, {'login' : login, 'mdp' : mdp}).then(function(response) {
			connected = true;
			return true;
		}, function(response) {
			return false;
		});
	};
	
	// Fonction déconnexion
	this.logout = function() {
		connected = false;
	};
    
}]);