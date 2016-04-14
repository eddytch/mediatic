var moduleAdherent = angular.module("ModuleAdherent") ;
moduleAdherent.service('ServiceAdherent',['$http',function($http){
    var self = this ;

    var uri = "http://10.34.10.140:8080/resource/adherent.recherche" ;
    var promise = undefined ;

    this.adherents = [] ;

    this.nbPages = Infinity;

    this.getAdherents = function(object){
        if(promise==undefined) {
            pages = $http.get(uri+'.taille',object).then(
                function(response){
                    self.nbPages = response.data['pages']
                }
            );
            promise = $http.get(uri,object).then(
                        function(response){
                            self.adherents.splice(0,self.adherents.length)
                            for(var index in response.data){
                            			var itemFromServeur = response.data[index];
                            			var itemForIHM = {
                            					id : itemFromServeur.id,
                            					nom : itemFromServeur.nom,
                            					prenom : itemFromServeur.prenom,
                            					email : itemFromServeur.email,
                            					date_naissance : itemFromServeur.date_naissance,
                            					cotisation_correcte : itemFromServeur.cotisation_correcte,
                            					nombre_media : itemFromServeur.nombre_media
                                        };
                                        self.adherents.push(itemForIHM);
                                        promise = undefined ;
                            }
                        }
                      );
        }
        return promise ;

    }

}]);