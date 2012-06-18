/*
 * Copyright 2012 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.drools.guvnor.client.decisiontable.widget.auditlog;

import org.drools.guvnor.client.messages.Constants;
import org.drools.ide.common.client.modeldriven.auditlog.AuditLogEntry;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.client.SafeHtmlTemplates.Template;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * A cell to render AuditLogEntry's
 */
@SuppressWarnings("unused")
public class AuditLogEntryCell extends AbstractCell<AuditLogEntry> {

    interface Template
        extends
        SafeHtmlTemplates {

        @Template("<div class=\"auditLogSummary\">{0}</div><div class=\"auditLogDetailValue\">{1}</div>")
        SafeHtml entrySummary(String eventTypeDisplayText,
                              String whoWhenDisplayText);
    }

    private static final Template         TEMPLATE = GWT.create( Template.class );

    private final DateTimeFormat          format;

    private final AuditLogEntryCellHelper helper;

    public AuditLogEntryCell(final DateTimeFormat format) {
        this.helper = new AuditLogEntryCellHelper( format );
        this.format = format;
    }

    @Override
    public void render(Context context,
                       AuditLogEntry value,
                       SafeHtmlBuilder sb) {
        if ( value == null ) {
            return;
        }

        //Audit Log entry type and date
        final String eventTypeDisplayText = AuditLogEntryCellHelper.getEventTypeDisplayText( value.getGenericType() );
        final String whoWhenDisplayText = Constants.INSTANCE.AuditLogEntryOn0( format.format( value.getDateOfEntry() ) );
        sb.append( TEMPLATE.entrySummary( eventTypeDisplayText,
                                          whoWhenDisplayText ) );

        //Audit Log entry detail
        sb.append( helper.getSafeHtml( value ) );
    }

}