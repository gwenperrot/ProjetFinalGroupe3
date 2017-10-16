//Création module angularJS
var app = angular.module("myApp", [ "ngRoute" ]);
// Configuration des différentes routes pour le site
app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "view/rechercheLivre.html",
		controller : "rechercheLivreCtrl"
	}).when("/creerCompte", {
		templateUrl : "view/formulairecreercompte.html",
		controller : "creerCompteCtrl"
	}).when("/monCompte", {
		templateUrl : "view/modifiercompte.html",
		controller : "modifierCompteCtrl"
	}).when("/mesReservations", {
		templateUrl : "view/mesreservations.html",
		controller : "mesReservationsCtrl"
	}).when("/gestionAdherents", {
		templateUrl : "view/gestionadherents.html",
		controller : "gestionAdherentsCtrl"
	}).when("/gestionLivres", {
		templateUrl : "view/gestionlivres.html",
		controller : "gestionLivresCtrl"
	}).when("/gestionAuteurs", {
		templateUrl : "view/gestionauteurs.html",
		controller : "gestionLivresCtrl"
	}).when("/gestionOeuvres", {
		templateUrl : "view/gestionoeuvres.html",
		controller : "gestionLivresCtrl"
	}).when("/gestionEmprunts", {
		templateUrl : "view/gestionemprunts.html",
		controller : "gestionEmpruntsCtrl"
	}).when("/gestionReservations", {
		templateUrl : "view/gestionreservations.html",
		controller : "gestionReservationsCtrl"
	});
});
// définition du crontroller de la page index
app.controller("indexCtrl", function($scope) {

	$scope.seConnecter = function() {
		$scope.varConnecte = "connecte";
		$scope.typeUtilisateur = "admin";

	};
	$scope.seDeconnecter = function() {
		$scope.varConnecte = "deconnecte";
		$scope.typeUtilisateur = "visiteur";
	};


	$scope.gestionLivres = function() {
		$scope.varGestionLivres = "liens";
	};
	$scope.gestionAutres = function() {
		$scope.varGestionLivres = "vide";
	};
	
	$scope.gererAuteurs = function() {
		$scope.msg = "Gestion des auteurs";
	};

	$scope.gererOeuvres = function() {
		$scope.msg = "Gestion des oeuvres";
	};
});

// définition du controller de la page creerCompte
app.controller("creerCompteCtrl", function($scope,$http) {
	// définiton de la fonction de création de compte
	$scope.adherent={};
	$scope.creerCompte = function() {
		alert($scope.adherent.nom);
		$http.post("http://localhost:8080/ProjetFinalGroupe3/saveAdherent", $scope.adherent).then(function(value) {
			alert($scope.adherent.nom);
			$scope.adherent=value;
			alert("ajouté à la bd");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		
		
	};

});
// définition du controller de la page modifierCompte
app.controller("modifierCompteCtrl", function($scope,$http) {
	$scope.idUtilisateur="21";
	$http.post("http://localhost:8080/ProjetFinalGroupe3/getAdherent", $scope.idUtilisateur).then(function(response) {
        $scope.adherent = response.data;
    }).catch(function(reason) {

    	alert("Erreur récupération");
    	console.log(reason);
    });
	// définition des différentes fonctions utile à la modification du compte
	// utilisateur
	$scope.modifierNom = function() {
		$scope.varNom = "modifierNom";
	};
	$scope.changerNom = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			alert("modifié");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		$scope.varNom = "afficherNom";
	};

	$scope.modifierPrenom = function() {
		$scope.varPrenom = "modifierPrenom";
	};
	$scope.changerPrenom = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			alert("modifié");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		$scope.varPrenom = "afficherPrenom";
	};

	$scope.modifierTel = function() {
		$scope.varTel = "modifierTel";
	};
	$scope.changerTel = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			alert("modifié");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		$scope.varTel = "afficherTel";
	};

	$scope.modifierVille = function() {
		$scope.varVille = "modifierVille";
	};
	$scope.changerVille = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			alert("modifié");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		$scope.varVille = "afficherVille";
	};

	$scope.modifierCodePostal = function() {
		$scope.varCodePostal = "modifierCodePostal";
	};
	$scope.changerCodePostal = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			alert("modifié");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		$scope.varCodePostal = "afficherCodePostal";
	};
	$scope.modifierLogin = function() {
		$scope.varLogin = "modifierLogin";
	};
	$scope.changerLogin = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			alert("modifié");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		$scope.varLogin = "afficherLogin";
	};
});
// définition du controller de la page rechercheLivre
app.controller("rechercheLivreCtrl", function($scope,$http) {
	// définition de la fonction de recherche de livre
	$scope.rechercherLivre = function() {
		alert($scope.typeRecherche + ' ' + $scope.rechercheLivre);
	};

	$scope.reserver = function() {
		alert("Je reserve un livre");
	};

	$scope.emprunter = function() {
		alert("J'emprunte un livre");
	};
});
// définition du controller de la page gestionAdherents
app.controller("gestionAdherentsCtrl", function($scope,$http) {
	$scope.msg = "Adherents";
	$scope.validerAdherent = function() {
		$scope.adherent={};
		$http.post("http://localhost:8080/ProjetFinalGroupe3/saveAdherent", $scope.adherent).then(function(data) {
			$scope.adherent=data;
			alert("ajouté à la bd");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
	};
});
// définition du controller de la page gestionLivres
app.controller("gestionLivresCtrl", function($scope,$http) {


	$scope.auteur={};
	$scope.validerAuteur = function() {
		$scope.auteur.nom=$scope.nom;
		$scope.auteur.prenom=$scope.prenom;
		$http.post("http://localhost:8080/ProjetFinalGroupe3/saveAuteur", $scope.auteur).then(function(data) {
			$scope.auteur=data;
			alert("ajouté à la bd");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
	};
	$scope.oeuvre={};
	$scope.validerOeuvre = function() {
		
		if($scope.oeuvre.id!=0){
			$http.post("http://localhost:8080/ProjetFinalGroupe3/saveOeuvre", $scope.oeuvre).then(function(data) {
				$scope.oeuvre=data;
				alert("ajouté à la bd");
			}).catch(function(reason) {
				alert("Pas ajouté, erreur");
				console.log(reason);
			});
			}else{
				$http.post("http://localhost:8080/ProjetFinalGroupe3/updateOeuvre", $scope.oeuvre).then(function(data) {
					$scope.oeuvre=data;
					alert("ajouté à la bd");
				}).catch(function(reason) {
					alert("Pas ajouté, erreur");
					console.log(reason);
				});
			}
			$scope.varOeuvre="oeuvre";
		};
		$scope.editerOeuvre = function() {
			$http.get("http://localhost:8080/ProjetFinalGroupe3/getOeuvre").then(function(response) {
		        $scope.oeuvre = response.data;
		    }).catch(function(reason) {

		    	alert("Erreur récupération");
		    	console.log(reason);
		    });
		};
	
	$scope.ajouterLivre = function() {
		$scope.varOeuvre="livre";
	};
	$scope.livre={};
	$scope.validerLivre = function() {
		if($scope.livre.id!=0){
		$http.post("http://localhost:8080/ProjetFinalGroupe3/saveLivre", $scope.livre).then(function(data) {
			$scope.livre=data;
			alert("ajouté à la bd");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		}else{
			$http.post("http://localhost:8080/ProjetFinalGroupe3/updateLivre", $scope.livre).then(function(data) {
				$scope.livre=data;
				alert("ajouté à la bd");
			}).catch(function(reason) {
				alert("Pas ajouté, erreur");
				console.log(reason);
			});
		}
		$scope.varOeuvre="oeuvre";
	};
	$scope.editerLivre = function() {
		$http.get("http://localhost:8080/ProjetFinalGroupe3/getLivre").then(function(response) {
	        $scope.livre = response.data;
	    }).catch(function(reason) {

	    	alert("Erreur récupération");
	    	console.log(reason);
	    });
	};
	$scope.supprimerLivre = function() {
		
	};
	
});
// définition du controller de la page gestionEmprunts
app.controller("gestionEmpruntsCtrl", function($scope) {
	$scope.msg = "Emprunts";
	$scope.adherent={};
	$scope.consulterEmprunts = function(){
		$http.get("http://localhost:8080/ProjetFinalGroupe3/getAdherent").then(function(response) {
	        $scope.adherent = response.data;
	    }).catch(function(reason) {

	    	alert("Erreur récupération");
	    	console.log(reason);
	    });
	};
	$scope.editerEmprunts = function(){
		
	};
	$scope.supprimerEmprunts = function(){
	
	};
	
});
// définition du controller de la page gestionReservations
app.controller("gestionReservationsCtrl", function($scope) {
	$scope.msg = "Reservations";
	$scope.adherent={};
	$scope.consulterReservations = function(){
		$http.get("http://localhost:8080/ProjetFinalGroupe3/getAdherent").then(function(response) {
	        $scope.adherent = response.data;
	    }).catch(function(reason) {

	    	alert("Erreur récupération");
	    	console.log(reason);
	    });
	};
	
	$scope.editerReservations = function(){
		
	};
	$scope.supprimerReservations = function(){
	
	};
});

app.controller("mesReservationsCtrl", function($scope) {
	$scope.msg = "Mes reservations/emprunts";
});

app.controller("allAdherentCtrl",function($scope, $http){
	$http.get("http://localhost:8080/ProjetFinalGroupe3/allAdherent")
    .then(function(response) {
        $scope.adherents = response.data;
       
    })
    .catch (function(reason){
    	alert("erreur de récupération des données");
    	console.log(reason);	
    })
});
