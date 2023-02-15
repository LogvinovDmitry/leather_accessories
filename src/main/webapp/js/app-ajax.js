
$(document).ready(function() {
$('#userName').mouseenter(function(event) {
		$.ajax({
			url : 'asynchronous-AJAX-jQuery-Test',
			//data : {
			//	userName : $('#userName').val()
			//},
			success : function(array) {
			console.log(array)
			 const html = array.map(e=>{
                  debugger;
                  return `<li>${e.bagName} ${e.bagPrice} ${e.bagDescription}</li>`
                })
				$('#ajaxGetUserServletResponse').html(html);
			}
		});
		});
	});
