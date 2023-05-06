let Right=document.getElementById('right');
let My_introduce=document.getElementById('MyIntroduce');
let Introduce=document.getElementById('IntroBtn');
let hidden=document.getElementById('Hidden');
let search=document.getElementById('Search');
let input=document.getElementById('Input');
let word=document.getElementById('Word');

My_introduce.addEventListener('click',function (){
    Introduce.style.display='none';
    Right.style.display='block';
 })

hidden.addEventListener('click',function (){
    Right.style.display='none';
    Introduce.style.display='block';
})

search.addEventListener('click',function (){
    const Set=document.createElement('div');
    const paragraph=document.createElement('p');
    const Btn=document.createElement('button');
    Btn.innerText='삭제';
    paragraph.style.float='left';
    paragraph.style.margin='0 auto';
    Btn.style.margin='0 auto';
    Btn.style.float='right';
    paragraph.innerText=input.value;
    Set.style.width='30%';
    Set.style.height='25px';
    Set.style.textAlign='center';
    Set.style.margin='0 auto';
    Set.appendChild(paragraph);
    Set.appendChild(Btn);
    word.appendChild(Set);
    input.value="";
    Btn.addEventListener('click', function (){
        word.removeChild(Set);
    })
})