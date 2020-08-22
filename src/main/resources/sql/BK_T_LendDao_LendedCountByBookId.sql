/* BK_T_LendDao_LendedBookDataByMenberId.sql */
/*
 * ※以降は不要であれば削除
SELECT
  B.本ID,
  count(本ID)

FROM,
  貸出テーブル

GROUP BY
  本ID

 ※ここまで※
 */

-- bookId 本ID

select

BOOK_ID,
count(BOOK_ID) as cnt

from
book_db.BK_T_LEND

group by
BOOK_ID
;