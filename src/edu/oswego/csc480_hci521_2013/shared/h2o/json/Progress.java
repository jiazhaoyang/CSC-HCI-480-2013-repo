package edu.oswego.csc480_hci521_2013.shared.h2o.json;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 *
 */
public class Progress implements IsSerializable
{
    private String destination_key;
    private ResponseStatus response;

    public String getDestinationKey()
    {
        return destination_key;
    }

    public ResponseStatus getResponse()
    {
        return response;
    }

    @Override
    public String toString()
    {
        return "Progress{" + "destination_key=" + destination_key + ", response=" + response + '}';
    }
}
