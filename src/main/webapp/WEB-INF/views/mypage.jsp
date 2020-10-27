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
<link rel="stylesheet" href="resources/css/common.css" media="screen">
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="resources/css/menu.css" media="screen">
<link rel="stylesheet" href="resources/css/book-list.css" media="screen">
<link rel="stylesheet" href="resources/css/mypage.css" media="screen">
<link rel="stylesheet" href="resources/css/modal.css" media="screen">
</head>
<body>
  <jsp:include page="./header.jsp"><jsp:param
      name="act_type" value="farmer" /></jsp:include>
  <section class="bdy">
    <jsp:include page="./menu.jsp"></jsp:include>
    <div class="contents">
      <div class="title">マイページ</div>
      <div class="bk-cnt">
        いままで読んだ本…
        <p>${myForm.count}</p>
        冊
      </div>

      <div class="tab">
        <div class="tab-wrap">
          <input id="TAB-01" type="radio" name="TAB" class="tab-switch"
            checked="checked" /><label class="tab-label" for="TAB-01">予約・履歴</label>
          <div class="tab-content">
            <div class="col">
              <h4>予約中の本</h4>
              <c:choose>
                <%-- ログインユーザーが予約中の本がない場合 --%>
                <c:when test="${myForm.myResevedBookList.size() == 0}">
                  予約中の本はありません。
                </c:when>
                <%-- ログインユーザーが予約中の本がある場合 --%>
                <c:otherwise>
                  <c:forEach items="${myForm.myResevedBookList}"
                    var="myReserveBook">
                    <c:url var="detailLink" value="/detail">
                      <c:param name="bookId"
                        value="${myReserveBook.bookId}" />
                    </c:url>
                    <div class="book_box">
                      <div class="row book_img">
                        <a href="${detailLink}"><img
                          class="book-img"
                          src="resources/img/sample_book.jpg" alt=""></a>
                      </div>

                      <div class="row book_info">
                        <div class="name">
                          <a href="${detailLink}">${myReserveBook.title}</a>
                        </div>
                        <div class="author">${myReserveBook.author}</div>
                        <ul class="tag">
                          <li>${myReserveBook.tagIds}</li>
                        </ul>
                      </div>
                    </div>
                  </c:forEach>
                </c:otherwise>
              </c:choose>

              <hr style="border: 0; border-top: 1.5px solid lightgray;">
              <h4>あなたに貸出中の本</h4>
              <c:choose>
                <%-- ログインユーザーに貸出中の本がない場合 --%>
                <c:when test="${myForm.myLendingBookList.size() == 0}">
                  あなたに貸出中の本はありません。
                </c:when>
                <%-- ログインユーザーに貸出中の本がある場合 --%>
                <c:otherwise>
                  <c:forEach items="${myForm.myLendingBookList}"
                    var="myLendingBook">
                    <c:url var="detailLink" value="/detail">
                      <c:param name="bookId"
                        value="${myLendingBook.bookId}" />
                    </c:url>
                    <div class="book_box">
                      <div class="row book_img">
                        <a href="${detailLink}"><img
                          class="book-img"
                          src="resources/img/sample_book.jpg" alt=""></a>
                      </div>

                      <div class="row book_info">
                        <div class="name">
                          <a href="${detailLink}">${myLendingBook.title}</a>
                        </div>
                        <div class="author">${myLendingBook.author}</div>
                        <ul class="tag">
                          <li>${myLendingBook.tagIds}</li>
                        </ul>
                      </div>
                    </div>
                  </c:forEach>
                </c:otherwise>
              </c:choose>


              <hr style="border: 0; border-top: 1.5px solid lightgray;">
              <h4>いままでに読んだ本</h4>
              <c:choose>
                <%-- ログインユーザーが今までに読んだ本がない場合 --%>
                <c:when test="${myForm.myReturnedBookList.size() == 0}">
                  いままでに読んだ本はありません。
                </c:when>
                <%-- ログインユーザーが今までに読んだ本がある場合 --%>
                <c:otherwise>
                  <c:forEach items="${myForm.myReturnedBookList}"
                    var="myReturnedBook">
                    <c:url var="detailLink" value="/detail">
                      <c:param name="bookId"
                        value="${myReturnedBookList.bookId}" />
                    </c:url>
                    <div class="book_box">
                      <div class="row book_img">
                        <a href="${detailLink}"><img
                          class="book-img"
                          src="resources/img/sample_book.jpg" alt=""></a>
                      </div>

                      <div class="row book_info">
                        <div class="name">
                          <a href="${detailLink}">${myReturnedBook.title}</a>
                        </div>
                        <div class="author">${myReturnedBook.author}</div>
                        <ul class="tag">
                          <li>${myReturnedBook.tagIds}</li>
                        </ul>
                      </div>
                    </div>
                  </c:forEach>
                </c:otherwise>
              </c:choose>
            </div>
          </div>

          <input id="TAB-02" type="radio" name="TAB" class="tab-switch" /><label
            class="tab-label" for="TAB-02">おすすめ</label>
          <div class="tab-content">
            <div class="col">
              <c:choose>
                <%-- ログインユーザーに貸出中の本がない場合 --%>
                <c:when test="${myForm.recomToMeBookList.size() == 0}">
                  おすすめの本はありません。
                </c:when>
                <%-- ログインユーザーに貸出中の本がある場合 --%>
                <c:otherwise>
                  <c:forEach items="${myForm.recomToMeBookList}"
                    var="recomToMeBook">
                    <c:url var="detailLink" value="/detail">
                      <c:param name="bookId"
                        value="${recomToMeBook.bookId}" />
                    </c:url>
                    <div class="book_box">
                      <div class="row book_img">
                        <a href="${detailLink}"><img
                          class="book-img"
                          src="resources/img/sample_book.jpg" alt=""></a>
                      </div>

                      <div class="row book_info">
                        <div class="name">
                          <a href="${detailLink}">${recomToMeBook.title}</a>
                        </div>
                        <div class="author">${recomToMeBook.author}</div>
                        <ul class="tag">
                          <li>${recomToMeBook.tagIds}</li>
                        </ul>
                        おすすめしている人
                        <div>${recomToMeBook.memName}</div>
                      </div>
                    </div>
                  </c:forEach>
                </c:otherwise>
              </c:choose>
            </div>
          </div>
          <input id="TAB-03" type="radio" name="TAB" class="tab-switch" /><label
            class="tab-label" for="TAB-03">お気に入り</label>
          <div class="tab-content">
            <div class="col">
              <c:choose>
                <%-- ログインユーザーに貸出中の本がない場合 --%>
                <c:when test="${myForm.myFavoriteBookList.size() == 0}">
                  お気に入りの本はありません。
                </c:when>
                <%-- ログインユーザーに貸出中の本がある場合 --%>
                <c:otherwise>
                  <c:forEach items="${myForm.myFavoriteBookList}"
                    var="myFavoriteBook">
                    <c:url var="detailLink" value="/detail">
                      <c:param name="bookId"
                        value="${myFavoriteBook.bookId}" />
                    </c:url>
                    <div class="book_box">
                      <div class="row book_img">
                        <a href="${detailLink}"><img
                          class="book-img"
                          src="resources/img/sample_book.jpg" alt=""></a>
                      </div>

                      <div class="row book_info">
                        <div class="name">
                          <a href="${detailLink}">${myFavoriteBook.title}</a>
                        </div>
                        <div class="author">${myFavoriteBook.author}</div>
                        <ul class="tag">
                          <li>${myFavoriteBook.tagIds}</li>
                        </ul>
                      </div>
                    </div>
                  </c:forEach>
                </c:otherwise>
              </c:choose>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
    crossorigin="anonymous"></script>
</body>
</html>