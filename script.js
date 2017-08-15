var o =[document.querySelector('.onglet1'),document.querySelector('.onglet2'),document.querySelector('.onglet3')];
o[0].addEventListener('click', updateOnglets);
o[1].addEventListener('click', updateOnglets);
o[2].addEventListener('click', updateOnglets);

var b =[document.querySelector('.block1'),document.querySelector('.block2'),document.querySelector('.block3')];

function updateOnglets(e){
	reset(o);
	e.target.classList.remove("hidden");
	e.target.classList.add("current");
	if(e.target.classList.contains('onglet1')){
		reset(b);
		b[0].classList.remove('hidden');
		b[0].classList.add('current');
	}
	else if(e.target.classList.contains('onglet2')){
		reset(b);
		b[1].classList.remove('hidden');
		b[1].classList.add('current');
	}
	else if(e.target.classList.contains('onglet3')){
		reset(b);
		b[2].classList.remove('hidden');
		b[2].classList.add('current');
	}
	console.log("ok");
};


function reset(l){
	for(var i = 0 ;i<l.length;i++){
		if(l[i].classList.contains('current')){
			l[i].classList.remove('current');
			l[i].classList.add('hidden');
		}
	}
}
