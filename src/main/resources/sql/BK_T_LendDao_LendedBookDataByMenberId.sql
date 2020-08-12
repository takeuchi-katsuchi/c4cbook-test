/* BK_T_LendDao_LendedBookDataByMenberId.sql */
/*
 * ※以降は不要であれば削除
SELECT
  B.本ID,
  B.タイトル,
  B.タイトルかな,
  B.著者,
  B.タグ,
  B.画像,

  L.貸出ステータス

FROM
  BK_M_BOOK B,
  BK_T_LEND L

WHERE
　L.削除フラグ = 0,
  L.メンバーID = 自分（カトレアのID）
  B.本ID = L.本ID

ORDER BY
  L.貸出ステータス ASC,
  L.返却日 DESC

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

  L.LEND_STATUS

from
  BK_M_BOOK B,
  BK_T_LEND L

where
  L.DEL_FLG = 0,
  L.MEM_ID = loginId
  B.BOOK_ID = F.BOOK_ID

order by
  L.LEND_STATUS asc,
  L.TO_DATE desc
;