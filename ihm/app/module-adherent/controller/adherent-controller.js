var moduleAdherent = angular.module("ModuleAdherent") ;
moduleAdherent.controller('AdherentController',function($scope,ServiceAdherent){

    self = this ;
    this.pageCourante = 0 ;
    var service = ServiceAdherent ;
    this.adherents = service.adherents ;
    this.rechCrit = { params : {}} ;

    this.numCritPrec = 0 ;
    this.valuePrec = "" ;


    this.noms = ['id','nom','prenom','email'] ;

    this.getPage = function(page){
        var rechPages = { params : { "page" : page}  } ;
        service.getAdherents(rechPages) ;
    }

    this.getPageSuivante = function() {
        self.pageCourante ++ ;
        self.getPageCourante() ;
    }

    this.getPagePrecedente = function() {
        self.pageCourante -- ;
        self.getPageCourante() ;
    }


    this.getPageCourante = function(){
         if(self.rechCrit == {})
             self.getPage(self.pageCourante) ;
         else
             self.getAdherents(self.numCritPrec,self.valuePrec) ;
    }

    this.getAdherents = function(numCrit, value){
        self.numCritPrec = numCrit ;
        self.value = value ;

        var nom = self.noms[numCrit] ;
        self.pageCourante = 0 ;
        var params = self.rechCrit['params'] ;
        params['page'] = self.pageCourante ;
        if (value != undefined && value != "")
            params[nom] = value ;
        else
            delete params[nom] ;

        service.getAdherents(self.rechCrit) ;
    }
    this.getPage(this.pageCourante) ;


}) ;