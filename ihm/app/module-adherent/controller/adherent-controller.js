var moduleAdherent = angular.module("ModuleAdherent") ;
moduleAdherent.controller('AdherentController',function($scope,ServiceAdherent){

    self = this ;
    this.pageCourante = 0 ;
    var service = ServiceAdherent ;
    this.adherents = service.adherents ;
    this.service = service ;
    this.rechCrit = { params : {}} ;

    this.numCritPrec = 0 ;
    this.valuePrec = "" ;



    this.noms = ['id','nom','prenom','email'] ;

    this.getPage = function(page){
        var rechPages = { params : { "page" : page}  } ;
        service.getAdherents(rechPages) ;
    }

    this.getPageSuivante = function() {
        self.correctPage() ;
        self.pageCourante ++ ;
        self.getPageCourante() ;
    }

    this.getPagePrecedente = function() {
        self.correctPage() ;
        self.pageCourante -- ;
        self.getPageCourante() ;
    }


    this.getPageCourante = function(){
         if(Object.keys(self.rechCrit['params']).length == 0)
             self.getPage(self.pageCourante) ;
         else
             self.getAdherents(self.numCritPrec,self.valuePrec) ;
    }

    this.correctPage = function(){
        if(Object.keys(self.rechCrit['params']).length == 0)
            self.pageCourante = 0 ;
    }

    this.getAdherents = function(numCrit, value){
        self.numCritPrec = numCrit ;
        self.valuePrec = value ;

        var nom = self.noms[numCrit] ;

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