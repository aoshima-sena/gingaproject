/**
 *
 */
$(function() {
	$('.btn-animation-add').click(function() {
		//function cancelsubmit() {
		var startHour = document.getElementById("startHour").value;
		var startMin = document.getElementById("startMin").value;
		var endHour = document.getElementById("endHour").value;
		var endMin = document.getElementById("endMin").value;
		var year = document.getElementById("year").value;
		var month = document.getElementById("month").value;
		var date = document.getElementById("date").value;

		if (startMin == 0) {
			startMin = startMin + "0";
		}
		if (endMin == 0) {
			endMin = endMin + "0";
		}
		var tai1 = startHour + startMin;
		var tai2 = endHour + endMin;

		console.log(startMin + startHour);
		var startchan = startHour + startMin
		var numstart = Number(startchan);
		var endchan = endHour + endMin;
		var numend = Number(endchan);
		var start1 = Number(startHour);
		var start2 = Number(startMin);
		var start = start1 + start2;
		var end1 = Number(endMin);
		var end2 = Number(endHour);
		var end = end1 + end2;

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

		//var abc = document.getElementById("error");

		//今ある予約時間との重複を見る
		var num = [];
		/*	var result1 = [];
			var result2 = [];
			var result3 = [];
			var result4 = [];*/


		if (numstart >= numend) {
			$("#what").empty();
			//	var str = `ooiocha`
			//なんかうまくいかない
			//	abc.append(str);
			//	icon = document.createElement("system-msg");
			//	icon.setAttribute("class", "icon");
			//	abc.append(icon);

			var str2 = `<div class="system-msg">終了時間は開始時間より未来に設定してください</div>`;
			$("#what").append(str2);
			return false;


			//	alert("終了時間は開始時間より未来に設定してください");
		} else if (year <= todayYear && month <= todayMonth && date <= todayday) {

			if (todayMin == "0") {
				todayMin += "0";
			}else if(todayMin !="0" &&todayMin <10){
			todayMin = "0" + todayMin;
			}
			var todayResult = todayHour + todayMin;
			//		console.log(todayResult);
			tai1 = Number(tai1);
			if (tai1 <= todayResult) {
				var str2 = `<div class="system-msg">過去の日時に予約をすることはできません</div>`;
				$("#what").append(str2);
				return false;
			}
		} else {
			$("#what").empty();
			for (var i = 0; i < document.cookie.split(";").length; i++) {

				num[i] = document.cookie.split('; ')[i]
					.split('=')[1];

				console.log(num[i]);
				var result1 = num[i].substr(0, 2);
				var result2 = num[i].substr(3, 2);
				var result3 = num[i].substr(6, 2);
				var result4 = num[i].substr(9, 2);

				var res1 = result1 + result2;
				var res2 = result3 + result4;
				res1 = Number(res1);
				res2 = Number(res2);
				tai1 = Number(tai1);
				tai2 = Number(tai2);
				if (res1 <= tai2 && res2 >= tai1) {
					var str2 = `<div class="system-msg">予約時間に重複があります</div>`;
					$("#what").append(str2);
					return false;
				} else {


				}

			}



	}

	})
})