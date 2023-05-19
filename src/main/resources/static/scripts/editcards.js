document.getElementById('numbers').addEventListener('input', function (e) {
    let cardNumber = e.target.value.replace(/\s/g, ''); // Удаляем все пробелы из введенного значения
    let formattedNumber = '';

    for (let i = 0; i < cardNumber.length; i++) {
        if (i > 0 && i % 4 === 0) {
            formattedNumber += ' '; // Добавляем пробел после каждых 4 символов
        }
        formattedNumber += cardNumber.charAt(i);
    }

    e.target.value = formattedNumber;
});