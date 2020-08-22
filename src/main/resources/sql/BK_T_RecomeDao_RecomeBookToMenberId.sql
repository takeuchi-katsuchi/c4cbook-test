/* BK_T_RecomeDao_RecomeBookToMenberId.sql */
/*
 * ※以降は不要であれば削除
SELECT
  B.本ID,
  B.タイトル,
  B.タイトルかな,
  B.著者,
  B.タグ,
  B.画像,

  R.おすすめID,
  R.おすすめ日

FROM
  BK_M_BOOK B,
  BK_T_RECOM R

WHERE
  B.本ID = R.本ID
  R.TO_MEM_D = 自分（カトレアのID）
  おすすめが今日の三ヵ月以内

ORDER BY
  R.おすすめ日 DESC

 ※ここまで※
 */

-- loginId ログインユーザのメンバーID

select
  B.BOOK_ID,
  B.TITLE,
  B.TITLE_KANA,
  B.AUTHOR,
  B.TAG_IMG,
  B.BOOK_IMG,

  R.RECOM_ID,
  R.RECOM_DATE

from
  BK_M_BOOK B,
  BK_T_RECOM R

where
  B.本ID = R.本ID
  R.TO_MEM_D = loginId
  R.RECOM_DATE between R.RECOM_DATE and R.RECOM_DATE + INTERVAL 2 MONTH

order by
  R.RECOM_DATE asc
;