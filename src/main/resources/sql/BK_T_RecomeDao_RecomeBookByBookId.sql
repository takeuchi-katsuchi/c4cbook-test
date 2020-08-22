/* BK_T_RecomeDao_RecomeBookByBookId.sql */
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

--おすすめテーブル
  BK_T_RECOM.おすすめID
  BK_T_RECOM.おすすめ元メンバーID
  BK_T_RECOM.おすすめ先メンバーID

FROM
  本マスタ,
  おすすめテーブル

WHERE
  本マスタ.削除フラグ = 0,
  本マスタ.本ID = おすすめテーブル.本ID
;
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

  BK_T_RECOM.RECOM_ID,
  BK_T_RECOM.FROM_MEM_ID,
  BK_T_RECOM.TO_MEM_ID,

from
  BK_M_BOOK B,
  BK_T_RECOM R

where
  B.DEL_FLG = 0,
  B.本ID = R.本ID
;