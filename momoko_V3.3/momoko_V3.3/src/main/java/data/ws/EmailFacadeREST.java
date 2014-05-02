package data.ws;

import data.model.enterprise.Email;
import data.ws.tools.Utils;
import data.ws.config.Configurator;
import data.persistence.hubs.EmailHubFacade;
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
@Path("emails/")
public class EmailFacadeREST implements Serializable {

	@Inject
    private EmailHubFacade emailHubFacade;

    @Context
    private UriInfo uri;

    public EmailFacadeREST() {
    }

	@PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Email create(Email entity) {
        return emailHubFacade.create(entity);
    }

	@POST
    @Path("{id : \\d+}")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Email edit(@PathParam("id") Long id, Email entity) {
        return emailHubFacade.edit(entity);
    }

    @DELETE
    @Path("{id : \\d+}")
    public void remove(@PathParam("id") Long id) {
        emailHubFacade.remove(emailHubFacade.find(id));
    }

    @GET
    @Path("{id : \\d+}")
    @Produces({"application/xml", "application/json"})
    public Email find(@PathParam("id") Long id) {
        return emailHubFacade.find(id);
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

        List<Email> emails = emailHubFacade.searchRange(range,
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
			new GenericEntity<List<Email>>(new ArrayList(emails)) {}
			).link(uri.getAbsolutePath() + "?offset=" + prevRange + "&size=" + pageSize + linkCondition, Configurator.getInstance().getLinkPreviousName())
             .link(uri.getAbsolutePath() + "?offset=" + nextRange + "&size=" + pageSize + linkCondition, Configurator.getInstance().getLinkNextName())
             .build();
    }

}
