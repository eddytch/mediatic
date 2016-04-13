var moduleAdherent = angular.module("ModuleAdherent") ;
moduleAdherent.service('ServiceAdherent',['$http',function($http){
    var self = this ;

    var uri = "http://10.34.10.140:8080/resource/adherent.recherche" ;
    var promise = undefined ;

    this.adherents = [] ;


    this.getAdherents = function(){
        if(promise==undefined) {
            promise = $http.get('http://10.34.10.140:8080/resource/adherent.recherche').then(
                        function(response){
                            for(var index in response.data){
                            			var itemFromServeur = response.data[index];
                            			var itemForIHM = {
                            					id : itemFromServeur.id,
                            					nom : itemFromServeur.nom,
                            					prenom : itemFromServeur.prenom,
                            					date_naissance : itemFromServeur.date_naissance,
                            					cotisation_correcte : itemFromServeur.cotisation_correcte
                                        };
                                        self.adherents.push(itemForIHM);
                            }
                        }
                      );
        }
        return promise ;

    }

}]);