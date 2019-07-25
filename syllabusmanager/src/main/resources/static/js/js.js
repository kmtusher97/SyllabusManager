/*
$( document ).ready(function() {

   */
/* $("#myForm").submit(function(event) {
        //event.preventDefault();
        ajaxPost();
    });*//*


   $("#inpt").on("change", function(event) {
        //event.preventDefault();
        ajaxPost();
   });


    function ajaxPost(){

      // PREPARE FORM DATA
      var formData = {
        title : $("#inpt").val()
      }

      // DO POST
      $.ajax({
      type : "POST",
      contentType : "application/json",
      url : "/cs/postTest",
      data : JSON.stringify(formData),
      dataType : 'json'
    });
  }
})*/

$( document ).ready(function() {

    /* $("#myForm").submit(function(event) {
    //event.preventDefault();
    ajaxPost();
    });*/

        $("#myForm").on("change", function() {
            ajaxPost();
        });



        function ajaxPost(){

             // PREPARE FORM DATA
            var formData = {
                title : $("#inpt2").val()
            }
            // DO POST
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/cs/postTest",
                data : JSON.stringify(formData),
                dataType : 'json'
            });
        }

})