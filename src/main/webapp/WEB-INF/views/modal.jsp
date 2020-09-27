<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<div class="top_sort sort_modal">
	<div class="sort_title">トップ画面並び替え</div>
	<div class="sort_column latest_and_arrivalday">最新入荷日順</div>
	<div class="sort_column japanese_syllabary">五十音順</div>
	<div class="sort_column number_of_favorites">お気に入り数順</div>
	<div class="sort_column number_of_read">読まれた回数順</div>
</div>

<div class="mypage_sort sort_modal">
	<div class="sort_title">マイページ画面並び替え</div>
	<div class="sort_column latest_and_arrivalday">最新入荷日順</div>
	<div class="sort_column japanese_syllabary">五十音順</div>
	<div class="sort_column number_of_favorites">お気に入り数順</div>
	<div class="sort_column number_of_read">読まれた回数順</div>
</div>

<div class="request_sort sort_modal">
	<div class="sort_title">要望画面並び替え</div>
	<div class="sort_column latest_and_arrivalday">最新入荷日順</div>
	<div class="sort_column japanese_syllabary">五十音順</div>
	<div class="sort_column number_of_favorites">お気に入り数順</div>
	<div class="sort_column number_of_read">読まれた回数順</div>
</div>


<div class="top_filter filter_modal">
	<div class="filter_title">トップ画面タグ絞り込み</div>
	<div class="filter_column">
		<input type="checkbox" name="filter_column_name" id="filter_column1" />
		<label for="filter_column1">資格</label> <input type="checkbox"
			name="filter_column_name" id="filter_column2" /> <label
			for="filter_column2">入門書</label> <input type="checkbox"
			name="filter_column_name" id="filter_column3" /> <label
			for="filter_column3">web開発</label> <input type="checkbox"
			name="filter_column_name" id="filter_column4" /> <label
			for="filter_column4">自己啓発</label> <input type="checkbox"
			name="filter_column_name" id="filter_column5" /> <label
			for="filter_column5">娯楽・実用</label>
	</div>
	<div class="filter_title">条件絞り込み</div>
	<div class="filter_column">
		<input type="checkbox" name="filter_column_name" id="filter_column6" />
		<label for="filter_column6">おすすめ</label> <input type="checkbox"
			name="filter_column_name" id="filter_column7" /> <label
			for="filter_column7">お気に入り</label> <input type="checkbox"
			name="filter_column_name" id="filter_column8" /> <label
			for="filter_column8">読まれた回数</label> <input type="checkbox"
			name="filter_column_name" id="filter_column9" /> <label
			for="filter_column9">未読</label>
	</div>
	<div class="close">閉じる ✖︎</div>
</div>

<div class="mypage_filter filter_modal">
	<div class="filter_title">マイページ画面タグ絞り込み</div>
	<div class="filter_column">
		<input type="checkbox" name="filter_column_name" id="filter_column1" />
		<label for="filter_column1">資格</label> <input type="checkbox"
			name="filter_column_name" id="filter_column2" /> <label
			for="filter_column2">入門書</label> <input type="checkbox"
			name="filter_column_name" id="filter_column3" /> <label
			for="filter_column3">web開発</label> <input type="checkbox"
			name="filter_column_name" id="filter_column4" /> <label
			for="filter_column4">自己啓発</label> <input type="checkbox"
			name="filter_column_name" id="filter_column5" /> <label
			for="filter_column5">娯楽・実用</label>
	</div>
	<div class="filter_title">条件絞り込み</div>
	<div class="filter_column">
		<input type="checkbox" name="filter_column_name" id="filter_column6" />
		<label for="filter_column6">おすすめ</label> <input type="checkbox"
			name="filter_column_name" id="filter_column7" /> <label
			for="filter_column7">お気に入り</label> <input type="checkbox"
			name="filter_column_name" id="filter_column8" /> <label
			for="filter_column8">読まれた回数</label> <input type="checkbox"
			name="filter_column_name" id="filter_column9" /> <label
			for="filter_column9">未読</label>
	</div>
	<div class="close">閉じる ✖︎</div>
</div>

<div class="request_filter filter_modal">
	<div class="filter_title">要望画面タグ絞り込み</div>
	<div class="filter_column">
		<input type="checkbox" name="filter_column_name" id="filter_column1" />
		<label for="filter_column1">資格</label> <input type="checkbox"
			name="filter_column_name" id="filter_column2" /> <label
			for="filter_column2">入門書</label> <input type="checkbox"
			name="filter_column_name" id="filter_column3" /> <label
			for="filter_column3">web開発</label> <input type="checkbox"
			name="filter_column_name" id="filter_column4" /> <label
			for="filter_column4">自己啓発</label> <input type="checkbox"
			name="filter_column_name" id="filter_column5" /> <label
			for="filter_column5">娯楽・実用</label>
	</div>
	<div class="filter_title">条件絞り込み</div>
	<div class="filter_column">
		<input type="checkbox" name="filter_column_name" id="filter_column6" />
		<label for="filter_column6">おすすめ</label> <input type="checkbox"
			name="filter_column_name" id="filter_column7" /> <label
			for="filter_column7">お気に入り</label> <input type="checkbox"
			name="filter_column_name" id="filter_column8" /> <label
			for="filter_column8">読まれた回数</label> <input type="checkbox"
			name="filter_column_name" id="filter_column9" /> <label
			for="filter_column9">未読</label>
	</div>
	<div class="close">閉じる ✖︎</div>
</div>



<script>
	$('.opensort').click(function() {
		switch (location.pathname) {
		case "/c4cbook/top":
			$('.top_sort').fadeIn();
			break;
		case "/c4cbook/mypage":
			$('.mypage_sort').fadeIn();
			break;
		case "/c4cbook/request":
			$('.request_sort').fadeIn();
			break;
		}
	});

	$('.openfilter').click(function() {
		console.log(location.pathname)
		switch (location.pathname) {
		case "/c4cbook/top":
			$('.top_filter').fadeIn();
			break;
		case "/c4cbook/mypage":
			$('.mypage_filter').fadeIn();
			break;
		case "/c4cbook/request":
			$('.request_filter').fadeIn();
			break;
		}
	});

	$('.close').click(function() {
		$('.top_filter').fadeOut();
	});
</script>