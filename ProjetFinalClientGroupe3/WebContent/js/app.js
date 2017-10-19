//Création module angularJS
var app = angular.module("myApp", [ "ngRoute" ]);
//Configuration des différentes routes pour le site
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
//définition du crontroller de la page index
app.controller("indexCtrl", function($scope,$http) {
	$scope.showMe2 = true;
	$scope.seConnecter = function() {
		
		$http.get("http://localhost:8080/ProjetFinalGroupe3/connexion", {params:{login: $scope.login, mdp: $scope.mdp}}).then(function(value) {
			$scope.utilisateur=value.data;
			$scope.varConnecte = "connecte";
			$scope.typeUtilisateur=$scope.utilisateur.type_Utilisateur;
			$scope.idUtilisateur=$scope.utilisateur.idUtilisateur;
			alert("connecté");
			$scope.showMe2 = false;
			$scope.hideMe = false;
		}).catch(function(reason) {
			alert("erreur de connexion");
			console.log(reason);
		});


	}
	
	$scope.showMe = false;
	$scope.hideMe = false;
    $scope.showFunc = function() {
        $scope.showMe = !$scope.showMe;
        $scope.hideMe = !$scope.hideMe;
    };
    
	
	$scope.seDeconnecter = function() {
		$scope.varConnecte = "deconnecte";
		$scope.typeUtilisateur = "visiteur";
		$scope.showMe2 = true;
		$scope.hideMe = true;
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

//définition du controller de la page creerCompte
app.controller("creerCompteCtrl", function($scope,$http) {
	// définiton de la fonction de création de compte
	$scope.adherent={};
	$scope.creerCompte = function() {
		alert($scope.adherent.nom);
		$http.post("http://localhost:8080/ProjetFinalGroupe3/saveAdherent", $scope.adherent).then(function(value) {
			alert($scope.adherent.nom);
			$scope.adherent=value;
			
		}).catch(function(reason) {
			alert("Erreur");
			console.log(reason);
		});


	};

});
//définition du controller de la page modifierCompte
app.controller("modifierCompteCtrl", function($scope,$http) {

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
			alert("Erreur");
			console.log(reason);
		});
		$scope.varNom = "afficherNom";
	};

	$scope.modifierPrenom = function() {
		$scope.varPrenom = "modifierPrenom";
	};
	$scope.changerPrenom = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			
		}).catch(function(reason) {
			alert("Erreur");
			console.log(reason);
		});
		$scope.varPrenom = "afficherPrenom";
	};

	$scope.modifierTel = function() {
		$scope.varTel = "modifierTel";
	};
	$scope.changerTel = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			
		}).catch(function(reason) {
			alert("Erreur");
			console.log(reason);
		});
		$scope.varTel = "afficherTel";
	};

	$scope.modifierVille = function() {
		$scope.varVille = "modifierVille";
	};
	$scope.changerVille = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			
		}).catch(function(reason) {
			alert("Erreur");
			console.log(reason);
		});
		$scope.varVille = "afficherVille";
	};

	$scope.modifierCodePostal = function() {
		$scope.varCodePostal = "modifierCodePostal";
	};
	$scope.changerCodePostal = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			
		}).catch(function(reason) {
			alert("Erreur");
			console.log(reason);
		});
		$scope.varCodePostal = "afficherCodePostal";
	};
	$scope.modifierLogin = function() {
		$scope.varLogin = "modifierLogin";
	};
	$scope.changerLogin = function() {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
			
		}).catch(function(reason) {
			alert("Erreur");
			console.log(reason);
		});
		$scope.varLogin = "afficherLogin";
	};
});
//définition du controller de la page rechercheLivre
app.controller("rechercheLivreCtrl", function($scope,$http) {
	// définition de la fonction de recherche de livre
	$scope.rechercherLivre = function(typeRecherche) {

		switch (typeRecherche) {

		case "auteur":
			$http.post("http://localhost:8080/ProjetFinalGroupe3/livreParAuteurAdmin?mc=",$scope.rechercheLivre)
			.then(function(response) {
				$scope.oeuvres = response.data;
			})
			.catch (function(reason){
				alert("erreur de récupération des données");
				console.log(reason);	
			})
			break;

		case "titre":
			$http.post("http://localhost:8080/ProjetFinalGroupe3/livreParMCAdmin?mc=", $scope.rechercheLivre )
			.then(function(response) {

				$scope.oeuvres = response.data;

			})
			.catch (function(reason){
				alert("erreur de récupération des données");
				console.log(reason);	
			})
			break;
		default:
			alert("Erreur");
		break;
		}
	};

	$scope.reserver = function() {
		alert("Je reserve un livre");
	};

	$scope.emprunter = function() {
		alert("J'emprunte un livre");
	};
});
//définition du controller de la page gestionAdherents
app.controller("gestionAdherentsCtrl", function($scope,$http,$route) {
	$scope.msg = "Adherents";
	$scope.gererAdherent = function() {

		if($scope.adherent.idUtilisateur==null){
			$http.post("http://localhost:8080/ProjetFinalGroupe3/saveAdherent", $scope.adherent).then(function(data) {
				$scope.adherent=data;
				
			}).catch(function(reason) {
				alert("Erreur");
				console.log(reason);
			});
		}else{
			$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAdherent", $scope.adherent).then(function(data) {
				$scope.adherent=data;
				
			}).catch(function(reason) {
				alert("Erreur");
				console.log(reason);
			});
		};
		$route.reload();
		$scope.adherent={};
	};
	$scope.editerAdherent = function(idUtilisateur) {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/getAdherent",idUtilisateur).then(function(response) {
			$scope.adherent = response.data;
		}).catch(function(reason) {

			alert("Erreur récupération");
			console.log(reason);
		});
	};
	$scope.supprimerAdherent = function(idUtilisateur) {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/deleteAdherentAdmin",idUtilisateur).then(function(response) {
			alert("supprimé");
			$route.reload();
		}).catch(function(reason) {

			alert("Erreur récupération");
			console.log(reason);
		});
	};
});
//définition du controller de la page gestionLivres
app.controller("gestionLivresCtrl", function($scope,$http,$route) {
	$http.get("http://localhost:8080/ProjetFinalGroupe3/allAuteur")
	.then(function(response) {
		$scope.auteurs = response.data;

	})
	.catch (function(reason){
		alert("erreur de récupération des données");
		console.log(reason);	
	});

	$scope.validerAuteur = function() {
		if($scope.auteur.idAuteur==null){
			$http.post("http://localhost:8080/ProjetFinalGroupe3/saveAuteur", $scope.auteur).then(function(data) {
				$scope.auteur=data;
				
			}).catch(function(reason) {
				alert("Pas ajouté, erreur");
				console.log(reason);
			});
		}else{
			$http.post("http://localhost:8080/ProjetFinalGroupe3/updateAuteur", $scope.auteur).then(function(data) {
				$scope.auteur=data;
				
			}).catch(function(reason) {
				alert("Pas ajouté, erreur");
				console.log(reason);
			});
		};
		$route.reload();
		$scope.auteur={};
	};
	$scope.editerAuteur = function(idAuteur) {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/getAuteur", idAuteur).then(function(response) {
			$scope.auteur = response.data;
		}).catch(function(reason) {

			alert("Erreur récupération");
			console.log(reason);
		});
	};
	$scope.supprimerAuteur = function(idAuteur) {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/deleteAuteur",idAuteur).then(function(response) {
			alert("supprimé");
			$route.reload();
		}).catch(function(reason) {

			alert("Erreur récupération");
			console.log(reason);
		});
	};
	$scope.validerOeuvre = function() {
		
		if($scope.oeuvre.idOeuvre==null){
			$http.post("http://localhost:8080/ProjetFinalGroupe3/saveOeuvre", $scope.oeuvre).then(function(data) {
				$scope.oeuvre=data.data;
				

				$http.get("http://localhost:8080/ProjetFinalGroupe3/attibuerOeuvreAuteur", {params:{idOeuvre: $scope.oeuvre.idOeuvre, idAuteur: $scope.lauteur}})
				.then(function(data) {
					
					$scope.oeuvre={};
					$route.reload();

					$scope.varOeuvre="oeuvre";
				}).catch(function(reason) {
					
					console.log(reason);
				});
			}).catch(function(reason) {
				alert("Erreur");
				console.log(reason);
			});
		}else{
			$http.post("http://localhost:8080/ProjetFinalGroupe3/updateOeuvre", $scope.oeuvre).then(function(data) {
				$scope.oeuvre=data.data;
				alert($scope.oeuvre.idOeuvre);
				alert("Modifié");

				$http.get("http://localhost:8080/ProjetFinalGroupe3/attibuerOeuvreAuteur", {params:{idOeuvre: $scope.oeuvre.idOeuvre, idAuteur: $scope.lauteur}})
				.then(function(data) {
					
					$scope.oeuvre={};
					$route.reload();

					$scope.varOeuvre="oeuvre";
				}).catch(function(reason) {
					
					console.log(reason);
				});
			}).catch(function(reason) {
				alert("Erreur");
				console.log(reason);
			});			
		}
	};
	$scope.editerOeuvre = function(idOeuvre) {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/getOeuvre",idOeuvre).then(function(response) {
			$scope.oeuvre = response.data;
		}).catch(function(reason) {

			alert("Erreur récupération");
			console.log(reason);
		});
	};
	$scope.supprimerOeuvre = function(idOeuvre) {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/deleteOeuvre",idOeuvre).then(function(response) {
			alert("Supprimé");
			$route.reload();
		}).catch(function(reason) {

			alert("Erreur récupération");
			console.log(reason);
		});
	};

	$scope.ajouterLivre = function(o) {
		$scope.varOeuvre="livre";
		$scope.loeuvre=o.idOeuvre;
		$scope.titre=o.titre;
		$scope.auteurPrenom=o.lauteur.prenom;
		$scope.auteurNom=o.lauteur.nom;
		$scope.msg="Ajouter un livre";
	};

	$http.get("http://localhost:8080/ProjetFinalGroupe3/allOeuvre")
	.then(function(response) {
		$scope.oeuvres = response.data;

	})
	.catch (function(reason){
		alert("erreur de récupération des données");
		console.log(reason);	
	});


	$scope.validerLivre = function() {
		alert($scope.loeuvre);
		if($scope.livre.idLivre==null){
			$http.post("http://localhost:8080/ProjetFinalGroupe3/saveLivre", $scope.livre).then(function(data) {

				$scope.livre=data.data;
				

				$http.get("http://localhost:8080/ProjetFinalGroupe3/attibuerLivreOeuvre", {params:{idLivre: $scope.livre.idLivre, idOeuvre: $scope.loeuvre}})
				.then(function(data) {
					$scope.livre=data.data;
					
				}).catch(function(reason) {
					
					console.log(reason);
				});
			}).catch(function(reason) {
				alert("Erreur");
				console.log(reason);
			});
		}else{
			
			$http.post("http://localhost:8080/ProjetFinalGroupe3/updateLivre", {params:{l: $scope.livre, etatPrecedent: $scope.etatPrecedent}}).then(function(data) {
				$scope.livre=data.data;
				
			}).catch(function(reason) {
				alert("Erreur");
				console.log(reason);
			});			
		}
		$scope.varOeuvre="livre";
		$scope.livre={};
		$route.reload($scope.varOeuvre);
		
		

	};
	$scope.editerLivre = function(idLivre) {
		$scope.msg="Editer un livre";
		$http.post("http://localhost:8080/ProjetFinalGroupe3/getLivre", idLivre).then(function(response) {
			$scope.livre = response.data;
			$scope.etatPrecedent=$scope.livre.dispo;
		}).catch(function(reason) {

			alert("Erreur récupération");
			console.log(reason);
		});
	};
	$scope.supprimerLivre = function(idLivre) {
		$http.post("http://localhost:8080/ProjetFinalGroupe3/deleteLivre", idLivre).then(function(response) {
			alert("Supprimé");
			$route.reload();
		}).catch(function(reason) {

			alert("Erreur récupération");
			console.log(reason);
		});
	};

});
//définition du controller de la page gestionEmprunts
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
//définition du controller de la page gestionReservations
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
app.controller("allAuteursCtrl",function($scope, $http){
	$http.get("http://localhost:8080/ProjetFinalGroupe3/allAuteur")
	.then(function(response) {
		$scope.auteurs = response.data;

	})
	.catch (function(reason){
		alert("erreur de récupération des données");
		console.log(reason);	
	})
});

app.controller("allOeuvresCtrl",function($scope, $http){
	$http.get("http://localhost:8080/ProjetFinalGroupe3/allOeuvre")
	.then(function(response) {
		$scope.oeuvres = response.data;

	})
	.catch (function(reason){
		alert("erreur de récupération des données");
		console.log(reason);	
	})
});

app.controller("allLivresCtrl",function($scope, $http){
	$http.get("http://localhost:8080/ProjetFinalGroupe3/allLivre")
	.then(function(response) {
		$scope.livres = response.data;
		alert($scope.livres.length);
		$scope.livresOeuvre={};
		n=0;
		for(var i=0;i<$scope.livres.length;i++){
			if($scope.titre==$scope.livres[i].loeuvre.titre){
				$scope.livresOeuvre[n]=$scope.livres[i];
				if($scope.livresOeuvre[n].dispo){
					$scope.livresOeuvre[n].dispoText="Disponible";
				}
				else{
					$scope.livresOeuvre[n].dispoText="Indisponible";
				}
			}
			n++;
		}
	})
	.catch (function(reason){
		alert("erreur de récupération des données");
		console.log(reason);	
	});
});
