/* BK_T_FavoriteDao_FavoritedBookDataByBookId.sql */
/*
 * ※以降は不要であれば削除

SELECT

-- 本マスタ
  本マスタ.本ID,
  本マスタ.タイトル,
  本マスタ.著者,
  本マスタ.タグ,
  本マスタ.概要,
  本マスタ.画像,
  本マスタ.提供メンバーID,
  本マスタ.提供メンバーコメント,

-- お気に入りテーブル
  お気に入りテーブル.メンバーID

FROM
  本マスタ
  お気に入りテーブル

WHERE
  本マスタ.削除フラグ = 0,
  本マスタ.本ID = お気に入りテーブル.本ID
;
 ※ここまで※
 */

-- loginId ログインユーザのメンバーID

select

  B.BOOK_ID,
  B.TITLE,
  B.AUTHOR,
  B.TAG_IDS,
  B.OUTLINE,
  B.BOOK_IMG,
  B.OFFER_MEM_ID,
  B.OFFER_MEM_COMMENT,

  BK_T_FAVORITE.MEM_ID

from
  book_db.BK_M_BOOK B
  book_db.BK_T_FAVORITE F

where
  B.DEL_FLG = 0,
  B.BOOK_ID = F.BOOK_ID
;