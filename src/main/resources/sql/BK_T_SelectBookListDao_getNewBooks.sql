/* BK_T_SelectBookListDao_getNewBooks.sql */
select
    BOOK_ID,
    TITLE
from
    book_db.BK_M_BOOK
where
   OFFER_DATE > /*readTime*/
;