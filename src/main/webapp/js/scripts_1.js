$(document).ready(function(){
  console.log("test...")

  $('#booking-form').submit(function(e){
      e.preventDefault();
      var formData = $(this).serializeArray();
      console.log(formData);
      var obj = new Object();
      formData.forEach(function(item){
          obj[item.name] = item.value;
      });
      console.log(obj);

  });

});
