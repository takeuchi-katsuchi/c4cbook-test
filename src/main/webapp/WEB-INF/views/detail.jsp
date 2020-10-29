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
<title>C4C BOOK</title>
<link rel="stylesheet" href="resources/css/common.css" media="screen">
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="resources/css/menu.css" media="screen">
<link rel="stylesheet" href="resources/css/book-list.css" media="screen">
<link rel="stylesheet" href="resources/css/detail.css" media="screen">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">


<link href='resources/js/fullcalendar/core/main.css' rel='stylesheet' />
<link href='resources/js/fullcalendar/daygrid/main.css' rel='stylesheet' />
<script src='resources/js/fullcalendar/core/main.js'></script>
<script src='resources/js/fullcalendar/daygrid/main.js'></script>

<script>

</script>

</head>
<body>
    <jsp:include page="./header.jsp">
        <jsp:param name="act_type" value="farmer" />
    </jsp:include>
    <section class="bdy">
      <jsp:include page="./menu.jsp"></jsp:include>
        <div class="book_box">
            <div class="row book_img">
<!--                 <img class="javabook" src="resources/img/sample_book.jpg" alt="">
                <img class="material" src="resources/img/book.png" alt="">
                <img class="heart" src="resources/img/heart.jpeg" alt=""> -->
            </div>
            <div class="row book_info">
                <div class="name">${detailForm.v_TopAndDetailDto.title}</div>
                <div class="author">${detailForm.v_TopAndDetailDto.author}</div>
                <ul class="tag">
                    <li>ps</li>
                    <li>java</li>
                    <li>基本情報技術者試験</li>
                </ul>
            </div>
        </div>
        <ul>
            <li>読まれた回数：${detailForm.v_TopAndDetailDto.lendCount}</li>
            <li>お気に入り：${detailForm.v_TopAndDetailDto.favCount}</li>
        </ul>

        <div class="contents">
           <!--  <button class="btn-rent" type="button" class="btn btn-secondary" data-toggle="modal" data-target="#reviewModal">貸出し・予約</button> -->
            <button id="openLendingProcedureModal" type="button" class="btn btn-secondary">
                貸出し・予約
             </button>
            <p class="detal-text">${detailForm.v_TopAndDetailDto.outline}</p>
            <hr style="border: 0; border-top: 1.5px solid lightgray;">
            <div class="offer">
                <div class="mem">
                    提供メンバーコメント:
                    <p class="com">${detailForm.v_TopAndDetailDto.offerMemComment}</p>
                </div>
            </div>

            <div class="tab">
                <div class="tab-wrap">
                    <input id="TAB-01" type="radio" name="TAB" class="tab-switch" checked="checked" /><label class="tab-label" for="TAB-01">貸出し履歴</label>
                    <div class="tab-content">
                        <c:choose>
                            <c:when test="${empty detailForm.v_LendHistoryDtoList}">
                                <div>貸出し履歴はありません。</div>
                            </c:when>

                            <c:otherwise>
                            	<div class="container sticky_table_wrapper">
		                            	<table class="text-center table table-bordered sticky_table">
		                            		<thead>
			                            		<tr>
			                            			<th>貸出日</th>
			                            			<th>返却日</th>
			                            			<th>名前</th>
			                            		</tr>
		                            		</thead>
			                                <tbody>
				                                <c:forEach items="${detailForm.v_LendHistoryDtoList}" var="lendHistory">
			                            		<tr>
			                            			<td><fmt:formatDate value="${lendHistory.fromDate}" pattern="yyyy/MM/dd" /></td>
			                            			<td><fmt:formatDate value="${lendHistory.toDate}" pattern="yyyy/MM/dd" /></td>
			                            			<td>${lendHistory.memName}</td>
			                            		</tr>
				                                </c:forEach>
			                                </tbody>
		                            	</table>
	                            </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <input id="TAB-02" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-02">お気に入りしている人</label>
                    <div class="tab-content">
                        <c:choose>
                            <c:when
                                test="${empty detailForm.v_FavoriteMemberDtoList}">
                                <div>お気に入りしている人はいません。</div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${detailForm.v_FavoriteMemberDtoList}" var="favoriteMember">
                                            <ul>
                                                <li>${favoriteMember.memName}</li>
                                            </ul>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <input id="TAB-03" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-03">おすすめしている人</label>
                    <div class="tab-content">
                        <c:choose>
                            <c:when test="${empty detailForm.v_RecomMemDtoList}">
                                <div>おすすめしている人はいません。</div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${detailForm.v_RecomMemDtoList}" var="recomMember">
                                    <ul>
                                        <li>${recomMember.memName}</li>
                                    </ul>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
        <div class="detail-review">
          <div class="review-title">レビュー</div>
          <div id="review-list-more">
          <%--  あとで修正する --%>
          <%-- <c:forEach items="${detailForm.〇〇}" var="〇〇"> --%>
           <ul>
            <li>
            <div class="review-contents">説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。</div>
             <div class="reviewer">
              <span>2020/10/10</span>
              <span>中川愛華</span>
             </div>
            </li>
            <li>
             <div class="review-contents">説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。</div>
             <div class="reviewer">
              <span>2020/10/10</span>
              <span>中川愛華</span>
             </div>
            </li>
            <li>
             <div class="review-contents">説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。</div>
             <div class="reviewer">
              <span>2020/10/10</span>
              <span>中川愛華</span>
             </div>
            </li>
            <li>
             <div class="review-contents">説明が平易でわかりやすいです。説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。</div>
             <div class="reviewer">
              <span>2020/10/10</span>
              <span>中川愛華</span>
             </div>
            </li>
            <li>
             <div class="review-contents">説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。</div>
             <div class="reviewer">
              <span>2020/10/10</span>
              <span>中川愛華</span>
             </div>
            </li>
            <li>
             <div class="review-contents">説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。</div>
             <div class="reviewer">
              <span>2020/10/10</span>
              <span>中川愛華</span>
             </div>
            </li>
            <li>
             <div class="review-contents">説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。説明が平易でわかりやすいです。他のプログラミングスキルがそれほどなくても理解できるようになっています。おすすめです。</div>
             <div class="reviewer">
              <span>2020/10/10</span>
              <span>中川愛華</span>
             </div>
            </li>
           </ul>
           <div class="read-more" id="more-btn">その他のレビューを表示<i class="fa fa-chevron-down" aria-hidden="true"></i></div>
           <div class="read-more" id="close-btn">閉じる<i class="fa fa-chevron-up" aria-hidden="true"></i></div>
          </div>
        </div>
    </section>
    <jsp:include page="detailModal.jsp"></jsp:include>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="resources/js/detail.js"></script>
</body>
</html>