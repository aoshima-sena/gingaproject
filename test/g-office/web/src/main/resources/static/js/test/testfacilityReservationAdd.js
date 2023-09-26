
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
	var text;
	for (var i = 9; i <= 21; i++) {
		if (i < 10) {
			text = "0" + i;
		} else {
			text = i;
		}
		select += "<option value = " + i + ">" + text + "</option>";
	}
	return select;
}

function getSelectTabEH() {
	let select;
	var text;
	for (var i = 9; i <= 21; i++) {
		if (i < 10) {
			text = "0" + i;
		} else {
			text = i;
		}
		select += "<option value = " + i + ">" + text + "</option>";
	}
	return select;
}

function getSelectTabSM() {
	let select;
	var text;
	for (var i = 0; i <= 45; i += 15) {
		if (i == 0) {
			text = "00";
		} else {
			text = i;
		}
		select += "<option value = " + i + ">" + text + "</option>";
	}
	return select;
}

function getSelectTabEM() {
	let select;
	var text;
	for (var i = 0; i <= 45; i += 15) {
		if (i == 0) {
			text = "00";
		} else {
			text = i;
		}
		select += "<option value = " + i + ">" + text + "</option>";
	}
	return select;
}
//validation
$(function() {
	$('.btn-animation-add').click(function() {
		//selectで選んだ数字
		var startHour = $('#startHour').val();
		var startMin = $('#startMin').val();
		var endHour = $('#endHour').val();
		var endMin = $('#endMin').val();
		//予約時間の日時
		var year = $('#year').val();
		var month = $('#month').val();
		var date = $('#date').val();
		year = Number(year);
		month = Number(month) + 1;
		date = Number(date);
		//今の時間,日付
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
		//int型も一応作る
		var intTodayHour = Number(todayHour);
		var intTodayMin = Number(todayMin);
		var intTodayYear = Number(todayYear);
		var intTodayMonth = Number(todayMonth);
		var intTodayDate = Number(todayMonth);
		var facilityId = $('#facilityId').val();
		facilityId = Number(facilityId);
		//0をつける
		if (startMin == 0) {
			startMin = startMin + "0";
		}
		if (endMin == 0) {
			endMin = endMin + "0";
		}
		if (todayMin == 0) {
			todayMin = todayMin + "0";
		}
		//9:00が900になる
		var tai1 = startHour + startMin;
		var tai2 = endHour + endMin;
		//int型にする
		var start = Number(tai1);
		var end = Number(tai2);
		var todayTai = todayHour + todayMin;
		var todayTime = Number(todayTai);
		var send_url = `/testfacilityreservation/add/remake/${facilityId}/${year}/${month}/${date}`;
		startHour = Number(startHour);
		if (todayHour == startHour) {
			console.log("OK");
		}
		var error = false;
		//予約時間の重複
		//過去の時間にしないように
		$.ajax({
			url: send_url,
			type: "GET",
			dataType: "JSON",
			async: false,
		}).done(function(data) {
			console.log(data);
			if (start >= end) {//ここの値違う
				$("#error").empty();
				var str = `<div class="system-mdg">終了時間は開始時間より未来に設定してください<div>`;
				$("#error").append(str);
				error = true;
				//過去に予約しようとしたとき
			} else if (year <= todayYear && month <= todayMonth && date <= todayDate) {
				$("#error").empty();
				if (start <=  todayTime) {
					$("#error").empty();
					var str = `<div class="system-msg">過去の日時に予約をすることはできません</div>`;
					$("#error").append(str);
					error = true;
				}
			} else {//予約時間の重複
				$("#error").empty();
				for (var i = 0; i < data.facilityReservationFormList.length; i++) {
					if (data.facilityReservationFormList[i].startTime != null) {
						var startlist = data.facilityReservationFormList[i].startTime;
						var endlist = data.facilityReservationFormList[i].endTime;
						startlist = new Date(startlist);
						endlist = new Date(endlist);
						console.log(startlist.getHours());
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
						//既存の予約時間 900 型にする
						var startlistTime = startlistHour + startlistMin;
						var endlistTime = endlistHour + endlistMin;
						endlistTime = Number(endlistTime);
						startlistTime = Number(startlistTime);
						if (startlistTime <= start && endlistTime >= end) {
							var str2 = `<div class="system-msg">予約時間に重複があります</div>`;
							$("#error").append(str2);
							error = true;
						}
					}
				}
			}
			/*error = true;*/
		}).fail(function() {
			alert("error");
		})
		if (error == true) {
			return false;
		}
	})
})