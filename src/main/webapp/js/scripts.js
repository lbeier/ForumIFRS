$(document).ready(function() {
	$('form').submit(function() {
		$.each($('input, textarea'), function(){
			if($(this).val() == '') {
				$(this).addClass('inputError');
			    $('<span style="color: red;">Este campo &eacute; obrigat&oacute;rio.</span>').insertAfter(this);
			} else {
				$(this).removeClass('inputError');
			}
		});
		
		if($('input, textarea').hasClass('inputError')) {
			return false;			
		} else {
			return true;
		}
	});
});