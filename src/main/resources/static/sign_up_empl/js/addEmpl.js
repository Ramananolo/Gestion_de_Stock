document.addEventListener('DOMContentLoaded', function () {
    const addEmployeForm = document.getElementById('addEmployeForm');

    // Ajouter un écouteur d'événement pour le formulaire
    addEmployeForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        // Appeler l'API pour ajouter une personne
        addPerson({ email, password });
    });

    // Fonction pour ajouter une personne
    function addPerson(employe) {
        fetch('/employe', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(employe),
        })
        .then(response => {
            if (response.ok) {
                // Réinitialiser le formulaire
                addPersonForm.reset();
            } else {
                console.error('Failed to add employe:', response.status);
            }
        })
        .catch(error => console.error('Error adding employe:', error));
    }
});
