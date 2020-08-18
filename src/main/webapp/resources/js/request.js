function readMoreReason() {

	//「ReadMore」を非表示にする
	document.getElementById('readmore').className += " hide";

	//要望理由をすべて表示する
	document.getElementById('reason_close').className = "reason_open";
}

window.onload = function(){
	// ページ読み込み時に実行したい処理

	let client_h = document.getElementById('reason_close').clientHeight;

	//3行以上あれば
	if (client_h < 50) {
		document.getElementById('readmore').className += " hide";
	}
}