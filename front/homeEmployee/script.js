var i = 0;
    var txt = 'Vous ne pouvez pas modifier votre information proffessionnelle';
    var speed = 50;

    
    function typeWriter() {
      if (i < txt.length) {
        document.getElementById("demo").innerHTML += txt.charAt(i);
        i++;
        setTimeout(typeWriter, speed);
      }
    }

