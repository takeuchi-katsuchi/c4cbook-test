/* BK_T_SelectBookListDao_getNewsRecometBook.sql */

select
    RECOM_ID,
    TO_MEM_ID,
    RECOM_DATE
from
    book_db.BK_T_RECOM
where
    TO_MEM_ID = /*memId*/
And
    RECOM_DATE > /*readTime*/
;