package models;

public class TestCase {

    String title;
    String status;
    String description;
    String suite;
    String severity;
    String priority;
    String type;
    String layer;
    String isFlaky;
    String milestone;
    String behaviour;
    String automationStatus;
    String preConditions;
    String postConditions;
    //String tags;

    public TestCase(String title, String status, String description, String suite, String severity, String priority, String type, String layer,
                    String isFlaky, String milestone, String behaviour, String automationStatus, String preConditions, String postConditions) {
        this.title = title;
        this.status = status;
        this.description = description;
        this.suite = suite;
        this.severity = severity;
        this.priority = priority;
        this.type = type;
        this.layer = layer;
        this.isFlaky = isFlaky;
        this.milestone = milestone;
        this.behaviour = behaviour;
        this.automationStatus = automationStatus;
        this.preConditions = preConditions;
        this.postConditions = postConditions;
        //this.tags = tags;
    }

    public TestCase(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getIsFlaky() {
        return isFlaky;
    }

    public void setIsFlaky(String isFlaky) {
        this.isFlaky = isFlaky;
    }

    public String getMilestone() {
        return milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getAutomationStatus() {
        return automationStatus;
    }

    public void setAutomationStatus(String automationStatus) {
        this.automationStatus = automationStatus;
    }

    public String getPreConditions() {
        return preConditions;
    }

    public void setPreConditions(String preConditions) {
        this.preConditions = preConditions;
    }

    public String getPostConditions() {
        return postConditions;
    }

    public void setPostConditions(String postConditions) {
        this.postConditions = postConditions;
    }

//    public String getTags() {
//        return tags;
//    }
//
//    public void setTags(String tags) {
//        this.tags = tags;
//    }
}
