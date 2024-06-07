 				var x=100;
	            var largura = window.innerWidth
	                || document.documentElement.clientWidth
	                || document.body.clientWidth;


           	 	function voltar(){
                
	                y=-((2100-largura)/2+250);
	                if(x>y){
	                const quadro=document.getElementsByClassName("filho");
	                var y=quadro.length;
	                x-=100;
	                for (var i = 0; i < y; i++) {
	                    quadro[i].style.transform=`translateX(${x}px)`;
	                    quadro[i].style.transition=`transform 1s`;
	                }
	                }
            	}

           		 function next(){ 
	                y=((2100-largura)/2+250);
	                if(x<y){
	                const quadro=document.getElementsByClassName("filho");
	                var y=quadro.length;
	                x+=100;
	                for (var i = 0; i < y; i++) {
	                    quadro[i].style.transform=`translateX(${x}px)`;
	                    quadro[i].style.transition=`transform 1s`;
	                }
	
	                }
             	}