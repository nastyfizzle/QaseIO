package steps;

import io.qameta.allure.Step;
import pages.ProjectsPage;

public class ProjectSteps {

    ProjectsPage projectsPage;

    public ProjectSteps() {
        this.projectsPage = new ProjectsPage();
    }

    @Step("Click on [Create new project] button and fill in fields with valid values")
    public ProjectSteps createProject(String projectName, String projectCode, String description,
                                      String projectAccessType, String membersAccess) {
        projectsPage
                .isOpened()
                .clickOnCreateNewProjectButton()
                .isOpened()
                .fillInFields(projectName, projectCode, description, projectAccessType, membersAccess)
                .clickOnCreateProjectButton();
        return this;
    }

    @Step("Open settings and update title of project with the new one")
    public ProjectSteps updateProject(String projectName, String newProjectName) {
        projectsPage
                .isOpened()
                .clickOnSettingsOption(projectName)
                .editProjectTitle(newProjectName)
                .clickOnUpdate();
        return this;
    }

    @Step("Delete project")
    public ProjectSteps deleteProject(String projectName) {
        projectsPage
                .isOpened()
                .clickOnDeleteProjectOption(projectName)
                .confirmDeleting();
        return this;
    }

    @Step("Validate the name of created project is displayed in the list of projects")
    public ProjectSteps validateProjectCreated(String projectName) {
        projectsPage
                .open()
                .isProjectCreated(projectName);
        return this;
    }

    @Step("Validate the name of project is displayed with updated value in the list of projects")
    public ProjectSteps validateProjectUpdated(String newProjectName) {
        projectsPage
                .open()
                .isProjectCreated(newProjectName);
        return this;
    }

    @Step("Validate the name of deleted project isn't displayed in the list of projects")
    public ProjectSteps validateProjectDeleted(String projectName) {
        projectsPage
                .open()
                .isProjectDeleted(projectName);
        return this;
    }
}
