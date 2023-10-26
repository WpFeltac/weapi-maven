package com.feltac.weapi.rest;

import java.util.Optional;

import com.feltac.weapi.ejb.WeaponBean;
import com.feltac.weapi.model.Weapon;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/weapons")
public class WeaponRessource {
    @Inject
    private WeaponBean weaponBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAllWeapons()
    {
        return Response.ok(weaponBean.retrieveAllWeapons()).build();
    }

    @GET
    @Path("/{weaponName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveOneWeapon(@PathParam("weaponName") String weaponName)
    {        
        Optional<Weapon> res = weaponBean.retrieveOneWeapon(weaponName);

        if(res.isEmpty())
        {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok(res.get()).build();
    } 

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createWeapon(Weapon weapon)
    {
        if(!weaponBean.createWeapon(weapon))
        {
            return Response.status(Status.BAD_REQUEST).build();
        }

        return Response.status(Status.CREATED).build();
    }

    @DELETE
    @Path("/{weaponName}")
    public Response deleteWeaponByName(@PathParam("weaponName") String weaponName)
    {
        if(!weaponBean.deleteWeaponByName(weaponName))
        {
            return Response.status(404, weaponName).build();
        }

        return Response.status(200).build();
    }
}