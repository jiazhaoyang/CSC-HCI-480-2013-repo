package edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders;

/**
 *
 */
public class InspectBuilder extends AbstractBuilder
{

    InspectBuilder()
    {
    }

    public InspectBuilder(String key)
    {
        super("Inspect.json");
        addArg("key", key);
    }
}