package com.hostlund.textapproval.workers;

import io.camunda.client.annotation.JobWorker;
import io.camunda.client.api.response.ActivatedJob;
import io.camunda.client.api.worker.JobClient;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CheckBadWordsWorker {

    private static final String[] BAD_WORDS = {"bad", "damn", "hell"};

    //TODO replace with solution using Apache Commons
    @JobWorker(type = "checkBadWords")
    public void handle(ActivatedJob job, JobClient client) {
        Map<String, Object> variables = job.getVariablesAsMap();
        String text = (String) variables.get("inputText");
        boolean found = StringUtils.containsAnyIgnoreCase(text, BAD_WORDS);

        client.newCompleteCommand(job.getKey())
            .variables(Map.of("badWordsFound", found))
            .send()
            .join();  // Or .send() for async
    }

}



