UPDATE book_db.BK_T_LEND
SET
	LEND_STATUS = /*lendStatus*/,
	FROM_DATE = /*fromDate*/,
    TO_DATE = /*toDate*/,
    UPDATE_AT = /*updateAt*/
WHERE
	LEND_ID = /*lendId*/;