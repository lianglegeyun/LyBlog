<div class="pagination" style="text-align: -webkit-center">
  <ul>
    <li><a href="javascript:void(0)" onclick="page(1)">&laquo;</a></li>
    <#if (pager?size > 0)>
      <#list pager as p>
        <#if p == "...">
        	<li><a href="javascript:void(0)">...</a></li>
        
        <#else>
        	<li><a href="javascript:void(0)" onclick="page(${p})">${p}</a></li>
        </#if>

      </#list>
    
    </#if>
    <li><a href="javascript:void(0)" onclick="page(${pager?size})">&raquo;</a></li>
        
  </ul>
</div>