
const loginForm = document.getElementById('loginForm');
const messageElement = document.getElementById('message');
function login() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    if (email.trim() === '' || password.trim() === '') {
        alert("Veuillez renseigner tous les champs.");
    } else {
        var roleSelect = document.getElementById('role');
        var selectedOption = roleSelect.options[roleSelect.selectedIndex];
        var selectedRole = selectedOption.value;

        switch (selectedRole) {
            case 'admin':
                console.log('L\'utilisateur a sélectionné le rôle Admin');
                alert("admin");
                window.location.replace("../e.html");
                break;
            case 'employee':
                console.log('L\'utilisateur a sélectionné le rôle Employee');
                alert("employe");
                break;
            default:
                console.log('Rôle non reconnu');
                break;
        }
    }
}


