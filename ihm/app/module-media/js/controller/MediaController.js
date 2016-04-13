
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleMedia').controller('MediaController', ['$location','$rootScope','MediaService', function($location, $rootScope, MediaService) {

	var myCtrl = this;
	
	$rootScope.page = $rootScope.page || {};
	$rootScope.page.titre = "Media";
	
	
	myCtrl.medias = undefined;
	myCtrl.info = undefined;
	
	
	MediaService.getInfo().then(function(response){
		myCtrl.info = response;
	}, function(){
		myCtrl.info = -1;
	});
	
	var getMedias = function(params){
		MediaService.getList(params).then(function(response){
			myCtrl.medias = response;
		}, function(){
			myCtrl.medias = -1;
		});
	}
	getMedias({});
		
	myCtrl.submit = function(){
		var params = {};
		if (myCtrl.select) {
			params = myCtrl.select;
		}
		getMedias(params);
	}
	
	myCtrl.goPage = function (page) {
		getMedias({page: page});
	}	

	
	myCtrl.hasErrorMedias = function(){
		return !(myCtrl.medias===undefined || ( _.isArray(myCtrl.medias) && myCtrl.medias.length>0));
	}

	myCtrl.getEmprunteur = function(media) {
		if(media.emprunteur){
			return media.emprunteur.nom + " " + media.emprunteur.prenom;
		}
		return "-";
	}
	

	myCtrl.louerMedia = function(media) {
		console.warn('TODO : louer... ' + media.id);
	}


	myCtrl.voirMedia = function(media) {
		$location.path('/media='+media.id);
	}

	myCtrl.editProduit = function(media) {
		console.warn('TODO  : edit... ' + media.id);
	}
	
}]);