/**
 *
 */

const week = ["日", "月", "火", "水", "木", "金", "土"];
const today = new Date();
// 月末だとずれる可能性があるため、1日固定で取得
var showDate = new Date(today.getFullYear(), today.getMonth(), 1);


//selectボタンを押してページを移動するときの処理
$(function() {

	$('#selectYear,#selectMonth').change(function() {

		var facilityId = $('#facilityId').val();
		var selectYear = $('#selectYear').val();
		var selectMonth = $('#selectMonth').val();
		console.log(selectYear);

		var send_url = `/facilityreservation/remake/${facilityId}/${selectYear}/${selectMonth}`;

		$.ajax({
			url: send_url,
			type: "GET",
			dataType: "JSON"
		}).done(function(data) {

			console.log(data);
			const today = new Date();
			var year = today.getFullYear();
			var lastYear = year - 10;
			var nextYear = year + 10;
			var list = [];
			for (var j = lastYear; j <= nextYear; j++) {
				list.push(j);
			}

			var currentYear = today.getFullYear();
			var currentMonth = today.getMonth();
			var selectYear = document.querySelector('[name="yearJump"]').selectedIndex;
			var selectMonth = document.querySelector('[name="monthJump"]').selectedIndex;


			for (var i = 0; i < list.length; i++) {
				if (i === selectYear) {
					currentYear = list[i];
				}

			}
			for (var i = 1; i <= 12; i++) {
				if (i === selectMonth) {
					currentMonth = i + 1;
				}
			}
			var calendar = createProcessAjax(currentYear, currentMonth - 1, data);
			document.querySelector('.calendar-page').innerHTML = calendar;
			var show = new Date(currentYear, currentMonth, 1);
			//	history.replaceState('', '', `/facilityreservation/remake/${facilityId}/${currentYear}/${currentMonth}`);
			/*show.setMonth(show.getMonth() - 1);
			showProcess(show);
*/
			var yee = today.getFullYear();
			let yearList;
			var lastYear = yee - 10;
			var nextYear = yee + 10;
			var text;
			for (var i = lastYear; i <= nextYear; i++) {
				if (i === currentYear) {

					text = i + "年";

					yearList += "<option value =";
					yearList += i;
					/*yearList += "currentYear =";
					yearList += i;*/
					yearList += "  selected>" + text + "</option>";
					yearList += "";

				} else {


					text = i + "年";

					yearList += "<option value =";
					yearList += i;
					yearList += " >" + text + "</option>";
					yearList += "";
				}

			}

			let monthList = "";
			var text;

			for (var i = 1; i <= 12; i++) {

				if (i === currentMonth) {
					text = i + "月";

					monthList += "<option value =";
					monthList += i;
					monthList += " selected>" + text + "</option>";

				} else {

					text = i + "月";

					monthList += "<option value =";
					monthList += i;
					monthList += ">" + text + "</option>";

				}

			}

			document.querySelector('#selectYear').innerHTML = yearList;
			document.querySelector('#selectMonth').innerHTML = monthList;



		})
	})
})


// 初期表示
window.onload = function() {
	showProcess(today, calendar);

}

$(function() {
	$('.btn-animation-02').click(function() {
		var facilityId = $('#facilityId').val();
		var year = $('#selectYear').val();
		var month = $('#selectMonth').val() - 1;

		var send_url = `/facilityreservation/remake/${facilityId}/${year}/${month}`;

		$.ajax({
			url: send_url,
			type: "GET",
			dataType: "JSON"
		}).done(function(data) {

			console.log(month);
			//		history.replaceState('', '', `/facilityreservation/remake/${facilityId}/${year}/${month}`);
			//month １プラスしたい
			var nextYe = Number(year);
			var ril = Number(month);
			var preMon = ril - 1;

			//optionのselectedの場所を変える

			var yee = today.getFullYear();
			let yearList;
			var lastYear = yee - 10;
			var nextYear = yee + 10;
			var text;
			for (var i = lastYear; i <= nextYear; i++) {
				//selectedの年で１月じゃないとき
				if (i === nextYe && ril !== 0) {

					text = i + "年";

					yearList += "<option value =";
					yearList += i;
					/*yearList += "nextYe =";
					yearList += i;*/
					yearList += "  selected>" + text + "</option>";
					yearList += "";
					//selectedの年で1月の時 去年の年にする
				} else if (i === nextYe && ril === 0) {
					var text = nextYe - 1;
					yearList += "<option value =";
					yearList += nextYe - 1;
					yearList += " selected>" + text + "年" + "</option>";
					yearList += "";
				} else {


					text = i + "年";

					yearList += "<option value =";
					yearList += i;
					yearList += " >" + text + "</option>";
					yearList += "";
				}

			}


			let monthList = "";
			var text;

			for (var i = 1; i <= 12; i++) {
				//selectedの値が一月の時12月にする
				if (i === 12 && ril === 0) {
					monthList += "<option value = ";
					monthList += 12;
					monthList += " selected>" + 12 + "月" + "</option>";
					monthList += "";
					//selectedの値で1月じゃないとき
				} else if (i === ril) {
					text = i + "月";

					monthList += "<option value =";
					monthList += i;
					monthList += " selected>" + text + "</option>";


				} else {

					text = i + "月";

					monthList += "<option value =";
					monthList += i;
					monthList += ">" + text + "</option>";

				}

			}

			document.querySelector('#selectYear').innerHTML = yearList;
			document.querySelector('#selectMonth').innerHTML = monthList;

			/*if(preMon == 0){
			preMon = 1;
			}*/
			var calendar = createProcessAjax(year, preMon, data);
			document.querySelector('.calendar-page').innerHTML = calendar;
		})
	})
})
$(function() {
	$('.btn-animation-menu').click(function() {

		var facilityId = $('#facilityId').val();
		var year = $('#selectYear').val();
		var month = $('#selectMonth').val();
		var ril = Number(month);
		ril++
		var send_url = `/facilityreservation/remake/${facilityId}/${year}/${ril}`;

		$.ajax({
			url: send_url,
			type: "GET",
			dataType: "JSON"
		}).done(function(data) {
			//		history.replaceState('', '', `/facilityreservation/remake/${facilityId}/${year}/${ril}`);
			console.log(data);
			//month １プラスしたい
			var nextYe = Number(year);

			var nextMon = ril;

			//optionのselectedの場所を変える

			var yee = today.getFullYear();
			let yearList;
			var lastYear = yee - 10;
			var nextYear = yee + 10;
			var text;
			for (var i = lastYear; i <= nextYear; i++) {

				if (i === nextYe && nextMon !== 13) {

					text = i + "年";

					yearList += "<option value =";
					yearList += i;
					/*yearList += "nextYe =";
					yearList += i;*/
					yearList += "  selected>" + text + "</option>";
					yearList += "";
					(nextMon === 12)
				} else if (i === nextYe && nextMon === 13) {
					var text = nextYe + 1;
					yearList += "<option value =";
					yearList += nextYe + 1;
					yearList += " selected>" + text + "年" + "</option>";
					yearList += "";


				} else {


					text = i + "年";

					yearList += "<option value =";
					yearList += i;
					yearList += " >" + text + "</option>";
					yearList += "";
				}

			}


			let monthList = "";
			var text;

			for (var i = 1; i <= 12; i++) {

				if (i === nextMon) {
					text = i + "月";

					monthList += "<option value =";
					monthList += i;
					monthList += " selected>" + text + "</option>";

					/*} else if (i === nextMon && nextMon === 13) {
						var te = (nextYe + 1) + "年";
						yearList += "<option value =";
						yearList += nextYe + 1;
						yearList += "selected>" + te + "</option>";
						yearList += "";


						monthList += "<option value=";
						monthList += i;
						monthList += ">" + text + "</option>";
			*/

				} else {

					text = i + "月";

					monthList += "<option value =";
					monthList += i;
					monthList += ">" + text + "</option>";


				}

			}

			document.querySelector('#selectYear').innerHTML = yearList;
			document.querySelector('#selectMonth').innerHTML = monthList;

			ril = ril - 1;
			var calendar = createProcessAjax(year, ril, data);
			document.querySelector('.calendar-page').innerHTML = calendar;
		})

	})
})
$(function() {
	$('.btn-animation-submit').click(function() {
		var facilityId = $('#facilityId').val();
		var year = today.getFullYear();
		var month = today.getMonth();
		console.log("year: " + year);
		month++
		var send_url = `/facilityreservation/remake/${facilityId}/${year}/${month}`;

		$.ajax({
			url: send_url,
			type: "GET",
			dateType: "JSON"
		}).done(function(data) {
			//	history.replaceState('', '', `/facilityreservation/remake/${facilityId}/${year}/${month}`);
			console.log(data);
			var yearList = getYearList();
			var monthList = getMonthList();
			document.querySelector('#selectYear').innerHTML = yearList;
			document.querySelector('#selectMonth').innerHTML = monthList;
			month = month - 1;
			var calendar = createProcessAjax(year, month, data);
			document.querySelector('.calendar-page').innerHTML = calendar;
		}).fail(function() {
			alert("error");
		})
	})
})

//optionタグyearの生成
function getYearList() {
	let yearList;
	const today = new Date();
	var year = today.getFullYear();
	var lastYear = year - 10;
	var nextYear = year + 10;
	var text;


	for (var i = lastYear; i <= nextYear; i++) {
		if (i === year) {

			text = i + "年";

			yearList += "<option value =";
			yearList += i;
			/*yearList += "year =";
			yearList += i;*/
			yearList += "selected>" + text + "</option>";
			yearList += "";

		} else {


			text = i + "年";

			yearList += "<option value =";
			yearList += i;
			yearList += " >" + text + "</option>";
			yearList += "";
		}

	}
	return yearList;

}

//optionタグmonthの生成
function getMonthList() {
	const today = new Date();
	var month = today.getMonth() + 1;

	let monthList = "";
	var text;
	for (var i = 1; i <= 12; i++) {

		if (i === month) {
			text = i + "月";

			monthList += "<option value =";
			monthList += i;
			/*	monthList += "month =";
				monthList += i;*/
			monthList += " selected>" + text + "</option>";

		} else {

			text = i + "月";

			monthList += "<option value =";
			monthList += i;
			monthList += ">" + text + "</option>";

		}

	}

	return monthList;

}


// カレンダー表示
function showProcess(date) {



	var year = date.getFullYear();
	var month = date.getMonth();

	/*document.querySelector('.year').innerHTML = year + "年 ";
	document.querySelector('.month').innerHTML = (month + 1) + "月";
*/

	var yearList = getYearList();
	var monthList = getMonthList();
	document.querySelector('#selectYear').innerHTML = yearList;
	document.querySelector('#selectMonth').innerHTML = monthList;


	var calendar = createProcess(year, month);
	document.querySelector('.calendar-page').innerHTML = calendar;
}




// カレンダー作成
function createProcess(year, month) {

	var facilityId = $('#facilityId').val();
	var yearParam = $('#selectYear').val();
	var monthParam = $('#selectMonth').val();
	// 曜日
	var calendar = "<table class='calendar-page' align='center'><tr>";
	for (var i = 0; i < week.length; i++) {
		if (i % 7 === 0) {
			calendar += "<th class='sunday' >" + week[i] + "</th>";
		} else if (i % 6 === 0) {
			calendar += "<th class='saturday'>" + week[i] + "</th>";
		} else {
			calendar += "<th>" + week[i] + "</th>";
		}
	}
	calendar += "</tr>";

	var count = 0;
	var startDayOfWeek = new Date(year, month, 1).getDay();
	var endDate = new Date(year, month + 1, 0).getDate();
	//	var lastMonthEndDate = new Date(year, month, 0).getDate();
	var row = Math.ceil((startDayOfWeek + endDate) / week.length);

	// 1行ずつ設定
	for (var i = 0; i < row; i++) {
		calendar += "<tr>";
		// 1colum単位で設定
		for (var j = 0; j < week.length; j++) {
			if (i == 0 && j < startDayOfWeek) {
				// 1行目で1日まで先月の日付を設定
				calendar += "<td  class='date'>" + "-" + "</td>";
			} else if (count >= endDate) {
				// 最終行で最終日以降、翌月の日付を設定
				count++;
				calendar += "<td  class='date'>" + "-" + "</td>";
			} else {
				// 当月の日付を曜日に照らし合わせて設定
				count++;
				if (year == today.getFullYear()
					&& month == (today.getMonth())
					&& count < today.getDate()) {
					if (j % 7 == 0) {
						calendar += "<td class='sunday date'>" + count + "<p><a class='add'></a></p></td>";
					} else if (j % 6 == 0) {
						calendar += "<td class='saturday date'>" + count + "<p><a class='add'></a></p></td>";
					} else {
						calendar += "<td  class='date'>" + count + "<p><a class='add'></a></p></td>";
					}
				} else if (year <= today.getFullYear() && month < (today.getMonth())) {
					if (j % 7 == 0) {
						calendar += "<td class='sunday date'>" + count + "<p><a class='add'></a></p></td>";
					} else if (j % 6 == 0) {
						calendar += "<td class='saturday date'>" + count + "<p><a class='add'></a></p></td>";
					} else {
						calendar += "<td  class='date'>" + count + "<p><a class='add'></a></p></td>";
					}

				} else {
					//予約可能
					if (j % 7 == 0) {
						//hrefじゃないと使えない thymeleafが使えない  "/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}"
						calendar += `<td class="sunday date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + `+` + `</span></a></p></td>`;
					} else if (j % 6 == 0) {
						//例としてあげちゃう↓
						calendar += `<td class="saturday date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + `+` + `</span></a></p></td>`;
					} else {
						calendar += `<td class="date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + `+` + `</span></a></p></td>`;
					}
				}
			}
		}
		calendar += "</tr>";
	}
	return calendar += "</table>";

}
//Ajax通信
$(function() {
	//使えそうなやつ
	//window.addEventListener('onLoad',function(){ 画面が表示された後にする処理 },true);
	$(document).ready(function() { //画面が表示された後にする処理 });
		//	$('#selectYear').change(function() {
		//	window.onload = (function(){
		//id = facilityIdのvalue
		var facilityId = $('#facilityId').val();

		//selectYearのoptionのvalue
		var yearParam = $('#selectYear').val();

		//selectMonthのoptionのvalue
		var monthParam = $('#selectMonth').val();

		//URL
		var send_url = `/facilityreservation/remake/${facilityId}/${yearParam}/${monthParam}`;
		console.log(send_url);

		$.ajax({
			url: send_url,
			type: "GET",
			dateType: "JSON"
		}).done(function(data) {
			//	$("#calendar").empty();
			//URLを下の表示にする
			//		history.replaceState('', '', `/facilityreservation/remake/${facilityId}/${yearParam}/${monthParam}`);
			console.log(data);
			var year = today.getFullYear();
			var month = today.getMonth();

			var yearList = getYearList();
			var monthList = getMonthList();
			document.querySelector('#selectYear').innerHTML = yearList;
			document.querySelector('#selectMonth').innerHTML = monthList;
			if (data.facilityReservationFormList != null) {

				var calendar = createProcessAjax(year, month, data);
				document.querySelector('.calendar-page').innerHTML = calendar;
			} else if (data.facilityReservationForm.facilityForm != null) {
				var calendar = createProcess(year, month);
				document.querySelector('.calendar-page').innerHTML = calendar;
			}


		}).fail(function() {
			alert("error");

		})
	})
})

//test

/**
 *
 */
function createProcessAjax(year, month, data) {
	console.log(year);
	console.log(month);

	// 曜日
	var calendar = "<table class='calendar-page' align='center'><tr>";
	for (var i = 0; i < week.length; i++) {
		if (i % 7 === 0) {
			calendar += "<th class='sunday' >" + week[i] + "</th>";
		} else if (i % 6 === 0) {
			calendar += "<th class='saturday'>" + week[i] + "</th>";
		} else {
			calendar += "<th>" + week[i] + "</th>";
		}
	}
	calendar += "</tr>";

	var count = 0;
	var startDayOfWeek = new Date(year, month, 1).getDay();
	var endDate = new Date(year, month + 1, 0).getDate();
	//	var lastMonthEndDate = new Date(year, month, 0).getDate();
	var row = Math.ceil((startDayOfWeek + endDate) / week.length);
	//リストの長さ取得
	var length = data.facilityReservationFormList.length;
	//selectの値
	var yearParam = $('#selectYear').val();
	var monthParam = $('#selectMonth').val();
	var faci = $('#facilityId').val();
	var facilityId = Number(faci);

	// 1行ずつ設定
	for (var i = 0; i < row; i++) {
		calendar += "<tr>";

		// 1colum単位で設定
		for (var j = 0; j < week.length; j++) {
			if (i == 0 && j < startDayOfWeek) {
				// 1行目で1日まで先月の日付を設定
				calendar += "<td  class='date'>" + "-" + "</td>";

			} else if (count >= endDate) {
				// 最終行で最終日以降、翌月の日付を設定
				count++;
				calendar += "<td  class='date'>" + "-" + "</td>";

			} else {
				// 当月の日付を曜日に照らし合わせて設定
				count++;

				//今月のカレンダー作成開始

				if (year <= today.getFullYear()
					&& month <= (today.getMonth())
					&& count < today.getDate()) {
					//今日より過去の時

					if (j % 7 == 0) {//日曜日の時
						for (var k = 0; k < length; k++) {
							//会議年月日
							var start = new Date(data.facilityReservationFormList[k].startTime);
							var startYear = start.getFullYear();
							var startMonth = start.getMonth() + 1;
							var startDate = start.getDate();
							var reservationId = data.facilityReservationFormList[k].reservationId;

							var time = start.getHours();
							var time2 = start.getMinutes();
							if (time2 < 10) {
								var meeting = (time + ":" + time2 + "0");
							} else {
								var meeting = (time + ":" + time2);
							}

							var endDay = new Date(data.facilityReservationFormList[k].endTime);
							//	console.log(endDay);
							var endtime = endDay.getHours();
							var endtime2 = endDay.getMinutes();
							if (endtime2 < 10) {
								var endmeeting = (endtime + ":" + endtime2 + "0");
							} else {
								var endmeeting = (endtime + ":" + endtime2);
							}

							//	console.log(meeting + "~" + endmeeting); // → 10: 00～12: 00
							var meet = (meeting + "~" + endmeeting);

							//年月日が一致していた場合
							if (startYear == yearParam && startMonth == monthParam && count == startDate) {
								calendar += `<td class="sunday date">` + count + `<a href="/facilityreservation/detail/${reservationId}" class="addthree">` + meet + `</a>` + `<p><a class="add"></a></p></td>`;
								for (var l = k + 1; l < length; l++) {
									//会議時間を複数入れたい、for文の続きをここで行う
									var start2 = new Date(data.facilityReservationFormList[l].startTime);
									var year2 = start2.getFullYear();
									var month2 = start2.getMonth() + 1;
									var day2 = start2.getDate();
									if (year2 == startYear && month2 == startMonth && day2 == startDate) {
										var time3 = start2.getHours();
										var time4 = start2.getMinutes();
										if (time4 < 10) {
											var meeting2 = (time3 + ":" + time4 + "0");
										} else {
											var meeting2 = (time3 + ":" + time4);
										}

										var endDay2 = new Date(data.facilityReservationFormList[l].endTime);
										var endTime3 = endDay2.getHours();
										var endTime4 = endDay2.getMinutes();
										if (endTime4 < 10) {
											var endMeeting2 = (endTime3 + ":" + endTime4 + "0");
										} else {
											var endMeeting2 = (endTime3 + ":" + endTime4);
										}
										var meet2 = (meeting2 + "~" + endMeeting2);
										var reservationID = data.facilityReservationFormList[l].reservationId;

										calendar += `<a href="/facilityreservation/detail/${reservationID}" class="addthree">` + meet2 + `</a>`;

									}
								}
								calendar += `<p><a class="add"></a></p></td>`;
								break;
							} else if (count != startDate && k == length - 1) {
								calendar += `<td class="sunday date">` + count + `<p><a class="add"></a></p></td>`;
								break;
							} else if (count == startDate && k == length - 1) {
								calendar += `<td class="sunday date">` + count + `<p><a class="add"></a></p></td>`;
								break;



							} else if (startYear != yearParam && startMonth != monthParam && count != startDate) {//年月日が一致していなかった場合（meetなし）

							}


						}

					} else if (j % 6 == 0) {//土曜日の時

						for (var k = 0; k < length; k++) {
							//会議年月日
							var start = new Date(data.facilityReservationFormList[k].startTime);
							var startYear = start.getFullYear();
							var startMonth = start.getMonth() + 1;
							var startDate = start.getDate();
							var reservationId = data.facilityReservationFormList[k].reservationId;

							var time = start.getHours();
							var time2 = start.getMinutes();
							if (time2 < 10) {
								var meeting = (time + ":" + time2 + "0");
							} else {
								var meeting = (time + ":" + time2);
							}

							var endDay = new Date(data.facilityReservationFormList[k].endTime);
							//	console.log(endDay);
							var endtime = endDay.getHours();
							var endtime2 = endDay.getMinutes();
							if (endtime2 < 10) {
								var endmeeting = (endtime + ":" + endtime2 + "0");
							} else {
								var endmeeting = (endtime + ":" + endtime2);
							}

							//	console.log(meeting + "~" + endmeeting); // → 10: 00～12: 00
							var meet = (meeting + "~" + endmeeting);


							//年月日が一致していた場合
							if (startYear == yearParam && startMonth == monthParam && count == startDate) {
								calendar += `<td class="saturday date">` + count + `<a href="/facilityreservation/detail/${reservationId}" class="addthree">` + meet + `</a>` + `<p><a class="add"></a></p></td>`;
								for (var l = k + 1; l < length; l++) {
									//会議時間を複数入れたい、for文の続きをここで行う
									var start2 = new Date(data.facilityReservationFormList[l].startTime);
									var year2 = start2.getFullYear();
									var month2 = start2.getMonth() + 1;
									var day2 = start2.getDate();
									if (year2 == startYear && month2 == startMonth && day2 == startDate) {
										var time3 = start2.getHours();
										var time4 = start2.getMinutes();
										if (time4 < 10) {
											var meeting2 = (time3 + ":" + time4 + "0");
										} else {
											var meeting2 = (time3 + ":" + time4);
										}

										var endDay2 = new Date(data.facilityReservationFormList[l].endTime);
										var endTime3 = endDay2.getHours();
										var endTime4 = endDay2.getMinutes();
										if (endTime4 < 10) {
											var endMeeting2 = (endTime3 + ":" + endTime4 + "0");
										} else {
											var endMeeting2 = (endTime3 + ":" + endTime4);
										}
										var meet2 = (meeting2 + "~" + endMeeting2);
										var reservationID = data.facilityReservationFormList[l].reservationId;

										calendar += `<a href="/facilityreservation/detail/${reservationID}" class="addthree">` + meet2 + `</a>`;

									}
								}
								calendar += `<p><a class="add"></a></p></td>`;
								break;

							} else if (count != startDate && k == length - 1) {
								calendar += `<td class="saturday date">` + count + `<p><a class="add"></a></p></td>`;
								break;
							} else if (count == startDate && k == length - 1) {
								calendar += `<td class="saturday date">` + count + `<p><a class="add"></a></p></td>`;
								break;

							} else if (startYear != yearParam && startMonth != monthParam && count != startDate) {//年月日が一致していなかった場合（meetなし）

							}


						}

					} else {//土日以外

						for (var k = 0; k < length; k++) {
							//会議年月日
							var start = new Date(data.facilityReservationFormList[k].startTime);
							var startYear = start.getFullYear();
							var startMonth = start.getMonth() + 1;
							var startDate = start.getDate();
							var reservationId = data.facilityReservationFormList[k].reservationId;

							var time = start.getHours();
							var time2 = start.getMinutes();
							if (time2 < 10) {
								var meeting = (time + ":" + time2 + "0");
							} else {
								var meeting = (time + ":" + time2);
							}

							var endDay = new Date(data.facilityReservationFormList[k].endTime);
							//	console.log(endDay);
							var endtime = endDay.getHours();
							var endtime2 = endDay.getMinutes();
							if (endtime2 < 10) {
								var endmeeting = (endtime + ":" + endtime2 + "0");
							} else {
								var endmeeting = (endtime + ":" + endtime2);
							}

							//	console.log(meeting + "~" + endmeeting); // → 10: 00～12: 00
							var meet = (meeting + "~" + endmeeting);



							//年月日が一致していた場合
							if (startYear == yearParam && startMonth == monthParam && count == startDate) {
								calendar += `<td class="date">` + count + `<a href="/facilityreservation/detail/${reservationId}" class="addthree">` + meet + `</a>`;

								for (var l = k + 1; l < length; l++) {
									//会議時間を複数入れたい、for文の続きをここで行う
									var start2 = new Date(data.facilityReservationFormList[l].startTime);
									var year2 = start2.getFullYear();
									var month2 = start2.getMonth() + 1;
									var day2 = start2.getDate();
									if (year2 == startYear && month2 == startMonth && day2 == startDate) {
										var time3 = start2.getHours();
										var time4 = start2.getMinutes();
										if (time4 < 10) {
											var meeting2 = (time3 + ":" + time4 + "0");
										} else {
											var meeting2 = (time3 + ":" + time4);
										}

										var endDay2 = new Date(data.facilityReservationFormList[l].endTime);
										var endTime3 = endDay2.getHours();
										var endTime4 = endDay2.getMinutes();
										if (endTime4 < 10) {
											var endMeeting2 = (endTime3 + ":" + endTime4 + "0");
										} else {
											var endMeeting2 = (endTime3 + ":" + endTime4);
										}
										var meet2 = (meeting2 + "~" + endMeeting2);
										var reservationID = data.facilityReservationFormList[l].reservationId;

										calendar += `<a href="/facilityreservation/detail/${reservationID}" class="addthree">` + meet2 + `</a>`;

									}
								}
								calendar += `<p><a class="add"></a></p></td>`;
								break;

							} else if (count != startDate && k == length - 1) {
								calendar += `<td class="date">` + count + `<p><a class="add"></a></p></td>`;
								break;
							} else if (count == startDate && k == length - 1) {
								calendar += `<td class="date">` + count + `<p><a class="add"></a></p></td>`;
								break;

							} else if (startYear != yearParam && startMonth != monthParam && count != startDate) {//年月日が一致していなかった場合（meetなし）

							}

						}

					}
				} else if (year < today.getFullYear() || year <= today.getFullYear() && month < today.getMonth()) {


					if (j % 7 == 0) {//日曜日の時
						for (var k = 0; k < length; k++) {
							//会議年月日
							var start = new Date(data.facilityReservationFormList[k].startTime);
							var startYear = start.getFullYear();
							var startMonth = start.getMonth() + 1;
							var startDate = start.getDate();
							var reservationId = data.facilityReservationFormList[k].reservationId;

							var time = start.getHours();
							var time2 = start.getMinutes();
							if (time2 < 10) {
								var meeting = (time + ":" + time2 + "0");
							} else {
								var meeting = (time + ":" + time2);
							}

							var endDay = new Date(data.facilityReservationFormList[k].endTime);
							//	console.log(endDay);
							var endtime = endDay.getHours();
							var endtime2 = endDay.getMinutes();
							if (endtime2 < 10) {
								var endmeeting = (endtime + ":" + endtime2 + "0");
							} else {
								var endmeeting = (endtime + ":" + endtime2);
							}

							//	console.log(meeting + "~" + endmeeting); // → 10: 00～12: 00
							var meet = (meeting + "~" + endmeeting);

							//年月日が一致していた場合
							if (startYear == yearParam && startMonth == monthParam && count == startDate) {
								calendar += `<td class="sunday date">` + count + `<a href="/facilityreservation/detail/${reservationId}" class="addthree">` + meet + `</a>` + `<p><a class="add"></a></p></td>`;
								for (var l = k + 1; l < length; l++) {
									//会議時間を複数入れたい、for文の続きをここで行う
									var start2 = new Date(data.facilityReservationFormList[l].startTime);
									var year2 = start2.getFullYear();
									var month2 = start2.getMonth() + 1;
									var day2 = start2.getDate();
									if (year2 == startYear && month2 == startMonth && day2 == startDate) {
										var time3 = start2.getHours();
										var time4 = start2.getMinutes();
										if (time4 < 10) {
											var meeting2 = (time3 + ":" + time4 + "0");
										} else {
											var meeting2 = (time3 + ":" + time4);
										}

										var endDay2 = new Date(data.facilityReservationFormList[l].endTime);
										var endTime3 = endDay2.getHours();
										var endTime4 = endDay2.getMinutes();
										if (endTime4 < 10) {
											var endMeeting2 = (endTime3 + ":" + endTime4 + "0");
										} else {
											var endMeeting2 = (endTime3 + ":" + endTime4);
										}
										var meet2 = (meeting2 + "~" + endMeeting2);
										var reservationID = data.facilityReservationFormList[l].reservationId;

										calendar += `<a href="/facilityreservation/detail/${reservationID}" class="addthree">` + meet2 + `</a>`;

									}
								}
								calendar += `<p><a class="add"></a></p></td>`;
								break;
							} else if (count != startDate && k == length - 1) {
								calendar += `<td class="sunday date">` + count + `<p><a class="add"></a></p></td>`;
								break;
							} else if (count == startDate && k == length - 1) {
								calendar += `<td class="sunday date">` + count + `<p><a class="add"></a></p></td>`;
								break;

							} else if (startYear != yearParam && startMonth != monthParam && count != startDate) {//年月日が一致していなかった場合（meetなし）

							}

						}

					} else if (j % 6 == 0) {//土曜日の時

						for (var k = 0; k < length; k++) {
							//会議年月日
							var start = new Date(data.facilityReservationFormList[k].startTime);
							var startYear = start.getFullYear();
							var startMonth = start.getMonth() + 1;
							var startDate = start.getDate();
							var reservationId = data.facilityReservationFormList[k].reservationId;

							var time = start.getHours();
							var time2 = start.getMinutes();
							if (time2 < 10) {
								var meeting = (time + ":" + time2 + "0");
							} else {
								var meeting = (time + ":" + time2);
							}

							var endDay = new Date(data.facilityReservationFormList[k].endTime);
							//	console.log(endDay);
							var endtime = endDay.getHours();
							var endtime2 = endDay.getMinutes();
							if (endtime2 < 10) {
								var endmeeting = (endtime + ":" + endtime2 + "0");
							} else {
								var endmeeting = (endtime + ":" + endtime2);
							}

							//	console.log(meeting + "~" + endmeeting); // → 10: 00～12: 00
							var meet = (meeting + "~" + endmeeting);


							//年月日が一致していた場合
							if (startYear == yearParam && startMonth == monthParam && count == startDate) {
								calendar += `<td class="saturday date">` + count + `<a href="/facilityreservation/detail/${reservationId}" class="addthree">` + meet + `</a>` + `<p><a class="add"></a></p></td>`;
								for (var l = k + 1; l < length; l++) {
									//会議時間を複数入れたい、for文の続きをここで行う
									var start2 = new Date(data.facilityReservationFormList[l].startTime);
									var year2 = start2.getFullYear();
									var month2 = start2.getMonth() + 1;
									var day2 = start2.getDate();
									if (year2 == startYear && month2 == startMonth && day2 == startDate) {
										var time3 = start2.getHours();
										var time4 = start2.getMinutes();
										if (time4 < 10) {
											var meeting2 = (time3 + ":" + time4 + "0");
										} else {
											var meeting2 = (time3 + ":" + time4);
										}

										var endDay2 = new Date(data.facilityReservationFormList[l].endTime);
										var endTime3 = endDay2.getHours();
										var endTime4 = endDay2.getMinutes();
										if (endTime4 < 10) {
											var endMeeting2 = (endTime3 + ":" + endTime4 + "0");
										} else {
											var endMeeting2 = (endTime3 + ":" + endTime4);
										}
										var meet2 = (meeting2 + "~" + endMeeting2);
										var reservationID = data.facilityReservationFormList[l].reservationId;

										calendar += `<a href="/facilityreservation/detail/${reservationID}" class="addthree">` + meet2 + `</a>`;

									}
								}
								calendar += `<p><a class="add"></a></p></td>`;
								break;
							} else if (count != startDate && k == length - 1) {
								calendar += `<td class="saturday date">` + count + `<p><a class="add"></a></p></td>`;
								break;
							} else if (count == startDate && k == length - 1) {
								calendar += `<td class="saturday date">` + count + `<p><a class="add"></a></p></td>`;
								break;

							} else if (startYear != yearParam && startMonth != monthParam && count != startDate) {//年月日が一致していなかった場合（meetなし）

							}

						}

					} else {//土日以外

						for (var k = 0; k < length; k++) {
							//会議年月日
							var start = new Date(data.facilityReservationFormList[k].startTime);
							var startYear = start.getFullYear();
							var startMonth = start.getMonth() + 1;
							var startDate = start.getDate();
							var reservationId = data.facilityReservationFormList[k].reservationId;

							var time = start.getHours();
							var time2 = start.getMinutes();
							if (time2 < 10) {
								var meeting = (time + ":" + time2 + "0");
							} else {
								var meeting = (time + ":" + time2);
							}

							var endDay = new Date(data.facilityReservationFormList[k].endTime);
							//	console.log(endDay);
							var endtime = endDay.getHours();
							var endtime2 = endDay.getMinutes();
							if (endtime2 < 10) {
								var endmeeting = (endtime + ":" + endtime2 + "0");
							} else {
								var endmeeting = (endtime + ":" + endtime2);
							}

							//	console.log(meeting + "~" + endmeeting); // → 10: 00～12: 00
							var meet = (meeting + "~" + endmeeting);



							//年月日が一致していた場合
							if (startYear == yearParam && startMonth == monthParam && count == startDate) {
								calendar += `<td class="date">` + count + `<a href="/facilityreservation/detail/${reservationId}" class="addthree">` + meet + `</a>`;

								for (var l = k + 1; l < length; l++) {
									//会議時間を複数入れたい、for文の続きをここで行う
									var start2 = new Date(data.facilityReservationFormList[l].startTime);
									var year2 = start2.getFullYear();
									var month2 = start2.getMonth() + 1;
									var day2 = start2.getDate();
									if (year2 == startYear && month2 == startMonth && day2 == startDate) {
										var time3 = start2.getHours();
										var time4 = start2.getMinutes();
										if (time4 < 10) {
											var meeting2 = (time3 + ":" + time4 + "0");
										} else {
											var meeting2 = (time3 + ":" + time4);
										}

										var endDay2 = new Date(data.facilityReservationFormList[l].endTime);
										var endTime3 = endDay2.getHours();
										var endTime4 = endDay2.getMinutes();
										if (endTime4 < 10) {
											var endMeeting2 = (endTime3 + ":" + endTime4 + "0");
										} else {
											var endMeeting2 = (endTime3 + ":" + endTime4);
										}
										var meet2 = (meeting2 + "~" + endMeeting2);
										var reservationID = data.facilityReservationFormList[l].reservationId;

										calendar += `<a href="/facilityreservation/detail/${reservationID}" class="addthree">` + meet2 + `</a>`;

									}
								}
								calendar += `<p><a class="add"></a></p></td>`;
								break;

							} else if (count != startDate && k == length - 1) {
								calendar += `<td class="date">` + count + `<p><a class="add"></a></p></td>`;
								break;
							} else if (count == startDate && k == length - 1) {
								calendar += `<td class="date">` + count + `<p><a class="add"></a></p></td>`;
								break;

							} else if (startYear != yearParam && startMonth != monthParam && count != startDate) {//年月日が一致していなかった場合（meetなし）

							}
						}

					}


					//予約可能↓

				} else {//今日以降の未来（addとか必要）
					if (j % 7 == 0) {//日曜日
						var tmp = [];
						for (var k = 0; k < length; k++) {
							//会議年月日
							var start = new Date(data.facilityReservationFormList[k].startTime);
							var startYear = start.getFullYear();
							var startMonth = start.getMonth() + 1;
							var startDate = start.getDate();
							var reservationId = data.facilityReservationFormList[k].reservationId;

							var time = start.getHours();
							var time2 = start.getMinutes();
							if (time2 < 10) {
								var meeting = (time + ":" + time2 + "0");
							} else {
								var meeting = (time + ":" + time2);
							}

							var endDay = new Date(data.facilityReservationFormList[k].endTime);
							//	console.log(endDay);
							var endtime = endDay.getHours();
							var endtime2 = endDay.getMinutes();
							if (endtime2 < 10) {
								var endmeeting = (endtime + ":" + endtime2 + "0");
							} else {
								var endmeeting = (endtime + ":" + endtime2);
							}

							//	console.log(meeting + "~" + endmeeting); // → 10: 00～12: 00
							var meet = (meeting + "~" + endmeeting);

							//年月日が一致していた場合
							if (startYear == yearParam && startMonth == monthParam && count == startDate) {

								calendar += `<td  class="sunday date" >` + count + `<a href="/facilityreservation/detail/${reservationId}" class="addthree">` + meet + `</a>`;

								//会議時間のcookie

								tmp[k] += "meet " + k + "= " + meet + ";";
								document.cookie = tmp[k] + `path = /facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}`;

								for (var l = k + 1; l < length; l++) {
									//会議時間を複数入れたい、for文の続きをここで行う
									var start2 = new Date(data.facilityReservationFormList[l].startTime);
									var year2 = start2.getFullYear();
									var month2 = start2.getMonth() + 1;
									var day2 = start2.getDate();
									if (year2 == startYear && month2 == startMonth && day2 == startDate) {
										var time3 = start2.getHours();
										var time4 = start2.getMinutes();
										if (time4 < 10) {
											var meeting2 = (time3 + ":" + time4 + "0");
										} else {
											var meeting2 = (time3 + ":" + time4);
										}

										var endDay2 = new Date(data.facilityReservationFormList[l].endTime);
										var endTime3 = endDay2.getHours();
										var endTime4 = endDay2.getMinutes();
										if (endTime4 < 10) {
											var endMeeting2 = (endTime3 + ":" + endTime4 + "0");
										} else {
											var endMeeting2 = (endTime3 + ":" + endTime4);
										}
										var meet2 = (meeting2 + "~" + endMeeting2);
										var reservationID = data.facilityReservationFormList[l].reservationId;

										calendar += `<a href="/facilityreservation/detail/${reservationID}" class="addthree">` + meet2 + `</a>`;

										tmp[k] += "meet" + l + " =" + meet2 + ";";



										document.cookie += tmp[k] + `path = /facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}`;


									}

								}
								calendar += `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
								break;

								/*} else if (startYear != yearParam && startMonth != monthParam && count != startDate && k == length - 1) {

									calendar += `<td class="sunday date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
									break;*/

							} else if (count != startDate && k == length - 1) {
								calendar += `<td class="sunday date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;

								break;
							} else if (count == startDate && k == length - 1) {
								calendar += `<td class="sunday date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
								break;
							} else {

							}
						}

					} else if (j % 6 == 0) {//土曜日
						var tmp = [];
						for (var k = 0; k < length; k++) {
							//会議年月日
							var start = new Date(data.facilityReservationFormList[k].startTime);
							var startYear = start.getFullYear();
							var startMonth = start.getMonth() + 1;
							var startDate = start.getDate();
							var reservationId = data.facilityReservationFormList[k].reservationId;

							var time = start.getHours();
							var time2 = start.getMinutes();
							if (time2 < 10) {
								var meeting = (time + ":" + time2 + "0");
							} else {
								var meeting = (time + ":" + time2);
							}

							var endDay = new Date(data.facilityReservationFormList[k].endTime);
							//	console.log(endDay);
							var endtime = endDay.getHours();
							var endtime2 = endDay.getMinutes();
							if (endtime2 < 10) {
								var endmeeting = (endtime + ":" + endtime2 + "0");
							} else {
								var endmeeting = (endtime + ":" + endtime2);
							}

							//	console.log(meeting + "~" + endmeeting); // → 10: 00～12: 00
							var meet = (meeting + "~" + endmeeting);

							//年月日が一致していた場合
							if (startYear == yearParam && startMonth == monthParam && count == startDate) {

								calendar += `<td  class="saturday date" >` + count + `<a href="/facilityreservation/detail/${reservationId}" class="addthree">` + meet + `</a>`;

								//会議時間のcookie

								tmp[k] += "meet " + k + "= " + meet + ";";
								document.cookie = tmp[k] + `path = /facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}`;

								for (var l = k + 1; l < length; l++) {
									//会議時間を複数入れたい、for文の続きをここで行う
									var start2 = new Date(data.facilityReservationFormList[l].startTime);
									var year2 = start2.getFullYear();
									var month2 = start2.getMonth() + 1;
									var day2 = start2.getDate();
									if (year2 == startYear && month2 == startMonth && day2 == startDate) {
										var time3 = start2.getHours();
										var time4 = start2.getMinutes();
										if (time4 < 10) {
											var meeting2 = (time3 + ":" + time4 + "0");
										} else {
											var meeting2 = (time3 + ":" + time4);
										}

										var endDay2 = new Date(data.facilityReservationFormList[l].endTime);
										var endTime3 = endDay2.getHours();
										var endTime4 = endDay2.getMinutes();
										if (endTime4 < 10) {
											var endMeeting2 = (endTime3 + ":" + endTime4 + "0");
										} else {
											var endMeeting2 = (endTime3 + ":" + endTime4);
										}
										var meet2 = (meeting2 + "~" + endMeeting2);
										var reservationID = data.facilityReservationFormList[l].reservationId;

										calendar += `<a href="/facilityreservation/detail/${reservationID}" class="addthree">` + meet2 + `</a>`;

										tmp[k] += "meet" + l + " =" + meet2 + ";";

										document.cookie += tmp[k] + `path = /facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}`;

									}

								}
								calendar += `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
								break;

								/*} else if (startYear != yearParam && startMonth != monthParam && count != startDate && k == length - 1) {

									calendar += `<td class="saturday date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
									break;*/

							} else if (count != startDate & k == length - 1) {
								calendar += `<td class="saturday date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
								break;
							} else if (count == startDate && k == length - 1) {
								calendar += `<td class="saturday date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
								break;

							} else {


							}
						}

					} else {//土日以外

						var tmp = [];
						for (var k = 0; k < length; k++) {
							//会議年月日
							var start = new Date(data.facilityReservationFormList[k].startTime);
							var startYear = start.getFullYear();
							var startMonth = start.getMonth() + 1;
							var startDate = start.getDate();
							var reservationId = data.facilityReservationFormList[k].reservationId;

							var time = start.getHours();
							var time2 = start.getMinutes();
							if (time2 < 10) {
								var meeting = (time + ":" + time2 + "0");
							} else {
								var meeting = (time + ":" + time2);
							}

							var endDay = new Date(data.facilityReservationFormList[k].endTime);
							//	console.log(endDay);
							var endtime = endDay.getHours();
							var endtime2 = endDay.getMinutes();
							if (endtime2 < 10) {
								var endmeeting = (endtime + ":" + endtime2 + "0");
							} else {
								var endmeeting = (endtime + ":" + endtime2);
							}

							//	console.log(meeting + "~" + endmeeting); // → 10: 00～12: 00
							var meet = (meeting + "~" + endmeeting);

							//年月日が一致していた場合
							if (startYear == yearParam && startMonth == monthParam && count == startDate) {

								calendar += `<td  class="date" >` + count + `<a href="/facilityreservation/detail/${reservationId}" class="addthree">` + meet + `</a>`;

								//会議時間のcookie

								tmp[k] += "meet " + k + "= " + meet + ";";
								document.cookie = tmp[k] + `path = /facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}`;

								for (var l = k + 1; l < length; l++) {
									//会議時間を複数入れたい、for文の続きをここで行う
									var start2 = new Date(data.facilityReservationFormList[l].startTime);
									var year2 = start2.getFullYear();
									var month2 = start2.getMonth() + 1;
									var day2 = start2.getDate();

									if (year2 == startYear && month2 == startMonth && day2 == startDate) {
										var time3 = start2.getHours();
										var time4 = start2.getMinutes();
										if (time4 < 10) {
											var meeting2 = (time3 + ":" + time4 + "0");
										} else {
											var meeting2 = (time3 + ":" + time4);
										}

										var endDay2 = new Date(data.facilityReservationFormList[l].endTime);
										var endTime3 = endDay2.getHours();
										var endTime4 = endDay2.getMinutes();
										if (endTime4 < 10) {
											var endMeeting2 = (endTime3 + ":" + endTime4 + "0");
										} else {
											var endMeeting2 = (endTime3 + ":" + endTime4);
										}
										var meet2 = (meeting2 + "~" + endMeeting2);
										var reservationID = data.facilityReservationFormList[l].reservationId;

										calendar += `<a href="/facilityreservation/detail/${reservationID}" class="addthree">` + meet2 + `</a>`;

										tmp[k] += "meet" + l + " =" + meet2 + ";";

										document.cookie += tmp[k] + `path = /facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}`;

									}

								}
								calendar += `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
								break;

							} else if (startYear != yearParam && startMonth != monthParam && count != startDate && k == length - 1) {

								calendar += `<td class="date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
								break;
							} else if (count != startDate && k == length - 1) {
								calendar += `<td class="date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
								break;
							} else if (count == startDate && k == length - 1) {
								calendar += `<td class="date">` + count + `<p><a href="/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}" class="add"><span>` + "+" + `</span></a></p></td>`;
								break;

							} else {

							}
						}


					}
				}

			}
		}
		calendar += "</tr>";
	}//一行終わり、また次の行へ

	//カレンダー終わり、return で返す
	return calendar;
}
