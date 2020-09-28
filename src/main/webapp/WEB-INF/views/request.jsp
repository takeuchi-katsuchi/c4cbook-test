<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>要望画面</title>
 <link rel="stylesheet" href="resources/css/header.css" media="screen">
 <link rel="stylesheet" href="resources/css/request.css" media="screen">
 <script type="text/javascript" src="resources/js/_cmn.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body onload="requestOnload();">
 <jsp:include page="./header.jsp"><jsp:param name="act_type" value="farmer" /></jsp:include>
 <section class="bdy">
  <div class="contents">
  <div class="title">本の要望</div>
  <div class="text-message">応援しよう！！！！！！！</div>
  <a href="#" id="openLendingProcedureModal" class="btn-rq">本を要望する</a>
   <section class="td-rq">
    <c:forEach items="${requestForm.reqInfoList}" varStatus="status" var="reqInfo">
     <div class="line">
      <div class="line-book-info" <c:if test="${reqInfo.requestStatus == 9 }">id="end_pblctn"</c:if>>
       <div class="book_img_area">
        <img class="book-img" id="bookImg" src="resources/img/sample_book.jpg" alt="">
       </div>
       <div class="book_info">
        <div class="name"><c:out value="${reqInfo.title}"/></div>
        <div class="author"><c:out value="${reqInfo.author}"/></div>
       </div>
       <div class="requester_info">
        <div class="requester">要望者:<c:out value="${reqInfo.memName}"/></div>
        <div class="requestDate">要望日:<fmt:formatDate value="${reqInfo.createAt}" pattern="M月 d日" /></div>
       </div>
       <div class="cheer_img_area">
        <div class="cheer_count"><c:out value="${reqInfo.reqCount}"/></div>
        <img class="cheerImg" src="resources/img/cheering.png" alt="" onclick="cheerBook();">
       </div>
      </div>
      <div class="line-reasons">
       <div class="reason" id="reason_close">
        <div class="sub-title">要望理由</div>
        <div class="reason-text"><c:out value="${reqInfo.comment}"/></div>
        <div class="readmore">
         <a href="#" class="readMoreBtn" onclick="readMoreReason(${status.index});return false;" >ReadMore...</a>
        </div>
       </div>
       <c:if test="${reqInfo.requestStatus == 9 }">
       <div class="line-reason-reject">
        <div class="rejected_img">
          <img class="reject-arrow" src="resources/img/arrow_reject.png" alt="">
        </div>
        <div class="reason_reject" id="reason_reject_close">
         <div class="sub-title">却下理由</div>
         <div class="reason-text"><c:out value="${reqInfo.rejectComment}"/></div>
         <div class="readmore_reject">
          <a href="#" class="readMoreBtn_reject" onclick="readMoreRejectReason(${status.index});return false;" >ReadMore...</a>
         </div>
        </div>
       </div>
       </c:if>
      </div>
     </div>
    </c:forEach>
   </section>
  </div>
 </section>

 <!-- Modal -->
 <div  class="modal" id="LendingProcedureModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
   <div class="modal-content">

   <div class="modal-header">
    <h5 class="modal-title" id="myLargeModalLabel">本を要望する</h5>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
     <span aria-hidden="true">&times;</span>
    </button>
   </div>

   <div class="modal-body">
    <div>本の画像</div>
    <div class="reg-img">
     <input type="file" name="pic">
    </div>
    <div class="reg-book-info">
     <div>タイトル</div>
     <div><input type="text"></div>
     <div>著者</div>
     <div><input type="text"></div>
     <div>要望理由</div>
     <div><textarea class="reg-reason" id="textarea"></textarea></div>
    </div>
    <div class="reg-img"></div>
   </div>

   <div class="modal-footer">
    <button type="button" class="btn btn-secondary" data-dismiss="modal">閉じる</button>
    <button id="save" type="button" class="btn btn-primary" onclick="requestBook();">要望する</button>
   </div>

   </div>
  </div>
 </div><!-- END Modal -->

    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script type="text/javascript" src="resources/js/request.js"></script>

</body>
</html>