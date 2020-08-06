/* BK_M_BookDao_top.sql */
select
B.BOOK_ID,
B.TITLE,
B.AUTHOR,
B.TAG_IDS,
B.BOOK_IMG

from
book_db.BK_M_BOOK B,
book_db.BK_T_RECOM R

where
R.TO_MEM_ID = '開いているユーザのID'
and
B.BOOK_ID = R.BOOK_ID

order by
R.RECOM_DATE desc,
B.CREATE_AT desc;