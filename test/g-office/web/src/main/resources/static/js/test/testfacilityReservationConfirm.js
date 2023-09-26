
$("#confirm-add").click(function() {
	var startForm = getStartForm();
	var endForm = getEndForm();
	$("#startForm").val(function() {
		return startForm;
	})
	$("#endForm").val(function() {
		return endForm;
	})
})

function getStartForm() {
	format_str = 'YYYY-MM-DD hh:mm:ss';
	var startHour = $('#startHour').val();
	var startMin = $('#startMin').val();
	var year = $('#year').val();
	var month = $('#month').val();
	var date = $('#date').val();
	var second = "00";
	if (startMin < 10) {
		startMin = 0 + startMin;
	}
	if (startHour < 10) {
		startHour = 0 + startHour;
	}
	if (month < 10) {
		month = 0 + month;
	}
	if (date < 10) {
		date = 0 < date;
	}
	format_str = format_str.replace(/YYYY/g, year);
	format_str = format_str.replace(/MM/g, month);
	format_str = format_str.replace(/DD/g, date);
	format_str = format_str.replace(/hh/, startHour);
	format_str = format_str.replace(/mm/g, startMin);
	format_str = format_str.replace(/ss/g, second);
	return format_str;
}

function getEndForm() {
	format_str1 = 'YYYY-MM-DD hh:mm:ss';
	var endHour = $('#endHour').val();
	var endMin = $('#endMin').val();
	var year = $('#year').val();
	var month = $('#month').val();
	var date = $('#date').val();
	var second = "00";
	if (endMin < 10) {
		endMin = 0 + endMin;
	}
	if (endHour < 10) {
		endHour = 0 + endHour;
	}
	if (month < 10) {
		month = 0 + month;
	}
	if (date < 10) {
		date = 0 + date;
	}
	format_str1 = format_str1.replace(/YYYY/g, year);
	format_str1 = format_str1.replace(/MM/g, month);
	format_str1 = format_str1.replace(/DD/g, date);
	format_str1 = format_str1.replace(/hh/g, endHour);
	format_str1 = format_str1.replace(/mm/g, endMin);
	format_str1 = format_str1.replace(/ss/g, second);
	return format_str1;
}