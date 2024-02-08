document.addEventListener('DOMContentLoaded', function () {
    const personTableBody = document.getElementById('personList');
    const addPersonForm = document.getElementById('addPersonForm');

    // Charger la liste des personnes au chargement de la page
    fetchPersons();

    // Ajouter un écouteur d'événement pour le formulaire
    addPersonForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const name = document.getElementById('name').value;
        const firstName = document.getElementById('first_name').value;

        // Appeler l'API pour ajouter une personne
        addPerson({ name, first_name: firstName });
    });

    // Fonction pour charger la liste des personnes
    function fetchPersons() {
        fetch('/persons')
            .then(response => response.json())
            .then(persons => displayPersons(persons))
            .catch(error => console.error('Error fetching persons:', error));
    }

    // Fonction pour afficher la liste des personnes dans un tableau
    function displayPersons(persons) {
        personTableBody.innerHTML = '';

        persons.forEach(person => {
            const row = personTableBody.insertRow();
            const idCell = row.insertCell(0);
            const nameCell = row.insertCell(1);
            const firstNameCell = row.insertCell(2);

            idCell.textContent = person.id;
            nameCell.textContent = person.name;
            firstNameCell.textContent = person.first_name;
        });
    }

    // Fonction pour ajouter une personne
    function addPerson(person) {
        fetch('/persons', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(person),
        })
        .then(response => {
            if (response.ok) {
                // Actualiser la liste des personnes
                fetchPersons();

                // Réinitialiser le formulaire
                addPersonForm.reset();
            } else {
                console.error('Failed to add person:', response.status);
            }
        })
        .catch(error => console.error('Error adding person:', error));
    }
});
