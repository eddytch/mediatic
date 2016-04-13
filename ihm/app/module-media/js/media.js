angular.module('ModuleMedia', ['ngRoute']);

angular.module('ModuleMedia').config(function($routeProvider){
	
	$routeProvider.when('/media', {
		templateUrl : './module-media/templates/media.html',
		controller : 'MediaController',
		controllerAs : 'mediaCtrl'
	});
	
	$routeProvider.when('/media/creation', {
		templateUrl : './module-media/templates/creerMedia.html',
		controller : 'CreerMediaController',
		controllerAs : 'creerMediaCtrl'
	});
	
});