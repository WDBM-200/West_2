package com.cxq.two;

import sun.applet.resources.MsgAppletViewer;

public class CatNotFoundException extends BaseException{
    public CatNotFoundException(){
        super();
    }
    public CatNotFoundException(String msg){
        super(msg);
    }

}
