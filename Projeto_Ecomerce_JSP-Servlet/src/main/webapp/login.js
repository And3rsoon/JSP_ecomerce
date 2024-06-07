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