// Création du module ModuleLogin
angular.module('ModuleLogin', ['ngRoute']);

// Configuration du module ModuleLogin
// => Injection du Provider du service $route afin de configurer la route do login
angular.module('ModuleLogin').config(function($routeProvider){
	$routeProvider.when('/login', {
		templateUrl : './module-login/templates/login.html',
		controller : 'LoginController',
		controllerAs : 'loginCtrl'
	});
});