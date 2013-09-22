package com.coinsetter.client.api.rest;

import com.coinsetter.client.api.rest.dto.*;

import javax.ws.rs.*;
  
/**
 * Created with IntelliJ IDEA.
 * User: jay
 * Date: 7/8/13
 * Time: 1:54 AM
 * To change this template use File | Settings | File Templates.
 */
//@Path("api-server")
@Path("api")
@Consumes("application/json")
@Produces("application/json")
public interface Coinsetter {
    @PUT
    @Path("/clientSession/{clientSessionUuid}")
    public ClientSession action(@PathParam("clientSessionUuid") String uuId, @QueryParam("action") String action);

    @POST
    @Path("/clientSession")
    public ClientSession login(Login login);
    // public CoinsetterClientSession  login(Login login);
    @GET
    @Path("/ping/{echo}")
    public String ping(@PathParam("echo") String echo);

    @GET
    @Path("/ping")
    public String ping();

    @GET
    @Path("/customer/{customerUuid}")
    public Customer customerGet(
            @HeaderParam("coinsetter-client-session-id") String sessionid,
                              @PathParam("customerUuid") String customerUuid);
    @PUT
    @Path("/customer/{customerUuid}")
    public ClientSession customerAction(@HeaderParam("coinsetter-client-session-id") String sessionid,
                                        @PathParam("customerUuid") String customerUuid, @QueryParam("action") String action,String customer);

    @POST
    @Path("/order")
    public OrderResponse addOrder(
            @HeaderParam("coinsetter-client-session-id") String sessionid,
            OrderAdd orderAdd);

    @GET
    @Path("/customer/{customerUuid}/account")
    public AccountList getAccounts(
            @HeaderParam("coinsetter-client-session-id") String sessionid,
            @PathParam("customerUuid") String customerUuid
    );


    /*Order stage to return:
           "NEW"
           "PENDING"
           "PARTIAL_FILL"
           "OPEN"
           "EXPIRED"
           "CANCELLED"
           "REJECTED"
           "CLOSED"
           "EXT_ROUTED"
           "NEW-FILL" - includes new, partial fill and open.  Default.
           "FILL" - include partial fill and open
   */
    @GET
    @Path("/customer/{customerUuid}/account/{accountUuid}/order")
    public OrderList orderList(
            @HeaderParam("coinsetter-client-session-id") String sessionid,
            @PathParam("customerUuid") String customerUuid,
            @PathParam("accountUuid") String accountUuid,
            @QueryParam("view") String view);

    @GET
    @Path("/order/{orderUuid}")
    public Order getOrder(
            @HeaderParam("coinsetter-client-session-id") String sessionid,
            @PathParam("orderUuid") String orderUuid
    );


    @GET
    @Path("/customer/{customerUuid}/account/{accountUuid}/position")
    public PositionList positionList(
            @HeaderParam("coinsetter-client-session-id") String sessionid,
            @PathParam("customerUuid") String customerUuid,
            @PathParam("accountUuid") String accountUuid);

    @DELETE
    @Path("/order/{orderUuid}")
    public OrderResponse cancelOrder(
        @HeaderParam("coinsetter-client-session-id") String sessionid,
        @PathParam("orderUuid") String orderUuid
    );
}
