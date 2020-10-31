/* BK_T_LendDao_LendedBookDataByBookId.sql */

-- BOOK_IDは現在固定

select
  book_db.BK_T_LEND.MEM_ID,
  book_db.BK_T_LEND.FROM_DATE,
  book_db.BK_T_LEND.TO_DATE
from
  book_db.BK_M_BOOK
join
  book_db.BK_T_LEND on book_db.BK_M_BOOK.BOOK_ID = book_db.BK_T_LEND.BOOK_ID
where
  book_db.BK_T_LEND.DEL_FLG = 0
and
  book_db.BK_T_LEND.BOOK_ID = 2
order by
  book_db.BK_T_LEND.TO_DATE desc
;