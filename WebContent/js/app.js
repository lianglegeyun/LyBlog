$(function () {
	

	$("[data-toggle='tooltip']").tooltip();
	
	getContextPath = function(){
		var pathName = document.location.pathname;
	    var index = pathName.substr(1).indexOf("/");
	    var result = pathName.substr(0,index+1);
	    return result;
	};
	
    loading = function(){
    	$('#panel-heading').css('opacity', 0);
    	$('#panel-body').css('opacity', 0);
        var loadingHTML = '<div class="loading"><img src="' + getContextPath() + '/img/loading.gif"></img></div>';
        $('#panel').append(loadingHTML);
    }

	$("[data-toggle='popover']").popover({
		html : true,
		content	 : '<img src="' + getContextPath() + '/img/wechatPay.jpg">',
		trigger : 'hover ',
		container: 'body',
		title : '打开微信扫描下面二维码'
		//template : '<div class="tooltip" role="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>'
	}); 

    page = function(page){
        htmlobj=$.ajax({
            url:"/blog/",
            async:false,
            data :{
                method : 'mainDiv',
                page : page
            }
        });
        $("#main").html(htmlobj.responseText);
        $('body').animate( {scrollTop: 0}, 500);
    };

});