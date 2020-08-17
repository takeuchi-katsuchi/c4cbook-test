/* BK_T_RequestDao_RequestCheerCountByRequestId.sql */
/*
 * ※以降は不要であれば削除
SELECT

要望ID,
count(要望ID)

FROM
book_db.要望応援テーブル

group by
要望ID

 ※ここまで※
 */

-- CheerForRequestId 応援対象の要望ID

select

REQUEST_ID,
MEM_ID,
count(REQUEST_ID) as cnt

from
book_db.BK_T_REQUEST_CHEER

group by
REQUEST_ID
;