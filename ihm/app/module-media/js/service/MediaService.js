angular.module('ModuleMedia').service('MediaService', ['$http','$sce', function($http, $sce) {
		
		var self = this;
		var url = "http://10.34.10.140:8080/resource/media.recherche";
		var promise = undefined;
		
		var initPromise = function(){
			if (promise == undefined) {
				promise = $http.get(url).then(function(response) {
					return response.data;;

				});
			}
		}
		
//		format d'un media :
//		id : "69",
//		titre : "La petite maison dans la prairie",
//		auteur : "Michael Landon",
//		type : "DVD",
//		emprunteur : null,
//		emprunteurs : [],
//		retour : null

		
		self.getList = function(){
			initPromise();
			return promise;
		}

		self.getMedia = function(id){
			initPromise();
			return promise.then(function(list){
				var index = list.findIndex(function(media){
					return media.id == id;
				});
				return 	list[index];
			});			
		}
		
		
		// Ajout d'une commande
		myCtrl.addProduit = function(id) {
			console.warn('TODO ... ');
		}
		
		// Fonction pour supprimer
		myCtrl.editProduit = function(id) {
			console.warn('TODO ... ');
		}
}]);
