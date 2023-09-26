$(function() {

	$('.btn-animation-update').click(function(e) {
		//エラー判定
		var error = false;

		//selectで選んだ時間の取得
		var startreHour = document.getElementById("startHour").value;
		var startreMin = document.getElementById("startMin").value;
		var endreHour = document.getElementById("endHour").value;
		var endreMin = document.getElementById("endMin").value;

		//00表記にしたい
		endreMin = String(endreMin);
		startreHour = String(startreHour);
		endreHour = String(endreHour);
		startreMin = String(startreMin);

		if (startreMin == "0") {
			startreMin += "0";
		}

		if (endreMin == "0") {
			endreMin += "0";
		}

		//selectで指定された時間を1300（仮）表記にする
		var realResult1 = startreHour + startreMin;
		var realResult2 = endreHour + endreMin;
		//	console.log(realResult1);
		//	console.log(realResult2);

		//selectで指定した年月日を取得する
		var year = document.getElementById("year").value;
		var month = document.getElementById("month").value;
		var date = document.getElementById("date").value;
		//	return false;

		//URLを取得
		var reservationId = document.getElementById("reservationId").value;
		//	console.log(reservationId);
		var send_url = `/facilityreservation/detail/remake/${reservationId}`;

		$.ajax({
			url: send_url,
			type: "GET",
			dateType: "JSON",
			async: false
		}).done(function(data) {
			$("#error").empty();

			var anyYear = [];
			var anyMonth = [];
			var anyDate = [];
			var endHour = [];
			var endMin = [];
			var startHour = [];
			var startMin = [];
			//	console.log(reservationId);

			//予約時間を過去にしないようにする
			var today = new Date();
			//	console.log(today);
			var todayHour = today.getHours();
			var todayMin = today.getMinutes();
			todayHour = String(todayHour);
			todayMin = String(todayMin);
			var todayYear = today.getFullYear();
			var todayMonth = today.getMonth() + 1;
			var todayday = today.getDate();



			if (year <= todayYear && month <= todayMonth && date <= todayday) {

				if (todayMin == "0") {
					todayMin += "0";
				}
				var todayResult = todayHour + todayMin;
				//		console.log(todayResult);
				if (realResult1 <= todayResult) {
					var str2 = `<div class="system-msg">過去の日時に予約をすることはできません</div>`;
					$("#error").append(str2);
					error = true;


				} else if (year <= todayYear && month <= todayMonth && date < todayday) {
					var str2 = `<div class="system-msg">過去の日時に予約をすることはできません</div>`;
					$("#error").append(str2);
					error = true;

				}
			} else {

			}
realResult1 = Number(realResult1);
realResult2 = Number(realResult2);

			if (realResult1 >= realResult2) {
				var str1 = `<div class="system-msg">終了時間は開始時間より未来に設定してください</div>`;
				$("#error").append(str1);
				error = true;
				//	return false;

			} else {

				for (var i = 0; i < data.facilityReservationFormList.length; i++) {



					var reservation = data.facilityReservationFormList[i].reservationId;
					//				console.log(reservation);
					//				console.log(reservationId);

					//13:00~14:00だった場合
					if (reservationId == reservation) {
						var ss = data.facilityReservationFormList[i].startTime;
						var ee = data.facilityReservationFormList[i].endTime;
						//					console.log(ss);
						//					console.log(ee);
						var sstt = new Date(ss);
						var eett = new Date(ee);
						var ssHour = sstt.getHours();
						var ssMin = sstt.getMinutes();
						var eeHour = eett.getHours();
						var eeMin = eett.getMinutes();
						ssHour = String(ssHour);
						ssMin = String(ssMin);
						eeHour = String(eeHour);
						eeMin = String(eeMin);
						if (ssMin == "0") {
							ssMin += "0";
						}

						if (eeMin == "0") {
							eeMin += "0";
						}


						var ssResult = ssHour + ssMin;
						var eeResult = eeHour + eeMin;

						if (ssHour == startreHour && ssMin == startreMin && eeHour == endreHour && eeMin == endreMin) {
							error = true;

							var str2 = `<div class="system-msg">予約時間が変更されていません</div>`;
							$("#error").append(str2);
							break;

						}
					} else if (reservationId != reservation) {//reservationIdが一致せず予約時間の変更がされている

						//予約時間がかぶった場合
						var start = data.facilityReservationFormList[i].startTime;

						var st = new Date(start);
						var startYear = st.getFullYear();
						var startMonth = st.getMonth() + 1;
						var startDate = st.getDate();
						anyYear[i] = startYear;
						anyMonth[i] = startMonth;
						anyDate[i] = startDate;


						if (anyYear[i] == year && anyMonth[i] == month && anyDate[i] == date) {
							var end = data.facilityReservationFormList[i].endTime;
							var ed = new Date(end);

							startHour[i] = st.getHours();
							startMin[i] = st.getMinutes();
							endHour[i] = ed.getHours();
							endMin[i] = ed.getMinutes();
							//	console.log(startHour[i]);
							//	console.log(startMin[i]);
							var moji1 = String(startHour[i]);
							var moji2 = String(startMin[i]);
							if (moji2 == "0") {
								moji2 += "0";
							}

							var moji3 = String(endHour[i]);
							var moji4 = String(endMin[i]);
							if (moji4 == "0") {
								moji4 += "0";
							}
							var result1 = moji1 + moji2;
							var result2 = moji3 + moji4;
							//					console.log(result1);
							//					console.log(result2);
							result1 = Number(result1);
							result2 = Number(result2);
							realResult1 = Number(realResult1);
							realResult2 = Number(realResult2);

							//文字型だからじゃね？
							if (result1 <= realResult2 && result2 >= realResult1) {
								//途中
								error = true;

								var str2 = `<div class="system-msg">予約時間に重複があります</div>`;
								$("#error").append(str2);

								break;
							}
						}

					}

				}//for文の終わり
			}
			//error = true;
		})


		if (error == true) {
			return false;
		}
	})

	$('.btn-animation-delete').click(function(e) {
		console.log("aho");
		//エラー判定
		var error = false;
		//selectで選んだ時間の取得
		var startreHour = document.getElementById("startHour").value;
		var startreMin = document.getElementById("startMin").value;
		var endreHour = document.getElementById("endHour").value;
		var endreMin = document.getElementById("endMin").value;
		//00表記にしたい
		endreMin = String(endreMin);
		startreHour = String(startreHour);
		endreHour = String(endreHour);
		startreMin = String(startreMin);
		if (startreMin == "0") {
			startreMin += "0";
		}
		if (endreMin == "0") {
			endreMin += "0";
		}
		//selectで指定された時間を1300（仮）表記にする
		var realResult1 = startreHour + startreMin;
		var realResult2 = endreHour + endreMin;
		//	console.log(realResult1);
		//	console.log(realResult2);
		//selectで指定した年月日を取得する
		var year = document.getElementById("year").value;
		var month = document.getElementById("month").value;
		var date = document.getElementById("date").value;
		//	return false;

		//URLを取得
		var reservationId = document.getElementById("reservationId").value;
		//	console.log(reservationId);
		var send_url = `/facilityreservation/detail/remake/${reservationId}`;

		$.ajax({
			url: send_url,
			type: "GET",
			dateType: "JSON",
			async: false
		}).done(function(data) {
			$("#error").empty();
			for (var i = 0; i < data.facilityReservationFormList.length; i++) {
				var reservation = data.facilityReservationFormList[i].reservationId;
				//		console.log(reservation);
				//		console.log(reservationId);

				//13:00~14:00だった場合
				if (reservationId == reservation) {
					var ss = data.facilityReservationFormList[i].startTime;
					var ee = data.facilityReservationFormList[i].endTime;
					//			console.log(ss);
					//			console.log(ee);
					var sstt = new Date(ss);
					var eett = new Date(ee);
					var ssHour = sstt.getHours();
					var ssMin = sstt.getMinutes();
					var eeHour = eett.getHours();
					var eeMin = eett.getMinutes();
					ssHour = String(ssHour);
					ssMin = String(ssMin);
					eeHour = String(eeHour);
					eeMin = String(eeMin);
					if (ssMin == "0") {
						ssMin += "0";
					}

					if (eeMin == "0") {
						eeMin += "0";
					}



					if (ssHour == startreHour && ssMin == startreMin && eeHour == endreHour && eeMin == endreMin) {
						error = false;

					} else {
						error = true;

						var str2 = `<div class="system-msg">削除する場合は予約時間を変えないでください</div>`;
						$("#error").append(str2);
						break;
					}
				}
			}
			return false;
		})


		if (error == true) {
			return false;
		}
	})

})