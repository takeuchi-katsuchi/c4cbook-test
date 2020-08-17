/* BK_T_RequestDao_Submit_RequestData.sql */
/*
 * ※以降は不要であれば削除
insert into 要望テーブル
(
要望ID,
タイトル,
著者,
メンバーID,
コメント,
要望ステータス,
削除フラグ,
作成日付,
更新日付
)
values
FROM
(
title,
author,
mId,
commet,
status,
delFlg,
createAt,
updateAt
)
;
 */

insert into book_db.BK_T_REQUEST
(
TITLE,
AUTHOR,
MEM_ID,
COMMENT,
REQUEST_STATUS,
DEL_FLG,
CREATE_AT,
UPDATE_AT
)
values
(
title,
author,
mId,
commet,
status,
delFlg,
createAt,
updateAt
)
;