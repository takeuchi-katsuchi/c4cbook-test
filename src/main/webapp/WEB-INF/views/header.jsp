<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<section class="header">
 <div class="top">C4CBOOK</div>
 <div class="menu">
  <div>
   <img src="resources/img/filter.png" alt="フィルタ" class="openfilter">
  </div>
  <div>
   <img src="resources/img/sort.png" alt="ソート" class="opensort">
  </div>
  <div>
   <img src="resources/img/news.png" alt="お知らせ">
  </div>
  <div>
   <img src="resources/img/menu.png" alt="メニュー">
  </div>
 </div>
</section>

<%-- アクティブ処理 --%>
<input type="hidden" id="act_type" value="<%=request.getParameter("act_type")%>">
<script type="text/javascript">
    var actType = document.getElementById('act_type').value;
    if (actType != null && actType != '') {
        document.getElementsByClassName(actType)[0].classList.add('actv');
    }
</script>