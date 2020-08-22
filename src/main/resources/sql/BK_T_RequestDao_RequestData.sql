/* BK_T_RequestDao_RequestData.sql */
/*
 * ※以降は不要であれば削除
SELECT

R.要望ID,
R.タイトル,
R.タイトルかな,
R.著者,
R.著者かな,
R.本画像,
R.メンバーID,
R.コメント,
R.要望ステータス,

FROM
  book_db.BK_T_REQUEST

WHERE
  R.DEL_FLG = 0
;
 */


select

REQUEST_ID,
TITLE,
TITLE_KANA,
AUTHOR,
AUTHOR_KANA,
BOOK_IMG,
MEM_ID,
COMMENT,
REQUEST_STATUS

from
  book_db.BK_T_REQUEST

where
  DEL_FLG = 0
;