$(function(){
  $("#add").click(function(){
	  htmlobj=$.ajax({
	  	url:"/blog/admin",
	  	async:false,
	  	data :{
	  		method : 'edit'
	  	}
	  });
	  $("#tab1").html(htmlobj.responseText);
  });

  viewAction = function(id){
	  htmlobj=$.ajax({
	  	url:"/blog/admin",
	  	async:false,
	  	data :{
	  		method : 'edit',
	  		id : id
	  	}
	  });
	  $("#tab1").html(htmlobj.responseText);
  };

  deleteAction = function(id){
	  htmlobj=$.ajax({
	  	url:"/blog/admin",
	  	async:false,
	  	data :{
	  		method : 'delete',
	  		id : id
	  	}
	  });
	  $("#tab1").html(htmlobj.responseText);
  };

	page = function(page){
        htmlobj=$.ajax({
            url:"/blog/admin",
            async:false,
            data :{
                method : 'vistorPage',
                page : page
            }
        });
        $("#vistorTable").html(htmlobj.responseText);
        $('body').animate( {scrollTop: 0}, 500);
    };

});