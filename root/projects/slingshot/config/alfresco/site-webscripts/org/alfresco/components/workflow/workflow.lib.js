function getWorkflowTypes()
{
   var connector = remote.connect("alfresco"),
      result = connector.get("/api/workflow-definitions"),
      filteredWorkflows;
   if (result.status == 200)
   {
      var workflows = eval('(' + result + ')').data,
         hiddenWorkflows = config.scoped["Workflow"]["hidden-workflows"].childrenMap["workflow"],
         hiddenWorkflowName;
      filteredWorkflows = []
      for (var i = 0, il = workflows.length; i < il; i++)
      {
         try
         {
            // TODO: Remove this filtering and add the hidden tasks to the url instead
            if (hiddenWorkflows)
            {
               for (var hi = 0, hil = hiddenWorkflows.size(); hi < hil; hi++)
               {
                  hiddenWorkflowName = hiddenWorkflows.get(hi).attributes["name"];
                  if (workflows[i].name == hiddenWorkflowName)
                  {
                     break;
                  }
               }
               if (hi == hil)
               {
                  filteredWorkflows.push(workflows[i]);
               }
            }
         }
         catch (e)
         {
         }
      }
   }
   return filteredWorkflows;
}
