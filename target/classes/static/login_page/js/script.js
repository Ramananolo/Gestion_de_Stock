var cta = document.querySelector(".cta");
var check = 0;

cta.addEventListener('click', function (e) {
    var text = e.target.nextElementSibling;
    var loginText = e.target.parentElement;
    text.classList.toggle('show-hide');
    loginText.classList.toggle('expand');
    if (check == 0) {
        //  cta.innerHTML = "<ion-icon name=\"arrow-up-outline\"></ion-icon>";
        cta.innerHTML = "<img id=\"imdi\" style=\"width:1.2vw;\"  src=\"login_page/img/arrow-up-outline.svg\" alt=\"clic\">";
        check++;
    }
    else {
        // cta.innerHTML = "<ion-icon name=\"arrow-down-outline\"></ion-icon>";
        cta.innerHTML = "<img id=\"imdi\" style=\"width:1.2vw;\"  src=\"login_page/img/arrow-down-outline.svg\" alt=\"clic\">";

        check = 0;
    }
})

