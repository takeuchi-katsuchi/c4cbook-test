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

	//////////画像の表示//////////

	//bookImgクラスのimgを取得
	var imgs = document.getElementsByClassName( "bookImg" ) ;
	//reason_rejectsクラスを持つ要素の数を取得
	var i_imgs = imgs.length;
	//画像の元サイズ
	var src_width = 0;
	var src_height = 0;
	//変更先サイズ
	var tgt_width = 0;
	var tgt_height = 0;
	//表示位置決定用
	var disp_x = 0;
	var disp_y = 0;
	//px文字
	var px = "px";

	for (var i = 0;  i < i_imgs;  i++) {

		if ( imgs[i].complete ) {

			src_width = imgs[i].naturalWidth ;
			src_height = imgs[i].naturalHeight ;

			//縦長なら
			if ( src_width < src_height ) {

				//縦を150で固定して同じ縦横比で横を設定
				tgt_height = 150;
				tgt_width = 150 * (src_width / src_height);

				if ( tgt_width <= 100 ) {

					//設定した横が100以内あればその値で表示
					imgs[i].style.width = tgt_width + px;
					imgs[i].style.height = tgt_height + px;

					//中央に表示
					disp_x = (100 - tgt_width) / 2;
					disp_y = 0;

					imgs[i].style.left = disp_x + px;
					imgs[i].style.top = disp_y + px;

				} else {

					//設定した横が100以上あればその値からさらに縮小し表示
					tgt_width = 100;
					tgt_height = 100 * (src_height / src_width);

					imgs[i].style.width = tgt_width + px;
					imgs[i].style.height = tgt_height + px;

					//中央に表示
					disp_x = 0;
					disp_y = (150 - tgt_height) / 2;

					imgs[i].style.left = disp_x + px;
					imgs[i].style.top = disp_y + px;

				};

			//横長なら
			} else {

				//横を100で固定して同じ縦横比で縦を設定
				tgt_width = 100;
				tgt_height = 100 * (src_height / src_width);

				//横長の画像の場合はこの値で表示
				imgs[i].style.width = tgt_width + px;
				imgs[i].style.height = tgt_height + px;

				//中央に表示
				disp_x = 0;
				disp_y = (150 - tgt_height) / 2;

				imgs[i].style.left = disp_x + px;
				imgs[i].style.top = disp_y + px;

			};
		};

	};

	//////////却下理由の表示//////////

	//テスト用の配列、本番は引数で配列受けて処理する
	var testRejectFlgArray = new Array(0, 1);

	//本の画像応援ボタン　グレーアウト用
	var bookImgs = document.getElementsByClassName( "bookImg" ) ;
	var bookImgAreas = document.getElementsByClassName( "book_img_area" ) ;
	var cheerImgs = document.getElementsByClassName( "cheerImg" ) ;
	var cheerImgAreas = document.getElementsByClassName( "cheer_img_area" ) ;

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

		//却下されたものじゃなければ
		} else {

			//非表示
			rejectImgss[i].className += " hide";
			rejectReasons[i].className += " hide";

		};
	};
}