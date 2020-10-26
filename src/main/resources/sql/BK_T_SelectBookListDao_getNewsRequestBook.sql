/* BK_T_SelectBookListDao_getNewsRequestBook.sql */

select
    REQUEST_ID,
    TITLE,
    MEM_ID,
    REQUEST_STATUS,
    UPDATE_AT
from
    book_db.BK_T_REQUEST
where
    MEM_ID = /*memId*/
And
    REQUEST_STATUS = 1
And
    UPDATE_AT > /*readTime*/
;