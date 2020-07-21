<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>詳細画面</title>
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="resources/css/top-cell.css" media="screen">
<link rel="stylesheet" href="resources/css/detail.css" media="screen">
</head>
<body>
 <jsp:include page="./header.jsp"><jsp:param name="act_type" value="farmer" /></jsp:include>
 <section class="bdy">
  <jsp:include page="./top-cell.jsp"></jsp:include>
  <div class="contents">
   <a href="#" class="btn-rent">貸出し・予約</a>
   <p class="detal-text">本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明本の説明</p>
   <hr style="border: 0; border-top: 1.5px solid lightgray;">
   <div class="offer">
    <div class="mem">
     提供メンバーコメント:
     <p class="com">現場の経験が浅かったころ、先輩に勧められて購入した本です。</p>
    </div>
   </div>

   <div class="tab">
    <div class="tab-wrap">
     <input id="TAB-01" type="radio" name="TAB" class="tab-switch" checked="checked" /><label class="tab-label" for="TAB-01">貸出し履歴</label>
     <div class="tab-content">貸出し履歴はありません。</div>
     <input id="TAB-02" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-02">お気に入りしている人</label>
     <div class="tab-content">お気に入りしている人はいません。</div>
     <input id="TAB-03" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-03">おすすめしている人</label>
     <div class="tab-content">おすすめしている人はいません。</div>
    </div>
   </div>
  </div>
 </section>
</body>
</html>