<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<section class="bdy">
 <div class="line">
  <div class="row book_img">
   <img src="resources/img/sample_book.jpg" alt="">
  </div>
  <div class="row book_info">
   <p class="name">Java SE 8 Silver 問題集</p>
   <p class="author">志賀 澄人</p>
   <p class="requester">要望者:小針 元気</p>
  </div>
  <div class="row cheer_img">
   <div class="cheer_count">99+</div>
   <img src="resources/img/cheering.png" alt="">
  </div>
 </div>
 <div class="reason">
  <div class="text">要望理由</div>
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