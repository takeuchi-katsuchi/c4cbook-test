<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<c:forEach items="${topForm.topAndDetailDtoList}" var="book">
    <c:url var="detailLink" value="/detail">
        <c:param name="bookId" value="${book.bookId}" />
    </c:url>

    <section class="request">
        <div class="book_box">
            <div class="row book_img">
                <a href="${detailLink}"><img class="javabook" src="resources/img/sample_book.jpg" alt=""></a>
                <img class="material" src="resources/img/book.png" alt="">
                <img class="heart" src="resources/img/heart.jpeg" alt="">
                <c:out value="${book.bookImg}" />
            </div>
            <div class="row book_info">
                <div class="name">
                    <a href="${detailLink}">${book.title}</a>
                </div>
                <div class="author">${book.author}</div>
                <c:choose>
                    <c:when test="${empty book.memName}">
                        <div class="recommended">貸出可能</div>
                    </c:when>
                    <c:otherwise>
                        <div class="recommended">${book.memName}さんに貸出中</div>
                    </c:otherwise>
                </c:choose>
                <ul class="tag">
                <c:forEach items="${book.tagIds}" var="tag">
                    <li>タグ:${tag}</li>
                </c:forEach>
                </ul>
            </div>
        </div>
    </section>
    <ul>
        <li>読まれた回数：${book.lendCount}</li>
        <li>お気に入り：${book.favCount}</li>
    </ul>
</c:forEach>

<%-- アクティブ処理 --%>
<input type="hidden" id="act_type"
    value="<%=request.getParameter("act_type")%>">
<script type="text/javascript">
    var actType = document.getElementById('act_type').value;
    if (actType != null && actType != '') {
        document.getElementsByClassName(actType)[0].classList.add('actv');
    }
</script>