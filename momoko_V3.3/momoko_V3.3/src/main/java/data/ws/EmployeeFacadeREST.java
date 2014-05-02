package data.ws;

import data.model.enterprise.Employee;
import data.model.enterprise.Contract;
import data.ws.tools.Utils;
import data.ws.config.Configurator;
import data.persistence.hubs.EmployeeHubFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("employees/")
public class EmployeeFacadeREST implements Serializable {

	@Inject
    private EmployeeHubFacade employeeHubFacade;

    @Context
    private UriInfo uri;

    public EmployeeFacadeREST() {
    }

	@PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Employee create(Employee entity) {
        return employeeHubFacade.create(entity);
    }

	@POST
    @Path("{id : \\d+}")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Employee edit(@PathParam("id") Long id, Employee entity) {
        return employeeHubFacade.edit(entity);
    }

    @DELETE
    @Path("{id : \\d+}")
    public void remove(@PathParam("id") Long id) {
        employeeHubFacade.remove(employeeHubFacade.find(id));
    }

    @GET
    @Path("{id : \\d+}")
    @Produces({"application/xml", "application/json"})
    public Employee find(@PathParam("id") Long id) {
        return employeeHubFacade.find(id);
    }

	@GET
    @Produces({"application/xml", "application/json"})
    public Response findRange(
            @QueryParam("offset") Integer offset,
            @QueryParam("size") Integer size,
            @QueryParam("projection") String attributes,
            @QueryParam("condition") String condition,
            @QueryParam("orderBy") String orderBy) {

        offset = offset == null ? 0 : offset;
        size = size == null ? Configurator.getInstance().getPageSize() : size;

        int	[] range = {offset, offset + size};
        Configurator.getInstance().setPageSize(range[1] - range[0]);

        List<Employee> employees = employeeHubFacade.searchRange(range,
                Utils.stringToList(attributes, Configurator.getInstance().getParamSeparator()),
                Utils.stringToMap(condition, Configurator.getInstance().getParamSeparator()),
                Utils.stringToMap(orderBy, Configurator.getInstance().getParamSeparator()));

        int prevRange = Math.max(offset - size, 0);
        int nextRange = offset + size;
        int pageSize = size;

        String linkCondition = "";
        if (condition != null && !condition.isEmpty()) {
            linkCondition = "&condition=" + condition;
        }

		return Response.ok(
			new GenericEntity<List<Employee>>(new ArrayList(employees)) {}
			).link(uri.getAbsolutePath() + "?offset=" + prevRange + "&size=" + pageSize + linkCondition, Configurator.getInstance().getLinkPreviousName())
             .link(uri.getAbsolutePath() + "?offset=" + nextRange + "&size=" + pageSize + linkCondition, Configurator.getInstance().getLinkNextName())
             .build();
    }

    @GET
    @Path("{id_employee : \\d+}/contracts")
    @Produces({"application/xml", "application/json"})
    public Response getEmployeeContractsRange(
            @PathParam("id_employee") Long id_employee,
            @QueryParam("offset") Integer offset,
            @QueryParam("size") Integer size,
            @QueryParam("condition") String condition,
            @QueryParam("orderBy") String orderBy) {

        offset = offset == null ? 0 : offset;
        size = size == null ? Configurator.getInstance().getPageSize() : size;

        int[] range = {offset, offset + size};
        Configurator.getInstance().setPageSize(range[1] - range[0]);

        int prevRange = Math.max(offset - size, 0);
        int nextRange = offset + size;
        int pageSize = size;

        List<Contract> contracts = employeeHubFacade.searchEmployeeContractsRange(range,
                id_employee,
                Utils.stringToMap(condition, Configurator.getInstance().getParamSeparator()),
                Utils.stringToMap(orderBy, Configurator.getInstance().getParamSeparator()));

        String linkCondition = "";
        if (condition != null && !condition.isEmpty()) {
            linkCondition = "&condition=" + condition;
        }

        return Response.ok(
                new GenericEntity<List<Contract>>(new ArrayList(contracts)) {
        })
                .link(uri.getAbsolutePath() + "?offset=" + prevRange + "&size=" + (int) (prevRange + pageSize) + linkCondition, Configurator.getInstance().getLinkPreviousName())
                .link(uri.getAbsolutePath() + "?offset=" + nextRange + "&size=" + (int) (nextRange + pageSize) + linkCondition, Configurator.getInstance().getLinkNextName())
                .build();
    }


    @GET
    @Path("{id_employee : \\d+}/contracts/count")
    @Produces("text/plain")
    public Long countUserProjects(@PathParam("id_employee") Long id_employee, @QueryParam("condition") String condition) {
        return employeeHubFacade.countEmployeeContracts(
                id_employee,
                Utils.stringToMap(condition, Configurator.getInstance().getParamSeparator()));
    }
}
