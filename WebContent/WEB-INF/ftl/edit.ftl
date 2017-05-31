<#assign basePath=request.contextPath>
<form role="form">
	<div class="btn-toolbar" role="toolbar">
		<div class="btn-group" role="group" >
		  <button type="button" class="btn btn-default" id="save">保存</button>
		  <button type="button" class="btn btn-default" id="delete">删除</button>
		  <button type="button" class="btn btn-default" id="back">返回</button>
		</div>
		
	</div>
	<div class="input-group">
        <input type="hidden" class="form-control"  id="id" value="${(article.id)!""}">
    </div>
	<div class="input-group">
        标题：
        <input type="text" class="form-control" placeholder="文章标题" id="title" value="${(article.title)!""}">
    </div>
    <div class="input-group">
        摘要：
        <input type="text" class="form-control" placeholder="文字摘要" id="excerpt" value="${(article.excerpt)!""}">
    </div>
    <div class="checkbox">
	    <label>
	      <#if article?? && article.status==0>
	      	<input type="checkbox" id="secret" checked="true"}">私有
	      <#else>
	      	<input type="checkbox" id="secret"}">私有
	      </#if>

	    </label>
	  </div>
</form>
<!-- /stat-container -->
<div id="summernote">${(article.content)!""}</div>
<script src="${basePath}/admin/summernote/summernote.js"></script>
<script src="${basePath}/admin/summernote/lang/summernote-zh-CN.min.js"></script>
<script src="${basePath}/admin/js/article.js"></script>