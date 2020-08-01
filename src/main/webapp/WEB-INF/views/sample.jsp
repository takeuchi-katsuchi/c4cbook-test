<!DOCTYPE html>
<?xml version="1.0" encoding="UTF-8"?>
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
<title>サンプル画面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="resources/css/sample.css" media="screen">
<script src="resources/js/sample.js"></script>
</head>
<body>
  <%-- ${変数名}で 画面から渡された値や、JSPの変数が使えます --%>
  <!-- Modelから取り出す場合はキー名 -->
  <%-- <h1>${message}</h1> --%>
  <!-- Formクラスから取り出す場合は、form名(小文字はじまり).変数名 -->
  <h1>メッセージは${sampleForm.message}</h1>
  <div>
    <!-- 値を送信したいときは、formで囲って、inputして、submitする -->
    <form:form action="sendMessage1" name="sendMessage1Form" method="post" enctype="multipart/form-data">
      <input type="text" name="message" value="">
      <input type="submit" value="メッセージを送る1">
    </form:form>
  </div>
  <div>
    <!-- javascriptからも送信できます -->
    <input type="text" id="t2" value="">
    <input type="button" value="メッセージを送る2" onclick="sendMessage2();">
    <div style="display: none;">
      <form:form action="sendMessage2" name="sendMessage2Form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="message" value="">
        <input type="submit" value="メッセージを送る">
      </form:form>
    </div>
  </div>
  <!-- top画面に遷移させるボタン -->
  <form:form action="top" method="post" enctype="multipart/form-data">
      <input type="submit" value="トップ画面へ">
   </form:form>
   <!-- mypage画面に遷移させるボタン -->
  <form:form action="mypage" method="post" enctype="multipart/form-data">
      <input type="submit" value="mypage画面へ">
   </form:form>
   <!-- 詳細画面に遷移させるボタン -->
  <form:form action="detail" method="post" enctype="multipart/form-data">
      <input type="submit" value="詳細画面へ">
   </form:form>
   <!-- 要望画面に遷移させるボタン -->
  <form:form action="request" method="post" enctype="multipart/form-data">
      <input type="submit" value="要望画面へ">
   </form:form>
</body>
</html>