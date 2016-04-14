var moduleAdherent = angular.module("ModuleAdherent") ;
moduleAdherent.service('ServiceAdherent',['$http',function($http){
    var self = this ;

    var uri = "http://10.34.10.140:8080/resource/adherent" ;
    var uriRech = uri+".recherche" ;
    var uriCreation = uri+".creation" ;
    var promise = undefined ;

    this.adherents = [] ;

    this.nbPages = Infinity;

    this.getAdherents = function(object){

        pages = $http.get(uriRech+'.taille',object).then(
                function(response){
                    self.nbPages = response.data['pages']
                }
        );
        promise = $http.get(uriRech,object).then(
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
                }
            }
        );

        return promise ;

    }

    this.addAdherent = function(object){
        promise = $http.post(uriCreation,{params : object} ).then(
            function(response){
                console.log(response) ;
            }

        );
        return promise ;
    }

}]);