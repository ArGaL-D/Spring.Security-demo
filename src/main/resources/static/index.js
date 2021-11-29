
const letters = Array.from( document.querySelectorAll(".letter") );
const colors  = ['#a4fca9','#b5fca4','#a4fcbf',
                '#a4fceb','#fde4c5','#a4fcf4',
                '#fca4cb','#fdf1c5'];


setInterval( ()=> {
    const color  = colors [ Math.floor(Math.random() * colors.length) ]
    const letter = letters[ Math.floor(Math.random() * letters.length) ]

    letter.style.color = color;
    letter.style.textShadow = `0px 0px 24px ${color}`;
    letter.style.transition = "500ms";
}, 100);
