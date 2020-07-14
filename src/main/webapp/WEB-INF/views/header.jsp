<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div class="header">
  <div class="top">C4CBOOK</div>
  <div class="menu">
    <div><img src="img/filter.png" alt="フィルタ"></div>
    <div><img src="img/sort.png" alt="ソート"></div>
    <div><img src="img/news.png" alt="お知らせ"></div>
    <div><img src="img/menu.png" alt="メニュー"></div>
  </div>
</div>

<%-- アクティブ処理 --%>
<input type="hidden" id="act_type" value="<%=
request.getParameter("act_type") %>">
<script type="text/javascript">
 var actType = document.getElementById('act_type').value;
 if (actType != null && actType != '') {
document.getElementsByClassName(actType)[0].classList.add('actv'); }
</script>