package com.hostlund.textapproval;

import io.camunda.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = {"classpath:text-approval.bpmn"})
public class TextApprovalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextApprovalApplication.class, args);
    }

}
