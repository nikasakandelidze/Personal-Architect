package businessLogic;

import model.common.ProjectGeneratorData;

public class CreateProjectGeneratorData {

    public void create(String projectName) {
        final ProjectGeneratorData.Builder builder = ProjectGeneratorData.builder().withProjectName(projectName);
        final ProjectGeneratorData build = builder.build();
        System.out.println(build);
    }
}
