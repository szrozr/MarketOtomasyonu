var userGetUrl = "http://localhost:8080/MarketOtomasyonu/webapi/user";
var currentNesne;
var currentUser;


$('#kaydetButonu').click(function(){
	
	//alert("butona tıklandı");
	
	inputDolumu();
	
	
	/*
		$.ajax({
			type: 'POST',
			url: userGetUrl,
			dataType: "json", // data type of response
			success: function(data){
				$('#uyari').empty();
				$('#uyari').append(data);
			}
		});
	*/
		
		$.ajax({
			type: 'POST',
			contentType: 'application/json',
			url: userGetUrl,
			dataType: "json",
			data: kullaniciGuncelleData(),
			success: function(data, textStatus, jqXHR){
				$('#uyari').empty();
				$('#uyari').append(data.sonuc);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert('Giriş Yapılamadı: ' + textStatus);
			}
		});
/*	if(yeni_sifre !== sifre_tekrar){		
		$('#uyari').append('şifreler uyuşmuyor!');
		$('#yeni_sifre').toggleClass('input_toggle');
		$('#sifre_tekrar').toggleClass('input_toggle');
	}
	*/
});
		function kullaniciGuncelleData(){
			return JSON.stringify({		
				"username": $('#kullanici_adi').val(),
				"password": $('#sifre').val(),
				"purpose":  "guncelleme",
				"name": $('#ad').val(),
				"surname": $("#soyad").val(),
				"newPassword": $('#yeni_sifre').val(),
				"newPassword1": $('#sifre_tekrar').val()
				});
		}

$('#temizleButonu').click(function(){
	$('#ad').val("");
	$('#soyad').val("");
	$('#kullanici_adi').val("");
	$('#sifre').val("");
	$('#yeni_sifre').val("");
	$('#sifre_tekrar').val("");
});


function inputDolumu(){
	
	  var ad = $('#ad').val();
		var soyad = $('#soyad').val();
		var sifre = $('#sifre').val();
		var yeni_sifre = $('#yeni_sifre').val();
		var sifre_tekrar = $('#sifre_tekrar').val();
		var kullanici_adi =$('#kullanici_adi').val();
	
		$('#uyari').empty();
	if(ad=="" || soyad == "" || sifre == "" || yeni_sifre == "" || sifre_tekrar == "" || kullanici_adi == ""){
		//alert("gerekli alanları doldurun!");
		
		$('#uyari').append('gerekli alanları doldurun!');
		
		if(ad==""){
			$('#ad').addClass('input_toggle');
		}
		else{
			$('#ad').removeClass('input_toggle');
		}
		
		if(soyad==""){
			$('#soyad').addClass('input_toggle');
		}else{
			$('#soyad').removeClass('input_toggle');
		}
		
		if(sifre==""){
			$('#sifre').addClass('input_toggle');
		}else{
			$('#sifre').removeClass('input_toggle');
		}
		
		if(yeni_sifre==""){
			$('#yeni_sifre').addClass('input_toggle');
		}else{
			$('#yeni_sifre').removeClass('input_toggle');
		}
		
		if(sifre_tekrar==""){
			$('#sifre_tekrar').addClass('input_toggle');
		}else{
			$('#sifre_tekrar').removeClass('input_toggle');
		}
		
		if(kullanici_adi==""){
			$('#kullanici_adi').addClass('input_toggle');
		}else{
			$('#kullanici_adi').removeClass('input_toggle');
		}
		
	}
	
	else if(yeni_sifre != sifre_tekrar){
		$('#ad').removeClass('input_toggle');
		$('#soyad').removeClass('input_toggle');
		$('#sifre').removeClass('input_toggle');
		$('#yeni_sifre').removeClass('input_toggle');
		$('#sifre_tekrar').removeClass('input_toggle');
		$('#kullanici_adi').removeClass('input_toggle');
		
		$('#uyari').empty();
		$('#uyari').append('şifreler uyuşmuyor!');
		$('#yeni_sifre').addClass('input_toggle');
		$('#sifre_tekrar').addClass('input_toggle');
	}
	
	
	else{
		$('#ad').removeClass('input_toggle');
		$('#soyad').removeClass('input_toggle');
		$('#sifre').removeClass('input_toggle');
		$('#yeni_sifre').removeClass('input_toggle');
		$('#sifre_tekrar').removeClass('input_toggle');
		$('#kullanici_adi').removeClass('input_toggle');
	}
	
	
}
