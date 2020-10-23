<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<section class="header">
 <div class="header-wrap">
  <h2 class="title">C4CBOOK</h2>
  <div class="menu">
   <ul class="pulldown">
    <li class="use_top"><img id="filtering" src="resources/img/filter.png" alt="フィルタ" data-toggle="modal"data-target="#filter_modal"></li>
    <li class="use_top"><img id="sorting" src="resources/img/sort.png" alt="ソート" data-toggle="modal"data-target="#sort_modal"></li>
    <li class="slidebtn, use_top"><a href="#"><img src="resources/img/news.png" alt="お知らせ"></a>
     <ul class="submenu">
      <c:if test="${LendingCnt >= 1}">
       <li class="news"><a href="/c4cbook/mypage">返却期限が近付いている本が${LendingCnt}件あります。</a></li>
      </c:if>
      <c:if test="${readStatus}">
       <li class="news">新しく入った本があります。</li>
      </c:if>
      <c:if test="${readStatus}">
       <li class="news">要望していた本が承認されました。</li>
      </c:if>
     </ul></li>
    <li class="drowerbtn"><a><img src="resources/img/menu.png" alt="メニュー"></a>
   </ul>
  </div>
 </div>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="resources/js/header.js"></script>
<script src="resources/js/menu.js"></script>

<%-- アクティブ処理 --%>
<input type="hidden" id="act_type" value="<%=request.getParameter("act_type")%>">
<script type="text/javascript">
    var actType = document.getElementById('act_type').value;
    if (actType != null && actType != '') {
        document.getElementsByClassName(actType)[0].classList.add('actv');
    }
</script>