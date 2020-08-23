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
<script type="text/javascript" src="resources/js/request.js"></script>
</head>
<body onload="testtest();">
 <jsp:include page="./header.jsp"><jsp:param name="act_type" value="farmer" /></jsp:include>
 <section class="bdy">
  <div class="contents">
   <div class="title">本の要望</div>
   <div class="text-message">応援しよう！！！！！！！</div>
   <a href="#" class="btn-rq">本を要望する</a>
   <section class="td-rq">
    <c:forEach var="i" begin="0" end="1" step="1">
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
		   <div class="readmore">
		   	<a href="#" class="readMoreBtn" onclick="readMoreReason(${i});" >ReadMore...</a>
		   </div>
		  </div>
		  <div class="rejected_img">
		  </div>
		  <div class="reason_reject" id="reason_reject_close">
		  却下理由却下理由却下理由却下理由<BR>
		  却下理由却下理由却下理由却下理由<BR>
		  却下理由却下理由却下理由却下理由<BR>
		  却下理由却下理由却下理由却下理由
		   <div class="readmore_reject">
		   	<a href="#" class="readMoreBtn_reject" onclick="readMoreRejectReason(${i});" >ReadMore...</a>
		   </div>
		  </div>
		 </div>
    </c:forEach>
   </section>
  </div>
 </section>
</body>
</html>