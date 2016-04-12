// Récupération du module global pour y ajouter le service du Panier

//Récupération du module global pour y ajouter le service du Panier
angular.module('ModuleLogin').service('LoginService', ['$http', function($http) {
	
	var ctrl = this;
	
	var url = "http://10.34.10.140:8080/resource/connexion.login";
	var connected = false;
	
	// Fonction pour voir si l'user est connecté
	this.isConnected = function(){
		return connected;
	}
	
	// Fonction qui permet de se connecter
	this.connect = function(login, mdp){
		return $http.post(url, {'login' : login, 'mdp' : mdp}).then(function(response) {
			connected = true;
			return response.data;
		});
	};
    
    this.getValidForm = function() {
    	if ($scope.myFormLogin.$invalid) {
    		console.warn('Erreur : formulaire invalide');
		} else {
			var item = ctrl.item;
			$http.post(url, item).then(function(){
				console.info('Données sauvegardées')
			}, function(){
				console.warn('Erreur dans la sauvegarde ...');
			})
			console.info('Formulaire valide ...')
		}
	}
	
}]);