<#assign basePath=request.contextPath>
<h1 class="page-title">
  <i class="icon-home"></i>
  文章          
</h1>

 <!-- /stat-container -->
<div class="btn-toolbar" role="toolbar">
  
    <button type="button" class="btn btn-default" id="add">新增</button>
  
  
  
</div>

<div class="widget widget-table">
            
  <div class="widget-header">
    <i class="icon-th-list"></i>
    <h3>文章列表</h3>
  </div> <!-- /widget-header -->
  
  <div class="widget-content">
  
    <table class="table table-striped table-bordered">
      <thead>
        <tr>
          <th>#</th>
          <th>标题</th>
          <th>摘要</th>
          <th>日期</th>
          <th>状态</th>
          <th>&nbsp;</th>
        </tr>
      </thead>
      
      <tbody>
        
        <#if (articleList?size > 0)>
          <#list articleList as a>
          <tr>
            <td>${a.id}</td>
            <td><a href="javascript:void(0)" onclick="viewAction(${a.id})">${a.title}</a></td>
            <td>${a.excerpt}</td>
            <td>${(a.createTime?string("yyyy-MM-dd"))!}</td>
            <td>${a.status}</td>
            <td class="action-td">
              <a href="javascript:;" class="btn btn-small btn-warning">
                <i class="icon-ok"></i>               
              </a>            
              <a href="javascript:void(0)" class="btn btn-small" onclick="deleteAction(${a.id})">
                <i class="icon-remove"></i>           
              </a>
            </td>
          </tr>
         </#list>
        </#if>
        
        
      </tbody>
    </table>
  
  </div> <!-- /widget-content -->
  
</div> <!-- /widget -->
<script src="${basePath}/admin/js/articleList.js"></script>
