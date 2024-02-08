document.addEventListener('DOMContentLoaded', function () {
    const employeTableBody = document.getElementById('employeList');

    // Charger la liste des employés au chargement de la page
    fetchEmployes();

    // Fonction pour charger la liste des employés
    function fetchEmployes() {
        fetch('/employe')
            .then(response => response.json())
            .then(employes => displayEmployes(employes))
            .catch(error => console.error('Error fetching employes:', error));
    }

    // Fonction pour afficher la liste des employés dans un tableau
  function displayEmployes(employes) {
      employeTableBody.innerHTML = '';

      employes.forEach(employe => {
          if (!employe.email.includes('admin')) { // Vérifier si l'email ne contient pas "admin"
              const row = employeTableBody.insertRow();
              const idCell = row.insertCell(0);
              const emailCell = row.insertCell(1);
              const passwordCell = row.insertCell(2);
              const deleteCell = row.insertCell(3);

              // Remplir les cellules avec les données de l'employé
              idCell.textContent = employe.id;
              // emailCell.textContent = employe.email;
              passwordCell.textContent = employe.email;

              // Créer un bouton de suppression
              const deleteButton = document.createElement('button');
              deleteButton.textContent = 'Delete';

              // Ajouter un style au bouton de suppression
              deleteButton.style.backgroundColor = 'red';
              deleteButton.style.color = 'white'; // Pour s'assurer que le texte est lisible sur le fond rouge

              // Ajouter un gestionnaire d'événements pour le clic sur le bouton de suppression
              deleteButton.addEventListener('click', function() {
                  deleteEmploye(employe.id);
              });

              // Ajouter le bouton de suppression à la cellule de suppression
              deleteCell.appendChild(deleteButton);
          }
      });
  }

    function deleteEmploye(id) {
        fetch(`/employe/${id}`, {
            method: 'DELETE',
        })
        .then(response => {
            if (response.ok) {
                fetchEmployes(); // Recharger la liste des employés après la suppression
            } else {
                console.error('Failed to delete employe:', response.status);
            }
        })
        .catch(error => console.error('Error deleting employe:', error));
    }


});
