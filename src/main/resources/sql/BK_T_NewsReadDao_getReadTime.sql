/* BK_T_NewsReadDao_getReadTime.sql */

select
    book_db.BK_T_NEWS_READ.READ_AT
from
    book_db.BK_T_NEWS_READ
where
    book_db.BK_T_NEWS_READ.MEM_ID = /*memId*/
;