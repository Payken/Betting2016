package com.ai;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by fdarmoch on 2015-12-28.
 */
@WebService
public class WS {
    private String message = new String("Hello, ");
public String papa;

    public void setPapa(String papa) {
        this.papa = papa;
    }

    public void WS() {
    setPapa("pdpd");



    }

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}