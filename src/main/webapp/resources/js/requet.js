$(function() {
      var textHeight = $('.reason_text').height(),
        lineHeight = parseFloat($('.reason_text').css('line-height')),
        lineNum = 4,
        textNewHeight = lineHeight * lineNum;
      if (textHeight > textNewHeight) {
        $('.reason_text').css('height', textNewHeight);
        $('.readmore-btn').show();
        $('.readmore-btn').click(function() {
          $(this).hide();
          $('.reason_text').css('height', textHeight);
          return false
        });
      };
    });