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

function testtest(){

//	//////////画像の表示//////////
//
//	//book_imgクラスのdivを取得
//	var bookImgs = document.getElementsByClassName('book_img');
//
//	var src_width = bookImgs[0].naturalWidth;
//
//	alert(src_width);
}

window.onload = function(){
	// ページ読み込み時に実行したい処理

	//////////要望理由のreadmore//////////

	//reasonクラスのdivを取得
	var reasons = document.getElementsByClassName('reason');
	//reasonsクラスを持つ要素の数を取得
	var i_roasons = reasons.length;
	//readmoreクラスのdivを取得
	var readmores = document.getElementsByClassName('readmore');

	for (var i = 0;  i < i_roasons;  i++) {

		//3行以上なければ
		if (reasons[i].clientHeight < 50) {
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
		if (reasons_reject[i].clientHeight < 50) {
			readmores_reject[i].className += " hide";
		};

	};

}