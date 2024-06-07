 document.addEventListener('DOMContentLoaded', function () {
            const cpfInput = document.querySelector('.input_cpf');

            cpfInput.addEventListener('input', function () {
                let value = cpfInput.value.replace(/\D/g, '');
                if (value.length > 5) {
                    value = value.substring(0, 3) + '.' + value.substring(3, 6)+ '.' +value.substring(6, 9)+'-'+value.substring(9, 11);
                }
                cpfInput.value = value;
            });
        }); 
 
 
 
 
 document.addEventListener('DOMContentLoaded', function () {
            const cepInput = document.querySelector('.input_cep');

            cepInput.addEventListener('input', function () {
                let value = cepInput.value.replace(/\D/g, '');
                if (value.length > 5) {
                    value = value.substring(0, 5) + '-' + value.substring(5, 8);
                }
                cepInput.value = value;
            });
        });
        
        
 document.addEventListener('DOMContentLoaded', function () {
            const cepInput = document.querySelector('.input_tel');

            cepInput.addEventListener('input', function () {
                let value = cepInput.value.replace(/\D/g, '');
                if (value.length > 5) {
                    value = '('+value.substring(0, 3)+')'+' '+value.substring(3, 8)+ '-' + value.substring(8, 12);
                }
                cepInput.value = value;
            });
        });
        
        
 document.addEventListener('DOMContentLoaded', function () {
            const cepInput = document.querySelector('.input_cep');
            const endInput = document.querySelector('.input_endereco');

            cepInput.addEventListener('input', function () {
				const cep=cepInput.value;
				async function buscarcep(cep,endInput){
	  				const url = 'https://viacep.com.br/ws/'+cep+'/json/';
      				const feetch=await fetch(url);
      				const result=await feetch.json();
     				 let value = endInput.value.replace(/\D/g, '');
     				 value = result.logradouro+','+result.bairro+','+result.localidade+'-'+result.uf;
     				 endInput.value = value;
 				}
 				buscarcep(cep,endInput)              
            });
 });
        
        


  