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

	//////////却下理由の表示//////////

	//テスト用の配列、本番は引数で配列受けて処理する
	var testRejectFlgArray = new Array(0, 1);

	//本の画像応援ボタン　グレーアウト用
	var bookImgs = document.getElementsByClassName( "book-img" ) ;
	var bookImgAreas = document.getElementsByClassName( "book_img_area" ) ;
	var cheerImgs = document.getElementsByClassName( "cheerImg" ) ;
	var cheerImgAreas = document.getElementsByClassName( "cheer_img_area" ) ;
 var bookInfo = document.getElementsByClassName("book_info");
 var requesterInfo = document.getElementsByClassName("requester_info");

	//却下理由　非表示用
	var rejectImgss = document.getElementsByClassName( "rejected_img" ) ;
	var rejectReasons = document.getElementsByClassName( "reason_reject" ) ;

	for (var i = 0;  i < testRejectFlgArray.length;  i++) {

		//拒否された物であれば（拒否フラグたってれば）
		if ( testRejectFlgArray[i] == 1 ) {

			//グレーアウト
			bookImgs[i].className += " end_pblctn";
			bookImgAreas[i].className += " end_pblctn";
			cheerImgs[i].className += " end_pblctn";
			cheerImgAreas[i].className += " end_pblctn";
   bookInfo[i].className += " end_pblctn";
   requesterInfo[i].className += " end_pblctn";

		//却下されたものじゃなければ
		} else {

			//非表示
			rejectImgss[i].className += " hide";
			rejectReasons[i].className += " hide";

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
function cheerBook(){
   var formData = {
   requestId: 1,
   memId: 1
  }
  if (!confirm('応援しますか?')) {
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
     alert("sucsses");
    },
    error: function() {
     alert("error");
//     $(`#myModal2`).modal('hide');
//     $('#LendingProcedureModal').modal('hide');
    }
   });
  }
}

//////////「要望する」ボタン//////////
function requestBook(){
   var formData = {
   title: "あいうえお",
   titleKana: "あいうえお",
   author: "こばり",
   authorKana: "こばり",
   mem_id: 1,
   comment: "こめんとです"
  }
  if (!confirm('応援しますか?')) {
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
     alert("sucsses");
    },
    error: function() {
     alert("error");
    }
   });
  }
}
