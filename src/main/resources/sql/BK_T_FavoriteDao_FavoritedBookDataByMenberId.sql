/* BK_T_FavoriteDao_FavoritedBookDataByMenberId.sql */
/*
 * ※以降は不要であれば削除
SELECT
  B.本ID,
  B.タイトル,
  B.タイトルかな,
  B.著者,
  B.タグ,
  B.画像,

  F.メンバーID

FROM
  BK_M_BOOK B,
  BK_T_FAVORITE F

WHERE
  F.削除フラグ = 0,
  B.本ID = F.本ID,
  F.メンバーID = 自分（カトレアのID）

ORDER BY
  B.本ID ASC

 ※ここまで※
 */

-- loginId ログインユーザのメンバーID

select

  B.BOOK_ID,
  B.TITLE,
  B.TITLE_KANA,
  B.AUTHOR,
  B.TAG_IDS,
  B.BOOK_IMG,

  F.MEM_ID

from
  book_db.BK_M_BOOK B,
  book_db.BK_T_FAVORITE F

where
  F.DEL_FLG = 0
and
  B.BOOK_ID = F.BOOK_ID
and
  F.MEM_ID = loginId

order by
  B.BOOK_ID asc
;