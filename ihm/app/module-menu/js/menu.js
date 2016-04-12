
// Création du module Module Menu
angular.module('ModuleMenu', ['ngRoute']);

// Configuration du module Module Menu
// => Injection du Provider du service $route afin de configurer la route des commandes.
//angular.module('ModuleMenu').config(function($routeProvider){
//	$routeProvider.when('/livre/:idLivre', {
//		templateUrl : './module-menu/templates/menu.html',
//		controller : 'MenuController',
//		controllerAs : 'MenuCtrl'
//	});
//});