package data.ws;

import data.model.enterprise.Account;
import data.ws.tools.Utils;
import data.ws.config.Configurator;
import data.persistence.hubs.AccountHubFacade;
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
@Path("accounts/")
public class AccountFacadeREST implements Serializable {

	@Inject
    private AccountHubFacade accountHubFacade;

    @Context
    private UriInfo uri;

    public AccountFacadeREST() {
    }

	@PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Account create(Account entity) {
        return accountHubFacade.create(entity);
    }

	@POST
    @Path("{id : \\d+}")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Account edit(@PathParam("id") Long id, Account entity) {
        return accountHubFacade.edit(entity);
    }

    @DELETE
    @Path("{id : \\d+}")
    public void remove(@PathParam("id") Long id) {
        accountHubFacade.remove(accountHubFacade.find(id));
    }

    @GET
    @Path("{id : \\d+}")
    @Produces({"application/xml", "application/json"})
    public Account find(@PathParam("id") Long id) {
        return accountHubFacade.find(id);
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

        List<Account> accounts = accountHubFacade.searchRange(range,
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
			new GenericEntity<List<Account>>(new ArrayList(accounts)) {}
			).link(uri.getAbsolutePath() + "?offset=" + prevRange + "&size=" + pageSize + linkCondition, Configurator.getInstance().getLinkPreviousName())
             .link(uri.getAbsolutePath() + "?offset=" + nextRange + "&size=" + pageSize + linkCondition, Configurator.getInstance().getLinkNextName())
             .build();
    }

}
