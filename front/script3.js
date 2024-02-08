document.addEventListener('DOMContentLoaded', function () {
     const changePasswordButton = document.getElementById('changePasswordButton');
        const changePasswordForm = document.getElementById('changePasswordForm');
        const confirmChangePasswordButton = document.getElementById('confirmChangePassword');

        // Ajoutez un écouteur d'événements pour le bouton "Change Password"
       // changePasswordButton.addEventListener('click', function () {
            // Affiche le formulaire de modification du mot de passe
         //   changePasswordForm.style.display = 'block';
       // });

        // Ajoutez un écouteur d'événements pour le bouton "Confirm Change Password"
        confirmChangePasswordButton.addEventListener('click', function () {
            const email = document.getElementById('email').value;
            const currentPassword = document.getElementById('currentPassword').value;
            const newPassword = document.getElementById('newPassword').value;

            // Appeler l'API pour changer le mot de passe
            changePassword({ email, currentPassword, newPassword });
        });

        // Fonction pour changer le mot de passe
        function changePassword(passwords) {
            fetch('/change-password', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(passwords),
            })
            .then(response => {
                if (response.ok) {
                    alert('Mot de passe modifié avec succès');
                } else {
                    alert('Erreur lors de la modification du mot de passe');
                }
            })
            .catch(error => console.error('Error changing password:', error));
        }

        });