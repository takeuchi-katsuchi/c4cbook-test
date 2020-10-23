
 function requestOnload() {
	// ページ読み込み時に実行したい処理

 //本の画像のリサイズ
imgResize();

}

//////////モーダル//////////

$(document).ready(function() {

 $(document).on('click', `#openLendingProcedureModal`, function() {
     $(`#LendingProcedureModal`).modal('show');
 });

 });

 //////////テキストエリア高さ自動//////////
 $(function() {
  var $textarea = $('#textarea');
  var lineHeight = parseInt($textarea.css('lineHeight'));
  $textarea.on('input', function(e) {
    var lines = ($(this).val() + '\n').match(/\n/g).length;
    $(this).height(lineHeight * lines);
  });
});

//////////応援ボタン//////////
function cheerBook(requestId,memberId,requestStatus,test){

  if(test){
   alert("既に応援済みの本は応援できません");
   return false;
  }

  if(requestStatus == 9) {
   alert("既に却下済みの本は応援できません");
   return false;
  }

  var formData = {
   requestId: requestId,
   memId: memberId
  }
  if (!confirm('この本を応援しますか?')) {
   return false;
  } else {
   $.ajax({
    url: 'api/cheerBook',
    type: 'post',
    contentType: "application/json",
    data: JSON.stringify(formData),
    dataType: 'json',
    success: function(response) {
     //カウントアップして再表示
     var nowCount = Number(document.getElementById('cheer_count' + requestId).innerText);
     var nextCount = nowCount + 1;
     document.getElementById('cheer_count' + requestId).innerText = nextCount;
     document.getElementById('cheer_count' + requestId).setAttribute('src', 'resources/img/cheering.png');

     //100超えたら99+
     if(nextCount > 99){
      document.getElementById('cheer_count' + requestId).innerText = "99+";
     }

     //応援画像を変更
     document.getElementById('cheer-img' + requestId).classList.remove('off');
    },
    error: function() {
     alert("要望は各本につき1度だけ応援できます。");
    }
   });
  }
}

//////////「要望する」ボタン//////////
function requestBook(memberId){

  //バリデーションチェック
  //入力欄ID
  var ids = new Array('inpt-title','inpt-author','textarea');
  var itemNames = new Array('タイトル','著者','要望理由');

  for( var i=0; i<ids.length; i++) {
    if(document.getElementById(ids[i]).value == "") {
      alert(itemNames[i] + 'は必ず入力してください。');
      return false;
    }
  }

   var formData = {
   title: document.getElementById('inpt-title').value,
   titleKana: document.getElementById('inpt-title-kana').value,
   author: document.getElementById('inpt-author').value,
   authorKana: document.getElementById('inpt-author-kana').value,
   memId: memberId,
   comment: document.getElementById('textarea').value,
   requestStatus: 0
  }
  if (!confirm('要望を確定しますか?')) {
   return false;
  } else {
   $.ajax({
    url: 'api/requestBook',
    type: 'post',
    contentType: "application/json",
    data: JSON.stringify(formData),
    dataType: 'json',
    success: function(response) {
     //モーダルの入力欄全クリアしてモーダルを閉じる
     clearInputValue();
     $('#LendingProcedureModal').modal('hide');
    },
    error: function() {
     alert("error");
    }
   });
  }
}

//////////要望後入力欄クリア//////////
function clearInputValue() {
    var arrayId =new Array('inpt-title', 'inpt-title-kana', 'inpt-author', 'inpt-author-kana', 'textarea');

    for (let i = 0; i < arrayId.length; i++) {
      document.getElementById(arrayId[i]).value = '';
    }
}

//////////xss対策用エスケープ処理//////////
//function escapeHTML(string){
//  return string.replace(/\&/g, '&amp;')
//    .replace(/\</g, '&lt;')
//    .replace(/\>/g, '&gt;')
//    .replace(/\"/g, '&quot;')
//    .replace(/\'/g, '&#x27');
//}




$('.reason-text').each(function(e){

    let $comment = $(this);
    // 元の文章を変数に格納
    let comment = $comment.html();
    let length = comment.length;
    let commentShow;
    let commentText;
    if($comment.height() > 50){
      // 文章の要素の高さが50を超えていたら隠す用のisHiddenクラスを付与
      $comment.addClass('isHidden');

      commentShow = comment.replace(/<br>/g, "\u00a0").substring(0, 68);
      commentText = commentShow += '<span class="review-contents-more">' + '... 続きを読む' + '</span>';
      $comment.html(commentText);

      // 続きを読むをクリックで元の文章を表示
      $comment.on('click', '.review-contents-more', function(e){
        let $anchor = $(e.currentTarget);
        let $anchorParent = $anchor.parent();
        $anchorParent.removeClass('isHidden');
        $anchorParent.html(''); // 一旦空にする
        $anchorParent.html(comment).append('<BR><span class="review-contents-hide">' + '閉じる' + '</span>');
        // 閉じるをクリックで元に戻す
        $('.review-contents-hide').on('click', function(e){
          let $anchorHide = $(e.currentTarget).parent();
          $anchorHide.addClass('isHidden');
          $anchorHide.html('');
          $anchorHide.html(commentText);
        });
      });
    }
});
