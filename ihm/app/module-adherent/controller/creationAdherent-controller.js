var moduleAdherent = angular.module("ModuleAdherent") ;
moduleAdherent.controller('CreationAdherentController',['$scope','$filter','ServiceAdherent',function($scope,$filter,ServiceAdherent){

    var self = this ;
    this.service = ServiceAdherent ;

    this.addAdherent = function(isValid){
        if(!isValid) { return }
        var dateNConv = $filter('date')($scope.dateN,"dd/MM/yyyy") ;
        var dateCotisConv = $filter('date')($scope.dateCotis,"dd/MM/yyyy") ;

        var object = {
            "nom" : $scope.nom,
            "prenom" : $scope.prenom,
            "email" : $scope.email,
            "date_naissance" : dateNConv,
            "adresse" : {
                "ligne1" : $scope.numVoie,
                "ligne2" : $scope.compl,
                "codepostal" : $scope.cP,
                "ville" : $scope.ville
            },
            "cotisation" :{
                "debut" : dateCotisConv,
                "fin" : self.dateIncAnnee(dateCotisConv) ,
                "montant" : $scope.montantCotis

            }
        }
        self.service.addAdherent(object) ;
    };

    this.dateIncAnnee = function(date) {
        return date.substr(0,6)+(parseInt(date.substr(6,4))+1)

    }
}]);