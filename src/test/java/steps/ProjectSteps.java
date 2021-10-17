package steps;

import io.qameta.allure.Step;
import pages.NewProjectPage;
import pages.ProjectDetailsPage;
import pages.ProjectsPage;
import pages.SettingsPage;

public class ProjectSteps {

    ProjectsPage projectsPage;
    SettingsPage settingsPage;
    NewProjectPage newProjectPage;
    ProjectDetailsPage projectDetailsPage;

    public ProjectSteps() {
        this.projectsPage = new ProjectsPage();
        this.settingsPage = new SettingsPage();
        this.newProjectPage = new NewProjectPage();
        this.projectDetailsPage = new ProjectDetailsPage();
    }

    @Step("Create new project")
    public void createProject(String projectName, String projectCode, String description,
                              String projectAccessType, String membersAccess) {
        projectsPage
                .isOpened()
                .clickOnCreateNewProjectButton();
        newProjectPage
                .isOpened()
                .fillInFields(projectName, projectCode, description, projectAccessType, membersAccess)
                .clickOnCreateProjectButton();
    }

    @Step("Update project")
    public void updateProject(String projectCode, String newProjectName) {
        projectsPage
                .open(projectCode);
        settingsPage
                .isOpened()
                .open(projectCode)
                .editProjectTitle(newProjectName)
                .clickOnUpdate();
    }

    @Step("Delete project")
    public ProjectSteps deleteProject(String projectCode) {
        projectsPage
                .open(projectCode);
        settingsPage
                .isOpened()
                .open(projectCode)
                .clickOnDelete()
                .confirmProjectDeleting();
        return this;
    }

    @Step("Validate the name of created project is displayed in the list of projects")
    public void validateProjectCreated(String projectName) {
        projectsPage
                .open()
                .isProjectCreated(projectName);
    }

    @Step("Validate the name of created project isn't displayed in the list of projects")
    public void validateProjectDeleted(String projectName) {
        projectsPage
                .open()
                .isProjectDeleted(projectName);
    }
}
