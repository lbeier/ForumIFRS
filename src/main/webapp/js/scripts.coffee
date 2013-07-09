$(document).ready ->
  $('form').submit ->
    $('input, textarea').each ->
      if $(this).val() == ''
        $(this).addClass('inputError')
        $('<span style="color: red">Os campos em vermelho são obrigatórios.</span>').appendTo(this);
      else
        $(this).removeClass('inputError')
      
    if $('input, textarea').hasClass('inputError')
      return false
    else
      return true