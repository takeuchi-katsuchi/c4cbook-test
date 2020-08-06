/* BK_M_BookDao_top.sql */
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
  F.MEM_ID = 4

order by
  B.BOOK_ID asc;
