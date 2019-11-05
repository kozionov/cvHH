$(document).ready(function() {
    $.ajax({
        type: 'GET',
        url: '/rest/student/all',
        success: function (response) {
            console.log(response)
            var tblbody = document.getElementById("students-table-body");

            for (let i=0; i<response.length; i++) {
                // table row
                let row = document.createElement("tr");

                for (let j = 0; j < 5; j++) {
                    let cell = document.createElement("td");
                    if (j==0){cell.innerText = response[i].id;}
                    if (j==1){cell.innerText = response[i].firstName;}
                    if (j==2){cell.innerText = response[i].lastName}
                    if (j==3){cell.innerText = response[i].course.name}
                    if (j==4){cell.innerHTML = '<a href="/mycv/' + response[i].id + '" class="btn btn-info" role="button" name="cv">Резюме</a>'+
                        '<a href="/vacancies/' + response[i].id + '?page=0" class="btn btn-info" role="button" name="vacancy">Вакансии</a>'+
                        '<a href="/checknegotiates/' + response[i].id + '"  class="btn btn-info" role="button" name="negotiations">Отклики</a>'}

                    row.appendChild(cell);
                }
                tblbody.appendChild(row);
            }
            // table.appendChild(tableBody);
            // let btn = document.getElementById("EnrollBtn");
            // btn.setAttribute("onclick", "checkTableAndEnroll("+courseSetId+")");
        },
        error: function (error) {
            console.log(error)
        }
    });
});