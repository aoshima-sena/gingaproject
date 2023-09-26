
window.onload = function() {
	var selectTabSH = getSelectTabSH();
	document.querySelector('#startHour').innerHTML = selectTabSH;
	var selectTabEH = getSelectTabEH();
	document.querySelector('#endHour').innerHTML = selectTabEH;
	var selectTabSM = getSelectTabSM();
	document.querySelector('#startMin').innerHTML = selectTabSM;
	var selectTabEM = getSelectTabEM();
	document.querySelector('#endMin').innerHTML = selectTabEM;
}
function getSelectTabSH() {
	let select;
	var startTime = $('#startTime').val();
	var sta = startTime.substring(0, 2);
	var st = Number(sta);
	var text;
	for (var i = 9; i <= 21; i++) {
		if (i < 10) {
			text = "0" + i;
		} else {
			text = i;
		}
		if (i == st) {
			select += "<option value = ";
			select += i;
			select += " selected>" + text + "</option>";
		} else {
			select += "<option value = ";
			select += i;
			select += ">" + text + "</option>";
		}
	}
	return select;
}

function getSelectTabEH() {
	var select;
	var endTime = $('#endTime').val();
	var ed = endTime.substring(0, 2);
	var end = Number(ed);
	console.log(end)
	console.log(ed);
	var text;
	for (var i = 9; i <= 21; i++) {
		if (i < 10) {
			text = "0" + i;
		} else {
			text = i;
		}
		if (i == end) {
			select += "<option value = ";
			select += i;
			select += " selected>" + text + "</option>";
		} else {
			select += "<option value = ";
			select += i;
			select += "> " + text + "</option> ";
		}
	}
	return select;
}

function getSelectTabSM() {
	let select;
	var startTime = $('#startTime').val();
	var sta = startTime.substring(3, 5);
	var st = Number(sta);
	console.log(st);
	//var st = Number(sta);
	var text;
	for (var i = 0; i <= 45; i += 15) {
		if (i == 0) {
			text = "00";
		} else {
			text = i
		}
		if (st == i) {
			select += "<option value = " + i + " selected>" + text + "</option>";
		} else {
			select += "<option value=" + i + ">" + text + "</option>";
		}
	}
	return select;
}

function getSelectTabEM() {
	let select;
	var endTime = $('#endTime').val();
	var end = endTime.substring(3, 5);
	var ed = Number(end);
	//var st = Number(sta);
	var text;
	for (var i = 0; i <= 45; i += 15) {
		if (i == 0) {
			text = "00";
		} else {
			text = i
		}
		if (ed == i) {
			select += "<option value = " + i + " selected>" + text + "</option>";
		} else {
			select += "<option value=" + i + ">" + text + "</option>";
		}
	}
	return select;
}
$(function() {
	$('.btn-animation-update').click(function() {
		var startHour = $('#startHour').val();
		var startMin = $('#startMin').val();
		var endHour = $('#endHour').val();
		var endMin = $('#endMin').val();
		var year = $('#startYear').val();
		var month = $('#startMonth').val();
		var date = $('#startDate').val();
		year = Number(year);
		month = Number(month);
		date = Number(date);
		var today = new Date();
		var todayHour = today.getHours();
		var todayMin = today.getMinutes();
		var todayYear = today.getFullYear();
		var todayMonth = today.getMonth() + 1;
		var todayDate = today.getDate();
		todayHour = String(todayHour);
		todayMin = String(todayMin);
		todayYear = String(todayYear);
		todayMonth = String(todayMonth);
		todayDate = String(todayDate);
		if (startMin == 0) {
			startMin = startMin + "0";
		}
		if (endMin == 0) {
			endMin = endMin + "0";
		}
		if (todayMin == 0) {
			todayMin = todayMin + "0";
		}
		var start = startHour + startMin;
		var end = endHour + endMin;
		start = Number(start);
		end = Number(end);
		var todayTime = todayHour + todayMin;
		todayTime = Number(todayTime);
		console.log(start);
		var reservationId = $('#reservationId').val();
		var send_url = `/testfacilityreservation/detail/remake/${reservationId}`;
		var error = false;
		$.ajax({
			url: send_url,
			type: "GET",
			dataType: "JSON",
			async: false
		}).done(function(data) {
			console.log(data);
			if (start >= end) {
				$("#error").empty();
				var str = `<div class="system-mdg">終了時間は開始時間より未来に設定してください<div>`;
				$("#error").append(str);
				error = true;
				//過去に予約しようとしたとき(今日)
			} else if (year <= todayYear && month <= todayMonth && date <= todayDate) {
				$("#error").empty();
				if (start <= todayTime) {
					$("#error").empty();
					var str = `<div class="system-msg">過去の日時に予約をすることはできません</div>`;
					$("#error").append(str);
					error = true;
				}//過去に予約しようとしたとき(今日以外)↴
				if (year <= todayYear && month <= todayMonth && date < todayDate) {
					$("#error").empty();
					var str = `<div class="system-msg">過去の日時に予約をすることはできません</div>`;
					$("#error").append(str);
					error = true;
				}
			} else {//予約時間の重複
				$("#error").empty();
				console.log(data.facilityReservationFormList.length);
				//	var length = data.facilityReservationFormList.length();
				for (var i = 0; i < data.facilityReservationFormList.length; i++) {
					if (data.facilityReservationFormList[i].startTime != null) {
						var startlist = data.facilityReservationFormList[i].startTime;
						var endlist = data.facilityReservationFormList[i].endTime;
						startlist = new Date(startlist);
						endlist = new Date(endlist);
						var startlistYear = startlist.getFullYear();
						var startlistMonth = startlist.getMonth();
						var startlistDate = startlist.getDate();
						if (startlistYear == year && startlistMonth + 1 == month && startlistDate == date) {
							var startlistHour = startlist.getHours();
							var startlistMin = startlist.getMinutes();
							var endlistHour = endlist.getHours();
							var endlistMin = endlist.getMinutes();
							if (startlistMin == 0) {
								startlistMin = startlistMin + "0";
							}
							if (endlistMin == 0) {
								endlistMin = endlistMin + "0";
							}
							var startlistTime = startlistHour + startlistMin;
							var endlistTime = endlistHour + endlistMin;
							startlistTime = Number(startlistTime);
							endlistTime = Number(endlistTime);
							if (startlistTime >= start && endlistTime <= end) {
								$("#error").empty();
								var str2 = `<div class="system-msg">予約時間に重複があります</div>`;
								$("#error").append(str2);
								error = true;
							}
						}
					}
				}
			}
		}).fail(function() {
			alert("error");
		})
		if (error == true) {
			return false;
		}
	})
	$('.btn-animation-delete').click(function() {//削除できてしまう
		//エラー判定
		var error = false;
		//selectで選んだ時間の取得
		var startHour = $('#startHour').val();
		var startMin = $('#startMin').val();
		var endHour = $('#endHour').val();
		var endMin = $('#endMin').val();
		if (startMin == 0) {
			startMin = startMin + "0";
		}
		if (endMin == 0) {
			endMin = endMin + "0";
		}
		var start = startHour + startMin;
		var end = endHour + endMin;
		var reservationId = $('#reservationId').val();
		var send_url = `/testfacilityreservation/detail/remake/${reservationId}`;
		$.ajax({
			url: send_url,
			type: "GET",
			dataType: "JSON",
			async: false
		}).done(function(data) {
			console.log(data);
			var length = data.facilityReservationFormList.length;
			for (var i = 0; i < length; i++) {
				var reservationData = data.facilityReservationFormList[i].reservationId;
				if (reservationData == reservationId) {
					var startlist = data.facilityReservationFormList[i].startTime;
					var endlist = data.facilityReservationFormList[i].endTime;
					startlist = new Date(startlist);
					endlist = new Date(endlist);
					var startlistHour = startlist.getHours();
					var startlistMin = startlist.getMinutes();
					var endlistHour = endlist.getHours();
					var endlistMin = endlist.getMinutes();
					if (startlistMin == 0) {
						startlistMin = startlistMin + "0";
					}
					if (endlistMin == 0) {
						endlistMin = endlistMin + "0";
					}
					var startlistTime = startlistHour + startlistMin;
					var endlistTime = endlistHour + endlistMin;
					startlistTime = Number(startlistTime);
					endlistTime = Number(endlistTime);
					if (startlistTime != start || endlistTime != end) {
						error = true;
						$("#error").empty();
						var str2 = `<div class="system-msg">削除する場合は予約時間を変えないでください</div>`;
						$("#error").append(str2);
						break;
					}
				}
			}
		})
		if (error == true) {
			return false;
		}
	})
})