$(".done").click(function(){
    alert("this is done");
});

$(".delete").click(function(){
    alert("this is delete");
});

$("#submit").click(function(){
    var value = $("#todoText").val();
    alert(value);
});