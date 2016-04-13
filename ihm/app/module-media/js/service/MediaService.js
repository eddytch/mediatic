angular.module('ModuleMedia').service('MediaService', ['$http', function($http) {

	var self = this;
	var lignes = [];
			
	var url = "http://10.34.10.140:8080/resource/media.recherche";
	var getPromise = function(params){
		return $http.get(url, {params:params}).then(function(response) {
			return response.data;
		});
	}
	
	var urlInfo = url +".taille";
	self.getInfo = function(){
		return $http.get(urlInfo).then(function(response) {
			return response.data;
		});
	}
	
	self.getList = function(params){
		return getPromise(params);
	}

	// Fonction pour ajouter un media
	self.add = function(media) {	

		var index = lignes.findIndex(function(lignes) {
			return lignes.media.id == media.id;
		});
		
		if (index != -1) {
			lignes.push({
				media : media
			});
		} 
	};

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
