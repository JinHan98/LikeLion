const navbarMenu = document.querySelector('.navbar__menu');
const navbarToggleBtn = document.querySelector('.navbar__toggle-btn');
const word1=document.getElementById('word1');
const word2=document.getElementById('word2');
const word3=document.getElementById('word3');
navbarToggleBtn.addEventListener('click', () => {
    navbarMenu.classList.toggle('open');
});
window.onload = () => {
    axios.get('https://random-word-api.herokuapp.com/word?number=3')
        .then(response =>{
            console.log(response.data)
            word1.innerText=response.data[0];
            word2.innerText=response.data[1];
            word3.innerText=response.data[2];
        })
}