document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById('loginForm');
    const messageElement = document.getElementById('message');
    const loginButton = document.getElementById('log');

    loginButton.addEventListener('click', function () {
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        if (email.trim() === '' || password.trim() === '') {
            messageElement.textContent = "Veuillez renseigner tous les champs.";
        } else {
             // Envoi des informations de connexion au serveur
             fetch('/login', {
                 method: 'POST',
                 headers: {
                     'Content-Type': 'application/json',
                 },
                 body: JSON.stringify({ email, password }),
             })
             .then(response => {
                 console.log('Après la requête');
                 if (response.ok) {
                     messageElement.textContent = 'Information correct';
                     var roleSelect = document.getElementById('role');
                     var selectedOption = roleSelect.options[roleSelect.selectedIndex];
                     var selectedRole = selectedOption.value;

                     switch (selectedRole) {
                         case 'admin':
                             console.log('L\'utilisateur a sélectionné le rôle Admin');
                            // alert("admin");

                            if(email.includes('admin')) {
                                window.location.replace("admin_page.html");
                               }

                             break;
                         case 'employee':
                             console.log('L\'utilisateur a sélectionné le rôle Employee');
                             //alert("employe");
                             if(!(email.includes('admin'))) {
                              window.location.replace("employe_page.html");
                               }
                             // Redirection vers index.html
                             break;
                         default:
                             console.log('Rôle non reconnu');
                             break;
                     }
                 } else {
                     messageElement.textContent = 'Information incorrecte';
                 }
             })
             .catch(error => console.error('Error during login:', error));
         }
    });
});
