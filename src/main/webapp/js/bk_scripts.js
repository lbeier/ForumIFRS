// Generated by CoffeeScript 1.6.3
(function() {
  $(document).ready(function() {
    return $('form').submit(function() {
      $('input, textarea').each(function() {
        if ($(this).val() === '') {
          $(this).addClass('inputError');
          return $('<span style="color: red;">Este campo &eacute; obrigat&oacute;rio.</span>').insertAfter(this);
        } else {
          return $(this).removeClass('inputError');
        }
      });
      if ($('input, textarea').hasClass('inputError')) {
        return false;
      } else {
        return true;
      }
    });
  });

}).call(this);