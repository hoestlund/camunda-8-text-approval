package com.hostlund.textapproval;

import io.camunda.client.CamundaClient;
import io.camunda.client.api.response.ProcessInstanceEvent;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    @Autowired
    private CamundaClient client;

    @PostMapping("/start-approval")
    public ProcessInstanceEvent start(@RequestBody Map<String, Object> vars) {
        return client.newCreateInstanceCommand()
            .bpmnProcessId("textApprovalProcess")
            .latestVersion()
            .variables(vars)
            .send().join();
    }

}
