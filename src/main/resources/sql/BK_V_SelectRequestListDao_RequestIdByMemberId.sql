/* BK_V_SelectRequestListDao_RequestIdByMemberId.sql */
select
    B.REQUEST_ID
from
    book_db.BK_T_REQUEST_CHEER B
where
    B.MEM_ID = /*memId*/

;