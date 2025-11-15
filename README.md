## Overview

+ Process Flow (from exercise diagram): Start with inputText → Automated bad words scan → Approval gateway → Send approved text or reject.
+ Key Features: External job workers for tasks, variable propagation (e.g., badWordsFound: Boolean for routing), REST endpoint to start instances.
+ Not Production-Ready: Focuses on core automation; extendable (e.g., email integration in "sendText").

## Tech Stack

+ Camunda 8: Zeebe engine (local via Docker Compose), Modeler for BPMN.
+ Spring Boot 3.5.7: Auto-configures Zeebe client, @JobWorker for tasks, @Deployment for BPMN.
+ Java 21: LTS for compatibility.
+ Other: Apache Commons Lang (profanity utils), Maven.
