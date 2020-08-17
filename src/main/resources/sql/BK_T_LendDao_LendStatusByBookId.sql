/* BK_T_LendDao_LendStatusByBookId.sql */
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

-- 貸出テーブル
  貸出テーブル.貸出ID
  貸出テーブル.メンバーID
  貸出テーブル.貸出ステータス
  貸出テーブル.貸出日
  貸出テーブル.返却日
  貸出テーブル.レビュー

FROM
  本マスタ,
  貸出テーブル

WHERE
  本マスタ.削除フラグ = 0,
  本マスタ.本ID = 貸出テーブル.本ID
;

 ※ここまで※
 */

select

  B.BOOK_ID,
  B.TITLE,
  B.AUTHOR,
  B.TAG_IDS,
  B.OUTLINE,
  B.BOOK_IMG,
  B.OFFER_MEM_ID,
  B.OFFER_MEM_COMMENT,

  L.LEND_ID,
  L.MEM_ID as L_MEN_ID,
  L.LEND_STATUS,
  L.FROM_DATE,
  L.TO_DATE,
  L.REVIEW

from
  book_db.BK_M_BOOK B
  book_db.BK_T_LEND L

where
  B.DEL_FLG = 0,
  B.BOOK_ID = L.BOOK_ID
;