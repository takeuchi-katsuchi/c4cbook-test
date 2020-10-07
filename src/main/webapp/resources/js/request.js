function readMoreReason(number) {

	//reasonクラスのdivを取得
	var reasons = document.getElementsByClassName('reason');
	//readMoreBtnsクラスのdivを取得
	var readmores = document.getElementsByClassName('readmore');

	//「ReadMore」を非表示にする
	readmores[number].className += " hide";

	//要望理由をすべて表示する
	reasons[number].id = "reason_open";

}

function readMoreRejectReason(number) {

	//reason_rejectクラスのdivを取得
	var reasons_reject = document.getElementsByClassName('reason_reject');
	//readMoreBtnsクラスのdivを取得
	var readmores_reject = document.getElementsByClassName('readmore_reject');

	//「ReadMore」を非表示にする
	readmores_reject[number].className += " hide";

	//要望理由をすべて表示する
	reasons_reject[number].id = "reason_reject_open";

}

 function requestOnload() {
	// ページ読み込み時に実行したい処理

 //本の画像のリサイズ
imgResize();

	//////////要望理由のreadmore//////////

	//reasonクラスのdivを取得
	var reasons = document.getElementsByClassName('reason');
	//reasonsクラスを持つ要素の数を取得
	var i_roasons = reasons.length;
	//readmoreクラスのdivを取得
	var readmores = document.getElementsByClassName('readmore');

	for (var i = 0;  i < i_roasons;  i++) {

		//3行以上なければ
		if (reasons[i].clientHeight < 68) {
			readmores[i].className += " hide";
		};

	};

	//////////却下理由のreadmore//////////

	//reason_rejectクラスのdivを取得
	var reasons_reject = document.getElementsByClassName('reason_reject');
	//reason_rejectsクラスを持つ要素の数を取得
	var i_roasons_reject = reasons_reject.length;
	//readmore_rejectクラスのdivを取得
	var readmores_reject = document.getElementsByClassName('readmore_reject');

	for (var i = 0;  i < i_roasons_reject;  i++) {

		//3行以上なければ
		if (reasons_reject[i].clientHeight < 68) {
			readmores_reject[i].className += " hide";
		};

	};
}

//////////モーダル//////////

$(document).ready(function() {

 console.log("JQuery OK");


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
function cheerBook(requestId,memberId){

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
//     $(`#myModal2`).modal('hide');
//     $('#LendingProcedureModal').modal('hide');
    }
   });
  }
}

//////////「要望する」ボタン//////////
function requestBook(memberId){

   var formData = {
   title: document.getElementById('inpt-title').value,
   titleKana: document.getElementById('inpt-title').value,
   author: document.getElementById('inpt-author').value,
   authorKana: document.getElementById('inpt-author').value,
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
     alert("sucsses：" + response);
    },
    error: function() {
     alert("error");
    }
   });
  }
}





