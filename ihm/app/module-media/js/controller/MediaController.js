
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleMedia').controller('MediaController', ['$location','$rootScope','MediaService', function($location, $rootScope, MediaService) {

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
		console.warn('TODO : voir... ' + media.id);
		$location.path('/media/'+id);
	}

	myCtrl.editProduit = function(media) {
		console.warn('TODO  : edit... ' + media.id);
	}
	
}]);