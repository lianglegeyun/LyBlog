<#assign basePath=request.contextPath>
<div class="panel panel-default " id="panel">
    
      <div class="panel-heading" id="panel-heading">
          <h3 class="panel-title">
              最新文章
          </h3>
      </div>
      <div class="panel-body" id="panel-body">
        <div id="list">
          
          	<#if (articleList?size > 0)>
            	<#list articleList as a>
  			      <section id="${a.id}">
              
                  <h3><a class="article-url" href="${basePath}/article/${a.id}" onclick="loading()">${a.title}</a></h3>
            
                  <p>${a.excerpt}

                    <time>
                    <br>
                    ${(a.createTime?string("yyyy-MM-dd"))!}
                    </time>

                  </p>
               </section>
  		       </#list>
  	      </#if>
        </div>
      </div>


    
  </div>



  <div class="pagination" style="text-align: -webkit-center">
      <ul>
        <li><a href="javascript:void(0)" onclick="page(1)">&laquo;</a></li>
        <#if (pager?size > 0)>
          <#list pager as p>
            
            <li><a href="javascript:void(0)" onclick="page(${p})">${p}</a></li>
          </#list>
        
        </#if>
        <li><a href="javascript:void(0)" onclick="page(${pager?size})">&raquo;</a></li>
            
      </ul>
    </div>
</div>