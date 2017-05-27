$(function () {
	/*var $link = $('.article-url');
	$link.bind('click',function(){
		var url = this.href;  
        var data = {

        };  
        $.ajax({  
            type : "get",  
            async : false,  //同步请求  
            url : url,  
            data : data,  
            timeout:1000,  
            success:function(dates){  
                //alert(dates);  
                $("#main").html(dates);//要刷新的div  
            },  
            error: function(a,b,c) {  
               // alert("失败，请稍后再试！");  
               var a = 1;
            }  
        });  
	});*/

	$("[data-toggle='tooltip']").tooltip();
	

	$("[data-toggle='popover']").popover({
		html : true,
		content	 : '<img src="./img/wechatPay.jpg">',
		
		trigger : 'hover ',
		container: 'body',
		title : '打开微信扫描下面二维码'
		//template : '<div class="tooltip" role="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>'
	}); 
});