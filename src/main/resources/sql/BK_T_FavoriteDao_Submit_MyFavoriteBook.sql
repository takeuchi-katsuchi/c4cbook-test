/* BK_T_FavoriteDao_Submit_MyFavoriteBook.sql */
/*
 * ※以降は不要であれば削除
insert into お気に入りテーブル
(
本ID,
メンバーID,
削除フラグ,
作成日付,
更新日付
)
values
FROM
(
bookId,
mId,
delFlg,
createAt,
updateAt
)
;
 */

insert into book_db.BK_T_FAVORITE
(
BOOK_ID,
MEM_ID,
DEL_FLG,
CREATE_AT,
UPDATE_AT
)
values
(
bookId,
mId,
delFlg,
createAt,
updateAt
)
;