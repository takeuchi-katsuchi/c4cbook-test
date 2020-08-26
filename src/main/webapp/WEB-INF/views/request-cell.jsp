<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<section class="request">
 <div class="line">
  <div class="book_img">
   <img class="bookImg" src="resources/img/sample_book.jpg" alt="">
  </div>
  <div class="book_info">
   <div class="name">Java SE 8 Silver 問題集</div>
   <div class="author">志賀 澄人</div>
   <div class="requester">要望者:小針 元気</div>
  </div>
  <div class="cheer_img">
   <div class="cheer_count">99+</div>
   <img src="resources/img/cheering.png" alt="">
  </div>
  <div class="reason" id="reason_close">
   要望理由要望理由要望理由要望理由<BR>
   要望理由要望理由要望理由要望理由<BR>
   要望理由要望理由要望理由要望理由<BR>
   要望理由要望理由要望理由要望理由
   <div class="readmore" id="readmore">
   	<a href="#" class="readMoreBtn" onclick="readMoreReason();" >ReadMore...</a>
   </div>
  </div>
  <div class="rejected_img">
  </div>
  <div class="rejected_reason">
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