$(document).ready(function () {
    console.log("JQuery OK");

    // ハートをクリックした時
    $(document).on('click', 'i[name="fav"]', function () {
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
            success: function (response) {
                console.log(response.status);
            },
            error: function () {
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
            success: function (response) {
                console.log(response.status);
            },
            error: function () {
                alert("error");
            }
        });
    }


    let memId = $('#loginMember').val();
    let dataList, favBookIdList, lendBookIdList;
    $(document).on('click', '#sorting', function () {
        // 並び替え絞り込み用に、本のデータを全件クライアント側に保持
        getBookList(memId);
    });

    $(document).on('click', '#filtering', function () {
        // 並び替え絞り込み用に、本のデータを全件クライアント側に保持
        getBookList(memId);
    });

    // 非同期でbookListを取得
    function getBookList(memId) {
        $.ajax({
            url: 'api/getBookList',
            data: {memId: memId},
            type: 'get',
            success: function (response) {
                dataList = response.dataList;
                favBookIdList = response.myFavoriteBookIdList;
                lendBookIdList = response.myLendedBookIdList;
                // 読み込みが完了したらチェックボックスを活性化
                $('input[type="checkbox"]').prop('disabled', false);
            },
            error: function () {
            }
        });
    }

    /////////////////////////////////////////////////////////
    // 並び替えの処理
    ////////////////////////////////////////////////////////
    let sortCond;
    $('input[name="sortCond"]').on('change', function () {
        sortCond = $(this).val();

        let sortedList = null;
        // 最新入荷日順
        if (sortCond === "1") {
            sortedList = getSortedListLatest(dataList);
            // あいうえお順
        } else if (sortCond === "2") {
            sortedList = getSortedListKana(dataList);
            // お気に入り数順
        } else if (sortCond === "3") {
            sortedList = getSortedListFav(dataList);
            // 読まれた回数順
        } else if (sortCond === "4") {
            sortedList = getSortedListLend(dataList);
        }

        // 元々の要素を削除
        $(`.request`).children().remove();
        // 並び替えた要素を全件追加する
        for (let i = 0; i < sortedList.length; i++) {
            // url
            let destinationUrl = `/c4cbook/detail?bookId=${sortedList[i]["bookId"]}`
            let memName = sortedList[i]["memName"];
            let lendStatusObj;

            // memNameがnullの場合貸出可能
            if (memName === null) {
                lendStatusObj = `<div class="rent_able">貸出可能です</div>`
            // memNameがnullでない場合誰々に貸出中
            } else {
                lendStatusObj = `<div class="rent_disable">${memName}に貸出中</div>`
            }

            let bookId, elem1, elem2;
            bookId = sortedList[i]["bookId"];
            // 読書済みの場合本が開いたアイコンを表示
            if (lendBookIdList.includes(bookId)) {
                elem1 = `<i class="fas fa-book-open fa-2x"></i>`
                // 読書済みでない場合本が開閉じたアイコンを表示
            } else {
                elem1 = `<i class="noread fas fa-book fa-2x"></i>`
            }
            // お気に入りしている場合赤いハートを表示
            if (favBookIdList.includes(bookId)) {
                elem2 = `<i class="fas fa-heart fa-2x" name="fav" data-id="${bookId}"></i>`
                // お気に入りしていない場合薄いピンクのハートを表示
            } else {
                elem2 = `<i class="noheart fas fa-heart fa-2x" name="fav" data-id="${bookId}"></i>`
            }

            // 要素を追加
            $('.request').append(`
                    <div class="book_box">
						<div class="book_img_area">
							<a href="${destinationUrl}"><img class="book-img" src="resources/img/sample_book.jpg" alt=""></a>
						</div>
			
						<div class="book_info">
							<div class="name"><a href="${destinationUrl}">${sortedList[i]["title"]}</a></div>
							<div class="author">${sortedList[i]["author"]}</div>
							${lendStatusObj}
							<ul class="tag">
								<li>${sortedList[i]["tagIds"]}</li>
							</ul>
							<div class="icon_img_wrap">
								<div class="icon_img_area">
                                    ${elem1}
								</div>
								<div class="icon_img_area book-count">${sortedList[i]["lendCount"]}</div>
								<div class="icon_img_area">
									${elem2}
								</div>
								<div class="icon_img_area heart-count">
										${sortedList[i]["favCount"]}
								</div>
							</div>
						</div>
                    </div>
		                `);
        }
    });

    function getSortedListLatest(list) {
        let sortedList = list.sort(function (a, b) {
            if (a.offerDate > b.offerDate) return -1;
            if (a.offerDate < b.offerDate) return 1;
            return 0;
        });
        return sortedList;
    }


    function getSortedListKana(list) {
        let sortedList = list.sort(function (a, b) {
            if (a.titleKana < b.titleKana) return -1;
            if (a.titleKana > b.titleKana) return 1;
            return 0;
        });
        return sortedList;
    }

    function getSortedListFav(list) {
        let sortedList = list.sort(function (a, b) {
            if (a.favCount > b.favCount) return -1;
            if (a.favCount < b.favCount) return 1;
            return 0;
        });
        return sortedList;
    }

    function getSortedListLend(list) {
        let sortedList = list.sort(function (a, b) {
            if (a.lendCount > b.lendCount) return -1;
            if (a.lendCount < b.lendCount) return 1;
            return 0;
        });
        return sortedList;
    }

    // チェックボックスの選択制御
    $('input[type="checkbox"]').on("click", function () {
        $('input[type="checkbox"]').prop('checked', false);  //  全部のチェックを外す
        $(this).prop('checked', true);  //  押したやつだけチェックつける
    });

});
