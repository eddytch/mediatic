angular.module('ModuleApp', ['ngRoute', 'ngMessages', 'ModuleMenu','ModuleMedia','ModuleAdherent','ModuleGlobal','ModuleLogin']);
//'ModuleGlobal', 'ModuleMedia', 'ModuleAdherent','ngRoute'

angular.module('ModuleApp').config(function($httpProvider){
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
});