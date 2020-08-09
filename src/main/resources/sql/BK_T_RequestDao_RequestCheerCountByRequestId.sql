/* BK_T_RequestDao_RequestCheerCountByRequestId.sql */
/*
 * ※以降は不要であれば削除
SELECT

count(RC.要望ID)

FROM
(SELECT * FROM book_db.要望応援テーブル WHERE 要望ID = パラメータ) RC

WHERE
  (SELECT 削除フラグ FROM book_db.要望テーブル WHERE 要望ID = パラメータ) = 0

 ※ここまで※
 */

-- CheerForRequestId 応援対象の要望ID

select

count(RC.REQUEST_ID)

from
(select * from book_db.BK_T_REQUEST_CHEER where REQUEST_ID = CheerForRequestId) RC

where
  (select DEL_FLG from book_db.BK_T_REQUEST where REQUEST_ID = CheerForRequestId) = 0
;