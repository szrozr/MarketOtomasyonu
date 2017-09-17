var musteriEkleURL = "http://localhost:8080/MarketOtomasyonu/webapi/musteriekle";


$('#kaydetButonu').click(function(){
	inputTest();
});

function inputTest(){
	var ad = $('#ad').val();
	var soyad = $('#soyad').val();
	var telefon = $('#telefon').val();
	var adres = $('#adres').val();
	var subeid = $('#subeid').val();
	
	
	if(ad=="" || soyad=="" || telefon=="" || adres=="" || subeid ==""){
		   
		$('#uyari').empty();
		$('#uyari').append("tüm alanları doldurun!");
		
		if(ad == ""){
			$('#ad').addClass('input_toggle');
		}else{
			$('#ad').removeClass('input_toggle');
		}
		
		
		if(soyad == ""){
			$('#soyad').addClass('input_toggle');
		}else{
			$('#soyad').removeClass('input_toggle');
		}
		
		
		if(telefon == ""){
			$('#telefon').addClass('input_toggle');
		}else{
			$('#telefon').removeClass('input_toggle');
		}
		
		
		if(adres == ""){
			$('#adres').addClass('input_toggle');
		}else{
			$('#adres').removeClass('input_toggle');
		}
		
		if(subeid == ""){
			$('#subeid').addClass('input_toggle');
		}else{
			$('#subeid').removeClass('input_toggle');
		}
		
		
	}
	
	else{
		   
		$('#ad').removeClass('input_toggle');
		$('#soyad').removeClass('input_toggle');
		$('#telefon').removeClass('input_toggle');
		$('#adres').removeClass('input_toggle');
		$('#subeid').removeClass('input_toggle');
		  gonder();
	}
}




function gonder(){
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: musteriEkleURL,
		dataType: "json",
		data: musteriData(),
		success: function(data, textStatus, jqXHR){
			$('#uyari').empty();
			$('#uyari').append(data.sonuc);
		},
		error: function(jqXHR, textStatus, errorThrown){
		alert('Hata: ' + textStatus);
		}
	});
}

/*var ad = $('#ad').val();
var soyad = $('#soyad').val();
var telefon = $('#telefon').val();
var adres = $('#adres').val();
var subeid = $('#subeid').val();*/




function musteriData(){
	return JSON.stringify({
			"ad": $('#ad').val(),
			"soyad":  $('#soyad').val(),
			"telefon":  $('#telefon').val(),
			"adres": $('#adres').val(),
			"subeid": $('#subeid').val()
	
	});
}

$('#temizleButonu').click(function(){
	$('#ad').val("");
	$('#soyad').val("");
	$('#telefon').val("");
	$('#adres').val("");
	$('#subeid').val("");
	
	
	$('#ad').removeClass('input_toggle');
	$('#soyad').removeClass('input_toggle');
	$('#telefon').removeClass('input_toggle');
	$('#adres').removeClass('input_toggle');
	$('#subeid').removeClass('input_toggle');
	
	$('#uyari').empty();
});