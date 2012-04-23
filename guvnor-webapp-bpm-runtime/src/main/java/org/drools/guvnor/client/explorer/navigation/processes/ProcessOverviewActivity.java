/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.explorer.navigation.processes;

import com.google.gwt.event.shared.EventBus;
import org.drools.guvnor.client.explorer.AcceptItem;
import org.drools.guvnor.client.messages.ConstantsCore;
import org.drools.guvnor.client.util.Activity;
import org.jboss.bpm.console.client.ClientFactory;
import org.jboss.bpm.console.client.process.MergedProcessView;

public class ProcessOverviewActivity extends Activity {

    private ClientFactory clientFactory;

    public ProcessOverviewActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptItem tabbedPanel, EventBus eventBus) {
        tabbedPanel.add(ConstantsCore.INSTANCE.ProcessOverview(), new MergedProcessView(clientFactory));
    }
}