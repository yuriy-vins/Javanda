//Иными словами, DOMContentLoaded гарантирует, что скрипт не начнет выполняться раньше,
//чем весь HTML контент будет готов для работы, что повышает надежность вашего кода.
//document.addEventListener("DOMContentLoaded", function() {
//Variables
var audio = document.getElementById('audioPlayer');
var audio_start = document.getElementById('audio_start');
var audio_loop = document.getElementById('audio_loop');
var end = document.getElementById('end');
var buttonGame = document.getElementById("button-game");
var windows = document.getElementsByClassName("window");
var buttons = document.getElementsByClassName("button");
var prevButton = document.getElementById("prev");
var answerButton = document.getElementById("answer");
var nextButton = document.getElementById("next");
var windows = document.getElementsByClassName("window");
var buttons = document.getElementsByClassName("button");
var prevButton = document.getElementById("prev");
var answerButton = document.getElementById("answer");
var nextButton = document.getElementById("next");
var questionsWindow = document.getElementById('questions');
var ok = document.getElementById('ok');
var otvet = document.getElementById('otvet');
var backnext = document.getElementById('backnext');
var stopGame = document.getElementById('stop');
var buttonSound = document.getElementById("music");
var randomQuestionIndex = 0;
var qCounter = 0;
var qCounterForget = 0;
var timer = 0;
var seconds = 0;
var swSound = 0;
var sw = 0;
var sw_play = 0;
var audioContext;
var source;
var buffer;
var isPlaying = false;

//Functions
//audio.volume = .25;
function playGame() {

end.pause();
end.currentTime = 0;

//---Функция запуска таймера игры.
function startTimer() {
    // Очищаем предыдущий таймер, если он существует
    clearInterval(timer);

    let timerGame = document.getElementById("timer-game"); // Найти элемент с id "timer-game"
    seconds = 0; // Сбрасываем время
    // Обновить текст элемента, сохраняя неизменной часть текста
    timerGame.textContent = `Время игры: ${formatTime(seconds)}`;

    // Запускаем новый таймер
    timer = setInterval(function() {
    seconds++;
    // Обновить текст элемента, сохраняя неизменной часть текста
    timerGame.textContent = `Время игры: ${formatTime(seconds)}`;
    }, 1000); // Обновляем каждую секунду
}
function formatTime(seconds) {
    const hrs = Math.floor(seconds / 3600);
    const mins = Math.floor((seconds % 3600) / 60);
    const secs = seconds % 60;

    return `${pad(hrs)}:${pad(mins)}:${pad(secs)}`;
}
function pad(num) {
    return num.toString().padStart(2, '0');
}

if (buttonGame.innerHTML == "ИГРАТЬ") {
    Array.from(windows).forEach(function(window) {window.style.display = "block";});
    Array.from(buttons).forEach(function(button) {button.style.display = "block";});
    prevButton.style.display = "block";
    answerButton.style.display = "block";
    nextButton.style.display = "block";
    buttonGame.innerHTML = "СТОП";
    document.getElementById("answer").innerHTML = "ОТВЕТ";
    startTimer(); //Запуск таймера.
    //---Update Info:
    let userGame = document.getElementById("user");
        userGame.textContent = `Пользователь: User`;
    let title = document.getElementById("grade"); // Найти элемент с id "grade"
        title.textContent = `Звание: Trainee`;
    let questionCount = document.getElementById("question-count");
            qCounter = 0;
            questionCount.textContent = `Пройдено вопросов: ${qCounter}`;
    let questionCountForget = document.getElementById("question-count-forget");
        qCounterForget = 0;
        questionCountForget.textContent = `Усвоение вопросов: ${qCounterForget}`;
    let questionCountTopic = document.getElementById("question-count-topic");
        questionCountTopic.textContent = `Усвоение тем: 0`;
} else {
    gameStop();
  }
}

//---Функция остановки таймера игры.
function stopTimer() {
    // Очищаем предыдущий таймер, если он существует
    clearInterval(timer);
}

//--- Функция возвращает звание игрока в зависимости от усвоения вопросов.
function determineTitle(questionsCompleted) {
    if (questionsCompleted < 100) {
        return "Trainee"; //Trainee
    } else if (questionsCompleted < 200) {
        return "Junior"; //Junior
    } else if (questionsCompleted < 300) {
            return "Junior +"; //Junior+
    } else if (questionsCompleted < 500) {
        return "Middle"; //Middle
    } else if (questionsCompleted < 800) {
        return "Senior"; //Senior
    }  else if (questionsCompleted < 1000) {
        return "Team Lead"; //Team Lead
    } else {
        return "Software Architect"; //Software Architect
    }
}

function gameStop() {
sw_play = 0;
audio_start.pause();
audio_start.currentTime = 0;
audio_loop.pause();
audio_loop.currentTime = 0;
end.play();
stopTimer();
stopAudio();



Array.from(windows).forEach(function(window) {window.style.display = "none";});
Array.from(buttons).forEach(function(button) {button.style.display = "none";});
prevButton.style.display = "none";
answerButton.style.display = "none";
nextButton.style.display = "none";
buttonGame.innerHTML = "ИГРАТЬ";
sw = 0;
}

const prevBtn = document.getElementById('prev');
const answerBtn = document.getElementById('answer');
const nextBtn = document.getElementById('next');


<!-- Обработчики кнопок!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-->

//Функция возвращающая адрес запроса в зависимости от полученного рандомного числа.
function getQuestionAddress() {

//Массив с веб-адресами
var addresses = [
"/getQuestionCore1",
"/getQuestionCore2",
"/getQuestionMultithreading",
"/getQuestionSQL",
"/getQuestionHibernate",
"/getQuestionSpring",
"/getQuestionPatterns",
"/getQuestionAlgorithms"
// Добавь сюда остальные адреса
];

// Генерация случайного индекса в пределах длины массива
randomQuestionIndex = Math.floor(Math.random() * addresses.length);

// Возвращаем случайный веб-адрес
return addresses[randomQuestionIndex];
}

function getAnswerAddress() {
// Массив с веб-адресами
var addresses = [
"/getAnswerCore1",
"/getAnswerCore2",
"/getAnswerMultithreading",
"/getAnswerSQL",
"/getAnswerHibernate",
"/getAnswerSpring",
"/getAnswerPatterns",
"/getAnswerAlgorithms"
// Добавь сюда остальные адреса
];

// Возвращаем случайный веб-адрес
return addresses[randomQuestionIndex];
}

function getPrevQuestionAddress() {
// Массив с веб-адресами
var addresses = [
"/getPrevQuestionCore1",
"/getPrevQuestionCore2",
"/getPrevQuestionMultithreading",
"/getPrevQuestionSQL",
"/getPrevQuestionHibernate",
"/getPrevQuestionSpring",
"/getPrevQuestionPatterns",
"/getPrevQuestionAlgorithms"
// Добавь сюда остальные адреса
];

// Возвращаем случайный веб-адрес
return addresses[randomQuestionIndex];
}

//Функция возвращающая название раздела в зависимости от номера randomQuestionIndex.
function getChapter() {
var chapter = "";

switch (randomQuestionIndex + 1) {
case 1: chapter = "РАЗДЕЛ: CORE-1."; break;
case 2: chapter = "РАЗДЕЛ: CORE-2."; break;
case 3: chapter = "РАЗДЕЛ: MULTITHREADING."; break;
case 4: chapter = "РАЗДЕЛ: SQL."; break;
case 5: chapter = "РАЗДЕЛ: HIBERNATE."; break;
case 6: chapter = "РАЗДЕЛ: SPRING."; break;
case 7: chapter = "РАЗДЕЛ: PATTERNS."; break;
case 8: chapter = "РАЗДЕЛ: ALGORITHMS."; break;

// default: chapter = "РАЗДЕЛ: ЕЩЕ НЕ СОЗДАН."; break;
}
return chapter;
}

//Функция Для запроса вопроса.
function questionRequest(){

//-- Запрос вопроса на сервер, при нажатии на кнопку Играть или Вопрос
console.log("Запрос отправлен на сервер!")
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
    console.log(this.responseText)

    // Преобразование ответа сервера в объект JavaScript
    var response = JSON.parse(this.responseText);

    document.getElementById("inner").innerHTML = getChapter()+" ВОПРОС № "+response[1]+"."+" <br>"+response[0];

    const element = document.getElementById("inner"); //Форматируем вопрос
    element.style.textAlign = "center"; //Выравниваем по центру
 }
};
xhttp.open("GET", getQuestionAddress(), true);
xhttp.send();
}

// Обработчик кнопки Играть.
document.getElementById("button-game").addEventListener("click", function() {
    loadAudio('files/loop.wav'); // Load your audio file

    playGame();
    questionsWindow.scrollTop = 0;

    audio_start.play().then(function() {
                console.log('Audio is playing.');
            }).catch(function(error) {
                console.log('Play was prevented:', error);
            });

    playAudio();

    questionRequest();

    var windows = document.getElementById("windows");
    // Прокрутка к элементу target с плавной анимацией
    window.scrollTo({ // Если что, то есть если не будет работать корректно - убрать!
                top: windows.offsetTop - document.getElementById("target").offsetHeight,
                behavior: 'smooth'
            });
    window.scrollTo({
                    bottom: windows.offsetBottom - document.getElementById("target-2").offsetHeight,
                    behavior: 'smooth'
                });
});



// Обработчики опциональных кнопок.
// Обработчик кнопки Остановить игру.

document.getElementById("stop").addEventListener("click", function() {
buttonGame.innerHTML = "СТОП";
gameStop();
start_end = false;
});

//--- Следующий блок кода обеспечивает плавный переход в петлевом проигрывании.
        function loadAudio(url) {
            if(!audioContext) audioContext = new (window.AudioContext || window.webkitAudioContext)();
            var request = new XMLHttpRequest();
            request.open('GET', url, true);
            request.responseType = 'arraybuffer';

            request.onload = function() {
                audioContext.decodeAudioData(request.response, function(decodedData) {
                    buffer = decodedData;
                    playAudio();
                });
            };
            request.send();
        }

        function playAudio() {
                    if (!buffer) return;
                    if (isPlaying) {
                        swSound++;
                        buttonSound.innerHTML = "выключить звук";
                    } else {
                        source = audioContext.createBufferSource();
                        source.buffer = buffer;
                        source.connect(audioContext.destination);
                        source.loop = true;
                        source.start(0);
                        isPlaying = true;
                    }
                }

                function pauseAudio() {
                    if (source) {
                        source.stop(0);
                        isPlaying = false;
                    }
                }

                function stopAudio() {
                    if (source) {
                        source.stop(0);
                        source = null;
                        isPlaying = false;
                    }
                }


//---+

document.getElementById("music").addEventListener("click", function() {
    swSound++;
    if(swSound>1) {swSound = 0}

    if(swSound == 0) {
        buttonSound.innerHTML = "выключить звук";

        playAudio();
    }

    if(swSound == 1) {
        buttonSound.innerHTML = "включить звук";

        pauseAudio();
    }
});


document.getElementById("clear").addEventListener("click", function() {

    otvet.play();
    //---Здесь просто обновляется счетчик. Вопрос при этом не забывается. Нужно будет сделать забывание.

    let questionCountForget = document.getElementById("question-count-forget"); // Найти элемент с id "question-count-forget"
    qCounterForget++; //Сделать инкремент переменной qCounterForget.
    // Обновить текст элемента, сохраняя неизменной часть текста
    questionCountForget.textContent = `Усвоение вопросов: ${qCounterForget}`;

    // Также при нажатии кнопки обновляется грейд-звание игрока.

    let title = document.getElementById("grade"); // Найти элемент с id "grade"
    // Обновить текст элемента, сохраняя неизменной часть текста
    title.textContent = `Звание: ${determineTitle(qCounterForget)}`;

    //---Здесь просто обновляется счетчик пройденных тем. Пока что он расчитывается по постой формуле. В будущем нужно будет изменить формулу подсчета пройденных тем.

    let questionCountTopic = document.getElementById("question-count-topic"); // Найти элемент с id "question-count-topic"
    //qCounterTopic++;
    // Обновить текст элемента, сохраняя неизменной часть текста
    if(qCounterForget > 0) {
        questionCountTopic.textContent = `Усвоение тем: ${Math.floor(qCounterForget / 10)}`;
    }

});

document.getElementById("add").addEventListener("click", function() {

    otvet.play();
    console.log("Нажата кнопка Добавить вопрос. Но она не работает!");
});

document.getElementById("change").addEventListener("click", function() {

    otvet.play();
    console.log("Нажата кнопка Изменить вопрос. Но она не работает!");
});

document.getElementById("delete").addEventListener("click", function() {

    otvet.play();
    console.log("Нажата кнопка Удалить вопрос. Но она не работает!");
});

//Функция Для запроса ответа.
function answerRequest(){

<!-- Запрос ответа на сервер при нажатии на кнопку Ответ-->
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
    console.log(this.responseText)

    const textFromDatabase = this.responseText; //Получаем текст, чтобы перед вставкой сначала отформатировать его.

    const formattedText = textFromDatabase.replace(/(?<=[a-zа-я])(\.\s+)([A-ZА-Я])/g, "$1<br/>$2") //Любая маленькая буква, точка, пробел и любая заглавная буква - Затем перенос строки.
    .replace(/(?<!^)(\d+\.\s+)/g, "<br/>$1") //Цифра, точка и пробел - Затем перенос строки вместе с ними.
    .replace(/(\s-\s)([A-Za-zА-Яа-я])/g, "<br/>$1$2") //Тире, пробел и любая буква - Затем перенос строки.
    .replace(/\* /g, "<br/>* "); //Звездочка, пробел - Затем перенос строки.

    document.getElementById("inner").innerHTML = formattedText; //Помещаем этот текст в блок модального окна

    const element = document.getElementById("inner"); //Форматируем ответ
    element.style.textAlign = "left"; //Выравниваем по по левому краю
  }
};
xhttp.open("GET", getAnswerAddress(), true);
xhttp.send();
}


// Обработчик кнопки Ответ-Ok.
document.getElementById("answer").addEventListener("click", function() {

answerRequest();
questionsWindow.scrollTop = 0;

sw++; // Увеличиваем значение переменной на 1
if (sw === 2) {
    ok.play();
    sw = 0; // Обнуляем переменную, если достигнуто значение 2
}

console.log(sw); // Выводим текущее значение переменной в консоль (для проверки)

if (sw === 1) {
    otvet.play();
    answerRequest();
    document.getElementById("answer").innerHTML = "OK";

    let questionCount = document.getElementById("question-count"); // Найти элемент с id "question-count"
        qCounter++; //Сделать инкремент переменной qCounter.
        // Обновить текст элемента, сохраняя неизменной часть текста
        questionCount.textContent = `Пройдено вопросов: ${qCounter}`;

} else {
    document.getElementById("answer").innerHTML = "ОТВЕТ";
    questionRequest();
}

});

<!-- Запрос вопроса на сервер, при нажатии на кнопку Дальше-->
document.getElementById("next").addEventListener("click", function() {

questionsWindow.scrollTop = 0;
backnext.play();
<!--console.log("Запрос отправлен на сервер!")-->
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
  console.log(this.responseText)

  // Преобразование ответа сервера в объект JavaScript
  var response = JSON.parse(this.responseText);

  document.getElementById("inner").innerHTML = getChapter()+" ВОПРОС № "+response[1]+"."+" <br>"+response[0];

  const element = document.getElementById("inner"); //Форматируем вопрос
  element.style.textAlign = "center"; //Выравниваем по центру
  }
};
xhttp.open("GET", getQuestionAddress(), true);
xhttp.send();

sw = 0;
document.getElementById("answer").innerHTML = "ОТВЕТ";
});

<!-- Запрос вопроса на сервер, при нажатии на кнопку Назад-->
document.getElementById("prev").addEventListener("click", function() {

questionsWindow.scrollTop = 0;
backnext.play();
<!--console.log("Запрос отправлен на сервер!")-->
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
    console.log(this.responseText)

    // Преобразование ответа сервера в объект JavaScript
    var response = JSON.parse(this.responseText);

    document.getElementById("inner").innerHTML = getChapter()+" ВОПРОС № "+response[1]+"."+" <br>"+response[0];

    const element = document.getElementById("inner"); //Форматируем вопрос
    element.style.textAlign = "center"; //Выравниваем по центру
  }
};
xhttp.open("GET", getPrevQuestionAddress(), true);
xhttp.send();

sw = 0;
document.getElementById("answer").innerHTML = "ОТВЕТ";
});
//});




