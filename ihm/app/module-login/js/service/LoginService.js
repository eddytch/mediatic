// Récupération du module global pour y ajouter le service du Panier

//Récupération du module global pour y ajouter le service du Panier
angular.module('ModuleLogin').service('LoginService', ['$http', function($http) {
	
	var self = this;
	
	var url = "http://10.34.10.140:8080/resource/connexion.login";
	var promise = undefined;
	
	// Fonction pour voir si l'user est connecté
	this.isConnected = function(){
		
	}
	
	// Fonction qui permet de se connecter
	this.connect = function(login, mdp){
		if (promise == undefined) {
			promise = $http.post(url, {'login' : login, 'mdp' : mdp}).then(function(response) {
				return response.data;
			})
		}
	};
	
}]);