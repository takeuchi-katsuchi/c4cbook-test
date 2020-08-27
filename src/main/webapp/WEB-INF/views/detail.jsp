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
        <div class="book_box">
            <div class="row book_img">
                <img class="javabook" src="resources/img/sample_book.jpg" alt="">
                <img class="material" src="resources/img/book.png" alt="">
                <img class="heart" src="resources/img/heart.jpeg" alt="">
            </div>
            <div class="row book_info">
                <div class="name">${detailForm.v_TopAndDetailDto.title}</div>
                <div class="author">${detailForm.v_TopAndDetailDto.author}</div>
                <c:choose>
                    <c:when
                        test="${empty detailForm.v_TopAndDetailDto.memName}">
                        <div class="recommended">貸出可能</div>
                    </c:when>
                    <c:otherwise>
                        <div class="recommended">${detailForm.v_TopAndDetailDto.memName}さんに貸出中</div>
                    </c:otherwise>
                </c:choose>
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
        <%--  <jsp:include page="./top-cell.jsp"></jsp:include> --%>
        <div class="contents">
            <a href="#" class="btn-rent">貸出し・予約</a>
            <button id="openLendingProcedureModal" type="button" class="btn btn-primary" data-toggle="modal" data-target="#LendingProcedureModal">
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
                    <input id="TAB-01" type="radio" name="TAB"
                        class="tab-switch" checked="checked" /><label
                        class="tab-label" for="TAB-01">貸出し履歴</label>
                    <div class="tab-content">
                        <c:choose>
                            <c:when
                                test="${empty detailForm.v_LendHistoryDtoList}">
                                <div class="recommended">貸出し履歴はありません。</div>
                            </c:when>

                            <c:otherwise>
                                <c:forEach items="${detailForm.v_LendHistoryDtoList}" var="lendHistory">
                                            <ul>
                                                <li>
                                                    <fmt:formatDate value="${lendHistory.fromDate}" pattern="yyyy/MM/dd" />
                                                    〜<fmt:formatDate value="${lendHistory.toDate}" pattern="yyyy/MM/dd" />
                                                    ${lendHistory.memName}
                                                </li>
                                            </ul>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <input id="TAB-02" type="radio" name="TAB"
                        class="tab-switch" /><label class="tab-label"
                        for="TAB-02">お気に入りしている人</label>
                    <div class="tab-content">
                        <c:choose>
                            <c:when
                                test="${empty detailForm.v_FavoriteMemberDtoList}">
                                <div class="recommended">お気に入りしている人はいません。</div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${detailForm.v_LendHistoryDtoList}" var="favoriteMember">
                                            <ul>
                                                <li>${favoriteMember.memName}</li>
                                            </ul>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <input id="TAB-03" type="radio" name="TAB" class="tab-switch" /><label class="tab-label" for="TAB-03">おすすめしている人</label>
                    <div class="tab-content">おすすめしている人はいません。</div>
                </div>
            </div>
        </div>
    </section>


    <!-- Modal -->
    <div  class="modal bd-example-modal-lg" id="LendingProcedureModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <h5 class="modal-title" id="myLargeModalLabel">貸出し・予約</h5>
                    <button type="button" class="close"
                        data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body">
                    <div id='calendar'></div>
                    <!-- 現在のLendStatus -->
                    <input id="getLendStatus" type="hidden" value="${detailForm.v_TopAndDetailDto.lendStatus}">

                    <c:choose>
                        <c:when
                            test="${empty detailForm.v_TopAndDetailDto.memName}">
                            <div class="recommended">貸出可能</div>
                        </c:when>
                        <c:otherwise>
                            <div class="recommended">${detailForm.v_TopAndDetailDto.memName}さんに貸出中</div>
                        </c:otherwise>
                    </c:choose>
                    <div class="mb-2 mt-2">
                        貸出：<input id="lendChkBox" type="checkbox">
                        予約：<input id="reserveChkBox" type="checkbox" checked="checked"><br>
                    </div>
                    <form id="lendReserveForm" action="">
                        貸出日：<input id="postFromDate" type="date" name="fromDate"> 返却日：<input id="postToDate" type="date" name="toDate">
                        <!-- BookId -->
                        <input id="postBookId" type="hidden" name="bookId" value="${detailForm.v_TopAndDetailDto.bookId}">
                        <!-- メンバーID -->
                        <input id="postMemberId" type="hidden" name="memId" value=1>
                        <!-- LendStatus -->
                        <input id="postLendStatus" type="hidden" name="lendStatus" value=10>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button id="save" type="button" class="btn btn-primary">Save changes</button>
                </div>

            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="resources/js/detail.js"></script>
</body>
</html>