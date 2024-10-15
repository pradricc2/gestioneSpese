package controller;

import model.IncomeExpense;
import service.IncomeExpenseService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/incomes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IncomeExpenseController {


    @Inject
    private IncomeExpenseService service;



    @GET
    public List<IncomeExpense> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public IncomeExpense getById(@PathParam("id") Long id) {
        return service.getById(id);
    }

    @POST
    public Response addIncomeExpense(IncomeExpense incomeExpense) {
        IncomeExpense expense = service.addIncomeExpense(incomeExpense);
        return Response.ok().entity(expense).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateIncomeExpense(@PathParam("id") Long id, IncomeExpense incomeExpense) {
        IncomeExpense updated = service.updateIncomeExpense(incomeExpense);
        if (updated != null) {
            return Response.ok().entity(updated).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteIncomeExpense(@PathParam("id") Long id) {
        service.deleteIncomeExpense(id);
        return Response.noContent().build();
    }

}
