var pathArray = window.location.pathname.split('/');
var id = pathArray[2]; //Достаем id студента

//Откликнуться на все вакансии
function responseOnAllVacancies() {
    
}

//Откликнуться на заданное кол-во вакансий
function responseOnVacancies(amount) {
    //Получаем вакансии
    for (let i = 0; i < amount / 100; i++) {
        $.ajax({
            async: true,
            type: 'GET',
            url: '/rest/vacancies/' + id + '?page=' + i,
            success: function (response) {
                let vacancies = JSON.parse(response).items;
                //Откликаемся на каждую
                for (let j = 0; j < amount ; j++) {
                    $.ajax({
                        async: true,
                        type: 'POST',
                        url: '/rest/negotiations/' + id,
                        data: {'vacId':vacancies[j].id, 'message':''},
                        success: function (response) {
                            console.log(response);
                        },
                        error: function (error) {
                            console.log(error)
                        }
                    })
                }
            },
            error: function (error) {
                console.log(error)
            }
        })
    }
}

//Показывает таблицу с вакансиями
function showVacancies() {
    $.ajax({
        type: 'GET',
        url: '/rest/vacancies/' + id + '?page=0', //TODO показ всех страниц вакансий, не только страницу 0
        success: function (response) {
            let vacancies = JSON.parse(response).items;
            var tblbody = document.getElementById("vacancies-table-body");
            for (let i = 0; i < vacancies.length; i++) {
                let row = document.createElement("tr");
                for (let j = 0; j < 5; j++) {
                    let cell = document.createElement("td");
                    if (j == 0) {
                        cell.innerText = vacancies[i].id;
                    }
                    if (j == 1) {
                        cell.innerText = vacancies[i].name;
                    }
                    if (j == 4) {
                        //TODO правильную ссылку на кнопке, если она вообще нужна
                        cell.innerHTML = '<a href="/mycv/' + response[i].id + '" class="btn btn-info" role="button">Откликнутся</a>'
                    }
                    row.appendChild(cell);
                }
                tblbody.appendChild(row);
                let tbl = document.getElementById("vac-view");
                tbl.style.visibility = "";
            }
        },
        error: function (error) {
            console.log(error)
        }
    });
}