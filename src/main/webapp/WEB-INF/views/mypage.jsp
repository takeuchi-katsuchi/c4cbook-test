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
<title>マイページ画面</title>
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="resources/css/book-list.css" media="screen">
<link rel="stylesheet" href="resources/css/mypage.css" media="screen">
<link rel="stylesheet" href="resources/css/modal.css" media="screen">
</head>
<body>
 <jsp:include page="./header.jsp"><jsp:param name="act_type" value="farmer" /></jsp:include>
 <section class="bdy">
  <div class="contents">
   <div class="title">マイページ</div>
   <div class="bk-cnt">
    いままで読んだ本…
    <p>${myForm.count}</p>
    冊
   </div>

   <div class="tab">
    <div class="tab-wrap">
     <input id="TAB-01" type="radio" name="TAB" class="tab-switch" checked="checked" /><label class="tab-label" for="TAB-01">予約・履歴</label>
     <div class="tab-content">
      <div class="col">
        <jsp:include page="./book-list.jsp"></jsp:include>
      </div>
      <hr style="border: 0; border-top: 1.5px solid lightgray;">
      <div class="col">
       <img style="width: 130px; height: auto; float: left;" src="./sample_book.jpg" alt="">
       <div class="sub-contents">
        <jsp:include page="./book-list.jsp"></jsp:include>
       </div>
      </div>
     </div>
     <input id="TAB-02" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-02">おすすめ</label>
     <div class="tab-content">おすすめの本がありません。</div>
     <input id="TAB-03" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-03">お気に入り</label>
     <div class="tab-content">お気に入りの本がありません。</div>
    </div>
   </div>
  </div>
 </section>
 <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
 <jsp:include page="./modal.jsp"></jsp:include>
</body>
</html>