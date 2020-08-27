/* BK_T_LendDao_Submit_LendBook.sql */
/*
 * ※以降は不要であれば削除
insert into 貸出テーブル
(
本ID,
メンバーID,
貸出ステータス,
貸出日,
返却日,
削除フラグ,
作成日付,
更新日付
)
values
FROM
(
bookId,
mId,
lstatus,
fromDate,
toDate,
delFlg,
createAt,
updateAt
)
;
 */

insert into book_db.BK_T_LEND
(
BOOK_ID,
MEM_ID,
LEND_STATUS,
FROM_DATE,
TO_DATE,
REVIEW,
DEL_FLG,
CREATE_AT,
UPDATE_AT
)
values
(
/*bookId*/,
/*mId*/,
/*lstatus*/,
/*fromDate*/,
/*toDate*/,
/*review*/,
/*delFlg*/,
/*createAt*/,
/*updateAt*/
)
;