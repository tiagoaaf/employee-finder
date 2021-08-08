package com.example.employee.resources;

import com.example.employee.entities.Employee;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employee")
public class EmployeeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> findAll() {
        return Employee.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee findById(@PathParam("id") String id) {
        return Employee.findById(new ObjectId(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Employee createEmployee(Employee employee) {
        Employee.persistOrUpdate(employee);

        return employee;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee updateEmployee(@PathParam("id") String id, Employee employee) {
        if (Employee.findById(id) == null) {
            throw new NotFoundException(id);
        }
        Employee.update(employee);

        return employee;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") String id) {
        if (Employee.findById(id) == null) {
            throw new NotFoundException(id);
        }
        Employee.deleteById(id);
    }

}
