var i = 0;
    var txt = 'Vous avez tout les droits ici';
    var speed = 50;

    
    function typeWriter() {
      if (i < txt.length) {
        document.getElementById("demo").innerHTML += txt.charAt(i);
        i++;
        setTimeout(typeWriter, speed);
      }
    }

const liste =document.getElementsByClassName("liste");

function effacer(){
  liste.remove();
}