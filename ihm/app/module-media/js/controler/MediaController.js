
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleMedia').controller('MediaController', ['$location', '$location', , 
                                                                     function($location, $location) {
	var myCtrl = this;
	
	$rootScope.page = $rootScope.page || {};
	$rootScope.page.titre = "Media";
	
	myCtrl.medias = undefined;
	
	MediaService.getList().then(function(response){
		myCtrl.medias = response;
	}, function(){
		myCtrl.medias = -1;
	});
	
	myCtrl.hasErrorProduits = function(){
		return !(myCtrl.medias===undefined || ( _.isArray(myCtrl.medias) && myCtrl.medias.length>0));
	}
	
	myCtrl.getMedia= function(id){
		var index =myCtrl.medias.findIndex(function(media){
			return media.id == id;
		});
		return myCtrl.medias[index];
	}
	
	
	// Fonction pour editer
	myCtrl.showMedia = function(id) {
		$location.path('/media/'+id);
	}
	
}]);