/* BK_T_RecomeDao_Submit_RecomeBook.sql */
/*
 * ※以降は不要であれば削除
insert into おすすめテーブル
(
本ID,
おすすめ元メンバーID,
おすすめ先メンバーID,
おすすめ日,
削除フラグ,
作成日付,
更新日付
)
values
FROM
(
bookId,
fMId,
tMId,
recomeDate,
delFlg,
createAt,
updateAt
)
;
 */

insert into book_db.BK_T_RECOM
(
	BOOK_ID,
	FROM_MEM_ID,
	TO_MEM_ID,
	RECOM_DATE,
	DEL_FLG,
	CREATE_AT,
	UPDATE_AT
)
values
(
	/*bookId*/,
    /*fromMemId*/,
    /*toMemId*/,
    /*recomDate*/,
    /*delFlg*/,
    /*createAt*/,
    /*updateAt*/
);