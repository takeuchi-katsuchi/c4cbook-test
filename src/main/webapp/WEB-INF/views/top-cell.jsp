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
  <div class="row book_img">
   <img src="resources/img/sample_book.jpg" alt="">
   <div class="book_sample">
    <img class="material" src="resources/img/book.png" alt="">
   </div>
  </div>
  <div class="row book_info">
   <p class="name">本のタイトル</p>
   <p class="author">東野圭吾</p>
   <p class="recommended">誰々に貸出中</p>
   <ul class="tag">
    <li>php</li>
    <li>php</li>
    <li>基本情報技術者試験</li>
   </ul>
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