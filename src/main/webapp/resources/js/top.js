$(document).ready(function() {
	console.log("JQuery OK");

	// ハートをクリックした時
	$('i[name="fav"]').on('click', function() {
		let bookId = $(this).data('id');
		let memId = $("#loginMember").val();
		let heartCountElem = $(this).parent().parent().find('div.icon_img_area.heart-count');

		// お気に入り未の場合
		if ($(this).hasClass("noheart")) {
			$(this).removeClass("noheart");
			heartCountElem.text(parseInt(heartCountElem.text()) + 1);
			// お気に入り登録呼び出し　
			favorite(bookId, memId);
			// お気に入り済の場合
		} else {
			heartCountElem.text(parseInt(heartCountElem.text()) - 1);
			$(this).addClass("noheart");
			// お気に入り削除呼び出し
			delFavorite(bookId, memId);
		}
	})

	// POST Ajax お気に入り登録　
	function favorite(bookId, memId) {
		let formData = {
			bookId: bookId,
			memId: memId
		}
		$.ajax({
			url: 'api/favorite',
			type: 'post',
			contentType: "application/json",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(response) {
				console.log(response.status);
			},
			error: function() {
				alert("error");
			}
		});
	}

	// POST Ajax お気に入り削除
	function delFavorite(bookId, memId) {
		let formData = {
			bookId: bookId,
			memId: memId
		}
		$.ajax({
			url: 'api/favorite-delete',
			type: 'post',
			contentType: "application/json",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(response) {
				console.log(response.status);
			},
			error: function() {
				alert("error");
			}
		});
	}


});
