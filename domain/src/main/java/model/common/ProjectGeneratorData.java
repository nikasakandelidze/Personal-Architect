package model.common;

import model.userSpecific.UserSpecificData;

public class ProjectGeneratorData {
    private String projectName;
    private ProjectDomainData domainData;
    private CRUD_UseCasesData crud_useCasesData;
    private ArchitectureType architectureType;
    private UserSpecificData userSpecificData;

    private ProjectGeneratorData(Builder builder) {
        this.projectName = builder.projectName;
        this.domainData = builder.domainData;
        this.crud_useCasesData = builder.crudUseCasesData;
        this.architectureType = builder.architectureType;
        this.userSpecificData = builder.userSpecificData;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getProjectName() {
        return projectName;
    }

    public ProjectDomainData getDomainData() {
        return domainData;
    }

    public CRUD_UseCasesData getCrud_useCasesData() {
        return crud_useCasesData;
    }

    public ArchitectureType getArchitectureType() {
        return architectureType;
    }

    public UserSpecificData getUserSpecificData() {
        return userSpecificData;
    }

    @Override
    public String toString() {
        return "ProjectGeneratorData{" +
                "projectName='" + projectName + '\'' +
                ", domainData=" + domainData +
                ", crud_useCasesData=" + crud_useCasesData +
                ", architectureType=" + architectureType +
                ", userSpecificData=" + userSpecificData +
                '}';
    }

    public static class Builder {
        private String projectName;
        private ProjectDomainData domainData;
        private CRUD_UseCasesData crudUseCasesData;
        private ArchitectureType architectureType;
        private UserSpecificData userSpecificData;

        private Builder(String projectName, ProjectDomainData domainData, CRUD_UseCasesData crudUseCasesData, ArchitectureType architectureType, UserSpecificData userSpecificData) {
            this.projectName = projectName;
            this.domainData = domainData;
            this.crudUseCasesData = crudUseCasesData;
            this.architectureType = architectureType;
            this.userSpecificData = userSpecificData;
        }

        private Builder(String projectName) {
            this.projectName = projectName;
        }

        private Builder(ProjectDomainData domainData) {
            this.domainData = domainData;
        }

        private Builder(CRUD_UseCasesData crudUseCasesData) {
            this.crudUseCasesData = crudUseCasesData;
        }

        private Builder(ArchitectureType architectureType) {
            this.architectureType = architectureType;
        }

        private Builder(UserSpecificData userSpecificData) {
            this.userSpecificData = userSpecificData;
        }

        private Builder() {
        }

        public ProjectGeneratorData build() {
            return new ProjectGeneratorData(this);
        }

        public Builder withProjectName(String projectName) {
            return new Builder(projectName, this.domainData.copy(), this.crudUseCasesData.copy(), this.architectureType, this.userSpecificData.copy());
        }

        public Builder withProjectDomainData(ProjectDomainData domainData) {
            return new Builder(this.projectName, domainData, this.crudUseCasesData.copy(), this.architectureType, this.userSpecificData.copy());
        }

        public Builder withUseCasesData(CRUD_UseCasesData useCasesData) {
            return new Builder(this.projectName, this.domainData, useCasesData.copy(), this.architectureType, this.userSpecificData.copy());
        }

        public Builder withArchitectureType(ArchitectureType architectureType) {
            return new Builder(this.projectName, this.domainData, this.crudUseCasesData, architectureType, this.userSpecificData.copy());
        }

        public Builder withUserSpecificData(UserSpecificData userSpecificData) {
            return new Builder(this.projectName, this.domainData, this.crudUseCasesData, this.architectureType, userSpecificData);
        }

        public Builder deepCopy() {
            return new Builder(this.projectName, this.domainData.copy(), this.crudUseCasesData.copy(), this.architectureType, this.userSpecificData.copy());
        }
    }
}
