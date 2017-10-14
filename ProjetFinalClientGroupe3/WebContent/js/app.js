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
app.controller("creerCompteCtrl", function($scope) {
	// définiton de la fonction de création de compte
	$scope.creerCompte = function() {
		alert($scope.adherent.nom + " " + $scope.adherent.prenom + " " + $scope.adherent.telephone + " "
				+ $scope.adherent.ville + " " + $scope.adherent.codePostal);
	};

});
// définition du controller de la page modifierCompte
app.controller("modifierCompteCtrl", function($scope) {

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
app.controller("rechercheLivreCtrl", function($scope) {
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
app.controller("gestionAdherentsCtrl", function($scope) {
	$scope.msg = "Adherents";
	$scope.validerAdherent = function() {
		alert($scope.nom + " " + $scope.prenom + " " + $scope.telephone + " "
				+ $scope.ville + " " + $scope.codePostal);
	};
});
// définition du controller de la page gestionLivres
app.controller("gestionLivresCtrl", function($scope) {
	$scope.msg = "Gestion des auteurs";

	$scope.gererAuteurs = function() {
		$scope.msg = "Gestion des auteurs";
		$scope.varLivre = "auteurs";
	};

	$scope.gererOeuvres = function() {
		$scope.msg = "Gestion des oeuvres";
		$scope.varLivre = "oeuvres";
	};

	$scope.validerAuteur = function() {
		alert($scope.nom + " " + $scope.prenom);
	};

	$scope.validerOeuvre = function() {
		alert($scope.titre + " " + $scope.auteurAssocie);
	};
	
	$scope.ajouterLivre = function() {
		$scope.varOeuvre="livre";
	};
	$scope.validerLivre = function() {
		alert($scope.etat+" "+$scope.numInventaire);
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
