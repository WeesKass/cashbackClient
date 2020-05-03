// $("#next__btn").on("click", function () {
//     event.preventDefault();
//     let catId = $("input[name='catId']").val();
//     let page = $("input[name='next__page']").val();
//     console.log(catId);
//     console.log(page);
//     $.get("/subs/"+ catId +"?page=" + page + "&size=5", function(fragment) {
//         $("div#orgBlock").replaceWith(JSON.parse(fragment));
//     });
// });
