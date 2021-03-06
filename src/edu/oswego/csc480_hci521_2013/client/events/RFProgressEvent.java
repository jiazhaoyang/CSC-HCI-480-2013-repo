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
import edu.oswego.csc480_hci521_2013.shared.h2o.json.RFView;

/**
 *
 */
public class RFProgressEvent extends GwtEvent<RFProgressEventHandler> {

    public static final Type<RFProgressEventHandler> TYPE = new Type<RFProgressEventHandler>();

    private RF source;
    private RFView data;

    public RFProgressEvent(RF source, RFView data) {
        this.source = source;
        this.data = data;
    }

    public RF getSource() {
        return source;
    }

    public RFView getData() {
        return data;
    }

    @Override
    public Type<RFProgressEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RFProgressEventHandler h) {
        h.onDataUpdate(this);
    }
}
