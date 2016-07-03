// The root URL for the RESTful services
//mg v1
var rootURL = "http://localhost:8080/CarAudioShop/rest/woofers";
var rootURLcompanies = "http://localhost:8080/ShuttleProgram22/rest/companies";
var table;
var tableHTML = "<table id=\"woofersTable\" class=\"display\"><thead> <tr> <th>Model</th> <th>Piston Description</th> <th>Suspension Description</th> <th>RMS Wats</th> <th>Magnet Description</th><th>Production Date</th></table>";

// Retrieve list of missions


var findAll= function () {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", 
		success: renderList
	});
};

var woofersTable = function(){
	$('#dataTable').show();
	
	$.ajax({
		   type:'GET',
		   url: rootURL,
		   dataType:"json",
		   success: function(data){
			   if(table == null){
			  table = $('#woofersTable').DataTable({
				   data: data, 
				   columns: [
				      {'data': 'model', "name": "engine"},
				      {'data': 'piston_Desc'},
				      {'data': 'susp_Desc'},
				      {'data': 'pe'},
				      {'data': 'mag_Desc'},
				      {'data': 'date'},
				     ],  
				   
				   "columnDefs": [ 
				                  {
			            "targets": 6,
			            "data": null,
			            "defaultContent": "<button id='btnModal' data-toggle='modal' data-target='#myModal'>Ts Parameters</button>"
			        } ],
				   "aLengthMenu": [20, 100, 500, 1000],
				   
			   });
			  
		   }else{
			   $("#dataTable").show(); 
		   }		   
		   }
	});
	
};


var renderList = function (data) {
		$.each(data, function(index, woofer){
			$('#woofersTable').append('<li><a href="#" id="'+woofer.id+
								  '">'+woofer.model+'</a></li>');
								  });
};

var findById = function(id){
	$.ajax({
		   type:'GET',
		   url: rootURL + '/' + id,
		   dataType:"json",
		   success:function(data){
			   $('.modal-title').html(data.model);
			   $('#piston_Desc').html("<b> Piston Description: </b>"+ data.piston_Desc);
			   $('#susp_Desc').html("<b> Suspension Description: </b>" + data.susp_Desc);
			   $('#dust_Cap_Desc').html("<b> Dust Cap Description: </b>" + data.dust_Cap_Desc);
			   $('#frame_Desc').html("<b> Frame Description: </b>" + data.frame_Desc);
			   $('#vc_Desc').html("<b> Voice Coil Description: </b>" + data.vc_Desc);
			   $('#mag_Desc').html("<b> Magnet Description: </b>" + data.mag_Desc);
			   $('#dualMG').html("<b> Dual Coil: </b>" + data.dualMG);
			   $('#fs').html("<b> Frequency Response: </b>" + data.fs);
			   $('#qms').html("<b> QMS: </b>" + data.qms);
			   $('#vas').html("<b> Vas: </b>" + data.vas);
			   $('#cms').html("<b> Cms: </b>" + data.cms);
			   $('#mms').html("<b> Mms: </b>" + data.mms);
			   $('#rms').html("<b> RMS Wat: </b>" + data.rms);
			   $('#xlin').html("<b> Xlin: </b>" + data.xlin);
			   $('#sd').html("<b> Sd: </b>" + data.sd);
			   $('#qes').html("<b> Qes: </b> ;" + data.qes);
			   $('#re').html("<b> Resistance: </b>" + data.re);
			   $('#le').html("<b> Le: </b>" + data.le);
			   $('#z').html("<b> Vas: </b>" + data.z);
			   $('#bl').html("<b> Bl: </b>" + data.bl);
			   $('#pe').html("<b> Continuous power: </b>" + data.pe);
			   $('#qts').html("<b> Qts: </b>" + data.qts);
			   $('#spl1').html("<b> SPL Db: </b>" + data.spl1);
			   $('#spl2').html("<b> Max SPL Db: </b>" + data.spl2);
			   $('#date').html("<b> Production Date: </b>" + data.date);
		   }
	});
};
	
var renderSingle = function(wdata){
	   $('.modal-title').html(data.model);
	   $('#model').val(wdata.model);
	   $('#piston_Desc').val(wdata.piston_Desc);
	   $('#susp_Desc').val(wdata.susp_Desc);
	   $('#dust_Cap_Desc').val(wdata.dust_Cap_Desc);
	   $('#frame_Desc').val(wdata.frame_Desc);
	   $('#vc_Desc').val(wdata.vc_Desc);
	   $('#mag_Desc').val(wdata.mag_Desc);
	   $('#dualMG').val(wdata.dualMG);
	   $('#fs').val(wdata.fs);
	   $('#qms').val(wdata.qms);
	   $('#vas').val(wdata.vas);
	   $('#cms').val(wdata.cms);
	   $('#mms').val(wdata.mms);
	   $('#rms').val(wdata.rms);
	   $('#xlin').val(wdata.xlin);
	   $('#sd').val(wdata.sd);
	   $('#qes').val(wdata.qes);
	   $('#re').val(wdata.re);
	   $('#le').val(wdata.le);
	   $('#z').val(wdata.z);
	   $('#bl').val(wdata.bl);
	   $('#pe').val(wdata.pe);
	   $('#qts').val(wdata.qts);
	   $('#spl1').val(wdata.spl1);
	   $('#spl2').val(wdata.spl2);
	   $('#date').val(wdata.date);
}

var deactiveMenu = function(){
	document.getElementById("home").className = "";
	document.getElementById("woofers").className = "";
	document.getElementById("contact").className = "";
	document.getElementById("about").className = "";
}

var hideEverything = function(){
	$('#dataTable').hide();
	$('.jumbotron h1,.jumbotron p,.jumbotron a').hide();
	$('.aboutWeb').hide();
	$('.contactWeb').hide();
	
}

$(document).on( 'click', '#woofersTable tr', function () {
	findById(table.row(this).data().id);
} )

$(document).on("click", "#home", function(){
	hideEverything();
	$('.jumbotron h1,.jumbotron p,.jumbotron a').show();
	deactiveMenu();
	document.getElementById("home").className = "active";
	
});

$(document).on("click", "#woofers", function(){
	hideEverything();
	$('#dataTable').show();
	$('#woofersTable').show();
	woofersTable();
	deactiveMenu();
	document.getElementById("woofers").className = "active";
	
});

$(document).on("click", "#about", function(){
	hideEverything();
	$('.aboutWeb').show();
	deactiveMenu();
	document.getElementById("about").className = "active";
	
});

$(document).on("click", "#contact", function(){
	hideEverything();
	$('.contactWeb').show();
	deactiveMenu();
	document.getElementById("contact").className = "active";
	
});


$(document).ready(function(){
	hideEverything();
	$('.jumbotron h1,.jumbotron p,.jumbotron a').show();
	
});

