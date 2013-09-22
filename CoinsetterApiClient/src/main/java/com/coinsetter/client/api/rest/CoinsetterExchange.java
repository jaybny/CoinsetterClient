package com.coinsetter.client.api.rest;

import com.coinsetter.client.api.rest.dto.*;
import si.mazi.rescu.RestProxyFactory;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: jay
 * Date: 7/8/13
 * Time: 2:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class CoinsetterExchange {  
    public final Coinsetter coinSetter;
    private String clientSessionUuid,customerUuid;
    Customer customer;
    public Account useAccount;

    public  CoinsetterExchange(String uri) {
        this.coinSetter = RestProxyFactory.createProxy(Coinsetter.class,uri);
    }

    public void login(String user, String password,String ip) {
        try {
            ClientSession clientSession  = coinSetter.login(new Login(user,password,ip));

            if ( !clientSession.requestStatus.equals("SUCCESS"))
                throw new Exception(clientSession.toString());

            clientSessionUuid = clientSession.uuid;
            customerUuid = clientSession.customerUuid;
            System.out.print(clientSession.toString());
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public void customerAccount() {
        try {
            customer = coinSetter.customerGet(clientSessionUuid,customerUuid);
            //if ( !customer.requestStatus.equals("SUCCESS"))
            //    throw new Exception(coinsetterClientSession.toString());
            System.out.print(customer.toString());

            AccountList accounts = coinSetter.getAccounts(clientSessionUuid, customerUuid);
            System.out.print(accounts.toString());

            if ( accounts.accountList.length > 0)
                useAccount = accounts.accountList[0];
            else
                System.out.print("no accounts for customer");
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public OrderResponse newOrder(Order.OrderType ordertype,Order.Side side,double price, int qty) {
        try {
           OrderResponse or  = coinSetter.addOrder(clientSessionUuid,
                   new OrderAdd(customerUuid,useAccount.accountUuid,
                            side.toString(),ordertype.toString(),qty,BigDecimal.valueOf(price)));

           System.out.print(or.toString());
           return or;
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
        finally {
            return null;
        }

    }

    public OrderList orderList(String view) {
        try {
            OrderList or  = coinSetter.orderList(clientSessionUuid, customerUuid, useAccount.accountUuid, view);

            System.out.print(or.toString());
            return or;
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
        finally {
            return null;
        }
    }

    public Order getOrder(String orderuuid) {
        try {
            Order or  = coinSetter.getOrder(clientSessionUuid, orderuuid);

            System.out.print(or.toString());
            return or;
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
        finally {
            return null;
        }
    }

    public OrderResponse cancelOrder(String orderuuid) {
        try {
            OrderResponse or  = coinSetter.cancelOrder(clientSessionUuid, orderuuid);

            System.out.print(or.toString());
            return or;
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
        finally {
            return null;
        }
    }

    public OrderResponse cancelOrder(Order o) {
        return cancelOrder(o.uuid);
    }

    public PositionList positionList() {
        try {
            PositionList pl  = coinSetter.positionList(clientSessionUuid, customerUuid, useAccount.accountUuid);

            System.out.print(pl.toString());
            return pl;
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
        finally {
            return null;
        }
    }

    public void logout() {
        action("LOGOUT");
    }

    public void action(String action) {
        try {
            ClientSession clientSession  = coinSetter.action(clientSessionUuid, action);

            if ( !clientSession.requestStatus.equals("SUCCESS"))
                throw new Exception(clientSession.toString());

            System.out.print(clientSession.toString());
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        String coinsetter = "https://www.coinsetter.com/";

        try {
            CoinsetterExchange cs = new CoinsetterExchange(coinsetter);

            Scanner input = new Scanner(System.in);
            boolean run = true;
            while (run) {
                System.out.println("\n 1: login \n 2: list open orders \n 3: list positions \n 4: new order \n 5: cancel order \n 0: to exit");
                int in = input.nextInt();

                switch(in) {
                    case 0:
                        run = false;
                        break;
                    case 1:
                        System.out.print("\nUserName: ");
                        String user =  input.next();
                        System.out.print("\nPassword: ");
                        String pass =  input.next();
                        cs.login(user,pass,"www.address.com");
                        cs.customerAccount();
                        break;
                    case 2:
                        cs.orderList("OPEN");
                        break;
                    case 3:
                        cs.positionList();
                        break;
                    case 4:
                        System.out.print("\n0 for buy 1 for sell:");
                        Integer side = input.nextInt();
                        Order.Side oside = side == 0 ? Order.Side.BUY : Order.Side.SELL;
                        System.out.print("\nenter 1 for limit 2 for market: ");
                        int type = input.nextInt();

                        BigDecimal price = new BigDecimal(0.0);
                        Order.OrderType otype;

                        if (type == 1) {
                            System.out.print("\nEnter Price: ");
                            price = input.nextBigDecimal();
                            otype = Order.OrderType.LIMIT;
                        } else {
                            otype = Order.OrderType.MARKET;
                            price = BigDecimal.ONE;
                        }
                        System.out.print("\nEnter qty: ");
                        int qty = input.nextInt();

                        cs.newOrder(otype,oside,price.doubleValue(),qty);
                        break;
                    case 5:
                        System.out.print("\nEnter order uuid to cancel: ");
                        cs.cancelOrder(input.next());
                        break;
                    default:
                        break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
