<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>要望画面</title>
 <link rel="stylesheet" href="resources/css/header.css" media="screen">
 <link rel="stylesheet" href="resources/css/request.css" media="screen">
 <link rel="stylesheet" href="resources/css/request-cell.css" media="screen">
 <link rel="stylesheet" href="resources/css/modal.css" media="screen">
 <script type="text/javascript" src="resources/js/request.js"></script>
 <script type="text/javascript" src="resources/js/_cmn.js"></script>
</head>
<body onload="requestOnload();">
 <jsp:include page="./header.jsp"><jsp:param name="act_type" value="farmer" /></jsp:include>
 <section class="bdy">
  <div class="contents">
  <div class="title">本の要望</div>
  <div class="text-message">応援しよう！！！！！！！</div>
  <a href="#" class="btn-rq">本を要望する</a>
   <section class="td-rq">
    <c:forEach items="${requestForm.reqInfoList}" varStatus="status" var="reqInfo">
     <div class="line">
      <div class="book_img_area">
       <img class="book-img" id="bookImg" src="resources/img/sample_book.jpg" alt="">
      </div>
      <div class="book_info">
       <div class="name"><c:out value="${reqInfo.title}"/></div>
       <div class="author"><c:out value="${reqInfo.author}"/></div>
      </div>
      <div class="requester_info">
       <div class="requester">要望者:<c:out value="${reqInfo.memName}"/></div>
       <div class="requestDate">要望日:<c:out value="2020/09/04"/></div>
      </div>
      <div class="cheer_img_area">
       <div class="cheer_count"><c:out value="${reqInfo.reqCount}"/></div>
       <img class="cheerImg" src="resources/img/cheering.png" alt="">
      </div>
      <div class="reason" id="reason_close">
       <div class="sub-ttl">要望理由</div>
       <div class="reason-text">
<%--        <c:out value="${reqInfo.comment}"/> --%>
        要望理由要望理由要望理由要望理由<BR>
        要望理由要望理由要望理由要望理由<BR>
        要望理由要望理由要望理由要望理由<BR>
        要望理由要望理由要望理由要望理由
       </div>
       <div class="readmore">
        <a href="#" class="readMoreBtn" onclick="readMoreReason(${status.index});return false;" >ReadMore...</a>
       </div>
      </div>
      <div class="rejected_img">
       <div class="">
        <img class="reject-arrow" src="resources/img/arrow_reject.png" alt="">
       </div>
      </div>
      <div class="reason_reject" id="reason_reject_close">
       <div class="sub-ttl">却下理由</div>
       <div class="reason-text">
        却下理由却下理由却下理由却下理由<BR>
        却下理由却下理由却下理由却下理由<BR>
        却下理由却下理由却下理由却下理由<BR>
        却下理由却下理由却下理由却下理由
       </div>
       <div class="readmore_reject">
        <a href="#" class="readMoreBtn_reject" onclick="readMoreRejectReason(${status.index});return false;" >ReadMore...</a>
       </div>
      </div>
     </div>
    </c:forEach>
   </section>
  </div>
 </section>
 <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<jsp:include page="./modal.jsp"></jsp:include>
</body>
</html>