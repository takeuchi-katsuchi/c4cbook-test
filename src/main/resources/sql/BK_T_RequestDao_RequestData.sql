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
R.メンバーID AS R_MEM_ID,
R.コメント,
R.要望ステータス,

RC.メンバーID AS RC_MEM_ID

FROM
  book_db.BK_T_REQUEST R,
  book_db.BK_T_REQUEST_CHEER RC

WHERE
  R.DEL_FLG = 0
;
 */


select

R.REQUEST_ID,
R.TITLE,
R.TITLE_KANA,
R.AUTHOR,
R.AUTHOR_KANA,
R.BOOK_IMG,
R.MEM_ID as R_MEM_ID,
R.COMMENT,
R.REQUEST_STATUS,

RC.MEM_ID as RC_MEM_ID

from
  book_db.BK_T_REQUEST R,
  book_db.BK_T_REQUEST_CHEER RC

where
  R.DEL_FLG = 0
;