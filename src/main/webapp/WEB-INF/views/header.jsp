<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<div class="header">
  <div class="top">C4CBOOK</div>
  <div class="menu">
    <div><img src="resources/img/filter.png" alt="フィルタ"></div>
    <div><img src="resources/img/sort.png" alt="ソート"></div>
    <div><img src="resources/img/news.png" alt="お知らせ"></div>
    <div><img src="resources/img/menu.png" alt="メニュー"></div>
  </div>
</div>

<%-- アクティブ処理 --%>
<input type="hidden" id="act_type" value="<%=request.getParameter("act_type") %>">
<script type="text/javascript">
	var actType = document.getElementById('act_type').value;
	if (actType != null && actType != '') {
		document.getElementsByClassName(actType)[0].classList.add('actv');
	}
</script>