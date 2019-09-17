/**
 * 
 */
function changeText(text)
{
    var display = document.getElementById('title');
    display.innerHTML = "";
    display.innerHTML = text;
}

function goToProd(product) {
	$.ajax({
	    url: "ajax.aspx?ajaxid=4",
	    data: $.param({ 
	        "product": product
	    }),
	    cache: false,
	    type: "GET",
	    success: function(response) {

	    },
	    error: function(xhr) {

	    }
	});	
}