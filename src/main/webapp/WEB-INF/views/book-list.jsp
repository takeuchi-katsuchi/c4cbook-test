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
 <c:url var="detailLink" value="/detail">
    <c:param name="bookId" value="${topAndDetail.bookId}" />
 </c:url>
 <div class="book_box">
  <div class="row book_img">
  <a href="${detailLink}"><img class="book-img" src="resources/img/sample_book.jpg" alt=""></a>
   <c:choose>
    <c:when test="${topForm.myLendedBookIdList.contains(topAndDetail.bookId)}">
      <%-- 読書済みの場合 --%>
      <i class="fas fa-book-open fa-2x"></i>
    </c:when>
    <c:otherwise>
      <%-- 読書済みでない場合 --%>
      <i class="noread fas fa-book fa-2x"></i>
    </c:otherwise>
   </c:choose>
   <p class='book_count'>${topAndDetail.lendCount}</p>

   <c:choose>
    <c:when test="${topForm.myFavoriteBookIdList.contains(topAndDetail.bookId)}">
      <%-- お気に入りしてる場合 --%>
      <i class="fas fa-heart fa-2x" name="fav" data-id="${topAndDetail.bookId}"></i>
    </c:when>
    <c:otherwise>
     <%-- お気に入りしていない場合 --%>
     <i class="noheart fas fa-heart fa-2x" name="fav" data-id="${topAndDetail.bookId}"></i>
    </c:otherwise>
   </c:choose>
   <p class='heart_count' data-id="${topAndDetail.bookId}">${topAndDetail.favCount}</p>
  </div>

  <div class="row book_info">
   <div class="name"><a href="${detailLink}">${topAndDetail.title}</a></div>
   <div class="author">${topAndDetail.author}</div>
   <c:choose>
  	<c:when test="${topAndDetail.memName != null}">
     <%-- 条件に当てはまる場合 --%>
     <div class="rent_disable">${topAndDetail.memName}に貸出中</div>
  	</c:when>
  	<c:otherwise>
     <%-- 上記すべての条件に当てはまらない場合 --%>
     <div class="rent_able">貸出可能です</div>
  	</c:otherwise>
   </c:choose>

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