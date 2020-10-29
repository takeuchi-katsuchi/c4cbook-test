package jp.co.c4c.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.SampleDto;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;
import jp.sf.amateras.mirage.StringSqlResource;

@Component
public class SampleDao {

	// @Autowiredがうまくいかない
	@Autowired
	public SqlManager sqlManager;

	public List<SampleDto> selectNames() {
      final SqlResource sqlSrc = new StringSqlResource("select * from SAMPLE;");
      return sqlManager.getResultList(SampleDto.class, sqlSrc);
	}
}
