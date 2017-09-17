var rootURL = "http://localhost:8080/MarketOtomasyonu/webapi/myresource";
var userURL = "http://localhost:8080/MarketOtomasyonu/webapi/user";
var urunURL = "http://localhost:8080/MarketOtomasyonu/webapi/urunler";
var userGetUrl = "http://localhost:8080/MarketOtomasyonu/webapi/user";

var currentNesne;
var currentUser;


findAll();
getUser();

$('#btnGiris').click(function() {
	girisYap();
	return false;
});


function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: renderList
	});
}


function getUser() {
	console.log('getUser');
	$.ajax({
		type: 'GET',
		url: userURL,
		dataType: "json", // data type of response
		success: renderList2
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$.each(list, function(index, nesne) {
		$('#ad').val(nesne.ad);
		$('#soyad').val(nesne.soyad);
	});
}


function renderList2(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$.each(list, function(index, nesne) {
		$('#id').val(nesne.id);
		$('#firstname').val(nesne.firstname);
		$('#lastname').val(nesne.lastname);
		$('#password').val(nesne.password);
		$('#role').val(nesne.role);
		$('#username').val(nesne.username);
	});
}


function girisYap() {
	console.log('girisYap');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: userURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			if(data.sonuc=="admin"){
				 currentUser = data.sonuc;
				 top.location.href = '/MarketOtomasyonu/admin/index.html';
			}
			
			else if(data.sonuc=="kasiyer"){
				 currentUser = data.sonuc;
				 top.location.href = '/MarketOtomasyonu/kasiyer/index.html';
			}
				
		
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Giriş Yapılamadı: ' + textStatus);
		}
	});
}


function formToJSON() {
	
	return JSON.stringify({		
		"username": $("#username").val(),
		"password": $("#password").val(),
		"purpose":  "login",
		
		});
}


$('#btncikis').click(function() {
	windowClose();
	return false;
});

function windowClose() {
	window.alert('Message goes here');
}




//kullanici bilgileri sayfasi 
//$('#currentUser').click();



