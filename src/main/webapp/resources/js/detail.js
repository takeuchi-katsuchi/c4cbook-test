$(document).ready(function() {
	console.log("JQuery OK");

	let calendarEvents = [];
	var bookId = $("#postBookId").val();
	getLendHistory();
	function getLendHistory(){
		$.ajax({
			url: 'api/getLendHistory',
			type: 'get',
			data: `bookId=${bookId}`,
			success: function(response) {
				let lendHistorys = [];
				for (i = 0; i < response.data.length; i++) {
					if (response.data[i]["lendStatus"] == 19) {
						continue;
					} else {
						let fromDate = new Date(response.data[i]["fromDate"]);
						let toDate = new Date(response.data[i]["toDate"]);
						response.data[i]["period"] = (toDate - fromDate) / 86400000;
						lendHistorys.push(response.data[i]);
					}
				}
				console.log(lendHistorys);
				for (i = 0; i < lendHistorys.length; i++) {
					for (j = 0; j <= lendHistorys[i]["period"]; j++) {
						let title, dt, color;
						dt = new Date(lendHistorys[i]["fromDate"] + (86400000 * j));
						dt = dateFormat(dt);
						if (lendHistorys[i]["lendStatus"] == 11) {
							title = `${lendHistorys[i]["memName"]}/貸出`;
							color = "#00ff00";
							let obj = {
								title: title,
								start: dt,
								color: color
							};
							calendarEvents.push(obj);
						} else {
							title = `${lendHistorys[i]["memName"]}/予約`;
							color = "#ffff00";
							let obj = {
								title: title,
								start: dt,
								color: color
							};
						calendarEvents.push(obj);
						}
					}
				}
			},
			error: function() {
				alert("error");
			}
		});
	}
	// 貸出・予約カレンダー表示
	$(`#LendingProcedureModal`).on('shown.bs.modal', function() {
		// DOMを取得
		var calendarEl = document.getElementById('calendar');
		// 指定DOMにカレンダープラグインを適用する
		var calendar = new FullCalendar.Calendar(calendarEl, {
			plugins: ['dayGrid'],
			events: calendarEvents
			/*
			[
				{
					title: '小針さんに貸出',
					start: '2020-08-20',
				}
			]
			*/
		});
		calendar.render();

		$(`#LendingProcedureModal`).on('hidden.bs.modal', function() {
			calendar.destroy()
		});

	});

	// 誰かに貸出中の場合は貸出をチェックできない
	if ($(`#getLendStatus`).val() === "11") {
		$('#lendChkBox').prop('disabled', true)
	}

	// 貸出・予約チェックボックスを自動で切り替え
	$('#lendChkBox').on('click', function() {
		if ($('#reserveChkBox').prop('checked') === true) {
			$('#reserveChkBox').prop('checked', false);
			$('#postLendStatus').val(11);
			console.log($("#postLendStatus").val()); //確認用
		} else {
			return false
		}
	});
	$('#reserveChkBox').on('click', function() {
		if ($('#lendChkBox').prop('checked') === true) {
			$('#lendChkBox').prop('checked', false);
			$('#postLendStatus').val(10);
			console.log($("#postLendStatus").val()); //確認用
		} else {
			return false
		}
	});

	// 貸出・予約手続きAjax呼び出し
	$(`#save`).on('click', function() {
		var formData = {
			bookId: $("#postBookId").val(),
			memId: $("#postMemberId").val(),
			lendStatus: $("#postLendStatus").val(),
			fromDate: $("#postFromDate").val(),
			toDate: $("#postToDate").val()
		}
		console.log(formData);
		if (!confirm('内容を確定しますか?')) {
			return false;
		} else {
			$.ajax({
				url: 'api/proceedLendReserve',
				type: 'post',
				contentType: "application/json",
				data: JSON.stringify(formData),
				dataType: 'json',
				success: function(response) {
					console.log(response.status);
					$('#LendingProcedureModal').modal('hide');
				},
				error: function() {
					alert("error");
					$('#LendingProcedureModal').modal('hide');
				}
			});
		}
	});

	// dateformatメソッド
	function dateFormat(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		if (m < 10) { m = '0' + m; }
		if (d < 10) { d = '0' + d; }
		// フォーマット整形済みの文字列を戻り値にする
		return y + '-' + m + '-' + d;
	}

});

