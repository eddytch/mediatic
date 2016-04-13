var moduleAdherent = angular.module("ModuleAdherent") ;
moduleAdherent.controller('AdherentController',function($scope,ServiceAdherent){

    ServiceAdherent.getAdherents() ;
    this.adherents = ServiceAdherent.adherents ;

}) ;