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
           const row = employeTableBody.insertRow();
           const idCell = row.insertCell(0);
           const emailCell = row.insertCell(1);
           const passwordCell = row.insertCell(2);

          // idCell.textContent = employe.id;
           emailCell.textContent = " =======================>>>>>>>> ";

           passwordCell.textContent=employe.email;


           // Créer un élément span pour le texte du password
           const passwordSpan = document.createElement('span');
           passwordSpan.textContent = employe.id;

           // Appliquer le fond bleu et la couleur de texte au span
           passwordSpan.style.backgroundColor = "none";
           passwordSpan.style.color = "#3C91E6";

           // Ajouter le span contenant le texte du password à la cellule passwordCell
           idCell.appendChild(passwordSpan);
       });

    }
});
