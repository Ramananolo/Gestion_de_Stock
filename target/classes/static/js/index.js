const addUserBtn = document.getElementById('addUserBtn');
const userFormContainer = document.getElementById('userFormContainer');
const closeButton = document.getElementById('closeButton');

addUserBtn.addEventListener('click', function() {
    userFormContainer.classList.remove('hidden');
});

closeButton.addEventListener('click', function() {
    userFormContainer.classList.add('hidden');
});