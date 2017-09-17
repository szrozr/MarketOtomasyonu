var urunURL = "http://localhost:8080/MarketOtomasyonu/webapi/urunler";

$('#kaydetButonu').click(function(){
	
	
	inputKontrol();
	
});

function inputKontrol(){
	var ad = $('#ad').val();
	var fiyat = $('#fiyat').val();
	var miktar = $('#miktar').val();
	var barkod = $('#barkod').val();
	var sube_adi = $('#sube').val();
	
	
	if(ad=="" || fiyat=="" || miktar=="" || barkod=="" || sube_adi==""){
		$('#uyari').empty();
		$('#uyari').append("tüm alanları doldurun!");
		
		if(ad==""){
			$('#ad').addClass('input_toggle');
		}else{
			$('#ad').removeClass('input_toggle');
		}
		
		if(fiyat==""){
			$('#fiyat').addClass('input_toggle');
		}else{
			$('#fiyat').removeClass('input_toggle');
		}
		
		if(miktar==""){
			$('#miktar').addClass('input_toggle');
		}else{
			$('#miktar').removeClass('input_toggle');
		}
		
		if(barkod==""){
			$('#barkod').addClass('input_toggle');
		}else{
			$('#barkod').removeClass('input_toggle');
		}
		
		if(sube_adi==""){
			$('#sube').addClass('input_toggle');
		}else{
			$('#sube').removeClass('input_toggle');
		}
	}
	
	
	else{
		  gonder();
	}
	
}

function gonder(){
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: urunURL,
		dataType: "json",
		data: urunJson(),
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
var fiyat = $('#fiyat').val();
var miktar = $('#miktar').val();
var barkod = $('#barkod').val();
var sube_adi = $('#sube').val();*/

function urunJson(){
	return JSON.stringify({
		"ad": $('#ad').val(),
		"fiyat": $('#fiyat').val(),
		"miktar":  $('#miktar').val(),
		"barkod": $('#barkod').val(),
		"sube": $('#sube').val()
	});
}


$('#temizleButonu').click(function(){
	 $('#ad').val("");
	 $('#fiyat').val("");
	 $('#miktar').val("");
	 $('#barkod').val("");
	 $('#sube').val("");
});