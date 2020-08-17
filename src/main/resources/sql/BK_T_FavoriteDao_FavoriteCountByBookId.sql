/* BK_T_RequestDao_RequestCheerCountByRequestId.sql */
/*
 * ※以降は不要であれば削除
SELECT

要望ID,
count(本ID)

FROM
book_db.お気に入りテーブル

group by
本ID

 ※ここまで※
 */

select

BOOK_ID,
count(BOOK_ID) as cnt

from
book_db.BK_T_FAVORITE

group by
BOOK_ID
;