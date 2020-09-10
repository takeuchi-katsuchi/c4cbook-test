<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<section class="request">
<c:forEach items="${topForm.topAndDetailDtoList}" var="topAndDetail">
 <div class="book_box">
  <div class="row book_img">
   <img class="javabook" src="resources/img/sample_book.jpg" alt="">
   <i class="fas fa-book-open fa-2x"></i>
   <i class="noread fas fa-book-open fa-2x"></i>
   <p class='book_count'>${topAndDetail.lendCount}</p>
   <i class="fas fa-heart fa-2x"></i>
   <i class="noheart fas fa-heart fa-2x"></i>
   <p class='heart_count'>${topAndDetail.favCount}</p>
  </div>
  <div class="row book_info">
   <div class="name">${topAndDetail.title}</div>
   <div class="author">${topAndDetail.author}</div>
   <div class="recommended">${topAndDetail.memId}に貸出中</div>
    <ul class="tag">
     <li>${topAndDetail.tagIds}</li>
    </ul>
  </div>

 </div>
 </c:forEach>
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