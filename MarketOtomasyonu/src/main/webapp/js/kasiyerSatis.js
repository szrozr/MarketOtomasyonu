var urunUrl="http://localhost:8080/MarketOtomasyonu/webapi/urunler";
var secilenUrunler = new Array();
var toplamfiyat = 0.0;
var tumUrunler = new Array();




urunListele();
//tumUrunleriDiziyeAl();

Array.prototype.clean = function(deleteValue) {
	  for (var i = 0; i < this.length; i++) {
	    if (this[i] == deleteValue) {         
	      this.splice(i, 1);
	      i--;
	    }
	  }
	  return this;
	};


function urunListele(){
	//console.log('urunListele');
	$.ajax({
		type: 'GET',
		url: urunUrl,
		dataType: "json", // data type of response
		success: renderList
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	//$('#urunListe').remove();
	$.each(list, function(index, urun) {
		$('#urunListe').append('<tr class="table-row"><td class="id-sutun">'+urun.id+'</td><td class="urun-ismi">' +urun.product_name+ '</td><td class="urun-fiyat">' + urun.price + '</td><td class="urun-sayi">' + urun.quantity + '</td><td class="urun-sube">' + urun.branch_id + '</td><td class="urun-barkod">' + urun.barkod_no +'</td></tr>');
	});
}


function renderList2(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	//var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#urunListe tbody').remove();
	
    $('#urunListe').append('<tr class="table-row"><td class="id-sutun">'+data["urun_id"]+'</td><td class="urun-ismi">' +data["urun_ismi"]+ '</td><td class="urun-fiyat">' + data["urun_fiyat"] + '</td><td class="urun-sayi">' + data["urun_sayi"] + '</td><td class="urun-sube">' + data["urun_sube"] + '</td><td class="urun-barkod">' + data["urun_barkod"] +'</td></tr>');
	
    $('#urunListe').addClass('aramaSonuc');
}


function tumUrunleriDiziyeAl(){

}


$('#secButonu').click(function(){
	secilenUrunler.clean(undefined);
	$('#urunListe1 .table-row').remove();
	if(secilenUrunler.length === 0){
		alert("ürün seçmediniz!");
	}
	
	else{
		
		for(i=0; i< secilenUrunler.length; i++){
			$('#urunListe1').append('<tr class="table-row"><td class="id-sutun">'+secilenUrunler[i]["urun_id"]+'</td><td class="urun-ismi">' +secilenUrunler[i]["urun_ismi"]+ '</td><td class="urun-fiyat">' + secilenUrunler[i]["urun_fiyat"] + '</td><td class="urun-sayi">' + secilenUrunler[i]["urun_sayi"] + '</td><td class="urun-sube">' + secilenUrunler[i]["urun_sube"] + '</td><td class="urun-barkod">' + secilenUrunler[i]["urun_barkod"] +'</td></tr>');
			
		}
	}
});
	

$('#temizleButonu').click(function(){
	$('#urunListe1 .table-row').remove();
});




$("#onaylaButonu").click(function(){
	var fiyatToplami = 0;
	
	$('#urunListe1 tbody tr').each(function(){
		//alert('urun fiyat deneme: ' + $(this).find('.urun-fiyat').html()); 
		fiyatToplami += parseFloat($(this).find('.urun-fiyat').html().replace(',', '.'));
	})
	
	
	$('#toplamTutarInput').val(fiyatToplami);
	toplamfiyat = parseFloat(fiyatToplami);
	
	//alert("secilen ürünlerin fiyatları toplamı: " + fiyatToplami);

	//alert("  fiyat objesi" + fiyatObj["fiyat"]);
	
});




$('#alinanParaInput').keypress(function(e) {
    if(e.which == 13) {
     //alert("toplam fiyat=" + toplamfiyat);
      var alinanPara = 0.0;
      alinanPara = parseFloat($('#alinanParaInput').val());
      alinanPara.toFixed(2);
      
     var paraUstu = 0.0;
     
      if(alinanPara>toplamfiyat){
    	  paraUstu = alinanPara- toplamfiyat  ;
    	  paraUstu.toFixed(2);
    	  $('#paraUstuInput').val(paraUstu).replace(',', '.');
    	//  alert("para üstü= " + paraUstu);
      }
      
      else if(alinanPara<toplamfiyat){
    	  alert("alınan para yetersiz.")
      }
      
      
    }
    
   
});





//barkod ile ürün arama kısmı
$('#qr_src_in').keypress(function(e){
	//tüm ürünleri diziye alma
	
	if(e.which == 13){
		
		$("#urunListe tbody tr").each(function(){
			var obj = [];
			
			obj["urun_id"] = $(this).find(".id-sutun").html();
			obj["urun_ismi"] = $(this).find(".urun-ismi").html();
			obj["urun_fiyat"] = $(this).find(".urun-fiyat").html();
			obj["urun_sayi"] = $(this).find(".urun-sayi").html();
			obj["urun_sube"] = $(this).find(".urun-sube").html();
			obj["urun_barkod"] = $(this).find(".urun-barkod").html();
			
			tumUrunler.push(obj);
			
		});
		
		var girilenBarkod = $('#qr_src_in').val();
		//alert('girilen barkod: ' + girilenBarkod);
	    for(var i=0; i<tumUrunler.length; i++){
	    	if(tumUrunler[i]['urun_barkod'] == girilenBarkod){
	    		//alert('ürün bulundu!');
	    		renderList2(tumUrunler[i]);
	    		return;
	    	}
	    }
		
	}
});

$('#qr_src_in1').keypress(function(e){
	//tüm ürünleri diziye alma
	
	if(e.which == 13){
		
		tumUrunler = [];
		
		$("#urunListe tbody tr").each(function(){
			var obj = [];
			
			obj["urun_id"] = $(this).find(".id-sutun").html();
			obj["urun_ismi"] = $(this).find(".urun-ismi").html();
			obj["urun_fiyat"] = $(this).find(".urun-fiyat").html();
			obj["urun_sayi"] = $(this).find(".urun-sayi").html();
			obj["urun_sube"] = $(this).find(".urun-sube").html();
			obj["urun_barkod"] = $(this).find(".urun-barkod").html();
			
			tumUrunler.push(obj);
			
		});
		
		var girilenBarkod = $('#qr_src_in1').val();
		alert('girilen ürün ismi: ' + girilenBarkod);
	    for(var i=0; i<tumUrunler.length; i++){
	    	if(tumUrunler[i]['urun_ismi'] == girilenBarkod){
	    		//alert('ürün bulundu!');
	    		renderList2(tumUrunler[i]);
	    		return;
	    	}
	    }
		
	}
});


$('#urunListe').on('mouseover', 'tr', function() {
	  $(this).addClass('change_table_row')
});

$('#urunListe').on('mouseout', 'tr', function() {
	  $(this).removeClass('change_table_row')
});

$('#urunListe1').on('mouseover', 'tr', function() {
	  $(this).addClass('change_table_row')
});

$('#urunListe1').on('mouseout', 'tr', function() {
	  $(this).removeClass('change_table_row')
});

$('#urunListe1').on('click', '.table-row', function(){
	  $(this).toggleClass('change_selected_row');
});



var sayac = 0;
	
$('#urunListe').on('click', '.table-row', function() {
    $(this).toggleClass('change_selected_row');
    
    var id = $(this).find(".id-sutun").html();
    var urunIsmi = $(this).find(".urun-ismi").html();
    var urunFiyat = $(this).find(".urun-fiyat").html();
    var urunSayi = $(this).find(".urun-sayi").html();
    var urunSube = $(this).find(".urun-sube").html();
    var urunBarkod = $(this).find(".urun-barkod").html();
   
    
    
    	
    if(sayac==0){
    	 var obj = [];
    	 
   	    obj["urun_id"] = id;
   	    obj["urun_ismi"] = urunIsmi;
   	    obj["urun_fiyat"] = urunFiyat;
   	    obj["urun_sayi"] = urunSayi;
   	    obj["urun_sube"] = urunSube;
   	    obj["urun_barkod"] = urunBarkod;
   	    obj["secili_durumu"] = true;
   	    
   	    secilenUrunler.push(obj);

   	    sayac = sayac+1;
    } 
    else{
    	var sonuc = seciliMiKontrol(id);
    	
    	if(sonuc == true){
        	seciliIseSil(id);
        }
        
        else{
        	 var obj = [];
        	 
      	    obj["urun_id"] = id;
      	    obj["urun_ismi"] = urunIsmi;
      	    obj["urun_fiyat"] = urunFiyat;
      	    obj["urun_sayi"] = urunSayi;
      	    obj["urun_sube"] = urunSube;
      	    obj["urun_barkod"] = urunBarkod;
      	    obj["secili_durumu"] = true;
      	    
      	    secilenUrunler.push(obj);

      	  sayac = sayac+1;
        }
    }
   });


function indexDonder(value){
	
	for(i = 0; i<secilenUrunler.length; i++){
		if(typeof secilenUrunler[i]!=="undefined"){
			if(secilenUrunler[i]['urun_id'] === value){
				
				return i;
			}
		}
		
		
	}
}


function seciliIseSil(id){
	var index = indexDonder(id);
	
	if( typeof index!=="undefined"){
		 if(secilenUrunler[index]['secili_durumu'] === true ){
			 
			   delete secilenUrunler[index];
			 
		   }
	}
}

function seciliMiKontrol(id){
	var index = indexDonder(id);
	
	if( typeof index!=="undefined"){
	 

			 if(secilenUrunler[index]['secili_durumu'] === true ) {
				
				 return true;
			 }
			 
			 else{
				 return false;
			 }
	  
	}
}




	
	
