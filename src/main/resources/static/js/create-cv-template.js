$(document).ready(function() {
    $.ajax({
        type: 'GET',
        url: 'https://api.hh.ru/areas/countries',
        success: function (response) {
            console.log(response)
            var counties = document.getElementById("counties");
            for (var i = 0; i < response.length; i++) {
                var slct = document.createElement("option");
                slct.innerText = response[i].name;
                counties.appendChild(slct);
            }
        },
        error: function (error) {
            console.log(error)
        }
    });

    $.ajax({
        type: 'GET',
        url: 'https://api.hh.ru/dictionaries',
        success: function (response) {
            console.log(response);
            console.log(response.employment);

            var empl = document.getElementById("employment");
            var respEmpl = response.employment;
            for (var i = 0; i < respEmpl.length; i++) {
                var slct = document.createElement("option");
                slct.innerText = respEmpl[i].name;
                empl.appendChild(slct);
            }

            var schdl = document.getElementById("schedule");
            var respSchdl = response.schedule;
            for (var i = 0; i < respSchdl.length; i++) {
                var slct = document.createElement("option");
                slct.innerText = respSchdl[i].name;
                schdl.appendChild(slct);
            }

            // var strUser = schdl.options[schdl.selectedIndex].value;
            // console.log("strUser "+strUser);
        },
        error: function (error) {
            console.log(error)
        }
    });
});
