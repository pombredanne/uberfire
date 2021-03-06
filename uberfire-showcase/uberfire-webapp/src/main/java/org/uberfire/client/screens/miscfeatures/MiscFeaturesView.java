/*
 * Copyright 2012 JBoss Inc
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

package org.uberfire.client.screens.miscfeatures;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;

/**
 * A stand-alone (i.e. devoid of Workbench dependencies) View
 */
public class MiscFeaturesView extends Composite
        implements
        RequiresResize,
        MiscFeaturesPresenter.View {

    interface ViewBinder
            extends
            UiBinder<Widget, MiscFeaturesView> {

    }

    private static ViewBinder uiBinder = GWT.create( ViewBinder.class );

    @UiField
    public HTMLPanel panel;

    @Inject
    private Event<NotificationEvent> notification;

    private MiscFeaturesPresenter presenter;

    @Override
    public void init( final MiscFeaturesPresenter presenter ) {
        this.presenter = presenter;
    }

    @PostConstruct
    public void init() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }

    @Override
    public void onResize() {
        int height = getParent().getOffsetHeight();
        int width = getParent().getOffsetWidth();
        panel.setPixelSize( width,
                            height );
    }

    @UiHandler("notificationButton")
    public void onClickNotificationButton( final ClickEvent event ) {
        notification.fire( new NotificationEvent( "Something happened" ) );
    }

    @UiHandler("launchUnknownPlace")
    public void onClickLaunchUnknownPlace( final ClickEvent event ) {
        presenter.launchUnknownPlace();
    }

}