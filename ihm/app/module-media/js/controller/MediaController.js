
// Récupération du module des catalogue pour y ajouter le controller
angular.module('ModuleMedia').controller('MediaController', ['$location','$rootScope','MediaService', function($location, $rootScope, MediaService) {

	var myCtrl = this;
	var params = {};
	var pageActive = 0;
	
	$rootScope.page = $rootScope.page || {};
	$rootScope.page.titre = "Recherche media";

	//Creation de la variable medias qui contient les medias à afficher dans la page html
	myCtrl.medias = undefined;
	
	//Creation de la variableinfo qui contient le nombre d'items et le nombre de pages
	myCtrl.info = undefined;//{"items" : X,"pages" : Y}
	
	//Test si la recuperation des media est eroner
	myCtrl.hasErrorMedias = function(){
		return !(myCtrl.medias===undefined || ( _.isArray(myCtrl.medias) && myCtrl.medias.length>=0));
	}
	
	//Fonction pour obtenir des medias en fonction des parametres transmit
	var getMedias = function(){
		var mesParams = params;
		mesParams.page = pageActive;
		MediaService.getList(mesParams).then(function(response){
			myCtrl.medias = response;
		}, function(){
			myCtrl.medias = -1;
		});
	}

	//Fonction pour obtenir des informations en fonction des parametres
	var getInfo = function(params){
		MediaService.getInfo(params).then(function(response){
			myCtrl.info = response;
		}, function(){
			myCtrl.info = -1;
		});
	}

	//Récupération des medias au chargement de pa page html
	getInfo(params);
	getMedias(params);

		
	//récupération des medias en fonction des parametres saisient
	myCtrl.submit = function(){
		
		if(myCtrl.select){
			params = myCtrl.select;
		}
		getInfo(params);
		pageActive = 0;
		getMedias(params);
	}
	
//Gestion de la pagination		
 
	myCtrl.pageN = function (page) {
		pageActive = page;
		getMedias(params);
	}
	
	myCtrl.pageSuiv = function(){
		if(myCtrl.info.pages>0 && pageActive < (myCtrl.info.pages-1)){
			pageActive++;
			getMedias({page: pageActive});
		}
	}
	
	myCtrl.pagePrec = function(){
		if(pageActive > 0){
			pageActive--;
			getMedias({page: pageActive});
		}
	}
	
	myCtrl.pageActive = function(page){
		if(page==pageActive){
			return "active";
		}
	}
	
	myCtrl.pageDisabled = function(test){
		if(test){
			if(pageActive <= 0){
				return "disabled";
			}
		}else {
			if(pageActive >= ( myCtrl.info.pages-1)){
				console.log( myCtrl.info.pages-1);
				return "disabled";
			}
		}
	}
	
//Fonctions de redirection
	
	myCtrl.louerMedia = function(media) {
		console.warn('TODO : louer... ' + media.id);
	}

	myCtrl.voirMedia = function(media) {
		$location.path('/media='+media.id);
	}
	
}]);