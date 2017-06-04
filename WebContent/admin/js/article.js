//@ sourceURL=article.js
$(function(){
	$('#summernote').summernote({  
      height: 400,                  
      minHeight: 300,             
      maxHeight: 500,        
      focus: true,   
      lang:'zh-CN',   
      callbacks: {
        // 重写图片上传  
        onImageUpload: function(files, editor, $editable) {  
            sendFile(files[0],editor,$editable);  
        }  
      }
  });

  sendFile = function(file){
    data = new FormData();  
    data.append("file", file);
    $.ajax({
        data: data,  
        type: "POST",  
        url: "admin/uploadImg",  
        cache: false,  
        contentType: false,  
        processData: false,
        dataType : "json",  
        success: function(data) {  
          $("#summernote").summernote('insertImage', data.url, 'image name'); // the insertImage API  
        }  
    });  
  };

	$('#back').click(function(){
	  htmlobj=$.ajax({
	  	url:"/blog/admin",
	  	async:false,
	  	data : {
	  		method : 'backToArticleList'
	  	}
	  });
	  $("#tab1").html(htmlobj.responseText);
  	});

  	$('#save').click(function(){
  		var id = $('#id').val();
  		var title = $('#title').val();
  		var excerpt = $('#excerpt').val();
  		var content = $('#summernote').summernote('code');
  		var isPrivate = $('#secret')[0].checked;
  		$.ajax({
		  	url:"/blog/admin",
		  	async:false,
		  	data : {
		  		method : 'save',
		  		id : id,
		  		title : title,
		  		excerpt : excerpt,
		  		content : content,
		  		isPrivate : isPrivate
		  	},
		  	success:function(data){
		  		alert('success!');
		  	},
		  	error: function() {
            	alert("error");
          	}
  		});
  		
  	});

  	$('#delete').click(function(){
  		var id = $('#id').val();
  		if( !id || id ===''){
  			alert('id is empty!');
  			return;
  		}
  		htmlobj=$.ajax({
		  	url:"/blog/admin",
		  	async:false,
		  	data : {
		  		method : 'delete',
		  		id : id
		  	}
  		});
  		$("#tab1").html(htmlobj.responseText);
  		
  	});

});