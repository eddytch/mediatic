
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleMedia').controller('MediaController', ['$location','$rootScope','MediaService', function($location, $rootScope, MediaService) {

	var myCtrl = this;
	
	
	
	var getMedia = function(params){
		MediaService.getList(params).then(function(response){
			myCtrl.medias = response;
		}, function(){
			myCtrl.medias = -1;
		});
	}
	getMedia({});
	
	
	
	$rootScope.page = $rootScope.page || {};
	$rootScope.page.titre = "Media";
	
	myCtrl.medias = undefined;
	
	myCtrl.submit = function(){
		var params = {};
		if( myCtrl.medias.select.page){
			params.page = myCtrl.medias.select.page;
		}
		if( myCtrl.medias.select.titre){
			params.titre = myCtrl.medias.select.titre;
		}
		if( myCtrl.medias.select.auteur){
			params.auteur = myCtrl.medias.select.auteur;
		}
		if( myCtrl.medias.select.type){
			params.type = myCtrl.medias.select.type;
		} 
		getMedia(params);
	}
	

	
	myCtrl.hasErrorProduits = function(){
		return !(myCtrl.medias===undefined || ( _.isArray(myCtrl.medias) && myCtrl.medias.length>0));
	}
	

	myCtrl.louerMedia = function(media) {
		console.warn('TODO : louer... ' + media.id);
	}

	myCtrl.voirMedia = function(media) {
		console.warn('TODO : voir... ' + media.id);
		$location.path('/media/'+id);
	}

	myCtrl.editProduit = function(media) {
		console.warn('TODO  : edit... ' + media.id);
	}
	
}]);