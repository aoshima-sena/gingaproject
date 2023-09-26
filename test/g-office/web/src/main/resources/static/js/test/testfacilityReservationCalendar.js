
const week = ["日", "月", "火", "水", "木", "金", "土"];
const today = new Date();
// 月末だとずれる可能性があるため、1日固定で取得
var showDate = new Date(today.getFullYear(), today.getMonth(), 1);
var facilityId = $('#facilityId').val();
//初期表示
$(function() {
	$(document).ready(function() {
		var yearList = getYearList(today);
		document.querySelector('#selectYear').innerHTML = yearList;
		var monthList = getMonthList(today);
		document.querySelector('#selectMonth').innerHTML = monthList;
		var selectYear = $('#selectYear').val();
		var selectMonth = $('#selectMonth').val();
		var url = `/testfacilityreservation/remake/${facilityId}/${selectYear}/${selectMonth}`;
		$.ajax({
			url: url,
			type: "GET",
			dateType: "JSON"
		}).done(function(data) {
			var calendar = createCalendar(selectYear, selectMonth, data);
			document.querySelector('.calendar-page').innerHTML = calendar;
		}).fail(function() {
			alert("error");
		})
	})
})
//select表示
$(function() {
	$('#selectYear,#selectMonth').change(function() {
		var facilityId = $('#facilityId').val();
		var selectYear = $('#selectYear').val();
		var selectMonth = $('#selectMonth').val();
		var send_url = `/testfacilityreservation/remake/${facilityId}/${selectYear}/${selectMonth}`;
		$.ajax({
			url: send_url,
			type: "GET",
			dataType: "JSON"
		}).done(function(data) {
			console.log("OK");
			console.log(send_url);
			var calendar = createCalendar(selectYear, selectMonth, data);
			document.querySelector('.calendar-page').innerHTML = calendar;
		})
	})

	$(".button").click(function() {
		var facilityId = $('#facilityId').val();
		var selectYear = $('#selectYear').val();
		var selectMonth = $('#selectMonth').val();
		var name = $(this).attr('name');
		selectMonth = Number(selectMonth);
		selectYear = Number(selectYear);
		switch (name) {
			case "before":
				if (selectMonth == 1) {
					selectMonth = 12;
					selectYear = selectYear - 1;
				} else {
					selectMonth = selectMonth - 1;
				}
				break;
			case "current":
				selectMonth = today.getMonth() + 1;
				selectYear = today.getFullYear();
				break;
			case "next":souken
			
				if (selectMonth == 12) {
					selectMonth = 1;
					selectYear = selectYear + 1;
				} else {
					selectMonth = selectMonth + 1;
				}
				break;
		}
		var send_url = `/testfacilityreservation/remake/${facilityId}/${selectYear}/${selectMonth}`;
		$.ajax({
			url: send_url,
			type: "GET",
			dataType: "JSON"
		}).done(function(data) {
			var yearList = getBottonYearList(selectYear);
			document.querySelector('#selectYear').innerHTML = yearList;
			var monthList = getBottonMonthList(selectMonth);
			document.querySelector('#selectMonth').innerHTML = monthList;
			var calendar = createCalendar(selectYear, selectMonth, data);
			document.querySelector('.calendar-page').innerHTML = calendar;
		})
	})
})

function createCalendar(year, month, data) {
	// 曜日
	month--;
	console.log(data);
	if (data.calendarMonthFormList != null) {
		length = data.calendarMonthFormList.length;
	}
	//スタート時間の配列
	var startArray = (() => {
		var sameMonth = [];
		for (var i = 0; i < length; i++) {
			var startYear = data.calendarMonthFormList[i].startYear;
			var startMonth = data.calendarMonthFormList[i].startMonth;
			if (year == startYear && month + 1 == startMonth) {
				sameMonth[i] = data.calendarMonthFormList[i].startTime;
			}
		}
		return sameMonth.filter(() => {
			if (sameMonth != null) {
				return sameMonth;
			}
		})
	})
	//終了時間の配列
	var endArray = (() => {
		var sameMonth = [];
		for (var i = 0; i < length; i++) {
			var endYear = data.calendarMonthFormList[i].endYear;
			var endMonth = data.calendarMonthFormList[i].endMonth;
			if (year == endYear && month + 1 == endMonth) {
				sameMonth[i] = data.calendarMonthFormList[i].endTime;
			}
		}
		return sameMonth.filter(() => {
			if (sameMonth != null) {
				return sameMonth
			}
		})
	})
	//終了日
	var endDay = (() => {
		var endArray = [];
		for (var i = 0; i < length; i++) {
			var endYear = data.calendarMonthFormList[i].endYear;
			var endMonth = data.calendarMonthFormList[i].endMonth;
			if (year == endYear && month + 1 == endMonth) {
				endArray[i] = data.calendarMonthFormList[i].endDate;
			}
		}
		return endArray.filter(() => {
			if (endArray != null) {
				return endArray;
			}
		})
	})
	var reservation = (() => {
		var reservationArray = [];
		for (var i = 0; i < length; i++) {
			var reser = data.calendarMonthFormList[i].reservationId;
			var endYear = data.calendarMonthFormList[i].endYear;
			var endMonth = data.calendarMonthFormList[i].endMonth;
			if (year == endYear && month + 1 == endMonth) {
				reservationArray[i] = data.calendarMonthFormList[i].reservationId;
			}
		}
		return reservationArray.filter(() => {
			if (reservationArray != null) {
				return reservationArray;
			}
		})
	})
	var calendar = "<table class='calendar-page' align='center'><tr>";
	for (var i = 0; i < week.length; i++) {
		if (i % 7 === 0) {
			calendar += "<th class='sunday'>" + week[i] + "</th>";
		} else if (i % 6 === 0) {
			calendar += "<th class='saturday'>" + week[i] + "</th>";
		} else {
			calendar += "<th >" + week[i] + "</th>";
		}
	}
	calendar += "</tr>";
	var count = 0;
	var startDayOfWeek = new Date(year, month, 1).getDay();
	var endDate = new Date(year, month + 1, 0).getDate();
	//var lastMonthEndDate = new Date(year, month, 0).getDate();
	var row = Math.ceil((startDayOfWeek + endDate) / week.length);
	// 1行ずつ設定
	for (var i = 0; i < row; i++) {
		calendar += "<tr>";
		// 1colum単位で設定
		for (var j = 0; j < week.length; j++) {
			if (i == 0 && j < startDayOfWeek) {
				// 1行目で1日まで先月の日付を設定
				calendar += "<td class='date'>" + "-" + "</td>";
			} else if (count >= endDate) {
				// 最終行で最終日以降、翌月の日付を設定
				count++;
				calendar += "<td class='date'>" + "-" + "</td>";
			} else {
				// 当月の日付を曜日に照らし合わせて設定
				count++;
				if (year == today.getFullYear()
					&& month == (today.getMonth())
					&& count < today.getDate()) {
					if (j % 7 == 0) {
						calendar += `<td class="sunday date">` + count;
						for (var l = 0; l < endDay().length; l++) {
							if (count == endDay()[l]) {
								var reservationId = reservation()[l];
								calendar += `<a href="/testfacilityreservation/detail/${reservationId}" class="addthree">` + startArray()[l] + `~` + endArray()[l] + `</a>`;
							}
						}
						calendar += `<p><a class="add"></a></p></td>`;
					} else if (j % 6 == 0) {
						calendar += `<td class="saturday date">` + count;
						for (var l = 0; l < endDay().length; l++) {
							if (count == endDay()[l]) {
								var reservationId = reservation()[l];
								calendar += `<a href="/testfacilityreservation/detail/${reservationId}" class="addthree">` + startArray()[l] + `~` + endArray()[l] + `</a>`;
							}
						}
						calendar += `<p><a class="add"></a></p></td>`;
					} else {
						calendar += `<td class="date">` + count;
						for (var l = 0; l < endDay().length; l++) {
							if (count == endDay()[l]) {
								var reservationId = reservation()[l];
								calendar += `<a href="/testfacilityreservation/detail/${reservationId}" class="addthree">` + startArray()[l] + `~` + endArray()[l] + `</a>`;
							}
						}
						calendar += `<p><a class="add"></a></p></td>`;
					}
				} else if (year >= today.getFullYear() && month >= today.getMonth() || year > today.getFullYear()) {
					//予約可能
					if (j % 7 == 0) {
						//hrefじゃないと使えない thymeleafが使えない  "/facilityreservation/add/${facilityId}/${yearParam}/${monthParam}/${count}"
						calendar += `<td class="sunday date">` + count;
						for (var l = 0; l < endDay().length; l++) {
							if (count == endDay()[l]) {
								var reservationId = reservation()[l];
								calendar += `<a href="/testfacilityreservation/detail/${reservationId}" class="addthree">` + startArray()[l] + `~` + endArray()[l] + `</a>`;
							}
						}
						calendar += `<p><a href="/testfacilityreservation/add/${facilityId}/${year}/${month}/${count}" class="add"><span>` + `+` + `</span></a></p></td>`;
					} else if (j % 6 == 0) {
						//例としてあげちゃう↓
						calendar += `<td class="saturday date">` + count;
						for (var l = 0; l < endDay().length; l++) {
							if (count == endDay()[l]) {
								var reservationId = reservation()[l];
								calendar += `<a href="/testfacilityreservation/detail/${reservationId}" class="addthree">` + startArray()[l] + `~` + endArray()[l] + `</a>`;
							}
						}
						calendar += `<p><a href="/testfacilityreservation/add/${facilityId}/${year}/${month}/${count}" class="add"><span>` + `+` + `</span></a></p></td>`;
					} else {
						calendar += `<td class="date">` + count
						for (var l = 0; l < endDay().length; l++) {
							if (count == endDay()[l]) {
								var reservationId = reservation()[l];
								calendar += `<a href="/testfacilityreservation/detail/${reservationId}" class="addthree">` + startArray()[l] + `~` + endArray()[l] + `</a>`;
							}
						}
						calendar += `<p><a href="/testfacilityreservation/add/${facilityId}/${year}/${month}/${count}" class="add"><span>` + `+` + `</span></a></p></td>`;
					}
				} else {
						if (j % 7 == 0) {
							calendar += `<td class="sunday date">` + count;
							for (var l = 0; l < endDay().length; l++) {
								if (count == endDay()[l]) {
									var reservationId = reservation()[l];
									calendar += `<a href="/testfacilityreservation/detail/${reservationId}" class="addthree">` + startArray()[l] + `~` + endArray()[l] + `</a>`;
								}
							}
							calendar += `<p><a class="add"></a></p></td>`;
						} else if (j % 6 == 0) {
							calendar += `<td class="saturday date">` + count;
							for (var l = 0; l < endDay().length; l++) {
								if (count == endDay()[l]) {
									var reservationId = reservation()[l];
									calendar += `<a href="/testfacilityreservation/detail/${reservationId}" class="addthree">` + startArray()[l] + `~` + endArray()[l] + `</a>`;
								}
							}
							calendar += `<p><a class="add"></a></p></td>`;
						} else {
							calendar += `<td class="date">` + count;
							for (var l = 0; l < endDay().length; l++) {
								if (count == endDay()[l]) {
									var reservationId = reservation()[l];
									calendar += `<a href="/testfacilityreservation/detail/${reservationId}" class="addthree">` + startArray()[l] + `~` + endArray()[l] + `</a>`;
								}
							}
							calendar += `<p><a class="add"></a></p></td>`;
						}
					}
				}
			}
			calendar += "</tr>";
		}
		return calendar += "</table>";
	}

	function getYearList(date) {
		let yearList;
		var year = date.getFullYear();
		var text;
		for (var i = year - 10; i <= year + 10; i++) {
			if (i === year) {
				text = i + "年";
				yearList += "<option value =" + i + " selected>" + text + "</option>";
			} else {
				text = i + "年";
				yearList += "<option value =" + i + ">" + text + "</option>";
			}
		}
		return yearList;
	}

	function getBottonYearList(selectYear) {
		let yearList;
		var year = today.getFullYear();
		selectYear = Number(selectYear);
		var text;
		for (var i = year - 10; i <= year + 10; i++) {
			if (i === selectYear) {
				text = i + "年";
				yearList += "<option value =" + i + " selected>" + selectYear + "年" + "</option>";
			} else {
				text = i + "年";
				yearList += "<option value =" + i + ">" + text + "</option>";
			}
		}
		return yearList;
	}

	//optionタグmonthの生成
	function getMonthList(date) {
		//const today = new Date();
		var month = date.getMonth() + 1;
		let monthList = "";
		var text;
		for (var i = 1; i <= 12; i++) {
			if (i === month) {
				text = i + "月";
				monthList += "<option value =" + i + " selected>" + text + "</option>";
			} else {
				text = i + "月";
				monthList += "<option value =" + i + ">" + text + "</option>";
			}
		}
		return monthList;
	}

	function getBottonMonthList(selectMonth) {
		//const today = new Date();
		var month = selectMonth;
		let monthList = "";
		var text;
		for (var i = 1; i <= 12; i++) {
			if (i === selectMonth) {
				text = i + "月";
				monthList += "<option value =" + i + " selected>" + text + "</option>";
			} else {
				text = i + "月";
				monthList += "<option value =" + i + ">" + text + "</option>";
			}
		}
		return monthList;
	}