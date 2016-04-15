angular.module("ModuleAdherent",['ngRoute']) ;
// Configuration du module ModuleCommande
// => Injection du Provider du service $route afin de configurer la route des commandes.
angular.module('ModuleAdherent').config(function($routeProvider){
	$routeProvider.when('/adherent', {
		templateUrl : './module-adherent/templates/rechercherAdherent.html',
		controller : 'AdherentController',
		controllerAs : 'adherentController'
	});
	$routeProvider.when('/adherent/creation', {
    		templateUrl : './module-adherent/templates/addAdherent.html',
    		controller : 'CreationAdherentController',
    		controllerAs : 'creationAdherentController'
    });
    $routeProvider.when('/adherent=:id', {
    		templateUrl : './module-adherent/templates/consultationAdherent.html',
    		controller : 'voirAdherent-controller.js',
    		controllerAs : 'voirAdherentCtrl'
    });
});
