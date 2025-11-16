package com.hostlund.textapproval.workers;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.api.response.ActivatedJob;
import io.camunda.client.api.worker.JobClient;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SendTextWorker {

    @JobWorker(type = "sendText")
    public void handle(ActivatedJob job, JobClient client) {  // Takes job + client (void return OK)
        Map<String, Object> variables = job.getVariablesAsMap();  // Fetches vars safely
        String text = (String) variables.get("inputText");

        System.out.println("Approved text: " + text);

        client.newCompleteCommand(job.getKey())
            .send()
            .join();
    }

}
