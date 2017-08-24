// JavaScript Document

$('#btnCikis').click(function() {
	windowClose();
	return false;
});

function windowClose() {
	window.open('', '_self', ''); window.close();
}