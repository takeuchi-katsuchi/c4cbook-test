package jp.co.c4c.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.controller.form.DetailForm;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;
import jp.sf.amateras.mirage.StringSqlResource;

@Component
public class DetailDao {

    @Autowired
    public SqlManager sqlManager;

    public DetailForm seletctBookById(int bookId) {
        System.out.print("Daoが接続されたよ");
        final SqlResource sqlSrc = new StringSqlResource(
                "SELECT \n" +
                        "    book_db.BK_M_BOOK.BOOK_ID,\n" +
                        "    book_db.BK_M_BOOK.TITLE,\n" +
                        "    book_db.BK_M_BOOK.AUTHOR,\n" +
                        "    book_db.BK_M_BOOK.TAG_IDS,\n" +
                        "    book_db.BK_M_BOOK.OUTLINE,\n" +
                        "    book_db.BK_M_BOOK.BOOK_IMG,\n" +
                        "    book_db.BK_M_BOOK.OFFER_MEM_ID,\n" +
                        "    book_db.BK_M_BOOK.OFFER_MEM_COMMENT,\n" +
                        "    book_db.BK_T_LEND.LEND_ID,\n" +
                        "    book_db.BK_T_LEND.MEM_ID,\n" +
                        "    book_db.BK_T_LEND.LEND_STATUS,\n" +
                        "    book_db.M_MEM_BASIC.MEM_NAME\n" +
                        "FROM\n" +
                        "    book_db.BK_M_BOOK\n" +
                        "LEFT JOIN\n" +
                        "    book_db.BK_T_LEND ON book_db.BK_M_BOOK.BOOK_ID = book_db.BK_T_LEND.BOOK_ID\n" +
                        "LEFT JOIN\n" +
                        "    book_db.M_MEM_BASIC ON book_db.BK_T_LEND.MEM_ID = book_db.M_MEM_BASIC.MEM_ID\n" +
                        "WHERE\n" +
                        "	book_db.BK_M_BOOK.BOOK_ID =" + bookId + ";");
        return sqlManager.getSingleResult(DetailForm.class, sqlSrc);
    }

}
