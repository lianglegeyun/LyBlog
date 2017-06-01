$(function(){
	$("#vistDetails").click(function(){
	  htmlobj=$.ajax({
	  	url:"/blog/admin",
	  	async:false,
	  	data :{
	  		method : 'vistorPage'
	  	}
	  });
	  $("#systemInfoDiv").html(htmlobj.responseText);
	});

	$("#vistorInfo").click(function(){
	  htmlobj=$.ajax({
	  	url:"/blog/admin",
	  	async:false,
	  	data :{
	  		method : 'vistorInfo'
	  	}
	  });
	  $("#systemInfoDiv").html(htmlobj.responseText);
	});

	$("#updateAddr").click(function(){
	  htmlobj=$.ajax({
	  	url:"/blog/admin",
	  	async:false,
	  	data :{
	  		method : 'updateAddr'
	  	}
	  });
	  $("#systemInfoDiv").html(htmlobj.responseText);
	});

});