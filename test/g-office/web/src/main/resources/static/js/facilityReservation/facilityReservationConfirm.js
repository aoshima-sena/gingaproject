/**
 *
 */
/*$(window).on('load', function() {
	console.log("aa");
	getStartForm();
	getEndForm();
});*/

$("#confirm-add").click(function() {
	var startForm = getStartForm();
	var endForm = getEndForm();

	$("#startForm").val(function(){
	return startForm;
	})

	$("#endForm").val(function(){
	return endForm;
	})
})


function getStartForm() {
	console.log("dd");

	format_str = 'YYYY-MM-DD hh:mm:ss';
	var startHour = document.getElementById("startHour").value;
	var startSecond = document.getElementById("startSecond").value;

	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var date = document.getElementById("date").value;
	var second = "00";
	if (startSecond < 10) {
		startSecond = 0 + startSecond;
	}
	if (startHour < 10) {
		startHour = 0 + startHour;
	}


	if (month < 10) {
		month = 0 + month;
	}
	if (date < 10) {
		date = 0 + date;
	}



	format_str = format_str.replace(/YYYY/g, year);
	format_str = format_str.replace(/MM/g, month);
	format_str = format_str.replace(/DD/g, date);
	format_str = format_str.replace(/hh/g, startHour);
	format_str = format_str.replace(/mm/g, startSecond);
	format_str = format_str.replace(/ss/g, second);

	console.log(format_str);
	return format_str;


}

function getEndForm() {
	format_str1 = 'YYYY-MM-DD hh:mm:ss';
	var endHour = document.getElementById("endHour").value;
	var endSecond = document.getElementById("endSecond").value;
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var date = document.getElementById("date").value;
	var second = "00";

	if (endSecond < 10) {
		endSecond = 0 + endSecond;
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
	console.log(endHour);

	format_str1 = format_str1.replace(/YYYY/g, year);
	format_str1 = format_str1.replace(/MM/g, month);
	format_str1 = format_str1.replace(/DD/g, date);
	format_str1 = format_str1.replace(/hh/g, endHour);
	format_str1 = format_str1.replace(/mm/g, endSecond);
	format_str1 = format_str1.replace(/ss/g, second);

	console.log(format_str1);
	return format_str1;


}

