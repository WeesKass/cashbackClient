
function pagination (e, catId) {
    e.preventDefault();
    console.log(catId);

    // var id = document.forms["nextSubsForm"]["nextSubsForm__id"].value;
    // var page;
    // switch (direction) {
    //     case +1:
    //         page = document.forms["nextSubsForm"]["nextSubsForm__page"].value;
    //         break;
    //     case -1:
    //         page = document.forms["prevSubsForm"]["prevSubsForm__page"].value;
    //         break;
    // }
    var page = document.forms["nextSubsForm"]["nextSubsForm__page"].value;
    // page = encodeURIComponent(page);

    var xhr = new XMLHttpRequest();

    xhr.open('GET', 'http://localhost:4445/api/organization/category/' + catId + '?page=' + page + '&size=5');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200){
            var json = JSON.parse(xhr.responseText);
            var obj;
            for(var i = 0; i < json.content.length; i++) {
                obj = json.content[i];
                console.log(document.querySelector("#id_" + i + " #img"));
                console.log(obj.name);
                document.querySelector("#id_" + i + " #name").innerHTML = obj.name;
                document.querySelector("#id_" + i + " #img").src = obj.image;
            }
        }
    }
    xhr.send();

};

// var url = 'http://localhost:4445/api/organization/category/' + catId + '?page=' + page + '&size=3';
// $.ajax({
//     type: "GET",
//     contentType: "application/json",
//     url: url,
//     success: function(result) {
//         // handle Foo list...
//     }
// });