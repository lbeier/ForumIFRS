$(document).ready ->
  $('form').submit ->
    $('input, textarea').each ->
      if $(this).val() == ''
        $(this).addClass('inputError')
      else
        $(this).removeClass('inputError')
      
    if $('input, textarea').hasClass('inputError')
      return false
    else
      return true