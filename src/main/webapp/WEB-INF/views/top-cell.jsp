<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<section class="request">
 <div class="book_box">
  <div class="row book_img">
   <img class="javabook" src="resources/img/sample_book.jpg" alt="">
   <i class="fas fa-book-open fa-2x"></i> <i
    class="noread fas fa-book-open fa-2x"></i> <i
    class="fas fa-heart fa-2x"></i> <i
    class="noheart fas fa-heart fa-2x"></i>
  </div>
  <div class="row book_info">
   <div class="name">本のタイトル</div>
   <div class="author">東野圭吾</div>
   <div class="recommended">誰々に貸出中</div>
   <ul class="tag">
    <li>資格</li>
    <li>入門書</li>
    <li>web開発</li>
    <li>ビジネス</li>
    <li>娯楽・実用</li>
   </ul>
  </div>
 </div>
</section>
<%-- アクティブ処理 --%>
<input type="hidden" id="act_type"
 value="<%=request.getParameter("act_type")%>">
<script type="text/javascript">
    var actType = document.getElementById('act_type').value;
    if (actType != null && actType != '') {
        document.getElementsByClassName(actType)[0].classList.add('actv');
    }
</script>