/**
 *
 */

$(function() {
	$('#type').change(function() {

		var param = $('#type').val();

		console.log(param);
		var send_url = `/testfacilityreservation/remake/${param}`;
		console.log(send_url);

		$.ajax({
			url: send_url,
			type: "GET",
			dataType: "JSON"
		}).done(function(data) {
			console.log(data);
			//URL変更しなくていいよ
			//変更すると戻った時の画面が表示されなくなる
			//	history.replaceState('', '', `/facilityreservation/remake/${param}`);
			$("#facility").empty();

			var facilityId = $('#facilityId').val();
			console.log(facilityId);
			for (let i = 0; i < data.facilityFormList.length; i++) {
				var str = `<div class="r-col">
				<a href="/testfacilityreservation/calendar/${data.facilityFormList[i].facilityId}">${data.facilityFormList[i].name}</a>

				<p>定員${data.facilityFormList[i].capacity}人</p>
				</div>`
				$("#facility").append(str);

			}
		}).fail(function() {
			alert("error");
		})
	})
})