<#assign el=args.htmlid?js_string>
<script type="text/javascript">//<![CDATA[
   new Alfresco.dashlet.MyTasks("${el}").setOptions(
   {
      hiddenTaskTypes: [<#list hiddenTaskTypes as type>"${type}"<#if type_has_next>, </#if></#list>]
   }).setMessages(
      ${messages}
   );
   new Alfresco.widget.DashletResizer("${el}", "${instance.object.id}");
//]]></script>

<div class="dashlet my-tasks">
   <div class="title">${msg("header")}</div>
   <div class="toolbar">
      <a href="${page.url.context}/page/start-workflow" class="theme-color-1">${msg("link.startWorkflow")}</a>
      &nbsp;|&nbsp;
      <a href="${page.url.context}/page/my-tasks" class="theme-color-1">${msg("link.allTasks")}</a>
   </div>
   <div id="${el}-tasks" class="body scrollableList" <#if args.height??>style="height: ${args.height}px;"</#if>>
   </div>
</div>
