angular.module('ModuleAdherent').controller('VoirAdherentController', ['$routeParams','$rootScope','ServiceAdherent','$scope', function($routeParams, $rootScope, ServiceAdherent,$scope) {


	$rootScope.page.titre = "Modifier/voir un adherent";
    var self = this ;
	var idAdherent  = $routeParams.id;


	MediaService.getMedia(idMedia).then(function(response){
		$scope.media = response;
		console.log(response);
	}, function(){
		$scope.media = {};
	});

}]);