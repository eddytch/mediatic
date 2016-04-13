
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleMedia').controller('CreerMediaController', ['$location','$rootScope', '$scope', '$http', 'MediaService', function($location, $rootScope, $scope, $http, MediaService) {

	var myCtrl = this;
	var urlSave = 'http://10.34.10.140:8080/resource/media.creation';
	
	$rootScope.page = $rootScope.page || {};
	$rootScope.page.titre = "Création Media";
	
	myCtrl.medias = undefined;
	
	// Liste de type de media
	myCtrl.types = [
	               {key:'DVD', label:'DVD'},
	               {key:'CD', label:'CD'},
	               {key:'Livre', label:'Livres'}
	               ];		
	
	// Ajout d'un media
	myCtrl.addMedia = function() {
		
		if ($scope.myForm.$invalid) {
			console.warn('Erreur : formulaire invalide');
		} else {
			var item = myCtrl.item;
			$http.post(urlSave, item).then(function() {
				console.info('Données sauvegardées');
			}), function() {
				console.warn('Erreur dans la sauvegarde ...');
			}
			console.info('Formulaire valide ...');
		}
		
		var media = {
//				id : 'myId' + (id++),
				titre  : myCtrl.ajout.inputTitre,
				type   : myCtrl.ajout.inputType,
				auteur : myCtrl.ajout.inputAuteur,
			};
		MediaService.add(media);
		myCtrl.ajout = {};	
		
		console.log(media);
	}
	
}]);