<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<section class="header">
 <div class="title">C4CBOOK</div>
 <div class="menu">
  <ul class="pulldown">
   <li><img src="resources/img/filter.png" alt="フィルタ"></li>
   <li><img src="resources/img/sort.png" alt="ソート"></li>
   <li class="slidebtn"><a href="#"><img src="resources/img/news.png" alt="お知らせ"></a>
    <ul class="submenu">
     <li><a href="#">"${topForm.topAndDetailDtoList}" </a></li>
     <li><a href="#">返却期限...</a></li>
    </ul></li>
   <li class="slidebtn"><a href="#"><img src="resources/img/menu.png" alt="メニュー"></a>
    <ul class="submenu">
     <li><form:form action="top" method="post" enctype="multipart/form-data"><input type="submit" value="トップ"></form:form></li>
     <li><form:form action="mypage" method="post" enctype="multipart/form-data"><input type="submit" value="mypage"></form:form></li>
     <li><form:form action="request" method="post" enctype="multipart/form-data"><input type="submit" value="要望"></form:form></li>
    </ul></li>
  </ul>
 </div>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="resources/js/header.js"></script>

<%-- アクティブ処理 --%>
<input type="hidden" id="act_type" value="<%=request.getParameter("act_type")%>">
<script type="text/javascript">
    var actType = document.getElementById('act_type').value;
    if (actType != null && actType != '') {
        document.getElementsByClassName(actType)[0].classList.add('actv');
    }
</script>