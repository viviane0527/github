package data.persistence.hubs;

import data.persistence.ProjectFacade;
import data.model.enterprise.Project;
import data.annotations.Facade;
import data.annotations.FeatureType;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProjectHubFacade implements Serializable {

	@Inject @Facade(FeatureType.Project)
	private ProjectFacade projectFacade;

    public Project create(Project project) {
        return projectFacade.create(project);
    }

    public Project edit(Project project) {
        return projectFacade.edit(project);
    }

    public void remove(Project project) {
        projectFacade.remove(project);
    }

    public Project find(Object id) {
        return projectFacade.find(id);
    }

    public int count(Map<String, String> condition) {
        return projectFacade.count(condition);
    }

    public List<Project> searchRange(int[] range,
            List<String> projection,
            Map<String, Object> condition,
            Map<String, Object> orderBy) {
        return projectFacade.searchRange(range, condition, orderBy);
    }

}
