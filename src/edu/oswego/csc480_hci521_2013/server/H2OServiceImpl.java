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
package edu.oswego.csc480_hci521_2013.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.oswego.csc480_hci521_2013.client.services.H2OService;
import edu.oswego.csc480_hci521_2013.shared.h2o.RestException;
import edu.oswego.csc480_hci521_2013.shared.h2o.json.Inspect;
import edu.oswego.csc480_hci521_2013.shared.h2o.json.RF;
import edu.oswego.csc480_hci521_2013.shared.h2o.json.RFTreeView;
import edu.oswego.csc480_hci521_2013.shared.h2o.json.RFView;
import edu.oswego.csc480_hci521_2013.shared.h2o.json.StoreView;
import edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders.InspectBuilder;
import edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders.RFBuilder;
import edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders.RFTreeViewBuilder;
import edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders.RFViewBuilder;
import edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders.StoreViewBuilder;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
//@SuppressWarnings("serial")
public class H2OServiceImpl extends RemoteServiceServlet implements H2OService {

    private static final Logger logger = Logger.getLogger(H2OServiceImpl.class.getName());
    private RestHandler rest = new RestHandler();

    public StoreView getDataStores(StoreViewBuilder builder)
            throws RestException {
        return rest.get(builder, StoreView.class);
    }

    public ArrayList<String> getColumnHeaders(String dataKey) throws RestException {
        try {
            Inspect val = rest.get(new InspectBuilder(dataKey), Inspect.class);
            logger.log(Level.INFO, val.toString());

            ArrayList<String> columnHeaders = new ArrayList<String>();

            //Iterate through Arraylist of ColumnDef
            for(Inspect.Column column : val.getCols()){
                columnHeaders.add(column.getName());
            }

            return columnHeaders;
        } catch (RestException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    public Inspect getData(InspectBuilder builder) throws RestException {
        return rest.get(builder, Inspect.class);
    }

    public RFTreeView getTreeView(RFTreeViewBuilder builder)
            throws RestException {
        return rest.get(builder, RFTreeView.class);
    }

    public RF generateRandomForest(RFBuilder builder) throws RestException {
        return rest.get(builder, RF.class);
    }

    public RFView getRandomForestView(RFViewBuilder builder)
            throws RestException {
        return rest.get(builder, RFView.class);
    }
}
