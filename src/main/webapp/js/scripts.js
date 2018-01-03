$(document).ready(function(){

  $('#booking-form').submit(function(e){
      e.preventDefault();

      $('#booking-modal').modal('hide');
      $('#processing').modal('show');

      var formData = $(this).serializeArray();
      console.log(formData);
      var obj = new Object();
      formData.forEach(function(item){
          obj[item.name] = item.value;
      });
      console.log(obj);
      var jsonForm = JSON.stringify(obj);
      console.log(jsonForm);

      $.ajax({
          beforeSend: function(xhrObj){
             xhrObj.setRequestHeader("Content-Type","application/json");
             xhrObj.setRequestHeader("Accept","application/json");
          },
          type: "POST",
          url: "/resources/booking",
          data: jsonForm,
          dataType:"json",
          success: function(data){
            console.log("success...");
            console.log(data);
            $('#processing').modal('hide');
            var fields = $('#booking-form input');
            for(i = 0; i < fields.length; i++) { $(fields[i]).val(''); };
            //clear fields
            $('#booking-confirmation').modal('show');
          }
        });

  });

});
