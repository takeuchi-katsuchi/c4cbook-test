SELECT
    B.BOOK_ID,
    B.TITLE,
    B.AUTHOR,
    B.TAG_IDS,
    B.OUTLINE,
    B.BOOK_IMG,
    B.OFFER_MEM_ID,
	B.OFFER_MEM_COMMENT,
	B.OFFER_DATE,
    LM.LEND_ID,
    LM.MEM_ID,
    LM.FROM_DATE,
    LM.TO_DATE,
    LM.LEND_STATUS,
    LM.MEM_NAME,
    FC.FAV_COUNT,
    LC.LEND_COUNT
FROM
    book_db.BK_M_BOOK as B
LEFT JOIN
    (SELECT
		book_db.BK_T_LEND.BOOK_ID,
		book_db.BK_T_LEND.LEND_ID,
		book_db.BK_T_LEND.MEM_ID,
		book_db.BK_T_LEND.LEND_STATUS,
		book_db.BK_T_LEND.FROM_DATE,
		book_db.BK_T_LEND.TO_DATE,
		book_db.M_MEM_BASIC.MEM_NAME
	FROM
		book_db.BK_T_LEND
	JOIN
		book_db.M_MEM_BASIC ON book_db.BK_T_LEND.MEM_ID = book_db.M_MEM_BASIC.MEM_ID
	WHERE
		LEND_STATUS = 11) as LM
ON
	B.BOOK_ID = LM.BOOK_ID
LEFT JOIN
	(SELECT
		book_db.BK_T_FAVORITE.BOOK_ID,
		COUNT(BOOK_ID) as FAV_COUNT
	FROM
		book_db.BK_T_FAVORITE
	GROUP BY
		BOOK_ID) as FC
ON
	B.BOOK_ID = FC.BOOK_ID
LEFT JOIN
	(SELECT
		book_db.BK_T_LEND.BOOK_ID,
		COUNT(BOOK_ID) as LEND_COUNT
	FROM
		book_db.BK_T_LEND
	group by
		BOOK_ID) as LC
ON
	B.BOOK_ID = LC.BOOK_ID
WHERE
	B.BOOK_ID = /*bookId*/;