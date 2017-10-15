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

});
// définition du controller de la page creerCompte
app.controller("creerCompteCtrl", function($scope,$http) {
	// définiton de la fonction de création de compte
	$scope.adherent={};
	$scope.creerCompte = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/saveAdherent", $scope.adherent).then(function(data) {
			$scope.adherent=data;
			alert("ajouté à la bd");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		
		
	};

});
// définition du controller de la page modifierCompte
app.controller("modifierCompteCtrl", function($scope,$http) {

	// définition des différentes fonctions utile à la modification du compte
	// utilisateur
	$scope.modifierNom = function() {
		$scope.varNom = "modifierNom";
	};
	$scope.changerNom = function() {
		alert($scope.nom);
		$scope.varNom = "afficherNom";
	};

	$scope.modifierPrenom = function() {
		$scope.varPrenom = "modifierPrenom";
	};
	$scope.changerPrenom = function() {
		alert($scope.prenom);
		$scope.varPrenom = "afficherPrenom";
	};

	$scope.modifierTel = function() {
		$scope.varTel = "modifierTel";
	};
	$scope.changerTel = function() {
		alert($scope.tel);
		$scope.varTel = "afficherTel";
	};

	$scope.modifierVille = function() {
		$scope.varVille = "modifierVille";
	};
	$scope.changerVille = function() {
		alert($scope.ville);
		$scope.varVille = "afficherVille";
	};

	$scope.modifierCodePostal = function() {
		$scope.varCodePostal = "modifierCodePostal";
	};
	$scope.changerCodePostal = function() {
		alert($scope.codePostal);
		$scope.varCodePostal = "afficherCodePostal";
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
	$scope.msg = "Gestion des auteurs";

	$scope.gererAuteurs = function() {
		$scope.msg = "Gestion des auteurs";
		$scope.varLivre = "auteurs";
	};

	$scope.gererOeuvres = function() {
		$scope.msg = "Gestion des oeuvres";
		$scope.varLivre = "oeuvres";
	};
	$scope.auteur={};
	$scope.validerAuteur = function() {
		$scope.auteur.nom=$scope.nom;
		$scope.auteur.prenom=$scope.prenom;
		alert($scope.auteur.nom);
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
		
		$http.post("http://localhost:8080/ProjetFinalGroupe3/saveOeuvre", $scope.oeuvre).then(function(data) {
			$scope.oeuvre=data;
			alert("ajouté à la bd");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
	};
	
	$scope.ajouterLivre = function() {
		$scope.varOeuvre="livre";
	};
	$scope.livre={};
	$scope.validerLivre = function() {
		
		$http.post("http://localhost:8080/ProjetFinalGroupe3/saveLivre", $scope.livre).then(function(data) {
			$scope.livre=data;
			alert("ajouté à la bd");
		}).catch(function(reason) {
			alert("Pas ajouté, erreur");
			console.log(reason);
		});
		$scope.varOeuvre="oeuvre";
	};
	$scope.editerLivre = function() {
		
	};
	$scope.supprimerLivre = function() {
		
	};
	
});
// définition du controller de la page gestionEmprunts
app.controller("gestionEmpruntsCtrl", function($scope) {
	$scope.msg = "Emprunts";
});
// définition du controller de la page gestionReservations
app.controller("gestionReservationsCtrl", function($scope) {
	$scope.msg = "Reservations";
});

app.controller("mesReservationsCtrl", function($scope) {
	$scope.msg = "Mes reservations/emprunts";
});
