/*
 * Copyright 2013 State University of New York at Oswego
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package edu.oswego.csc480_hci521_2013.client.events;

import com.google.gwt.event.shared.GwtEvent;
import edu.oswego.csc480_hci521_2013.shared.h2o.json.RF;
import edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders.RFBuilder;

/**
 *
 */
public class RFGenerateEvent extends GwtEvent<RFGenerateEventHandler> {

    public static final Type<RFGenerateEventHandler> TYPE = new Type<RFGenerateEventHandler>();

    private RF data;
    private RFBuilder builder;

    public RFGenerateEvent(RF data) {
        this.data = data;
    }

    public RFGenerateEvent(RF data, RFBuilder builder){
        this.data = data;
        this.builder = builder;
    }

    public RF getData() {
        return data;
    }

    public RFBuilder getBuilder(){
        return builder;
    }

    @Override
    public Type<RFGenerateEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RFGenerateEventHandler h) {
        h.onStart(this);
    }
}
