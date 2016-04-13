angular.module('ModuleMedia').service('MediaService', ['$http', function($http) {

		
		var self = this;
		var url = "http://10.34.10.140:8080/resource/media.recherche";
		var urlInfo = "http://10.34.10.140:8080/resource/media.recherche.taille";// {"items":X,"pages":Y}
		
//		var getParam = function(){
//			return = $http.get(url).then(function(response) {
//				console.log(url);
//				return response.data;
//			});
//		}
		
		var getPromise = function(params){
			return $http.get(url, {params:params}).then(function(response) {
				return response.data;
			});
		}
		
//		self.submit = function(params){
//			console.log(url, params);
//			initPromise();
//		}
		
//		format d'un media :
//		id : "69",
//		titre : "La petite maison dans la prairie",
//		auteur : "Michael Landon",
//		type : "DVD",
//		emprunteur : null, emprunteur actuel
//		emprunteurs : [], historique des emprunteurs
//		retour : null
		
		self.getList = function(params){
			return getPromise(params);
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
}]);
