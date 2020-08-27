/* BK_T_RecomeDao_RecomeBookToMenberId.sql */

-- MEM_IDを固定中

select
  B.BOOK_ID,
  B.TITLE,
  B.TITLE_KANA,
  B.AUTHOR,
  B.TAG_IDS,
  B.BOOK_IMG

  LR.FROM_MEM_ID,
  LR.RECOM_DATE

from
  book_db.BK_M_BOOK B
JOIN
(SELECT
  book_db.BK_T_RECOM.RECOM_ID,
  book_db.BK_T_RECOM.BOOK_ID,
  book_db.BK_T_RECOM.FROM_MEM_ID,
  book_db.BK_T_RECOM.TO_MEM_ID,
  book_db.BK_T_RECOM.RECOM_DATE,
  book_db.M_MEM_BASIC.MEM_NAME
 FROM
  book_db.BK_T_RECOM
 JOIN
  book_db.M_MEM_BASIC ON book_db.BK_T_RECOM.FROM_MEM_ID = book_db.M_MEM_BASIC.MEM_ID
 WHERE
  DATE_ADD(RECOM_DATE,INTERVAL 3 MONTH) > CURRENT_TIMESTAMP()
 AND
  book_db.BK_T_RECOM.TO_MEM_ID = 2
 ) as LR
 ON
  B.BOOK_ID = LR.BOOK_ID
  ;