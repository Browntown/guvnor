/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.explorer.navigation.modules;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import org.drools.guvnor.client.common.AssetFormats;
import org.drools.guvnor.client.common.GenericCallback;
import org.drools.guvnor.client.explorer.ClientFactory;

public class ModulesNewAssetMenu implements IsWidget, ModulesNewAssetMenuView.Presenter {

    private ModulesNewAssetMenuView view;
    private ClientFactory clientFactory;


    public ModulesNewAssetMenu( ClientFactory clientFactory ) {
        this.clientFactory = clientFactory;
        this.view = clientFactory.getNavigationViewFactory().getModulesNewAssetMenuView();
        view.setPresenter( this );
    }

    public Widget asWidget() {
        return view.asWidget();
    }

    public void onNewModule() {
        view.openNewPackageWizard( clientFactory );
    }

    public void onNewSpringContext() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.SPRING_CONTEXT );
    }

    public void onNewWorkingSet() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.WORKING_SET );
    }

    public void onNewRule() {
        view.openNewAssetWizardWithCategories( null );
    }

    public void onNewRuleTemplate() {
        view.openNewAssetWizardWithCategories( AssetFormats.RULE_TEMPLATE );
    }

    public void onNewPojoModel() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.MODEL );
    }

    public void onNewDeclarativeModel() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.DRL_MODEL );
    }

    public void onNewBPELPackage() {
        view.openNewAssetWizardWithCategories( AssetFormats.BPEL_PACKAGE );
    }

    public void onNewFunction() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.FUNCTION );
    }

    public void onNewDSL() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.DSL );
    }

    public void onNewRuleFlow() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.RULE_FLOW_RF );
    }

    public void onNewBPMN2Process() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.BPMN2_PROCESS );
    }

    public void onNewWorkitemDefinition() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.WORKITEM_DEFINITION );
    }

    public void onNewEnumeration() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.ENUMERATION );
    }

    public void onNewTestScenario() {
        view.openNewAssetWizardWithoutCategories( AssetFormats.TEST_SCENARIO );
    }

    public void onNewFile() {
        view.openNewAssetWizardWithoutCategories( "*" );
    }

    public void onRebuildAllPackages() {
        view.confirmRebuild();
    }

    public void onRebuildConfirmed() {
        view.showLoadingPopUpRebuildingPackageBinaries();
        clientFactory.getPackageService().rebuildPackages( new GenericCallback() {
            public void onSuccess( Object result ) {
                view.closeLoadingPopUp();
            }
        } );
    }
}
