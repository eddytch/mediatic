angular.module("ModuleAdherent",['ngRoute','angularUtils.directives.dirPagination']) ;
// Configuration du module ModuleCommande
// => Injection du Provider du service $route afin de configurer la route des commandes.
angular.module('ModuleAdherent').config(function($routeProvider){
	$routeProvider.when('/adherent', {
		templateUrl : './module-adherent/templates/rechercherAdherent.html',
		controller : 'AdherentController',
		controllerAs : 'adherentController'
	});
});
