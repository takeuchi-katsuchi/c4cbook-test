/* BK_T_NewsReadDao_getReadTime.sql */

select
    R.MEM_ID,
    R.READ_AT,
    R.DEL_FLG,
    R.CREATE_AT,
    R.UPDATE_AT
from
    book_db.BK_T_NEWS_READ as R
where
     MEM_ID = /*memId*/
;